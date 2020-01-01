// Program to print numbers first in dec. manner then inc. using Recursion.

#include<iostream>
using namespace std;

void pdi(int n)
{
    if(n==0)
        return;
    cout<<n<<endl;
    pdi(n-1);
    cout<<n<<endl;
}

int main()
{
    int n=5;
    pdi(5);
}