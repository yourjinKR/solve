### 기존 풀이

```java
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        
        int[] arr1 = Arrays.copyOfRange(nums, 0, n);
        int[] arr2 = Arrays.copyOfRange(nums, n, nums.length);
        
        int j = 0;
        for (int i = 0; i < n; i++, j++) {
            ans[j] = arr1[i];
            j++;
            ans[j] = arr2[i];
        }
        
        return ans;
    }
}
```


### 개선 방식

- `[0,1,2,3,4,5]` -> `[0,2,4,1,3,5]`

```java
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int len = nums.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                ans[i] = nums[i / 2];
            } else {
                ans[i] = nums[n + (i / 2)];
            }
        }
        return ans;
    }
}
```