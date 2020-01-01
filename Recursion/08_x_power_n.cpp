// find x to the power n (log n)

#include<iostream>
using namespace std;

int power(int x, int n)
{
    if(n==0)
        return 1;
    int xpnb2 = power(x, n/2);

    if(n%2==0)
        return xpnb2*xpnb2;
    else
        return x*xpnb2*xpnb2;
}


int main(int argc, char** argv)
{
    int x = 5, n = 3;
    cout<<power(x, n);
}
