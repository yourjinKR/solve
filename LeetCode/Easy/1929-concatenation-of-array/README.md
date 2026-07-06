### 기존 풀이
- 일정 길이의 배열을 2개로 붙이는 것
- `[1,2,3]` -> `[1,2,3,1,2,3]`

```java
class Solution {
    public int[] getConcatenation(int[] nums) {
        int totalLength = nums.length * 2;
        int[] ans = new int[totalLength];

        int i = 0;
        int j = 0;

        for (i = 0; i < nums.length; i++, j++) {
            ans[i] = nums[i];
        }

        for (i = 0; i < nums.length; i++, j++) {
            ans[j] = nums[i];
        }

        return ans;
    }
}
```

### 개선 방식

- 기존에는 `nums`만큼 2번 돌았다면 아래 방식은 1번 돌되 그 배열의 길이만큼 인덱스를 추가하여 동시에 넣는다.
- 루프를 최대한 줄일 수 있는 방식을 고민

```java
class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2*n];
        for(int i=0;i<n;i++){
            ans[i]=nums[i];
            ans[i+n]=nums[i];
        }
        return ans;
    }
}

```