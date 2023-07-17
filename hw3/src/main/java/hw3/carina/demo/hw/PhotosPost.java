package hw3.carina.demo.hw;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/photos", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/photos/_post/rq.json")
@ResponseTemplatePath(path = "api/photos/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PhotosPost extends AbstractApiMethodV2
{
    public PhotosPost()
    {
        super("api/photos/_post/rq.json", "api/photos/_post/rs.json", "api/photos/photo.properties");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}
