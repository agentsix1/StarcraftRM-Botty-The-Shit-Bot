package bot.starcraft;

import bot.starcraft.Chat.EventProcessChat;

import bot.starcraft.Chat.PermissionJson;
import org.sikuli.basics.Settings;

public class Main {

    public static void main(String[] args) {
        Settings.ClickDelay = 0;
        Settings.MoveMouseDelay = 0;
        Settings.ActionLogs = false;
        EventProcessChat ProcessChat = new EventProcessChat();
        ProcessChat.start();
        System.out.println("hello world");
    }
}






