package bot.starcraft.Object;

import org.sikuli.script.Region;

public class ChatBox {
    public int x;
    public int y;
    public int w;
    public int h;
    public Region r;
    public ChatBox(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.r = new Region(x, y, w, h);
    }
}