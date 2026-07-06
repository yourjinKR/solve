## 기존 방식

```java
public int[] smallerNumbersThanCurrent(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (nums[i] > nums[j]) {
                ans[i] = ans[i] + 1;
            }
        }
    }
    return ans;
}
```

## 개선 방식1

```java
public int[] smallerNumbersThanCurrent(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];
    for (int i = 0; i < n; i++) {
        int count = 0;
        for (int j = 0; j < n; j++) {
            if (nums[i] > nums[j]) {
                count++;
            }
        }
        ans[i] = count;
    }
    return ans;
}
```

### 이론적 성능차이
- 기존 방식은 조건에 만족할때마다 배열에 특정 인덱스를 탐색하여 값을 증가시킨다.
- 그러나, `개선 방식1`은 불필요한 인덱스 탐색을 수행하지 않는다.

### 실질적인 성능차이
- 그러나, `개선방식1`로 바뀐다고 해서 큰 성능적 차이가 없다.
- 그 이유는 JIT 컴파일러가 최적화 작업을 진행하기 때문이다.  

## 개선 방식2


