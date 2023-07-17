package hw3.carina.demo.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.IAbstractTest;
import freemarker.template.Configuration;
import freemarker.template.Version;
import hw3.carina.demo.api.GetUserMethods;
import hw3.carina.demo.api.PostUserMethod;

public class HttpTest implements IAbstractTest
{
    private static final Logger LOGGER = LogManager.getLogger(HttpTest.class);

    @Test()
    public void testGet()
    {
        GetUserMethods get = new GetUserMethods();
        get.callAPIExpectSuccess();
        //get.validateResponse(JSONCompareMode.STRICT_ORDER, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        get.validateResponseAgainstSchema("api/users/_get/rs.schema");
    }

    @Test()
    public void testPost()
    {
        PostUserMethod post = new PostUserMethod();
        post.setProperties("api/users/user.properties");
        post.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        post.callAPI();
        post.validateResponse();
    }

    @Test
    public void testPatch()
    {
        
    }
}
