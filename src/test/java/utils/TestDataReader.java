package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataReader extends FileReader{
    private String categoryURL;
    public String customerServiceURL;
    private String testDataLocation;

    public TestDataReader(String testDataLocation)
     {
         super(testDataLocation);
         this.testDataLocation = testDataLocation;
     }


     void loadData(){
        categoryURL = properties.getProperty("category.url");
        customerServiceURL = properties.getProperty("customerService.url");
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
}
