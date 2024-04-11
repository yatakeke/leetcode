package romanToInt;

import java.util.HashMap;

public class Solution {
    public int romanToInt(String s) {

        var countMap = new HashMap<String, Integer>();
        countMap.put("I", 1);
        countMap.put("X", 10);
        countMap.put("C", 100);

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            var chatAt = String.valueOf(s.charAt(i));
            result += countMap.get(chatAt);

        }
        return result;
    }
}
