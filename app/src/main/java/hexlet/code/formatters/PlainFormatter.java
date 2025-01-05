package hexlet.code.formatters;

import hexlet.code.Entry;

import java.util.List;
import java.util.Map;

public class PlainFormatter {

    public static String format(Map<String, Entry> entries) {
        StringBuilder sb = new StringBuilder();
        entries.forEach((key, entry) -> {
            switch (entry.getStatus()) {
                case Entry.ADDED:
                    sb.append("Property '")
                            .append(key)
                            .append("' was added with value: ")
                            .append(checkValue(entry.getValue1()))
                            .append("\n");
                    break;
                case Entry.UPDATED:
                    sb.append("Property '")
                            .append(key)
                            .append("' was updated. From ")
                            .append(checkValue(entry.getValue1()))
                            .append(" to ")
                            .append(checkValue(entry.getValue2()))
                            .append("\n");
                    break;
                case Entry.REMOVED:
                    sb.append("Property '")
                            .append(key)
                            .append("' was removed\n");
                    break;
                default:
            }
        });
        return sb.toString().trim();
    }

    private static String checkValue(Object value) {
        if (value == null) {
            return "null";
        } else if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else {
            return value.toString();
        }
    }
}
