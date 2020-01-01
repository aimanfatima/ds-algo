// Print all indices of an element occuring in an array
// i/p : 2 2 1 3 8 5 0 2
// o/p : 0 1 7

#include<iostream>
using namespace std;

int* all_indices(int* arr, int n, int sp, int key, int* i, int* counter)
{
    if(sp==n)
    {
        int* ans = new int[*counter];
        return ans;
    }
    if(arr[sp]==key)
    {
        (*counter)++;
        (*i)++;
    }

    int* ans = all_indices(arr, n, sp+1, key, i, counter);
    if(arr[sp]==key)
    {
        ans[(*i)-1] = sp;
        (*i)--;
    }
    return ans;
}

int main()
{
    int arr[8] = {2,2,1,3,8,5,0,2};
    int n = 8;
    int i = 0;
    int counter = 0;
    int* a = all_indices(arr, n, 0, 2, &i, &counter);

    for(int j=0; j<counter; j++)
        cout<<*(a+j)<<"   ";
    cout<<endl;
}