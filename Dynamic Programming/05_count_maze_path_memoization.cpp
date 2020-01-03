#include<bits/stdc++.h>
using namespace std;

int count_maze_path(int cr, int cc, int er, int ec, vector<vector<int>> &dp)
{
    if(cr==er && cc==ec)
        return 1;
    
    if(cr>er || cc>ec)
        return 0;

    if(dp[cr][cc] != 0)
        return dp[cr][cc];
   
    int ans = 0;
    int hways = count_maze_path(cr, cc+1, er, ec, dp);
    int vways = count_maze_path(cr+1, cc, er, ec, dp);

    ans = hways + vways;
    dp[cr][cc] = ans;
    return ans;
}

int main()
{
    int n = 2;
    vector<vector<int>> dp(n+1, vector<int>(n+1, 0));
    cout<<count_maze_path(0,0,n,n, dp)<<endl;
}