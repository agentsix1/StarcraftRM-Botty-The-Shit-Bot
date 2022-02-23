package bot.starcraft.Chat;

import bot.starcraft.JSON.ConfigJson;
import bot.starcraft.Object.Chat;
import bot.starcraft.Object.ChatBox;
import bot.starcraft.Object.Game;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EventProcessChat extends Thread {
    Game _game;
    Chat _chat;
    ChatBox _chatbox;
    public Processing _process = new Processing();
    public Other _other = new Other();
    public ConfigJson _c = new ConfigJson();

    public void run(){
        while (true) {
            _game = new Game("Brood War");
            _game.a.focus();
            _chat = new Chat(_game.x + _c.getInt("chat-offset-x"),
                             _game.y + _c.getInt("chat-offset-y"),
                                          _c.getInt("chat-offset-w"),
                                          _c.getInt("chat-offset-h"));
            _chatbox = new ChatBox(_game.x+_c.getInt("chatbox-offset-x"),
                                   _game.y+_c.getInt("chatbox-offset-y"),
                                              _c.getInt("chatbox-offset-w"),
                                              _c.getInt("chatbox-offset-h"));
            if (_c.getBool("chat-highlight")) { _chat.r.highlight(_c.getInt("chat-highlight-time"), "red"); }
            if (_c.getBool("chatbox-highlight")) { _chatbox.r.highlight(_c.getInt("chatbox-highlight-time"), "red"); }
            try {
                _process.UpdateMessages(_chat.r.text());
                if (_process.NewMessages.size() > 0) {
                    for (String _msg : _process.NewMessages) {
                        MessageInterpreter _mi = new MessageInterpreter();
                        String _user = _mi.getUsername(_msg);
                        String _message = _mi.getMessage(_msg);
                        String _channel = _mi.getChannel(_msg);
                        System.out.println("[" + _other.getDetailedTime() + "] (" + _channel + ") " + _user + " -> " + _message);
                        try {
                            EventProcessCommand epc = new EventProcessCommand();
                            epc.Command(_user, _channel, _message, _chatbox, _game);
                        } catch (NullPointerException e) {

                        }
                    }
                    _process.NewMessages.clear();
                }
            } catch (Exception e) { } //e.printStackTrace(); }
        }
    }
}