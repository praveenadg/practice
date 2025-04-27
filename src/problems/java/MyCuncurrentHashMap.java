package problems.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyCuncurrentHashMap {

    List<Map<String, String>> mapList;//= new ArrayList<>();
    List<Object> locks;// = new ArrayList<>();
    int segment;

    public MyCuncurrentHashMap() {
        segment = 16;
        mapList = new ArrayList<>();
        locks = new ArrayList<>();

        for (int i = 0; i < segment; i++) {
            mapList.add(new HashMap<>());
            locks.add(new Object());
        }
    }

    private int getHashIndex(String key) {
        return Math.abs(key.hashCode()) % segment;
    }

    public String get(String key) {
        int index = getHashIndex(key);
        synchronized (locks.get(index)) {
            return mapList.get(index).getOrDefault(key, "key not found");
        }
    }

    public String remove(String key) {
        int index = getHashIndex(key);
        synchronized (locks.get(index)) {
            String removedval = mapList.get(index).remove(key);
            if (removedval != null) {
                return removedval;
            }
            return "key not found";
        }
    }

    public void put(String key, String val) {
        int index = getHashIndex(key);
        synchronized (locks.get(index)) {
            mapList.get(index).put(key, val);
        }
    }

    public boolean containsKey(String key) {
        int index = getHashIndex(key);
        synchronized (locks.get(index)) {
            return mapList.get(index).containsKey(key);
        }
    }

}
