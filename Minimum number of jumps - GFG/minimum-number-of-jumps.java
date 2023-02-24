//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}

// } Driver Code Ends


class Solution{
     static int minJumps(int[] arr){

        int jumps =0,curEnd=0,curFar=0;

        for(int i=0;i<=curFar;i++){

            curFar = Math.max(curFar,i+arr[i]);

            if(curFar >= arr.length-1){

                jumps++;

                return jumps;

            }

            if (i == curEnd) {

     jumps++;

     curEnd = curFar;

     }

        }

        return -1;

 

    }
}