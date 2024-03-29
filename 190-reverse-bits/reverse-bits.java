public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        /*
         * so in this approach we take the reversed_n as 0, shift it left (move all
         * digits to the left and add a 0), add the last bit of n to reverse_n, then
         * shift n right (move all digits to the right, the last one is dropped). we do
         * this 32 times to make sure n is fully shifted for each of the 32 bits.
         * how do we add the last bit? using a bit wise unary OR operator (|) and the
         * bit wise AND operator (&) with 1
         */
        int reversed_n = 0;
        for (int i = 0; i < 32; i++) {
            reversed_n <<= 1;
            reversed_n = reversed_n | (n & 1);
            n >>= 1;
        }
        return reversed_n;
    }
}