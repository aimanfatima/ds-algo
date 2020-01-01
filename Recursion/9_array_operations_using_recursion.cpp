#include<iostream>
#include<vector>
#include<climits>

using namespace std;

void display(vector<int> &arr, int sp)
{
    if(sp==arr.size())
        return;
    
    cout<<arr[sp]<<"    ";
    display(arr, sp+1);
}

void display_reverse(vector<int> &arr, int sp)
{
    if(sp==arr.size())
        return;

    display_reverse(arr, sp+1);
    cout<<arr[sp]<<"    ";
}

int max(vector<int> &arr, int sp)
{
    if(sp == arr.size())
        return INT_MIN;

    int max_spp1 = max(arr, sp+1);
    if(arr[sp] > max_spp1)
    {
        return arr[sp];
    }
    else
    {
        return max_spp1;
    }
}

bool find(vector<int> &arr, int sp, int key)
{
    if(sp==arr.size())
        return false;

    if(arr[sp]==key)
        return true;
    return find(arr, sp+1, key);
}

int first_index(vector<int> &arr, int sp, int key)
{
    if(sp==arr.size())
        return -1;

    if(arr[sp]==key)
        return sp;
    else
        return first_index(arr, sp+1, key);
    
}

int last_index(vector<int> &arr, int sp, int key)
{
    if(sp==arr.size())
        return -1;
    int idx_sp_p1 = last_index(arr, sp+1, key);

    if(idx_sp_p1 !=-1)
        return idx_sp_p1;
    else if(arr[sp]==key)
        return sp;
    else
        return -1;
}

int main()
{
    vector<int> arr = {7,8,2,9,2,9,2,3,4};

    // DISPLAY
    display(arr, 0);
    cout<<endl;

    // DISPLAY REVERSE
    display_reverse(arr, 0);
    cout<<endl;

    // FIND MAX
    cout<<max(arr, 0);
    cout<<endl;

    // FIND
    cout<<find(arr, 0, 2)<<endl;
    cout<<find(arr, 0, 10)<<endl;

    // FIRST INDEX
    cout<<first_index(arr, 0, 2)<<endl;
    cout<<first_index(arr, 0, 11)<<endl;

    // LAST INDEX
    cout<<last_index(arr, 0, 2)<<endl;
    cout<<last_index(arr, 0, 11)<<endl;

}