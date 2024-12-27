package hexlet.code.formatters;

import hexlet.code.Entry;

import java.util.Map;

public class StylishFormatter {

    public static String format(Map<String, Entry> entries) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        entries.forEach((key, entry) -> {
            switch (entry.getStatus()) {
                case Entry.ADDED:
                    sb.append("\n  + ")
                            .append(key)
                            .append(": ")
                            .append(entry.getValue1());
                    break;
                case Entry.UPDATED:
                    sb.append("\n  - ")
                            .append(key)
                            .append(": ")
                            .append(entry.getValue1())
                            .append("\n  + ")
                            .append(key)
                            .append(": ")
                            .append(entry.getValue2());
                    break;
                case Entry.REMOVED:
                    sb.append("\n  - ")
                            .append(key)
                            .append(": ")
                            .append(entry.getValue1());
                    break;
                default:
                    sb.append("\n    ")
                            .append(key)
                            .append(": ")
                            .append(entry.getValue1());
            }
        });
        sb.append("\n}");
        return sb.toString().trim();
    }
}
