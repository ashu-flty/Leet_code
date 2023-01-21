//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class GfG { 
	public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int m = Integer.parseInt(inputLine[1]);
		    int[] arr = new int[n];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++)arr[i] = Integer.parseInt(inputLine[i]);
		    
		    Solution obj = new Solution();
		    System.out.println(obj.firstElementKTime(arr, n, m));
		}
	}
}

// } Driver Code Ends


class Solution
{
    public int firstElementKTime(int[] a, int n, int k) { 
        // check given in constrians --> 1<= A[i] <= 200
        // taking a frequrncy unordered map
        int [] fmap = new int [200];
        // traversal on given array
        for(int i = 0; i < n; i ++) {
            int j = a[i];
            // increase the map frequency
            fmap[j] ++;
            /// checking given condition
            if(fmap[j] == k) {
                // return array occurance who equal k given value
                return a[i];
            }
        }
        return -1;
    } 
}