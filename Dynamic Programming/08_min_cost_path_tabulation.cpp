#include<bits/stdc++.h>
using namespace std;

int min_cost_path(vector<vector<int>> &costs)
{
    int dr = costs.size()-1;
    int dc = costs[0].size()-1;

    vector<vector<int>> min_cost(dr+1, vector<int>(dc+1));
    vector<vector<string>> path(dr+1, vector<string>(dc+1));

    for(int sr = dr ; sr>=0; sr--)
    {
        for(int sc = dc ; sc>=0; sc--)
        {
            if(sr==dr && sc==dc)
            {
                min_cost[sr][sc] = costs[sr][sc];
                path[sr][sc] = ".";
            }
            else if(sr==dr)
            {
                min_cost[sr][sc] = costs[sr][sc] + min_cost[sr][sc+1];
                path[sr][sc] = "h" + path[sr][sc+1];
            }
            else if(sc==dc)
            {
                min_cost[sr][sc] = costs[sr][sc] + min_cost[sr+1][sc];
                path[sr][sc] = "v" + path[sr+1][sc];
            }
            else
            {
                if(costs[sr][sc+1] > costs[sr+1][sc])
                {
                    min_cost[sr][sc] = costs[sr][sc] + min_cost[sr+1][sc];
                    path[sr][sc] = "v" + path[sr][sc+1];
                }
                else
                {
                    min_cost[sr][sc] = costs[sr][sc] + min_cost[sr][sc+1];
                    path[sr][sc] = "h" + path[sr][sc+1];
                }
            }
        }
    }

    cout<<path[0][0]<<endl;
    return min_cost[0][0];
    
}

int main()
{
    vector<vector<int>> costs = 
    {
        {2,3,0,4},
        {0,6,5,2},
        {8,0,3,7},
        {2,0,4,2}
    };

    cout<<min_cost_path(costs)<<endl;
}