class Solution {
    public int bestRotation(int[] A) {
        int[] temp = new int[A.length];
        for(int i = 0; i< A.length; i++){
            if(A[i] <= A.length) 
                temp[(i - A[i]) >= 0? i - A[i]: i + A.length - A[i]] += 1;
        }
        int min = 0, ret = 0;
        for(int i = 0; i < A.length; i++){
            if (A[i] > i)min++;
        }
        int count = min;
        for(int i = 0; i < A.length - 1; i++){
            if(A[i] <= A.length)count--;
            count += temp[i];
            if(count < min)
                {min = count;
                ret = i + 1;}
        }
        return ret;
    }
}