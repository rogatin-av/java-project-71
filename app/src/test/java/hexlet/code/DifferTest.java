package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DifferTest {

    private static final String PATH_TO_JSON1 = "src/test/resources/file1.json";
    private static final String PATH_TO_JSON2 = "src/test/resources/file2.json";
    private static final String PATH_TO_YAML1 = "src/test/resources/file1.yaml";
    private static final String PATH_TO_YAML2 = "src/test/resources/file2.yaml";
    private static final String STYILISH_FORMAT = "stylish";
    private static final String PLAIN_FORMAT = "plain";
    private static final String JSON_FORMAT = "json";
    private static String stylish;
    private static String plain;
    private static String json;

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", fileName)
                .toAbsolutePath().normalize();
    }

    private static String getFixtureContent(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim().replaceAll("\r", "");
    }

    @BeforeAll
    public static void beforeAll() throws Exception {
        stylish = getFixtureContent(STYILISH_FORMAT);
        plain = getFixtureContent(PLAIN_FORMAT);
        json = getFixtureContent(JSON_FORMAT);
    }

    @Test
    void testJsonToStylish() throws Exception {
        String actual = Differ.generate(PATH_TO_JSON1, PATH_TO_JSON2, STYILISH_FORMAT);
        String expected = stylish;

        assertEquals(expected, actual);
    }

    @Test
    void testJsonToPlain() throws Exception {
        String actual = Differ.generate(PATH_TO_JSON1, PATH_TO_JSON2, PLAIN_FORMAT);
        String expected = plain;

        assertEquals(expected, actual);
    }

    @Test
    void testJsonToJson() throws Exception {
        String actual = Differ.generate(PATH_TO_JSON1, PATH_TO_JSON2, JSON_FORMAT);
        String expected = json;

        assertEquals(expected, actual);
    }

    @Test
    void testJsonToDefault() throws Exception {
        String actual = Differ.generate(PATH_TO_JSON1, PATH_TO_JSON2);
        String expected = stylish;

        assertEquals(expected, actual);
    }

    @Test
    void testYamlToStylish() throws Exception {
        String actual = Differ.generate(PATH_TO_YAML1, PATH_TO_YAML2, STYILISH_FORMAT);
        String expected = stylish;

        assertEquals(expected, actual);
    }

    @Test
    void testYamlToPlain() throws Exception {
        String actual = Differ.generate(PATH_TO_YAML1, PATH_TO_YAML2, PLAIN_FORMAT);
        String expected = plain;

        assertEquals(expected, actual);
    }

    @Test
    void testYamlToJson() throws Exception {
        String actual = Differ.generate(PATH_TO_YAML1, PATH_TO_YAML2, JSON_FORMAT);
        String expected = json;

        assertEquals(expected, actual);
    }

    @Test
    void testYamlToDefault() throws Exception {
        String actual = Differ.generate(PATH_TO_YAML1, PATH_TO_YAML2);
        String expected = stylish;

        assertEquals(expected, actual);
    }
}
