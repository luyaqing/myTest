package MapTest;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *  HashMap 和 treeMap的对比
 */
public class TreeMapRepeat {

    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(new Key(), "value one");
        treeMap.put(new Key(), "value two");
        System.out.println(treeMap.size()); // key去重规则是根据排序结果

        Map<Key, String> hashMap = new HashMap<>();
        hashMap.put(new Key(), "value 1");
        hashMap.put(new Key(), "value 2");
        System.out.println(hashMap.size()); // 根据equals和hashCode的比较结果
    }
}

class Key implements Comparable<Key> {

    @Override
    public int compareTo(Key other) {
        return -1;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object object) {
        return true;
    }
}
