//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        ArrayList<Integer> list = new ArrayList<Integer>();

        Arrays.sort(arr);

        for(int i = 0; i < arr.length - 1; i++){

            if(arr[i] == arr[i+1]){

                list.add(arr[i]);

                }

            }

            HashSet<Integer> hs = new HashSet<Integer>(list);

            ArrayList<Integer> list2 = new ArrayList<Integer>(hs);

             Collections.sort(list2);

            if(list2.isEmpty()){

               list2.add(-1);

        }

        return list2;
    }
}
