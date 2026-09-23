class Solution {

    public int[] rotateArray(int[] nums, int k) {

        k = k % nums.length;

        int[] newArray = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            int newPosition = (i + k) % nums.length;

            newArray[newPosition] = nums[i];
        }

        return newArray;
    }
}

public class s4p5 {
    public static void main(String[] args) {

        Solution s = new Solution();

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        int[] result = s.rotateArray(nums, k);

        System.out.print("[");

        for (int i = 0; i < result.length; i++) {

            System.out.print(result[i]);

            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }
}