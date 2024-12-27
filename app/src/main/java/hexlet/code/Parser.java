package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String filepath) throws Exception {
        String extension = getExtension(filepath);
        ObjectMapper mapper = getMapper(extension);
        Path path = Paths.get(filepath).toAbsolutePath().normalize();
        return mapper.readValue(path.toFile(), Map.class);
    }

    private static String getExtension(String filepath) {
        String[] paths = filepath.split("\\.");
        return paths[paths.length - 1].toLowerCase().trim();
    }

    private static ObjectMapper getMapper(String extension) {
        ObjectMapper mapper = null;
        switch (extension) {
            case "json":
                mapper = new ObjectMapper();
                break;
            case "yaml":
            case "yml":
                mapper = new YAMLMapper();
                break;
            default:
                System.out.println("Wrong file extention");
        }
        return mapper;
    }
}
