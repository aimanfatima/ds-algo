// Given - currency - {2,3,5}
// sum - 10
// possible options- 

// 2,3,2,3
// 2,2,2,2,2
// 5,5
// 2,3,5 .....

#include<bits/stdc++.h>
using namespace std;

int coinchange(vector<int> coins, int sp, int sum, string asf)
{
    if(sum==0)
    {
        cout<<asf<<endl;
        return 1;
    }
    if(sum<0 || sp>=coins.size())
    {
        return 0;
    }
    
    int res = 0;
    res+=coinchange(coins,sp,sum - coins[sp] , asf + to_string(coins[sp])+" ");
    res+=coinchange(coins,sp+1,sum , asf);
    
    return res;

}

int main()
{
    vector<int> coins = {2,3,5};
    int sum = 10;
    cout<<coinchange(coins,0, sum, "")<<endl;
}


// FOR PERMUTATIONS

// void coinchange(vector<int>& arr, int sum, string asf)
// {
//     if(sum<=0)
//     {
//         if(sum==0)
//             cout<<asf<<endl;
//         return;
//     }
//     for(int i=0;i<arr.size();i++)
//     {
//         coinchange(arr, sum-arr[i], to_string(arr[i])+" "+asf);
//     }
// }
