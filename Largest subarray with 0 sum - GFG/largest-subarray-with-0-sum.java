//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
         int size = arr.length;
        int count =0;
        int max = 0; 
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int idx =0; idx < size; idx++){
           count += arr[idx];
           if(count == 0){
               max = idx + 1;
           }else {
               if(map.get(count) != null ){
                   max = Math.max(max, idx - map.get(count));
               }else {
                   map.put(count, idx);
               }
           }
            }
                    return max;

           
    }
}