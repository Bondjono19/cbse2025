package dk.sdu.cbse.main;

import java.util.Collection;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.GameKeys;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IPluginService;
import dk.sdu.cbse.common.services.IPostProcessingService;
import dk.sdu.cbse.common.services.IProcessingService;

import static java.util.stream.Collectors.toList;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.application.Application;
import javafx.animation.AnimationTimer;
import javafx.scene.text.Text;

/**
 * Hello world!
 */
public class Main extends Application{

    private final GameData gameData = new GameData();
    private final World world = new World();
    private final Map<Entity,Polygon> polygons = new ConcurrentHashMap<>();
    private final Pane gameWindow = new Pane();
    public static void main(String[] args) {
        launch(Main.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        Text text = new Text(20,20,"Asteroids Destroyed:");
        text.setId("SCORE");
        Text text2 = new Text(20,20,"Health:");
        text2.setId("HEALTH");
        text2.setX(gameData.getDisplayWidth()-100);
        text2.setY(20);
        gameWindow.setPrefSize(gameData.getDisplayWidth(),gameData.getDisplayHeight());
        gameWindow.getChildren().add(text);
        gameWindow.getChildren().add(text2);

        Scene scene = new Scene(gameWindow);
        scene.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.LEFT)){
                gameData.getKeys().setKey(GameKeys.LEFT,true);
            }
            if(event.getCode().equals(KeyCode.RIGHT)) {
                gameData.getKeys().setKey(GameKeys.RIGHT, true);
            }
            if (event.getCode().equals(KeyCode.UP)) {
                gameData.getKeys().setKey(GameKeys.UP, true);
            }
            if (event.getCode().equals(KeyCode.SPACE)) {
                gameData.getKeys().setKey(GameKeys.SPACE, true);
            }
        });
        scene.setOnKeyReleased(event -> {
            if (event.getCode().equals(KeyCode.LEFT)) {
                gameData.getKeys().setKey(GameKeys.LEFT, false);
            }
            if (event.getCode().equals(KeyCode.RIGHT)) {
                gameData.getKeys().setKey(GameKeys.RIGHT, false);
            }
            if (event.getCode().equals(KeyCode.UP)) {
                gameData.getKeys().setKey(GameKeys.UP, false);
            }
            if (event.getCode().equals(KeyCode.SPACE)) {
                gameData.getKeys().setKey(GameKeys.SPACE, false);
            }
        });


        //find all game plugins via the ServiceLoader class
        for (IPluginService plugin : getPluginServices()){
            plugin.start(gameData, world);
        }
        //map entities to acutal visible world
        for(Entity entity : world.getEntities()){
            Polygon polygon = new Polygon(entity.getPolygonCoordinates());
            polygons.put(entity,polygon);
            gameWindow.getChildren().add(polygon);
        }
        render();
        window.setScene(scene);
        window.setTitle("Marius Asteroids Game");
        window.show();

    }

    private void render(){
        //start new annimation timer that triggers handle every time frame
        new AnimationTimer(){
            @Override
            public void handle(long now){
                gameData.setTime(now);
                //Trigger all implementationns of interfaces 'IProcessingService & IPostProcessingService' to run their respective implementations of process() method.
                update();
                //Draw the new game board in accordance to the game logic whic has now been processed and updated .
                draw();
                //Update game keys
                gameData.getKeys().update();
            }
        }.start();
    }
    
    //call process on all implementations of 'IProcessingService & IPostProcessingService'
    private void update(){
        for (IProcessingService entityProcessingService : getEntityProcessingServices()){
            entityProcessingService.process(gameData, world);
        }
        for (IPostProcessingService postEntityProcessingService : getPostEntityProcessingServices()){
            postEntityProcessingService.process(gameData, world);
        }
    }

    private void draw(){
        //remove polygons from graphics if they are removed from game logic
        for (Entity polygonEntity : polygons.keySet()){
            if(!world.getEntities().contains(polygonEntity)){
                Polygon removedPolygon = polygons.get(polygonEntity);
                polygons.remove(polygonEntity);
                gameWindow.getChildren().remove(removedPolygon);
            }
        }
        //Add new entities from game logic to the board by assigninng them polygons annd putting these on the board. Also update their positions in relation to game logic.
        for(Entity entity : world.getEntities()){
            Polygon polygon = polygons.get(entity);
            if(polygon == null){
                polygon = new Polygon(entity.getPolygonCoordinates());
                polygons.put(entity,polygon);
                gameWindow.getChildren().add(polygon);
            }
            polygon.setTranslateX(entity.getX());
            polygon.setTranslateY(entity.getY());
            polygon.setRotate(entity.getRotation());
        }

        //update score & health
        Text score = (Text)gameWindow.lookup("#SCORE");
        if(score != null){
            score.setText("Points: " + Integer.toString(world.getPoints()));
        }
        Text health = (Text)gameWindow.lookup("#HEALTH");
        if(health != null){
            health.setText("Health: " + Double.toString(world.getPlayerHealth()));
        }
    }

    //Load all implementations of IPluginService
    private Collection<? extends IPluginService> getPluginServices() {
        return ServiceLoader.load(IPluginService.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
    //Load all implementations of IProcessingService
    private Collection<? extends IProcessingService> getEntityProcessingServices() {
        return ServiceLoader.load(IProcessingService.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
    //Load all implementations of IPostProcessingService
    private Collection<? extends IPostProcessingService> getPostEntityProcessingServices() {
        return ServiceLoader.load(IPostProcessingService.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
}
