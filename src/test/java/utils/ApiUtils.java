package utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ApiUtils {

    static Logger logger= LoggerFactory.getLogger("API utils- ");
    ApiConfig apiConfig=new ApiConfig();

    public Response getApiResponse(final int responseCode, final String uri) {
        logger.info("GET " + uri);
        Response res=given().header("user-key",apiConfig.getApiKey()).get(uri).then().statusCode(responseCode).extract().response();
        logger.info(" Expected Response " + responseCode + " Observed Response " + res.getStatusCode()+"\n"+res.asString());

        return res;
    }

    public static boolean isJSONValid(String test) {
        try {
            new JSONObject(test);
        } catch (JSONException ex) {
            try {
                new JSONArray(test);
            } catch (JSONException ex1) {
                return false;
            }
        }
        return true;
    }

}
