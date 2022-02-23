package bot.starcraft.Chat;

import bot.starcraft.Object.Game;
import org.sikuli.script.Button;
import org.sikuli.script.Location;
import org.sikuli.script.Mouse;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Other {
    public String getTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss aa");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
    public String getDetailedTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss.SSS aa");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public void resizeWindow(Game _game) {
        Mouse.move(new Location(_game.x+_game.w-5, _game.y+_game.h-5));
        Mouse.down(Button.LEFT);
        Mouse.move(new Location(_game.x+1280, _game.y+960));
        Mouse.up(Button.LEFT);
    }
}
