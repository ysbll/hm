package utils;

public class TestDataReader extends FileReader{
    private String categoryURL;
    public String customerServiceURL;
    private String testDataLocation;
    private String productURL;

    public TestDataReader(String testDataLocation)
     {
         super(testDataLocation);
         this.testDataLocation = testDataLocation;
     }


     void loadData(){
        categoryURL = properties.getProperty("category.url");
        customerServiceURL = properties.getProperty("customerService.url");
        productURL = properties.getProperty("product.url");

    }

    public String getTestDataLocation(){
        return testDataLocation;
    }

    public String getCustomerServiceURL(){
        return customerServiceURL;
    }

    public String getCategoryURL(){
        return categoryURL;
    }

    public String getProductURL() { return productURL;}
}
