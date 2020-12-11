package domain;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        HashMap<String, Integer> testMap = new HashMap<>();
        testMap.put("a", 1);
        testMap.put("b", 2);
        testMap.put("c", 3);

        for (Map.Entry<String, Integer> entry : testMap.entrySet()) {
            System.out.println("Key 값 : " + entry.getKey());
            System.out.println("Value 값 : " + entry.getValue());
        }
    }
}
