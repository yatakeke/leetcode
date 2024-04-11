package romanToInt;

public class Solution {
    public int romanToInt(String s) {

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).equals("I")) {
                result++;
            }
            if (String.valueOf(s.charAt(i)).equals("X")) {
                result += 10;
            }
        }
        return result;
    }
}
