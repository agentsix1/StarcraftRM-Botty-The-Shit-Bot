package bot.starcraft;

import bot.starcraft.Chat.EventProcessChat;

import bot.starcraft.Chat.Other;
import bot.starcraft.JSON.ConfigJson;
import bot.starcraft.Object.Game;
import org.sikuli.basics.Settings;
import org.sikuli.script.Location;

public class Main {
    public static String _ver = "v0.0.2 dev";
    public static void main(String[] args) {
        Game _game = new Game("Brood War");
        Other _other = new Other();
        ConfigJson _config = new ConfigJson();
        System.out.println("Botty The Shit Bot " + _ver);
        Settings.ClickDelay = 0;
        Settings.MoveMouseDelay = 0;
        Settings.ActionLogs = false;
        _game.a.focus();
        if (!new Location(_config.getInt("window-size-x"),
                          _config.getInt("window-size-y")).
                          equals(new Location(_game.w,_game.h))) {
            _other.resizeWindow(_game);
        }
        EventProcessChat ProcessChat = new EventProcessChat();
        ProcessChat.start();
    }
}






