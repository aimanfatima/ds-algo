// Given the number of steps, return a vector of strings, containing all the possible paths 
// of coming down the stairs using any one two or three steps

// Example - 

// n = 8
// possible paths are - 
// 1 1 1 1 1 1 1 1
// 2 2 2 2
// 3 3 2
// 1 2 3 2
// .....

// for n=7, possible paths are- 44

#include<bits/stdc++.h>
using namespace std;

vector<string>* get_stair_path(int n)
{
    if(n<=0)
    {
        vector<string>* bres = new vector<string>();
        if(n==0)
            bres->push_back("");
        return bres;
    }

    vector<string>* mres = new vector<string> ();
    for(int step = 1; step<=3; step++)
    {
        vector<string>* rres = get_stair_path(n-step);
        for(int i=0; i<rres->size(); i++)
        {
            string str = to_string(step) + (*rres)[i];
            mres->push_back(str);
        }
    }
    return mres;
}

int main()
{
    int n = 7;
    vector<string>* ans = get_stair_path(n);

    for(int i=0; i<ans->size(); i++)
    {
        cout<<(*ans)[i]<<endl;
    }
    cout<<ans->size();
}