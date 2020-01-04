package com.company.project.tests;
import io.restassured.RestAssured;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import utils.ApiConfig;
import utils.ApiUtils;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Properties;

public class BaseTest {
    ApiConfig apiConfig=new ApiConfig();
    ApiUtils apiUtils=new ApiUtils();

    Properties properties;
    @BeforeClass
    public  void setup(){
      apiConfig.getHost();
    }



    public static String[] getLinewiseTextFromFile(String filename) {
        String[] value = new String[100];

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));

            String line = new String();
            for (int i = 0; line != null; i++) {
                line = br.readLine();
                value[i] = line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

}



