package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DifferTest {

    private static final String FILE1 = "file1";
    private static final String FILE2 = "file2";
    private static final String JSON_EXC = ".json";
    private static final String YAML_EXC = ".yaml";
    private static final String STYLISH_FORMAT = "stylish";
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
        stylish = getFixtureContent(STYLISH_FORMAT);
        plain = getFixtureContent(PLAIN_FORMAT);
        json = getFixtureContent(JSON_FORMAT);
    }

    @ParameterizedTest
    @ValueSource(strings = { JSON_EXC, YAML_EXC })
    void testDefault(String fileException) throws Exception {
        String filepath1 = getFixturePath(FILE1 + fileException).toString();
        String filepath2 = getFixturePath(FILE2 + fileException).toString();

        String actual = Differ.generate(filepath1, filepath2);
        String expected = stylish;

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = { JSON_EXC, YAML_EXC })
    void testStylish(String fileException) throws Exception {
        String filepath1 = getFixturePath(FILE1 + fileException).toString();
        String filepath2 = getFixturePath(FILE2 + fileException).toString();

        String actual = Differ.generate(filepath1, filepath2, STYLISH_FORMAT);
        String expected = stylish;

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = { JSON_EXC, YAML_EXC })
    void testPlain(String fileException) throws Exception {
        String filepath1 = getFixturePath(FILE1 + fileException).toString();
        String filepath2 = getFixturePath(FILE2 + fileException).toString();

        String actual = Differ.generate(filepath1, filepath2, PLAIN_FORMAT);
        String expected = plain;

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = { JSON_EXC, YAML_EXC })
    void testJson(String fileException) throws Exception {
        String filepath1 = getFixturePath(FILE1 + fileException).toString();
        String filepath2 = getFixturePath(FILE2 + fileException).toString();

        String actual = Differ.generate(filepath1, filepath2, JSON_FORMAT);
        String expected = json;

        assertEquals(expected, actual);
    }
}
