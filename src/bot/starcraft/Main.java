package bot.starcraft;

import bot.starcraft.Chat.EventProcessChat;

import org.sikuli.basics.Settings;

public class Main {
    public String _ver = "v0.0.1 dev";
    public void main(String[] args) {
        System.out.println("Botty The Shit Bot " + _ver);
        Settings.ClickDelay = 0;
        Settings.MoveMouseDelay = 0;
        Settings.ActionLogs = false;
        EventProcessChat ProcessChat = new EventProcessChat();
        ProcessChat.start();
        System.out.println("hello world");
    }
}






