package hw3.carina.demo.hw;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.IAbstractTest;
import hw3.carina.demo.hw.PhotosGet;
import hw3.carina.demo.hw.PhotosPatch;
import hw3.carina.demo.hw.PhotosPost;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class HttpTest implements IAbstractTest
{
    private static final Logger LOGGER = LogManager.getLogger(HttpTest.class);

    @Test()
    public void testGet()
    {
        PhotosGet get = new PhotosGet();
        Response r = get.callAPIExpectSuccess();
        get.validateResponse(JSONCompareMode.STRICT_ORDER, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        get.validateResponseAgainstSchema("api/photos/_get/hw/photo.schema");
        JsonPath path = r.getBody().jsonPath();
    }

    @Test()
    public void testPost()
    {
        PhotosPost post = new PhotosPost();
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
        PhotosPost post = new PhotosPost();
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

        PhotosPatch patch = new PhotosPatch();
        patch.setProperties("api/photos/_patch/patch.properties");
        patch.callAPI();
        //patch.validateResponse();
    }
}
