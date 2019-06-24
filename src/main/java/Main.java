import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws JSONException, IOException {
    CompareJSONService service = new CompareJSONService();
        JSONObject local = service.getJSONfromFile("/svnwork/test_project/src/main/java/features.json");
        JSONObject exist = service.getJSONfromFile("/svnwork/test_project/src/main/java/features2.json");
//        System.out.println("This JSONs are diff? -> " + service.compare(local, exist));
//        service.withEx();
        System.out.println(service.getValidateFeatureDefinitionsURL("ID"));
    }
}
