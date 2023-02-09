//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}
// } Driver Code Ends



class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        Stack<Integer> stk = new Stack<>();

int[] result = new int[n];

for(int i=0;i<=n-1;i++){

if(stk.empty()) result[i] = -1;

else if(!stk.empty() && price[stk.peek()] > price[i]) result[i] = stk.peek();

else if(!stk.empty() && price[stk.peek()] <= price[i]){

while(!stk.empty() && price[stk.peek()] <= price[i]) stk.pop();

if(stk.empty()) result[i] = -1;

else result[i] = stk.peek();

}

stk.push(i);

}

for (int i=0;i<=n-1;i++) {

result[i] = (i -result[i]);

}

return result;

    }
    
}