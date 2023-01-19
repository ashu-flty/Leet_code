//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int A =sc.nextInt();
            int B =sc.nextInt();
            int C =sc.nextInt();
            int D =sc.nextInt();
             
           System.out.println(new Solution().carpetBox(A,B,C,D)); 
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    int carpetBox(int L, int B, int C, int D) { 
        int moves_wo=0;  //Moves count without rotation
        int moves_w=0; //Moves count with rotation
        
        // Storing Length and Breadth for later use

        int L1=L; 
        int B1=B;
        
        while(L>C)
        {
            L=L/2;
            moves_wo++;
        }
        while(B>D)
        {
            B=B/2;
            moves_wo++;
        }

       // Swapping Length and Breadth
      // Second Case, where L=B and B=L
        
        L=B1;
        B=L1;
        
        while(L>C)
        {
            L=L/2;
            moves_w++;
        }
        while(B>D)
        {
            B=B/2;
            moves_w++;
        }

       // Returning Minimum moves from each way

        return(Math.min(moves_wo,moves_w));
   
}
   
}
