#include<bits/stdc++.h>
using namespace std;

int fibonacci(int n, int fib[])
{
    if(n==0 || n==1)
        return n;
    if(fib[n]!=0)
        return fib[n];

    fib[n] = fibonacci(n-1, fib) + fibonacci(n-2, fib);
    return fib[n];

}

int main(int argc, char** argv)
{
    int n = 10;
    int fib[n+1] = {0};
    cout<<fibonacci(n, fib);
}