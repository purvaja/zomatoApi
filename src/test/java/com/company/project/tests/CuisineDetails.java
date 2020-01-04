package com.company.project.tests;

import com.company.project.validations.CuisinesDataValidation;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import utils.ApiConfig;
import utils.ApiUtils;
import utils.ResponseCode;

public class CuisineDetails extends BaseTest implements ResponseCode {
    private static final Logger logger = LoggerFactory.getLogger("CuisineDetails");

    CuisinesDataValidation dataValidation= new CuisinesDataValidation();

    @Test
    public void getCuisineDetailsWithCity() {
        logger.info("Fetching cuisine data with respect to cities ");
        RestAssured.baseURI=apiConfig.getHost();

        //String filePath = System.getProperty("user.dir")+ "\\src\\resources\\testData\\cityIdList.txt";
        String filePath = System.getProperty("user.dir") + apiConfig.getCityIDListFromTestData();
        String[] cityIdList = getLinewiseTextFromFile(filePath);
        for (String cityId:cityIdList) {
            if (cityId !=null && !cityId.isEmpty()) {
                int icityId = Integer.parseInt(cityId);
                String uri = String.format(apiConfig.getCityCuisinesDetails(), icityId);
                Response response = apiUtils.getApiResponse(OK, uri);
                dataValidation.validateCuisinesDataByCity(response);
            }
        }

    }
}
