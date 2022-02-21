package bot.starcraft.Chat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageInterpreter {
    public String getUsername(String _msg) {
        String _user = "";
        Pattern user = Pattern.compile("].*?:");
        Matcher m = user.matcher(_msg);
        if (m.find()) {
            _user = m.group().subSequence(1, m.group().length()-1).toString();
            _user = _user.substring(1, _user.length());
        }
        return _user;
    }
    public String getChannel(String _msg) {
        String _txt = "";
        if (_msg.contains("(")) {
            _txt = _msg.substring(_msg.indexOf("(") + 4, _msg.indexOf("]"));
        } else if (_msg.contains("[")){
            _txt = _msg.substring(_msg.indexOf("[") + 4, _msg.indexOf("]"));
        } else if (_msg.contains("{")) {
            _txt = _msg.substring(_msg.indexOf("{") + 4, _msg.indexOf("]"));
        }
        return _txt;
    }
    public String getMessage(String _msg) {
        String _txt = "";
        if (_msg.contains(":")) {
            _txt = _msg.substring(_msg.indexOf(":")+2, _msg.length());
        } else {
            _txt = _msg;
        }
        return _txt;
    }
}
