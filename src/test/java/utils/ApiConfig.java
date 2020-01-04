package utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class ApiConfig {

    Properties properties;

    public ApiConfig() {
        File src = new File("src/main/java/configs/config.properties");
        try {
            FileInputStream fileInputStream = new FileInputStream(src);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getHost() {
        String host = properties.getProperty("host");
        return host;
    }

    public String getApiKey() {
        String apiKey = properties.getProperty("apiKey");
        return apiKey;
    }

    public String getCityCuisinesDetails() {
        return properties.getProperty("cityCuisinesDetailsApi");
    }

    public String getCityIDListFromTestData() {
     return properties.getProperty("cityIdListFilePath");
    }

    public String getRestaurantSearchQuery(){
        return properties.getProperty("restaurantSearchQuery");
    }

    public String getRestaurantIDListFromTestData(){
        return properties.getProperty("restaurantIdListFilePath");
    }

    public String getReviewDetails(){
        return properties.getProperty("reviewApi");
    }
}
