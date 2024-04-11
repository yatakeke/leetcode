package romanToInt;

import java.util.HashMap;

public class Solution {

    private HashMap<String, Integer> countMap = getCountMap();
    public int romanToInt(String s) {

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            var chatAt = String.valueOf(s.charAt(i));
            result += this.countMap.get(chatAt);

        }
        return result;
    }

    private HashMap<String, Integer> getCountMap() {
        var countMap = new HashMap<String, Integer>();
        countMap.put("I", 1);
        countMap.put("X", 10);
        countMap.put("C", 100);
        return countMap;
    }
}
