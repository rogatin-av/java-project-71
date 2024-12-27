package hexlet.code;

import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

import java.io.IOException;
import java.util.Map;

public class Formatter {

    public static String format(Map<String, Entry> entries, String outputFormat) throws IOException {
        switch (outputFormat) {
            case "plain":
                return PlainFormatter.format(entries);
            case "json":
                return JsonFormatter.format(entries);
            default:
                return StylishFormatter.format(entries);
        }
    }
}
