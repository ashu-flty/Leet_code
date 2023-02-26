//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution
{
    public:
    //Function to find a continuous sub-array which adds up to a given number.
    vector<int> subarraySum(vector<int>a, int n, long long chk)
    {
        vector<int>ans;
        int s=0;
        long long sum=a[0];
        bool flag=false;
        for(int i=1 ; i<=n ; i++)
        {
            while(sum>chk&&s<i-1)
            {
                sum-=a[s];
                s++;
            }
            if(sum==chk)
            {
                ans.push_back(s+1);
                ans.push_back(i);
                flag=true;
                return ans;
            }
            if(i<n)
                sum+=a[i];
        }
        return {-1};
    }
};

//{ Driver Code Starts.

int main()
 {
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        long long s;
        cin>>n>>s;
        vector<int>arr(n);
        // int arr[n];
        const int mx = 1e9;
        for(int i=0;i<n;i++)
        {
            cin>>arr[i];
        }
        Solution ob;
        vector<int>res;
        res = ob.subarraySum(arr, n, s);
        
        for(int i = 0;i<res.size();i++)
            cout<<res[i]<<" ";
        cout<<endl;
        
    }
	return 0;
}
// } Driver Code Ends