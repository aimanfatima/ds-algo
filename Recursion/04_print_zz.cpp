// Program to illustrate two calls, left recursive call and right recursive call.
// Pre-area, in area, post area

#include<iostream>
using namespace std;

void pzz(int n)
{
    if(n==0)
        return;

    cout<<n<<" "; // pre- print
    pzz(n-1); // left rec call
    cout<<n<<" "; // in- print
    pzz(n-1); // right recursive call
    cout<<n<<" "; // post-print
}

int main()
{
    pzz(3);

    // output - 
    // 3 2 1 1 1 2 1 1 1 2 3 2 1 1 1 2 1 1 1 2 3
}