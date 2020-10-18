package drivers;

public enum BrowserType {

    FIREFOX("firefox"),
    CHROME("chrome"),
    SAFARI("safari"),
    IE("internetexplorer");

    private final String browser;

    BrowserType(String browser) {
        this.browser = browser;
    }
}
