#include<iostream>
#include<vector>

using namespace std;

int bs(vector<int> &arr, int key, int first, int last)
{
    if(first > last)
        return -1;
    int mid = (first + last)/2;
    if(arr[mid]==key)
        return mid;
    
    else if(key <arr[mid] )
        return bs(arr, key, first, mid-1);
    else
        return bs(arr, key, mid+1, last);    
}

int main()
{
    vector<int> arr = {2, 4, 6, 8, 10, 12};
    cout<<bs(arr, 6 ,0, arr.size()-1);
}