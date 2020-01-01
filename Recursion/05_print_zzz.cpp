// Program to illustrate three calls

#include<iostream>
using namespace std;

void pzz(int n)
{
    if(n==0)
        return;

    cout<<n<<" "; 
    pzz(n-1); 
    cout<<n<<" "; 
    pzz(n-1);
    cout<<n<<" "; 
    pzz(n-1);
    cout<<n<<" ";
}

int main()
{
    pzz(2);

    // output - 
    // 2 1 1 1 1 2 1 1 1 1 2 1 1 1 1 2
}