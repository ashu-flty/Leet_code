//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.noConseBits(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int noConseBits(int n) {

        int s[] = new int[32];

        for(int i = 31; i >= 0; i--) {

            s[i] =  ((n >> i) & 1);

        }

        int count = 0;

        for(int i = 31; i >= 0; i--) {

            if(s[i] == 1) {

                count++;

                if(count == 3) {

                    s[i] = 0;

                    count = 0;

                }

            } else {

                count = 0;

            }

        }

        int ans = 0;

        for(int i = 0; i <= 31; i++) {

            if(s[i] != 0)

            ans = ans | (1 << i);

        }

        return ans;

    }
}
        
