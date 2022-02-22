package bot.starcraft.Chat;

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


    public void run(){
        while (true) {
            _game = new Game("Brood War");
            _game.a.focus();
            Chat _chat = new Chat(_game.x + 65 , _game.y + 808, 635, 92);
            _chatbox = new ChatBox(_game.x+700, _game.y+925, 10, 10);
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