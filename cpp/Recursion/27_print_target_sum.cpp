// print all the vector of integers (which is a subset of a given array) with sum given to target.

// Example - 
// i/p - 10 20 30 40 50 tgt = 50
// o/p - 10 40, 20 30, 50

#include<bits/stdc++.h>
using namespace std;

void print_target_sum (vector<int> &arr, int idx, vector<int> &ans, int target)
{
    if(idx==arr.size())
    {
        if(target == 0)
        {
            for(int i=0; i<ans.size(); i++)
                cout<<ans[i]<<"     ";
            cout<<endl;
        }
        return;
    }

    print_target_sum(arr, idx+1, ans, target);
    ans.push_back(arr[idx]);
    print_target_sum(arr, idx+1, ans, target-arr[idx]);
    ans.pop_back(); 
    // can use string as well, 
    // printtargetsum(arr,vidx+1,target - arr[vidx],set+" "+to_string(arr[vidx]));
    // So, do not change the ans array in a particular state, 
    // and if you change, revert it back after the recursive call
    // i.e. after in post area 

}

int main()
{
    vector<int> arr = {10, 20, 30, 40, 50};
    vector<int> ans;
    print_target_sum(arr, 0, ans, 50);
}