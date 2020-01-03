// REVIEW

// Given a string, and a dictionary of valid words, 
// Return a list of all the possible sentences

// i/p - mangolovesicecream
// {man, go, loves, ice, cream}

// o/p - {"man go loves ice cream", "mango loves ice cream", "man go loves icecram", "mango loves icecream"}

#include<bits/stdc++.h>
using namespace std;

vector<vector<string>> getalls(vector<string> words, string str )
{
    if(str.size()==0)
    {
        vector<vector<string>> bres;
        vector<string> bstr = {""};
        bres.push_back(bstr);
        return bres;
    }
    vector<vector<string>> mres;
    for(int i=1; i<=str.size();i++)
    {
        string substr = str.substr(0,i);
        for(int j=0;j<words.size();j++)
        {
            if(substr==words[j])
            {
                vector<vector<string>> rres = getalls(words, str.substr(i) );
                for(int k=0;k<rres.size();k++)
                {
                    rres[k].push_back(substr);
                    mres.push_back(rres[k]);
                }
            }
        }
    }
    return mres;
}

int main()
{
    vector<string> words = { "man", "go", "mango", "ice", "cream", "icecream", "loves"};
    string str = "mangolovesicecream";

    vector<vector<string>> res = getalls(words, str);
    for(int i=0;i<res.size();i++)
    {
        for(int j=res[i].size()-1;j>=0; j--)
        {
            cout<<res[i][j]<<" ";
        }
        cout<<endl;
    }
}