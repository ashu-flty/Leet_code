//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
	public static int minIteration(int N, int M, int x, int y){
		//code here
		int res = 0;
		int[][] grid = new int[N][M];
		for(int[] row : grid)   Arrays.fill(row,0);
		grid[x-1][y-1]=1;
		
		int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[]{x-1,y-1});
		
		while(!q.isEmpty()){
		    int size = q.size();
		    while(size-->0){
		        int[] points = q.poll();
		        for(int[] d : dir){
		            int r = points[0] + d[0];
		            int c = points[1] + d[1];
		            if(r>=0 && c>=0 && r<N && c<M && grid[r][c]==0){
		                q.offer(new int[]{r,c});
		                grid[r][c] = 1;
		            }
		        }
		    }
		    if(!q.isEmpty())    res++;
		}
		return res;
		
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String input[]=read.readLine().trim().split(" ");
            int N = Integer.parseInt(input[0]);
            int M=Integer.parseInt(input[1]);
           	input=read.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.minIteration(N, M, x, y));
        }
        
    }
}
// } Driver Code Ends