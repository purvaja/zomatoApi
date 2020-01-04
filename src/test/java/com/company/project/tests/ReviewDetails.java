package com.company.project.tests;

import com.company.project.validations.ReviewDataValidation;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ApiConfig;
import utils.ApiUtils;
import utils.ResponseCode;


public class ReviewDetails extends BaseTest implements ResponseCode {
    private static final Logger logger = LoggerFactory.getLogger("CuisineDetails");

     ReviewDataValidation reviewValidation = new ReviewDataValidation();

    @Test
    public void getReviewDetails() {
        logger.info("Fetching restaurant reviews with respect to Zomato restaurant id ");
        RestAssured.baseURI = apiConfig.getHost();

        //String filePath = System.getProperty("user.dir")+ "\\src\\resources\\testData\\cityIdList.txt";
        String filePath = System.getProperty("user.dir") + apiConfig.getRestaurantIDListFromTestData();
        String[] resIdList = getLinewiseTextFromFile(filePath);
        for (String resId : resIdList) {
            if (resId != null && !resId.isEmpty()) {
                int iresId = Integer.parseInt(resId);
                String uri = String.format(apiConfig.getReviewDetails(), iresId);
                Response response = apiUtils.getApiResponse(OK, uri);
                Assert.assertTrue(reviewValidation.validateReviewsById(response), "Review Details for restaurants have produced invalid response");
            }
        }

    }
}



