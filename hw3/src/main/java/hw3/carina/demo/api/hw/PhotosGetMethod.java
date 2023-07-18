package hw3.carina.demo.api.hw;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.env.endpoint_url}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/photos/_get/photoRs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PhotosGetMethod extends AbstractApiMethodV2
{
}
