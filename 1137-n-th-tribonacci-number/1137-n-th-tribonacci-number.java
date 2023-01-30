class Solution {
    public int tribonacci(int n) {
        int[] arr={0,1,1};
        for(int i=3;i<=n;i++)
            arr[i%3]+=arr[(i+1)%3]+arr[(i+2)%3];
        return arr[n%3];
    }
}