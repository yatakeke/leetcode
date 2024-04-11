package romanToInt;

import java.util.HashMap;

public class Solution {

    private HashMap<String, Integer> countMap = getCountMap();
    private HashMap<String, Integer> minusMap = getMinusMap();
    public int romanToInt(String s) {

        int result = 0;

        for (var key: this.minusMap.keySet()) {
            if (s.contains(new StringBuilder(key))) {
                result -= this.minusMap.get(key);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            var chatAt = String.valueOf(s.charAt(i));
            result += this.countMap.get(chatAt);

        }
        return result;
    }

    private HashMap<String, Integer> getMinusMap() {
        var minusMap = new HashMap<String, Integer>();
        minusMap.put("IV", 2);
        minusMap.put("IX", 2);
        minusMap.put("XL", 20);
        minusMap.put("XC", 20);
        minusMap.put("CD", 200);
        minusMap.put("CM", 200);
        return minusMap;
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
