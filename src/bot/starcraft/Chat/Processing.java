package bot.starcraft.Chat;

import bot.starcraft.Chat.Similar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Processing {

    public void UpdateMessages(String _text) {
        if (!Log.contains(_text)) {
            Log+=_text;
            _text = CleanLog(_text);
            List<String> _chat_text = Arrays.asList(_text.split("\\r?\\n"));
            UpdateLogList(_chat_text);
        }
    }

    String Log = "";
    ArrayList<String> LogList = new ArrayList<String>();
    public ArrayList<String> NewMessages = new ArrayList<String>();
    private String CleanLog(String text) {
        List<String> _chat_text = Arrays.asList(text.split("\\r?\\n"));
        List<String> _chat_text_out = new ArrayList<String>();
        int i = 0;
        for (String l : _chat_text) {
            if ((!l.substring(0, 3).equals("(2.")) && (!l.substring(0, 3).equals("{2.")) && (!l.substring(0, 3).equals("[2."))) {
                if (isServer(l)) {
                    if (i == 0) { continue; }
                    if ((!_chat_text.get(i-1).substring(0, 3).equals("(2.")) && (!_chat_text.get(i-1).substring(0, 3).equals("{2.")) && (!_chat_text.get(i-1).substring(0, 3).equals("[2."))) {
                        if (_chat_text_out.size() < 2) { continue; }
                        if (_chat_text.size() < 2) { continue; }
                        _chat_text.set(i-2, _chat_text.get(i-2) + " " + l);
                        try {
                            _chat_text_out.set(i-2, _chat_text.get(i-2));
                        } catch (Exception e) { continue; }
                    } else {
                        if (_chat_text_out.size() < 1) { continue; }
                        if (_chat_text.size() < 1) { continue; }
                        _chat_text.set(i-1, _chat_text.get(i-1) + " " + l);
                        try {
                            _chat_text_out.set(i-1, _chat_text.get(i-1));
                        } catch (Exception e) { continue; }
                    }
                } else { _chat_text_out.add(l); }
            } else { _chat_text_out.add(l); }
            i++;
        }
        String out = "";
        for (String l : _chat_text_out) {
            out+=l+"\r\n";
        }
        try {
            return out.substring(0, out.length()-2);
        } catch (Exception e) {
            return "";
        }

    }

    private void UpdateLogList(List<String> lines) {
        Similar s = new Similar();
        List<String> add = new ArrayList<String>();
        for (String l : lines) {
            if (LogList.size() < 6) {
                LogList.add("");LogList.add("");LogList.add("");LogList.add("");
                LogList.add("");LogList.add("");LogList.add("");LogList.add("");
            }
            double similar = 0.960;
            if (s.similarity(LogList.get(LogList.size()-5), l)<similar && s.similarity(LogList.get(LogList.size()-4), l)<similar &&
                    s.similarity(LogList.get(LogList.size()-3), l)<similar && s.similarity(LogList.get(LogList.size()-2), l)<similar &&
                    s.similarity(LogList.get(LogList.size()-1), l)<similar) {
                add.add(l);

            } else {
                continue;
            }
        }
        for (String l : add) {
            NewMessages.add(l);
            LogList.add(l);
        }
    }

    private boolean isServer(String text) {
        if (!text.startsWith("Joining channel ") && !text.startsWith("Joined channel ")) {
            if (!text.startsWith("Leaving channel ") && !text.startsWith("That is not a valid command ")) {
                if (!text.startsWith("Available commands ") && !text.startsWith("/away ")) {
                    if (!text.startsWith("Type /help COMMAND") && !text.startsWith("/away ")) {
                        if (!text.startsWith("Error") && !text.startsWith("No one hears")) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
