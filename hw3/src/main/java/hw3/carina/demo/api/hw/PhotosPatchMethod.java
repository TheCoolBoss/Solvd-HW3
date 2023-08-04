package hw3.carina.demo.api.hw;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.apache.http.HttpStatus;

@Endpoint(url = "${config.env.endpoint_url}/${id}", methodType = HttpMethodType.PATCH)
@RequestTemplatePath(path = "api/photos/_patch/patchRq.json")
@ResponseTemplatePath(path = "api/photos/_patch/patchRs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PhotosPatchMethod extends AbstractApiMethodV2
{ 
}
