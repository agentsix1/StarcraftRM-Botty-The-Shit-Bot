package bot.starcraft.Chat;

import bot.starcraft.JSON.CommandJson;
import bot.starcraft.JSON.PermissionJson;
import bot.starcraft.Main;
import bot.starcraft.Object.ChatBox;
import bot.starcraft.Object.Game;

import java.util.*;

public class EventProcessCommand {
    Other _other = new Other();
    public void Command(String _user, String _channel, String _message, ChatBox _chatbox, Game _game) {
        PermissionJson _pj = new PermissionJson();
        Actions _action = new Actions();
        CommandJson _cj = new CommandJson();
        String _triggerA = "!";
        String _triggerB = "i";
        try {
            if (hasTrigger(_message, _triggerA) || hasTrigger(_message, _triggerB)) {
                List<String> _args = getCommandArgs(_message);
                Dictionary<String, String> _command = _cj.getCommand(_args.get(0));
                if (_command != new Hashtable<String, String>()) {
                    if (_command.get("built-in").equals("true")) {
                        if (_args.get(0).toLowerCase().equals("whoami") && _args.size() == 1 && _pj.hasPermission(_user, _command.get("permission"))) {
                            String _rank = _pj.getPermission(_user);
                            String _added = _pj.getAdded(_user);
                            _action.ChatSay(_user + ", is rank " + _rank + " added to the system " + _added, _chatbox);
                        } else if (_args.get(0).toLowerCase().equals("whois") && _args.size() > 1 && _pj.hasPermission(_user, _command.get("permission"))) {
                            String _rank = _pj.getPermission(_args.get(1));
                            String _added = _pj.getAdded(_args.get(1));
                            _action.ChatSay(_args.get(1) + ", is rank " + _rank + " added to the system " + _added, _chatbox);
                        } else if (_args.get(0).toLowerCase().equals("flip") && _pj.hasPermission(_user, _command.get("permission"))) {
                            _action.ChatSay("The coin is showing " + _action.CoinFlip(), _chatbox);

                        }
                    } else if (_pj.hasPermission(_user, _command.get("permission"))) {
                        _action.ChatSay(commandReplace(_command.get("usage"),_user, _message, _channel, _args), _chatbox);
                    }
                }
            }
        } catch (Exception e) {}
    }

    public String commandReplace(String _text, String _user, String _message, String _channel, List<String> _args) {
        String _msg = "";
        try {
            int i = 0;
            for (String arg : _args) {
                if (i == 0) { i++; continue; }
                _msg += " " + arg;
                i++;
            }
            _msg = _msg.substring(1, _msg.length());
        } catch (Exception e) {

        }
        return _text.replaceAll("%TIME%", _other.getTime()).
                replaceAll("%DETAIL_TIME%", _other.getDetailedTime()).replaceAll("%USER%", _user).
                replaceAll("%MSG%", _msg).replaceAll("%VER%", Main._ver);
    }

    public boolean hasTrigger(String _cmd, String _trigger) {
        if (_cmd.substring(0, 1).equals(_trigger)) {
            return true;
        }
        return false;
    }

    public List<String> getCommandArgs(String _message) {
        return Arrays.asList(_message.substring(1, _message.length()).split(" "));
    }
}
