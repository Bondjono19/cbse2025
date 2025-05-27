package dk.sdu.cbse.main;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.GameKeys;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IPlugin;
import dk.sdu.cbse.common.services.IPostProcess;
import dk.sdu.cbse.common.services.IProcess;

import java.util.ArrayList;

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

    static List<IPlugin> plugins;
    static List<IProcess> processes;
    static List<IPostProcess> postProcesses;

    @Autowired
    private static GameData gameData;
    @Autowired
    private static World world;

    private final Map<Entity,Polygon> polygons = new ConcurrentHashMap<>();

    private final Pane gameWindow = new Pane();

    public Main(){
        
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("dk.sdu.cbse");
        context.refresh();
        gameData = context.getBean(GameData.class);
        world = context.getBean(World.class);
        plugins = new ArrayList<>(context.getBeansOfType(IPlugin.class).values());
        processes = new ArrayList<>(context.getBeansOfType(IProcess.class).values());
        postProcesses = new ArrayList<>(context.getBeansOfType(IPostProcess.class).values());
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


        for (IPlugin plugin : plugins){
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
                //Trigger all implementationns of interfaces 'IProcess & IPostProcess' to run their respective implementations of process() method.
                update();
                //Draw the new game board in accordance to the game logic whic has now been processed and updated .
                draw();
                //Update game keys
                gameData.getKeys().update();
            }
        }.start();
    }
    
    //call process on all implementations of 'IProcess & IPostProcess'
    private void update(){
        for (IProcess entityProcessingService : processes){
            entityProcessingService.process(gameData, world);
        }
        for (IPostProcess postEntityProcessingService : postProcesses){
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

}
