package hexlet.code;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.TreeSet;

public class Comparator {

    public static Map<String, Entry> compare(Map<String, Object> map1, Map<String, Object> map2) {
        Map<String, Entry> diffRes  = new LinkedHashMap<>();
        TreeSet<String> keys = new TreeSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());
        for (String key : keys) {
            if (map1.containsKey(key) && map2.containsKey(key)) {
                if (Objects.equals(map1.get(key), (map2.get(key)))) {
                    diffRes.put(key, new Entry(Entry.SAVED, map1.get(key)));
                } else {
                    diffRes.put(key, new Entry(Entry.UPDATED, map1.get(key), map2.get(key)));
                }
            } else if (map2.containsKey(key)) {
                diffRes.put(key, new Entry(Entry.ADDED, map2.get(key)));
            } else {
                diffRes.put(key, new Entry(Entry.REMOVED, map1.get(key)));
            }
        }
        return diffRes;
    }
}
