class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int max = nums.length;
        Set<Integer> seqSet = new HashSet<>();
        for (int i = 1; i <= max; i++) {
            seqSet.add(i);
        }

        seqSet.removeAll(numSet);
        return new ArrayList<>(seqSet);
    }
}