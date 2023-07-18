package hw3.carina.demo.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.IAbstractTest;

import hw3.carina.demo.api.hw.PhotosGetMethod;
import hw3.carina.demo.api.hw.PhotosPatchMethod;
import hw3.carina.demo.api.hw.PhotosPostMethod;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class HttpTest implements IAbstractTest
{
    private static final Logger LOGGER = LogManager.getLogger(HttpTest.class);

    @Test()
    public void testGet()
    {
        PhotosGetMethod get = new PhotosGetMethod();
        Response r = get.callAPIExpectSuccess();
        get.validateResponse(JSONCompareMode.STRICT_ORDER, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        get.validateResponseAgainstSchema("api/photos/_get/hw/photo.schema");
        JsonPath path = r.getBody().jsonPath();
    }

    @Test()
    public void testPost()
    {
        PhotosPostMethod post = new PhotosPostMethod();
        post.setProperties("api/photos/photo.properties");
        post.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        Response r = post.callAPI();
        post.validateResponse();
        JsonPath path = r.getBody().jsonPath();
        String title = path.getString("0.title");
        LOGGER.info(title);
    }

    @Test()
    public void testPostWithMissingField()
    {
        PhotosPostMethod post = new PhotosPostMethod();
        post.setProperties("api/photos/photo.properties");
        post.getProperties().remove("title");
        post.callAPIExpectSuccess();
        post.validateResponse();
    }

    @Test()
    public void testPatch()
    {
        //Create with post first
        testPost();

        PhotosPatchMethod patch = new PhotosPatchMethod();
        patch.setProperties("api/photos/_patch/patch.properties");
        patch.callAPI();
        //patch.validateResponse();
    }
}
