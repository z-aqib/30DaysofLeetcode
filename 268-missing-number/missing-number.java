class Solution {
    public int missingNumber(int[] nums) {
        // so we know that the range of numbers is from 0 to the count of numbers n
        // so our approach is that we find the total of the array [0 + 1 + 2 + 3 + ... + n] where n is the number of integers in n
        // and then we subtract each value of nums[i] from the total of array
        // the value left over is the missing number
        int total = 0; // this is the total of the array
        // a better approach is to do this in one array
        // subtract nums[i] from the total and return the missing number
        for(int i = 0; i < nums.length; i++) {
            total = total + i;
            total = total - nums[i];
        }
        total = total + nums.length;
        return total;
    }
}