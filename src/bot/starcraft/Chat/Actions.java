package bot.starcraft.Chat;

import bot.starcraft.Object.ChatBox;
import org.sikuli.script.Key;

public class Actions {

    public void ChatSay(String _text, ChatBox _chatbox) {
        _chatbox.r.click();
        _chatbox.r.paste(_text);
        _chatbox.r.type(Key.ENTER);
    }

    public String GetUsername(String _text) {
        return "";
    }

}
