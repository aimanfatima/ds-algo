// Given n X m maze (er - end row, ec - end column)
// You are currently at (0,0) position, 
// Return a vector of strings of all the paths
// to from current position (0,0) to (n-1, m-1) using all three moves - "h", "v" and "d"
// Also, you may take a jump of any number of steps at a time. 

// Hence the result must have strings with letters of form -  H1, H2, H3, V1, V2, V3, D1, D2, D3 and so on..

#include<bits/stdc++.h>
using namespace std;

vector<string>* get_maze_path_mm(int r, int c, int er, int ec)
{
    if(r>er || c>ec) // Not required if using proactive approach
    {
        vector<string>* bres = new vector<string>();
        return bres;
    }

    if(r==er && c==ec)
    {
        vector<string>* bres = new vector<string>();
        bres->push_back("");
        return bres;
    }
    vector<string>* mres = new vector<string>();

    for(int i=1; i<=ec; i++) // REACTIVE CALLS (for proactive approach i<=er-r)
    {
        vector<string>* hres = get_maze_path_mm(r, c+i, er, ec);
        for(int j=0; j<hres->size(); j++)
        {
            mres->push_back("h" + to_string(i) + (*hres)[j]);
        }

    }

    for(int i=1; i<=er; i++)
    {
        vector<string>* vres = get_maze_path_mm(r+i, c, er, ec);
        for(int j=0; j<vres->size(); j++)
        {
            mres->push_back("v" + to_string(i) + (*vres)[j]);
        }
    }

    for(int i=1; i<=er && i<=ec; i++)
    {
        vector<string>* dres = get_maze_path_mm(r+i, c+i, er, ec);
        for(int j=0; j<dres->size(); j++)
        {
            mres->push_back("d" + to_string(i) + (*dres)[j]);
        }
    }
    return mres;
}

int main()
{
    int n = 3;
    vector<string>* ans = get_maze_path_mm(0, 0, 2, 2);

    for(int i=0; i<ans->size(); i++)
        cout<<(*ans)[i]<<endl;
}