package program;

import java.util.ResourceBundle;

public class JDBCUtils {
    public static final String DATABASE_RESOURCE = "database";

    public static final String URL_KEY = "url";
    public static final String USER_KEY = "user";
    public static final String PASSWORD_KEY = "password";
    private static final ResourceBundle resource = ResourceBundle.getBundle(DATABASE_RESOURCE);

    public static String getValue(String key){
        return resource.getString(key);
    }

}
