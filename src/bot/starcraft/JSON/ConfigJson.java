package bot.starcraft.JSON;

import com.fasterxml.jackson.databind.node.BooleanNode;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

public class ConfigJson {
    public Object getConfig(String _request) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray ___config = (JSONArray) parser.parse(new FileReader("src/bot/starcraft/JSON/config.json"));
            Object __config = ___config.get(0);
            JSONObject _config = (JSONObject) __config;
            try {
                return _config.get(_request);
            } catch (Exception e) {
                return new Object();
            }
        } catch (IOException | ParseException e) {
            //e.printStackTrace();
        }
        return new Object();
    }
    public int getInt(String _request) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray ___config = (JSONArray) parser.parse(new FileReader("src/bot/starcraft/JSON/config.json"));
            Object __config = ___config.get(0);
            JSONObject _config = (JSONObject) __config;
            try {
                return Integer.parseInt(_config.get(_request).toString());
            } catch (Exception e) {
                return -1;
            }
        } catch (IOException | ParseException e) {
            //e.printStackTrace();
        }
        return -1;
    }
    public boolean getBool(String _request) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray ___config = (JSONArray) parser.parse(new FileReader("src/bot/starcraft/JSON/config.json"));
            Object __config = ___config.get(0);
            JSONObject _config = (JSONObject) __config;
            try {
                return Boolean.valueOf((_config.get(_request).toString()));
            } catch (Exception e) {
                return false;
            }
        } catch (IOException | ParseException e) {
            //e.printStackTrace();
        }
        return false;
    }
    public String getString(String _request) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray ___config = (JSONArray) parser.parse(new FileReader("src/bot/starcraft/JSON/config.json"));
            Object __config = ___config.get(0);
            JSONObject _config = (JSONObject) __config;
            try {
                return _config.get(_request).toString();
            } catch (Exception e) {
                return "";
            }
        } catch (IOException | ParseException e) {
            //e.printStackTrace();
        }
        return "";
    }
}
