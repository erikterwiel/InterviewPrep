import java.util.HashMap;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seenNums = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (seenNums.get(target - nums[i]) != null) {
                int[] asdf = new int[2];
                asdf[0] = i;
                asdf[1] = seenNums.get(target - nums[i]);
                return asdf;
            } else {
                seenNums.put(nums[i], i);
            }
        }
        return new int[1];
    }
}
