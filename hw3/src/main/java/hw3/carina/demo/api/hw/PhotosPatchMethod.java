package hw3.carina.demo.api.hw;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = "${base_url}", methodType = HttpMethodType.PATCH)
@RequestTemplatePath(path = "api/photos/_patch/patchRq.json")
@ResponseTemplatePath(path = "api/photos/_patch/patchRs.json")
public class PhotosPatchMethod extends AbstractApiMethodV2
{ 
}
