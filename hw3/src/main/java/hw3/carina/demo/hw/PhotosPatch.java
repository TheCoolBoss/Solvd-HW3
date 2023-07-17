package hw3.carina.demo.hw;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/photos/5001", methodType = HttpMethodType.PATCH)
@RequestTemplatePath(path = "api/photos/_patch/patchRq.json")
@ResponseTemplatePath(path = "api/photos/_patch/patchRs.json")
public class PhotosPatch extends AbstractApiMethodV2
{
    public PhotosPatch()
    {
        super("api/photos/_patch/patchRq.json", "api/photos/_patch/patchRs.json", "api/photos/_patch/patch.properties");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));  
    }
 
}
