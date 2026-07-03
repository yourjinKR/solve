class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int now;
        int previous;
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            now = nums[i];
            previous = i == 0 ? nums[i] : nums[i-1];
            if (now == 1) {
                if (previous == 1) {
                    count++;
                } else {
                    count = 1;
                }
            } else {
                count = 0;
            }
            if (maxCount < count) maxCount = count;
        }
        return maxCount;
    }
}