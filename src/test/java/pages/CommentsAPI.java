package pages;
import java.util.List;
import java.util.Map;
import utils.APIHandler;

public class CommentsAPI {
    public boolean responseContainsCommentWithId(int id) {
        Map<String, ?> responseMap = APIHandler.response.jsonPath().getMap("$");
        return responseMap.get("id").equals(id);
    }
    public boolean responseContainsCommentString(String key,String value){
        Map<String, ?> responseMap = APIHandler.response.jsonPath().getMap("$");
        return responseMap.get(key).equals(value);
    }
    public Integer getIdFromResponse() {
        return APIHandler.response.jsonPath().getInt("id");
    }
}