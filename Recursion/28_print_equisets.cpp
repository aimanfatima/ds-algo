#include<bits/stdc++.h>
using namespace std;

void print_equisets(vector<int> &arr, int idx, string set1, int sos1, string set2, int sos2)
{
    if(idx==arr.size())
    {
        if(sos1 == sos2)
        {
            cout<<"Set 1 :  "<<set1<<"      Set 2 : "<<set2<<endl;
        }
        return;
    }

    print_equisets(arr, idx+1, set1+to_string(arr[idx])+" ", sos1 + arr[idx], set2, sos2);
    print_equisets(arr, idx+1, set1, sos1, set2 + to_string(arr[idx]) + " ", sos2 + arr[idx]);
}

int main()
{
    vector<int> arr = {10, 20, 30, 40, 50, 60, 70};
    print_equisets(arr, 0, "", 0, "", 0);

    // TO AVOID REDUNDANT CALLS
    // initially just call left hand recursion, so that the redundant sets in the output are eliminated
    // equisets(arr,1,to_string(arr[0])+"", arr[0] , "", 0);

}



// ALITER

// Using vector<int>

// void equisets(vector<int> &arr, int idx, vector<int> &set1, int sos1, vector<int> &set2, int sos2)
// {
//     if(idx==arr.size())
//     {
//         if(sos1==sos2)
//         {
//             cout<<"Set1:";
//             for(int i=0;i<set1.size();i++)
//                 cout<<set1[i]<<" ";
//             cout<<endl;
//             cout<<"Set2:";
//             for(int i=0;i<set2.size();i++)
//                 cout<<set2[i]<<" ";
//             cout<<endl<<endl;

//         }
//         return;
//     }

//     set1.push_back(arr[idx]);
//     equisets(arr,idx+1, set1, sos1+arr[idx], set2, sos2);
//     set1.pop_back();
//     set2.push_back(arr[idx]);
//     equisets(arr,idx+1, set1, sos1, set2, sos2+arr[idx]);
//     set2.pop_back();

    
// }