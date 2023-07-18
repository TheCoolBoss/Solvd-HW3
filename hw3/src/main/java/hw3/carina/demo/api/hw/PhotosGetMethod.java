package hw3.carina.demo.api.hw;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/photos", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/photos/_get/photoRs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PhotosGetMethod extends AbstractApiMethodV2
{
    public PhotosGetMethod()
    {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }

}
