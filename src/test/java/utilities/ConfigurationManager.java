package utilities;

public class ConfigurationManager {

    private static ConfigurationManager instance;

    public ConfigurationManager() {
    }

    public static ConfigurationManager getInstance() {
        instance = new ConfigurationManager();
        return instance;
    }

    public void loadData() {
    }
}
