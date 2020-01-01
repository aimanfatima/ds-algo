// Program to print the numbers in ascending order using Recursion

#include<iostream>
using namespace std;

void pi(int n)
{
    if(n==0)
        return;

    pi(n-1);    
    cout<<n<<endl;
}

int main()
{
    int n = 10;
    pi(n);
}