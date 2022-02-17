#include<bits/stdc++.h>
using namespace std;

int count_maze_path(int dr, int dc) // destination row and destination column
{
    int f[dr+1][dc+1] = {0};

    for(int r= dr; r>=0; r--)
    {
        for(int c=dc; c>=0; c--)
        {
            if(r==dr && c==dc) // last cell
            {
                f[r][c] = 1;
            }
            else if(r==dr) // last row except last cell (only horizontal moves possible)
            {
                f[r][c] = f[r][c+1];
            }
            else if(c==dc) // last column except last cell (only vertical moves possible)
            {
                f[r][c] = f[r+1][c];
            }
            else
            {
                f[r][c] = f[r][c+1] + f[r+1][c];
            }
        }
    }
    return f[0][0];
}

int main()
{
    cout<<count_maze_path(2,2)<<endl;
}