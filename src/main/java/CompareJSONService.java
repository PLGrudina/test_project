import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONCompare;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.JSONCompareResult;


import javax.ws.rs.core.UriBuilder;
import java.io.*;
import java.net.URI;
import java.nio.file.Paths;

import static java.nio.file.Files.readAllBytes;

public class CompareJSONService {

    public JSONObject getJSONfromFile(String path) throws JSONException, IOException {
            String jsonTxt = new String(readAllBytes(Paths.get(path)));
            return new JSONObject(jsonTxt);
    }

    public boolean compare(JSONObject local, JSONObject existing) throws JSONException {
        JSONCompareResult result = JSONCompare.compareJSON(local, existing, JSONCompareMode.STRICT);
        return result.failed();
    }

    public void withEx(){
        try {
            System.out.println("FROM METHOD BODY");
            if(true){
                throw new IllegalArgumentException("EX");
            }
        } catch (Exception ex){
            System.out.println("EXCEPTION MESSAGE "+ ex.getMessage());
            return;
        }
        System.out.println("METHOD DONT STOP");
    }

    public URI getValidateFeatureDefinitionsURL(String featureDefinitionsID) {
        UriBuilder builder = UriBuilder.fromPath("http://localhost:8080")
                .path("/v2/featuredefinitions")
                .path(featureDefinitionsID)
                .path("validate");

        return builder.build();
    }
}
