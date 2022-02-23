package bot.starcraft.Chat;

import bot.starcraft.Object.ChatBox;
import org.sikuli.script.Key;

import java.util.Random;

public class Actions {

    public void ChatSay(String _text, ChatBox _chatbox) {
        _chatbox.r.click();
        _chatbox.r.paste(_text);
        _chatbox.r.type(Key.ENTER);
    }

    public String CoinFlip() {
        Random randomNum = new Random();
        int result = randomNum.nextInt(2);
        if(result == 0){
            return "Heads";
        }else{
            return "Tails";
        }
    }

}
