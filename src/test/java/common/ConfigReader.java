package common;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;
    public ConfigReader() {
        try {
            properties = new Properties();
            InputStream inputStream = getClass()
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

            properties.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
