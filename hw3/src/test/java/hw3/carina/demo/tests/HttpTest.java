package hw3.carina.demo.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.IAbstractTest;
import hw3.carina.demo.api.PostUserMethod;
import hw3.carina.demo.hw.PhotosGet;
import hw3.carina.demo.hw.PhotosPatch;
import hw3.carina.demo.hw.PhotosPost;

public class HttpTest implements IAbstractTest
{
    private static final Logger LOGGER = LogManager.getLogger(HttpTest.class);

    @Test()
    public void testGet()
    {
        PhotosGet get = new PhotosGet();
        get.callAPIExpectSuccess();
        get.validateResponse(JSONCompareMode.STRICT_ORDER, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        get.validateResponseAgainstSchema("api/photos/_get/hw/photo.schema");
    }

    @Test()
    public void testPost()
    {
        PhotosPost post = new PhotosPost();
        post.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        post.callAPI();
        post.validateResponse();
    }

    @Test()
    public void testPostWithMissingField()
    {
        PhotosPost post = new PhotosPost();
        post.getProperties().remove("title");
        post.callAPIExpectSuccess();
        post.validateResponse();
    }

    @Test
    public void testPatch()
    {
        //Create with post first
        testPost();

        PhotosPatch patch = new PhotosPatch();
        patch.callAPI();
        //patch.validateResponse();
    }
}
