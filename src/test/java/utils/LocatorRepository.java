package utils;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LocatorRepository {

    static Map<String, String> objectRepository = new HashMap<>();
    static boolean isAndroid;

    public static String  get(String key){
        return objectRepository.get(key);
    }

    public static void load() throws IOException {
        String dir =System.getProperty("user.dir");
        dir += "/src/test/resources/staticData/LocatorRepo";

        List<Path> paths = Files.walk(Paths.get(dir),1)
                    .filter(Files::isRegularFile)
                    .filter(path-> path.getFileName().toString().endsWith(".json"))
                    .collect(Collectors.toList());
        for(Path path : paths) {
            String fileName = path.getFileName().toString().split("\\.")[0] + ".";
            String json = new String(Files.readAllBytes(path));
            JSONObject obj = new JSONObject(json);
            Map<String, Object> map = obj.toMap();
            for (Map.Entry<String,Object> entry : map.entrySet()){
                 String value = (String) (((HashMap) entry.getValue()).get("web"));
                objectRepository.put(fileName + entry.getKey(), value);
                if (((HashMap) entry.getValue()).size()>2){
                    objectRepository.put(fileName + entry.getKey() + ".expectedValue", value);
                }
            }
        }
        System.out.println("Finished Loading Object Repository");
    }
}
