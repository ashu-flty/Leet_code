//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution{
    public:
    pair<int,int> endPoints(vector<vector<int>> matrix, int R, int C){
        //code here
         pair<int,int>ans;
        int dir = 0;
        int i=0, j=0;
        int n=R, m=C;
        while(i<n && i>=0 && j<m && j>=0){
            if(matrix[i][j] == 1){
                matrix[i][j] = 0;
                dir = (dir+1)%4; // for range 0 to 3; not more than 3
            }
            ans.first=i, ans.second=j;
            if(dir == 0) j++;
            else if(dir == 1) i++;
            else if(dir == 2) j--;
            else i--;
        }
        
        return ans;
    }
};

//{ Driver Code Starts.


int main()
{
    int tc;
	scanf("%d", &tc);
	while(tc--){
		int row, col;
		scanf("%d", &row);
		scanf("%d", &col);
		vector<vector<int>> matrix(row , vector<int> (col));
	 
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
			    cin>>matrix[i][j];
			}
		}
		Solution obj;
		pair<int,int> p = obj.endPoints(matrix, row, col);
		
		cout << "(" << p.first << ", " << p.second << ")" << endl;
	}
	return 0;
}
// } Driver Code Ends