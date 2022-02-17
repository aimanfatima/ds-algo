#include<bits/stdc++.h>
using namespace std;

void floodfill(int cr, int cc, int er, int ec, vector<vector<int>> &arr, string path, vector<vector<bool>> &visited)
{
    if(cr==er && cc==ec)
    {
        cout<<path<<endl;
        return;
    }
    if(cr<0 || cr>er || cc<0 || cc>ec)
    {
        return;
    }

    if(arr[cr][cc]==1 || visited[cr][cc]==true)
    {
        return;
    }
    
    visited[cr][cc] = true;
    floodfill(cr, cc+1, er, ec, arr, path + "r", visited);
    floodfill(cr, cc-1, er, ec, arr, path + "l", visited);
    floodfill(cr+1, cc, er, ec, arr, path + "d", visited);
    floodfill(cr-1, cc, er, ec, arr, path + "t", visited);
    visited[cr][cc] = false; 
}

int main()
{
    vector<vector<int>> arr = {
        {0,1,0,0,0,0},
        {0,1,0,1,1,0},
        {0,1,0,1,1,0},
        {0,0,0,0,0,0},
        {0,1,0,1,1,0},
        {0,1,0,0,0,0}
    };
    vector<vector<bool>> visited(arr.size(), vector<bool>(6, false));
    floodfill(0, 0, 5, 5, arr, "", visited);
}