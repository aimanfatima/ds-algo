#include<bits/stdc++.h>
using namespace std;

int min_cost_path (int sr, int sc, int dr, int dc, vector<vector<int>> &costs, vector<vector<int>> &qb)
{
    if(sr==dr && sc==dc)
        return costs[sr][sc];
    if(sr>dr || sc > dc)
        return INT_MAX;

    if(qb[sr][sc]!=-1)
        return qb[sr][sc];
    
    int hcost = min_cost_path(sr, sc+1, dr, dc, costs, qb);
    int vcost = min_cost_path(sr+1, sc, dr, dc, costs, qb);
    int my_cost = costs[sr][sc] + min(hcost, vcost);
    qb[sr][sc] = my_cost;
    return my_cost;
}

int main()
{
    int dr = 3, dc = 3;
    vector<vector<int>> costs= {
        {2,3,0,4},
        {0,6,5,2},
        {8,0,7,3},
        {2,0,4,2}
    };
    vector<vector<int>> qb(costs.size(), vector<int>(costs[0].size(), -1));
    cout<<min_cost_path(0,0,dr,dc, costs, qb)<<endl;

}