// Program to print the numbers in descending order using Recursion

#include<iostream>
using namespace std;

void pd(int n)
{
    if(n==0)
        return;
        
    cout<<n<<endl;
    pd(n-1);
}

int main()
{
    int n = 10;
    pd(n);
}