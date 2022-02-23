package bot.starcraft.Chat;

import bot.starcraft.JSON.ConfigJson;
import bot.starcraft.Object.Game;
import org.sikuli.script.Button;
import org.sikuli.script.Location;
import org.sikuli.script.Mouse;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Other {
    ConfigJson _c = new ConfigJson();
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
        Mouse.move(new Location(_game.x+_c.getInt("window-size-x"), _game.y+_c.getInt("window-size-y")));
        Mouse.up(Button.LEFT);
    }
}
