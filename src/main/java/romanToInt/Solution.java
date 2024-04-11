package romanToInt;

import java.util.HashMap;

public class Solution {

    private HashMap<String, Integer> countMap = getCountMap();
    public int romanToInt(String s) {

        int result = 0;
        if (s.contains(new StringBuilder("IV"))) {
            result -= 2;
        }

        if (s.contains(new StringBuilder("IX"))) {
            result -= 2;
        }

        for (int i = 0; i < s.length(); i++) {
            var chatAt = String.valueOf(s.charAt(i));
            result += this.countMap.get(chatAt);

        }
        return result;
    }

    private HashMap<String, Integer> getCountMap() {
        var countMap = new HashMap<String, Integer>();
        countMap.put("I", 1);
        countMap.put("V", 5);
        countMap.put("X", 10);
        countMap.put("L", 50);
        countMap.put("C", 100);
        countMap.put("D", 500);
        countMap.put("M", 1000);
        return countMap;
    }
}
