package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {

    public static final String JSON_EXTENSION = "json";
    public static final String YAML_EXTENSION = "yaml";
    public static final String YML_EXTENSION = "yml";

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

    private static ObjectMapper getMapper(String extension) throws IOException {
        return switch (extension) {
            case JSON_EXTENSION -> new ObjectMapper();
            case YAML_EXTENSION, YML_EXTENSION -> new YAMLMapper();
            default -> throw new IOException("Wrong input file format");
        };
    }
}
