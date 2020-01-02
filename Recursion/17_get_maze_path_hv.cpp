// Given n X n maze
// You are currently at (0,0) position, 
// Return a vector of strings of all the paths
// to from current position (0,0) to (n-1, n-1) using two moves - 'h' and 'v'

#include<bits/stdc++.h>
using namespace std;

vector<string>* get_maze_path(int r, int c, int n)
{
    if(r==n-1 && c==n-1)
    {
        vector<string>* bres = new vector<string>();
        if(r==n-1 && c==n-1)
            bres->push_back("");
        return bres;
    }
    if(r>n-1 || c>n-1)
    {
        vector<string>* bres = new vector<string>();
        return bres;
    }

    vector<string>* hres = get_maze_path(r, c+1, n);
    vector<string>* vres = get_maze_path(r+1, c, n);
    vector<string>* mres = new vector<string>();

    for(int i=0; i<hres->size(); i++)
    {
        mres->push_back("h" + (*hres)[i]);
    }

    for(int i=0; i<vres->size(); i++)
    {
        mres->push_back("v" + (*vres)[i]);
    }

    return mres;
}

int main()
{
    int n=3;
    vector<string>* ans = get_maze_path(0, 0, n);
    for(int i=0; i<ans->size(); i++)
    {
        cout<<(*ans)[i]<<endl;
    }
}