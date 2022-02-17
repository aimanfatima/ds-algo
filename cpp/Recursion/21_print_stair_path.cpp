// Given the number of steps, by printing the paths in the base case
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

#include<iostream>
using namespace std;

int count = 0;

void print_stair_path(int n, string asf)
{
    if(n<=0)
    {
        if(n==0)
        {
            count++;
            cout<<asf<<endl;
        }
        return;
    }
    print_stair_path(n-1, asf + "1");
    print_stair_path(n-2, asf + "2");
    print_stair_path(n-3, asf + "3");
}

int main()
{
    print_stair_path(7, "");
    cout<<count<<endl;
}
