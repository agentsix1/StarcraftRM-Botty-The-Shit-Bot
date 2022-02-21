package bot.starcraft.Object;

import org.sikuli.script.App;
import org.sikuli.script.Region;

public class Game {
    public int x;
    public int y;
    public int w;
    public int h;
    public Region r;
    public App a;
    public Game(String game) {
        this.a = new App(game);
        this.x = a.window().x;
        this.y = a.window().y;
        this.w = a.window().w;
        this.h = a.window().h;
        this.r = a.window();
    }
}
