package dk.sdu.cbse.common.data;

import org.springframework.stereotype.Component;

@Component
public class GameData {
    private int displayWidth = 800;
    private int displayHeight = 800;
    private final GameKeys keys = new GameKeys();
    private long time;

    public long getTime() {
        return this.time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getDisplayWidth() {
        return this.displayWidth;
    }

    public void setDisplayWidth(int displayWidth) {
        this.displayWidth = displayWidth;
    }

    public int getDisplayHeight() {
        return this.displayHeight;
    }

    public void setDisplayHeight(int displayHeight) {
        this.displayHeight = displayHeight;
    }

    public GameKeys getKeys() {
        return this.keys;
    }

}
