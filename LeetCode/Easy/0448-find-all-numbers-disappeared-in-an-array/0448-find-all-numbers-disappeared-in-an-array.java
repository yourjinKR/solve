class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> numSet = new HashSet(Arrays.stream(nums).boxed().toList());
        Set<Integer> seqSet = new HashSet<>(IntStream.rangeClosed(1, nums.length).boxed().toList());
        seqSet.removeAll(numSet);
        return new ArrayList<>(seqSet);
    }
}