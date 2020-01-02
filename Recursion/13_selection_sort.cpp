// Implement selection sort using Recursion 

#include<iostream>
#include<vector>
#include<climits>

using namespace std;

int min(vector<int> &arr, int sp)
{
    if(sp==arr.size())
        return INT_MAX;

    int min_rec = min(arr, sp+1);
    if(arr[min_rec] < arr[sp])
        return min_rec;
    else
        return sp;
}

void selection_sort(vector<int> &arr, int sp)
{
    if(sp==arr.size())
        return;

    int min_idx = min(arr, sp);
    if(min_idx!=sp)
    {
        int temp = arr[min_idx];
        arr[min_idx] = arr[sp];
        arr[sp] = temp;
    }

    selection_sort(arr, sp+1);
}

int main(int argc, char** argv)
{
    vector<int> arr = {12, 3, 9, 8, 4, 6, 5};
    selection_sort(arr, 0);

    for(int i=0; i<arr.size(); i++)
        cout<<arr[i]<<"     ";
    
    cout<<endl;
}