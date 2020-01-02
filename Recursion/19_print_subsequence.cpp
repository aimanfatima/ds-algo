// Program to get all the possible subsequence of a string- 

// Using print style, i.e. printing the string at base case

// Example - 
// i/p - abc
// o/p - , c, b, bc, a, ac, ab, abc

#include<bits/stdc++.h>
using namespace std;

void print_subsequence(string ques, string asf) // asf - answer so far
{
    if(ques == "")
    {
        cout<<asf<<endl;
        return;
    }
    print_subsequence(ques.substr(1), asf);
    print_subsequence(ques.substr(1), asf + ques[0]);
}

int main()
{
    print_subsequence("abc", "");
}