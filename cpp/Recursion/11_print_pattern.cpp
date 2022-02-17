// Print the following patterns using recursion for(n = 3) - 
// Pattern - 1

// *
// **
// ***

// Pattern - 2

// ***
// **
// *

#include<iostream>
using namespace std;

void pp1(int r, int c, int n)
{
    if(r==n)
    {
        return;
    }
    if(c < n)
    {
        if(r>=c)
            cout<<"*";
        pp1(r, c+1, n);
    }
    else
    {
        cout<<endl;
        pp1(r+1, 0, n);
    }
    
}

void pp2(int r, int c, int n)
{
    if(r==n)
    {
        return;
    }
    if(c < n)
    {
        if(r<=c)
            cout<<"*";
        pp2(r, c+1, n);
    }
    else
    {
        cout<<endl;
        pp2(r+1, 0, n);
    }
}

int main()
{
    pp1(0, 0, 3);
    cout<<endl;
    pp2(0, 0, 3);
}