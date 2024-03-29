class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
         * a naive approach is to create two for loops and multiply each value except
         * the one we dont want. we have to use some other type of approach as this is
         * O(n^2) which we want in O(n)
         * 
         * an approach we can use is that first we create an array of nums size and each
         * element has the multiply of all elements BEFORE it excluding itself then we
         * create a second array which also is of nums size and each element in that has
         * all the multiply of elements AFTER it excluding itself then we just multiply
         * the [i] of both arrays
         * 
         * update: to reduce memory, we do it in the same array and just return it
         */

        int[] before = new int[nums.length];
        before[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            before[i] = before[i - 1] * nums[i - 1];
        }

        int[] after = new int[nums.length];
        // to optimise effeciency, we will start from the end
        after[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            after[i] = after[i + 1] * nums[i + 1];
        }

        // now we will calculate product using before[i] * after[i] and save in before
        for (int i = 0; i < before.length; i++) {
            before[i] = before[i] * after[i];
        }

        return before;

    }
}