class Solution {

    public boolean containsDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }
}

public class s4p3 {
    public static void main(String[] args) {

        Solution s = new Solution();

        int[] nums = {1, 2, 3, 1};

        boolean result = s.containsDuplicate(nums);

        System.out.println(result);
    }
}
