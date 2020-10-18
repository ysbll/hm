package utilities;

public class ConfigurationReader extends FileReader {
    private String baseUrl;
    private String configurationLocation;

    public ConfigurationReader(String configurationLocation) {
        super(configurationLocation);
        this.configurationLocation = configurationLocation;
    }

    void loadData() {
        baseUrl = properties.getProperty("baseUrl");
    }

    public String getConfigurationLocation() {
        return configurationLocation;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
