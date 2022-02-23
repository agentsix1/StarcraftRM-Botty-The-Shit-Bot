package bot.starcraft.JSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PermissionJson {
    public boolean hasPermission(String _user, String _require) {
        List<String> _ranks = getRanks();
        String _rank = getPermission(_user);
        int value = _ranks.indexOf(_rank);
        int required = _ranks.indexOf(_require);
        if (value == -1 || required == -1) {
            return false;
        }
        if (value <= required) {
            return true;
        } else {
            return false;
        }
    }

    private List<String> getRanks() {
        try {
            JSONParser parser = new JSONParser();
            JSONArray _users = (JSONArray) parser.parse(new FileReader("src/bot/starcraft/JSON/ranks.json"));
            for (Object _u : _users)
            {
                JSONObject _user = (JSONObject) _u;
                JSONArray _ranks = (JSONArray) _user.get("ranks");
                List<String> ranks = new ArrayList<String>();
                for (Object _r : _ranks)
                {
                    ranks.add(_r.toString());
                }
                return ranks;
            }

        } catch (IOException | ParseException e) {
            //e.printStackTrace();
        }
        return new ArrayList<String>();
    }

    public String getPermission(String _get) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray _users = (JSONArray) parser.parse(new FileReader("src/bot/starcraft/JSON/users.json"));
            for (Object _u : _users)
            {
                JSONObject _user = (JSONObject) _u;
                String _username = (String) _user.get("user");
                if (_username.equals(_get)) {
                    return (String) _user.get("rank");
                }
            }
        } catch (IOException | ParseException e) {
           //e.printStackTrace();
        }
        return "Guest";
    }
    public String getAdded(String _get) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray _users = (JSONArray) parser.parse(new FileReader("src/bot/starcraft/JSON/users.json"));
            for (Object _u : _users)
            {
                JSONObject _user = (JSONObject) _u;

                String _username = (String) _user.get("user");
                if (_username.equals(_get)) {
                    return (String) _user.get("added");
                }
            }
        } catch (IOException | ParseException e) {
            //e.printStackTrace();
        }
        return "Never";
    }
}
