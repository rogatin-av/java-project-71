package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Entry;

import java.io.IOException;
import java.util.Map;

public class JsonFormatter {

    public static String format(Map<String, Entry> entries) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(StylishFormatter.format(entries));
        return result.trim();
    }
}
