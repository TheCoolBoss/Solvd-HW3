package hw3.carina.demo.hw.api;

// import org.apache.logging.log4j.LogManager;
// import org.apache.logging.log4j.Logger;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.config.Configuration;
import hw3.carina.demo.api.hw.PhotosGetMethod;
import hw3.carina.demo.api.hw.PhotosPatchMethod;
import hw3.carina.demo.api.hw.PhotosPostMethod;
import io.restassured.response.Response;

public class HttpTest implements IAbstractTest
{
    //Left here just in case I need it later
    //private static final Logger LOGGER = LogManager.getLogger(HttpTest.class);

    public Response postLogic()
    {
        PhotosPostMethod post = new PhotosPostMethod();
        post.setProperties("api/photos/photo.properties");
        Response r = post.callAPIExpectSuccess();
        post.validateResponse();
        return r;
    }


    @Test()
    public void testGet()
    {
        PhotosGetMethod get = new PhotosGetMethod();
        get.callAPIExpectSuccess();
        get.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey() + "albumId" + "id" + "title" + "url" + "thumbnailUrl");
        get.validateResponseAgainstSchema("api/photos/_get/photo.schema");
    }

    @Test()
    public void testPost()
    {
        postLogic();
    }

    @Test()
    public void testPostWithMissingField()
    {
        PhotosPostMethod post = new PhotosPostMethod();
        post.setProperties("api/photos/photo.properties");
        post.getProperties().remove("title");
        post.getProperties().remove("thumbnailUrl");
        post.callAPIExpectSuccess();
        post.validateResponse();
    }

    @Test()
    public void testPatch()
    {
        //Create with post first
        Response createdResponse = postLogic();
        String id = createdResponse.jsonPath().getString("id");

        PhotosPatchMethod patch = new PhotosPatchMethod();

        patch.replaceUrlPlaceholder("base_url", Configuration.getRequired("endpoint_url") + "/" + id);
        patch.setProperties("api/photos/_patch/patch.properties");
        patch.callAPIExpectSuccess();
        patch.validateResponse();
    }
}
