#include<bits/stdc++.h>
using namespace std;

int max_submatrix (vector<vector<int>> &box)
{
    vector<vector<int>> dp(box.size(), vector<int>(box[0].size()));
    int r = box.size()-1;
    int c = box[0].size()-1;

    int ans = INT_MIN;

    for(int i=r; i>=0; i--)
    {
        for(int j=c; j>=0;j--)
        {
            if(i==r || j==c)
            {
                dp[i][j] = box[i][j];
            }
            else
            {   
                if(box[i][j]==0)
                    dp[i][j]==0;
                else
                {
                    dp[i][j] = 1 + min(dp[i][j+1], min(dp[i+1][j], dp[i+1][j+1]));
                }
            }
            ans = max(dp[i][j], ans);
        }
    }
    return ans;
}

int main()
{
    vector<vector<int>> box = 
    {
        {1,0,1,0,0,1},
        {1,1,1,1,1,1},
        {1,1,1,1,1,1},
        {1,1,1,1,1,1},
        {1,1,1,1,1,1},
        {1,1,1,1,1,1}
    };
    cout<<max_submatrix(box)<<endl;

}