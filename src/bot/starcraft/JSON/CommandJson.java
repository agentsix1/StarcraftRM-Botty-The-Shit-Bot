package bot.starcraft.JSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

public class CommandJson {

    public Dictionary<String, String> getCommand(String _request) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray _users = (JSONArray) parser.parse(new FileReader("src/bot/starcraft/JSON/commands.json"));
            for (Object _u : _users)
            {
                JSONObject _user = (JSONObject) _u;
                String _command = (String) _user.get("command");
                if (_command.equals(_request)) {
                    Dictionary<String, String> _output = new Hashtable<String, String>();
                    String _permission = (String) _user.get("permission");
                    String _usage = (String) _user.get("usage");
                    String _timeout = (String) _user.get("timeout");
                    String _builtin = (String) _user.get("built-in");
                    _output.put("command", _command);
                    _output.put("permission", _permission);
                    _output.put("usage", _usage);
                    _output.put("timeout", _timeout);
                    _output.put("built-in", _builtin);
                    return _output;
                }
            }
        } catch (IOException | ParseException e) {
            //e.printStackTrace();
        }
        return new Hashtable<String, String>();
    }

}
