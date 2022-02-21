package bot.starcraft.Chat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Other {
    public String getTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss aa");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
    public String getDetailedTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss.SSS aa");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
}
