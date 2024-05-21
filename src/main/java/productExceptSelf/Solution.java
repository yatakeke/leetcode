package productExceptSelf;

public class Solution {
        public int[] productExceptSelf(int[] nums) {
            var res = new int[nums.length];
            var countZero = 0;

            var product = 1;
            for (var n: nums) {
                if (n != 0) {
                    product *= n;
                } else {
                    countZero += 1;
                }
            }

            for (var i = 0; i < nums.length; i++) {
                if (countZero == 0)  {
                    res[i] = product / nums[i];
                } else if (countZero >= 2) {
                  res[i] = 0;
                } else if (nums[i] == 0) {
                    res[i] = product;
                } else {
                    res[i] = 0;
                }
            }

            return res;
        }
}
