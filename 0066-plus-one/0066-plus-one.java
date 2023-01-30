class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int n = digits.length;
		// loop to add the digits
        for(int i=n-1; i>=0; i--) {
            digits[i] += carry;   // add carry in every digit
            carry = digits[i] / 10;   // update carry for next digit
            digits[i] = digits[i] % 10;   //  put remainder in the digit
        }
        if(carry == 1) {   // in case of carry, we need to return n+1 length array
            int[] res = new int[n+1];
            res[0] = 1;
			// assinging values of digit in new array
            for(int i=1; i<=n;i++) {
                res[i] = digits[i-1];
            }
            return res;
        }
        return digits;
    }
}