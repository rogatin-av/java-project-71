package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DifferTest {

    private static String stylishFixture;
    private static String plainFixture;
    private static String jsonFixture;

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
        stylishFixture = getFixtureContent("stylish");
        plainFixture = getFixtureContent("plain");
        jsonFixture = getFixtureContent("json");
    }

    @Test
    void testJsonToStylish() throws Exception {
        String filepath1 = "./src/test/resources/file1.json";
        String filepath2 = "./src/test/resources/file2.json";
        String format = "stylish";
        String actual = Differ.generate(filepath1, filepath2, format);
        String expected = stylishFixture;
        assertEquals(expected, actual);
    }

    @Test
    void testJsonToPlain() throws Exception {
        String filepath1 = "src/test/resources/file1.json";
        String filepath2 = "src/test/resources/file2.json";
        String format = "plain";
        String actual = Differ.generate(filepath1, filepath2, format);
        String expected = plainFixture;
        assertEquals(expected, actual);
    }

    @Test
    void testJsonToJson() throws Exception {
        String filepath1 = "src/test/resources/file1.json";
        String filepath2 = "src/test/resources/file2.json";
        String format = "json";
        String actual = Differ.generate(filepath1, filepath2, format);
        String expected = jsonFixture;
        assertEquals(expected, actual);
    }

    @Test
    void testJsonToDefault() throws Exception {
        String filepath1 = "src/test/resources/file1.json";
        String filepath2 = "src/test/resources/file2.json";
        String actual = Differ.generate(filepath1, filepath2);
        String expected = stylishFixture;
        assertEquals(expected, actual);
    }

    @Test
    void testYamlToStylish() throws Exception {
        String filepath1 = "src/test/resources/file1.yaml";
        String filepath2 = "src/test/resources/file2.yaml";
        String format = "stylish";
        String actual = Differ.generate(filepath1, filepath2, format);
        String expected = stylishFixture;
        assertEquals(expected, actual);
    }

    @Test
    void testYamlToPlain() throws Exception {
        String filepath1 = "src/test/resources/file1.yaml";
        String filepath2 = "src/test/resources/file2.yaml";
        String format = "plain";
        String actual = Differ.generate(filepath1, filepath2, format);
        String expected = plainFixture;
        assertEquals(expected, actual);
    }

    @Test
    void testYamlToJson() throws Exception {
        String filepath1 = "src/test/resources/file1.yaml";
        String filepath2 = "src/test/resources/file2.yaml";
        String format = "json";
        String actual = Differ.generate(filepath1, filepath2, format);
        String expected = jsonFixture;
        assertEquals(expected, actual);
    }

    @Test
    void testYamlToDefault() throws Exception {
        String filepath1 = "src/test/resources/file1.yaml";
        String filepath2 = "src/test/resources/file2.yaml";
        String actual = Differ.generate(filepath1, filepath2);
        String expected = stylishFixture;
        assertEquals(expected, actual);
    }
}
