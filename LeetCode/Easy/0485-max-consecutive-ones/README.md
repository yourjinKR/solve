### 기존 풀이
```java
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
```


### 개선 방식

```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int count = 0;

        for (int n : nums) {
            if (n == 0) {
                count = 0;
            } else {
                count++;
            }

            if (res < count) {
                res = count;
            }
        }

        return res;        
    }
}
```