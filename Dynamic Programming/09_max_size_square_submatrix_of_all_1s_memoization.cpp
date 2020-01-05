#include<bits/stdc++.h>
using namespace std;

int max_submatrix(int sr, int sc, vector<vector<int>> &arr, int &omax, int &orow, int &ocol, vector<vector<int>> &dp)
{
    if(sr==arr.size()-1 && sc == arr[0].size()-1)
    {
        return arr[sr][sc];
    }

    
    if(dp[sr][sc]!=-1)
        return dp[sr][sc];

    if(arr[sr][sc]==0)
        return 0;
    
    if(sr==arr.size()-1 || sc == arr[0].size()-1)
        return arr[sr][sc];

    int hres = max_submatrix(sr, sc+1, arr, omax, orow, ocol, dp);
    int vres = max_submatrix(sr+1, sc, arr, omax, orow, ocol, dp);
    int dres = max_submatrix(sr+1, sc+1, arr, omax, orow, ocol, dp);

    int mres = 1 + min(hres, min(vres, dres));

    if(mres > omax)
    {
        omax = mres;
        orow = sr;
        ocol = sc;
    }
    dp[sr][sc] = mres;
    return mres;
}   

int main()
{
    vector<vector<int>> arr = 
    {
        {1,0,1,0,0,1},
        {1,1,0,1,1,1},
        {0,1,1,1,1,1},
        {1,1,1,1,1,1},
        {1,1,1,1,0,1},
        {1,1,1,1,1,1}
    };

    vector<vector<int>> dp(arr.size(), vector<int>(arr[0].size(), -1));

    int omax = INT_MIN;
    int orow = -1;
    int ocol = -1;

    max_submatrix(0, 0, arr, omax, orow, ocol, dp);
    cout<<omax<<" "<<orow<<" "<<ocol<<endl;

    return 0;
}