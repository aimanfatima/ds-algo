#include<bits/stdc++.h>
using namespace std;

int count_board_path(int d)
{
    int dp[d+1] = {0};

    dp[d] = 1;
    for(int i=d-1; i>=0; i--)
    {
        for(int dice = 1; dice<=6; dice++)
        {
            if(i+dice <= d)
                dp[i] += dp[i + dice];
        }
    }
    return dp[0];
}

int main()
{
    cout<<count_board_path(10)<<endl;
}