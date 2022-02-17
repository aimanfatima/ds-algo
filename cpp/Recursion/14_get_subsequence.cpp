// Program to get all the possible subsequence of a string- 

// Using get style, i.e. returning vector of strings

// Example - 
// i/p - abc
// o/p - , c, b, bc, a, ac, ab, abc

#include<bits/stdc++.h>

using namespace std;

vector<string>* get_subsequence(string s, int sp)
{
    if(sp == s.size())
    {
        vector<string>* bres = new vector<string>();
        bres->push_back("");
        return bres;
    }

    vector<string>* rres = get_subsequence(s, sp+1);
    char ch = s[sp];
    vector<string>* mres = new vector<string>();
    for(int i=0; i<rres->size(); i++)
    {
        string str = (*rres)[i];
        mres->push_back(str);
    }
    for(int i=0; i<rres->size(); i++)
    {
        string str = (*rres)[i];
        str = ch + str;
        mres->push_back(str);
    }

    return mres;   
}

int main(int argc, char** argv)
{
    string s = "abc";
    vector<string>* res = get_subsequence(s, 0);

    for(int i=0; i<res->size(); i++)
    {
        cout<<(*res)[i]<<"  ";
    }    
    cout<<endl;
}