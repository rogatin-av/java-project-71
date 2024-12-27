package hexlet.code;

import java.util.Map;

public class Differ {

    public static String generate(String filepath1, String filepath2, String outputFormat) throws Exception {
        Map<String, Object> map1 = Parser.parse(filepath1);
        Map<String, Object> map2 = Parser.parse(filepath2);
        Map<String, Entry> entries = Comparator.compare(map1, map2);
        return Formatter.format(entries, outputFormat);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        String format = "stylish";
        return generate(filepath1, filepath2, format);
    }
}
