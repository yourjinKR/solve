<h2><a href="https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array">448. Find All Numbers Disappeared in an Array</a></h2><h3>Easy</h3><hr><p>Given an array <code>nums</code> of <code>n</code> integers where <code>nums[i]</code> is in the range <code>[1, n]</code>, return <em>an array of all the integers in the range</em> <code>[1, n]</code> <em>that do not appear in</em> <code>nums</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [4,3,2,7,8,2,3,1]
<strong>Output:</strong> [5,6]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [1,1]
<strong>Output:</strong> [2]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= n</code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Could you do it without extra space and in <code>O(n)</code> runtime? You may assume the returned list does not count as extra space.</p>

### 기존 풀이

- Stream API에서 boxed 메서드로 List -> List를 Set
- `IntStream.rangeClosed()` 메서드로 순차적인 Set 생성 
- 두 집합을 비교
- 해당 방식은 메모리 영역을 많이 차지하는 구조이다. (배열 및 집합을 한번씩 만들어냄)

```java
public List<Integer> findDisappearedNumbers(int[] nums) {
    Set<Integer> numSet = new HashSet(Arrays.stream(nums).boxed().toList());
    Set<Integer> seqSet = new HashSet<>(IntStream.rangeClosed(1, nums.length).boxed().toList());
    seqSet.removeAll(numSet);
    return new ArrayList<>(seqSet);
}
```

### 최종 풀이

- 제자리 마킹 기법을 활용
- 우리의 전제조건을 먼저 파악, 1~N 과정에서 N은 `nums`의 길이와 동일
- 최초 순회에 조회한 숫자가 X일때 원본 배열의 X-1 인덱스에 해당 값이 있다는 뜻
- 해당 인덱스의 값을 어떻게 마킹할 것인가? -> 음수화
- 한번 더 조회하여 값이 양수라면, 해당 값은 없다는 뜻으로 해석

```java
public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> ans = new ArrayList<>();

    for (int num : nums) {
        // 음수값 예외 케이슬 방지를 위해 절대값으로 계산 
        int idx = Math.abs(num) - 1;
        if (nums[idx] > 0) {
            nums[idx] *= -1;
        }
    }

    for (int i = 0; i < nums.length; i++) {
        if (nums[i] > 0) {
            ans.add(i + 1);
        }
    }

    return ans;
}
```