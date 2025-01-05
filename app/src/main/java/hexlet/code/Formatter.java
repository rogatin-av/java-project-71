package hexlet.code;

import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

import java.io.IOException;
import java.util.Map;

public class Formatter {

    private static final String PLAIN_FORMAT = "plain";
    private static final String JSON_FORMAT = "json";
    private static final String STYLISH_FORMAT = "stylish";

    public static String format(Map<String, Entry> entries, String outputFormat) throws IOException {
        return switch (outputFormat) {
            case PLAIN_FORMAT -> PlainFormatter.format(entries);
            case JSON_FORMAT -> JsonFormatter.format(entries);
            case STYLISH_FORMAT -> StylishFormatter.format(entries);
            default -> throw new IOException("Wrong output format");
        };
    }
}
