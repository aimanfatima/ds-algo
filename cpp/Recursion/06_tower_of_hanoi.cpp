// three towers 
// 1. Source (s)
// 2. destinantion (d)
// 3. helper (h)

// we are given n, initiall present at source
// rules - move one disc at a time, never place a heavier disc over a light one

#include<iostream>
using namespace std;

void toh(int n, char s, char h, char d)
{
    if(n==0)
        return;

    toh(n-1, s, d, h);
    cout<<n<<s<<d<<endl;
    toh(n-1, h, s, d);
}

int main()
{
    int n = 3;
    toh(n, 's', 'h', 'd');
}