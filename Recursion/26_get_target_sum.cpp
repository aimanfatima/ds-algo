// Return the vector of vector of integers (which is a subset of a given array) with sum given to target.

// Example - 
// i/p - 10 20 30 40 50 tgt = 50
// o/p - 10 40, 20 30, 50

#include<bits/stdc++.h>
using namespace std;

vector<vector<int>>* get_target_sum(vector<int> &arr, int idx, int target)
{
    if(idx==arr.size())
    {
        if(target==0)
        {
            vector<vector<int>>* bres = new vector<vector<int>>(1);
            return bres;
        }
        else
        {
            vector<vector<int>>* bres = new vector<vector<int>>();
            return bres;
        }
    }

    vector<vector<int>>* mres = new vector<vector<int>>();
    vector<vector<int>>* rres1 = get_target_sum(arr, idx+1, target-arr[idx]);
    vector<vector<int>>* rres2 = get_target_sum(arr, idx+1, target);

    for(int i=0; i<rres1->size(); i++)
    {
        (*rres1)[i].push_back(arr[idx]);
        mres->push_back((*rres1)[i]);
    }
    for(int i=0; i<rres2->size(); i++)
    {
        mres->push_back((*rres2)[i]);
    }

    return mres;
    
}

int main(int argc, char** argv)
{
    vector<int> arr = {10, 20, 30, 40, 50};
    vector<vector<int>>* ans = get_target_sum(arr, 0, 50);

    for(int i=0; i<ans->size(); i++)
    {
        for(int j=0; j<(*ans)[i].size(); j++)
        {
            cout<<(*ans)[i][j]<<"   ";
        }
        cout<<endl;
    }
}