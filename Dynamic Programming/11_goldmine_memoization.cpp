#include<bits/stdc++.h>
using namespace std;

int goldmine(vector<vector<int>> &mine, int r, int c, vector<vector<int>> &dp)
{
    // cout<<r<<"  "<<c<<endl;
    if(c==mine[0].size()-1)
        return mine[r][c];

    if(dp[r][c] != -1)
        return dp[r][c];

    int gstod = 0; // gold from source to destinantion
    int grp1tod = INT_MIN;
    int grtod = INT_MIN;
    int grm1tod = INT_MIN;

    if(r+1 < mine.size()-1 && c+1 < mine[0].size())
        grp1tod = goldmine(mine, r+1, c+1, dp);
    if(c+1 < mine[0].size())
        grtod = goldmine(mine, r, c+1, dp);
    if(r-1 > 0 && c+1 < mine[0].size())
        grm1tod = goldmine(mine,  r-1, c+1, dp);

    gstod = mine[r][c] + max(grp1tod, max(grtod, grm1tod));
    // cout<<gstod<<endl;
    dp[r][c] = gstod;
    return gstod;
}

int main()
{
    vector<vector<int>> mine = 
    {
        {2,6,0,5},
        {0,7,5,2},
        {3,0,3,7},
        {8,0,2,3}
    };
    vector<vector<int>> dp(mine.size(), vector<int>(mine[0].size(), -1));
    for(int r=0; r<mine.size(); r++)
    {
        cout<<goldmine(mine, r, 0, dp)<<endl;
    }
}