package hexlet.code;

import lombok.Getter;

@Getter

public class Entry {
    public static final String REMOVED = "removed";
    public static final String SAVED = "saved";
    public static final String ADDED = "added";
    public static final String UPDATED = "updated";

    private String status;
    private Object value1;
    private Object value2;

    Entry(String status, Object oldValue, Object newValue) {
        this.status = status;
        this.value1 = oldValue;
        this.value2 = newValue;
    }

    Entry(String status, Object value) {
        this.status = status;
        this.value1 = value;
    }
}
