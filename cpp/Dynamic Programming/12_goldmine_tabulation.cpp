#include<bits/stdc++.h>
using namespace std;

int goldmine(vector<vector<int>> &mine)
{
    vector<vector<int>> max_mine(mine.size(), vector<int>(mine[0].size()));
    // vector<vector<string>> path(mine.size(), vector<string>(mine[0].size()));

    int r = mine.size()-1;
    int c = mine[0].size()-1;

    for(int j = c; j>=0; j--)
    {
        for(int i=c; i>=0; i--)
        {
            if(j==c)
            {
                max_mine[i][j] = mine[i][j];
                // path[i][j] = ".";
            }
            else if(i==r)
            {
                max_mine[i][j] = mine[i][j] + max(max_mine[i][j+1], max_mine[i-1][j+1]);
            }
            else if(i==0)
            {
                max_mine[i][j] = mine[i][j] + max(max_mine[i][j+1], max_mine[i+1][j+1]);
            }
            else
            {
                max_mine[i][j] = mine[i][j] + max(max_mine[i][j+1], max(max_mine[i+1][j+1], max_mine[i-1][j+1]));
            }
        }
    }    

    int max = INT_MIN;

    for(int i=0; i<max_mine.size(); i++)
    {
        if(max_mine[i][0] > max)
            max = max_mine[i][0];
    }

    return max;
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
    cout<<goldmine(mine)<<endl;
}