// s - source
// d - destination

// Find the number of paths to reach d from s (ladder board)
// steps - we throw a die and whichever number comes that many steps are taken 
// hence, possible options at each step = 6 {1,2,3,4,5,6}

#include<bits/stdc++.h>
using namespace std;

int count_board_paths(int s, int d, int qb[])
{
    if(s > d)
        return 0;
    if(s==d)
        return 1;

    if(qb[s]!=0)
    {
        return qb[s];
    }

    int ans = 0;
    for(int i=1; i<=6; i++)
    {
        ans += count_board_paths(s+i, d, qb);
    }
    qb[s] = ans;
    return qb[s];
}

int main()
{
    int n=10;
    int qb[n+1] = {0};
    cout<<count_board_paths(0, 10, qb)<<endl;

    // for(int i=0; i<=n; i++)
    //     cout<<qb[i]<<"  ";
    // cout<<endl;
}