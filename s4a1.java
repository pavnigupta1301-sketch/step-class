import java.util.Arrays;

class Solution {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];

        // Product of elements on the left
        int leftProduct = 1;

        for (int i = 0; i < n; i++) {
            answer[i] = leftProduct;
            leftProduct = leftProduct * nums[i];
        }

        // Product of elements on the right
        int rightProduct = 1;

        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }

        return answer;
    }
}

public class s4a1 {

    public static void main(String[] args) {

        Solution s = new Solution();

        int[] nums = {1, 2, 3, 4};

        int[] result = s.productExceptSelf(nums);

        System.out.println(Arrays.toString(result));
    }
}