#include<bits/stdc++.h>
using namespace std;

char str[27] ;

vector<string> apc(string s)
{
    if(s.size()==0)
    {
        vector<string> bres;
        bres.push_back("");
        return bres;
    } 
    vector<string> mres ;   
    int fidx = stoi(s.substr(0,1));
    if(s.size()>=1 && fidx!=0)
    {
        
        char fletter = str[fidx];
        vector<string> oneres = apc(s.substr(1, s.size()-1));

        for(int i=0;i<oneres.size();i++)
        {
            string mstr = string(1,fletter) + oneres[i];
            mres.push_back(mstr);
        }

        if(s.size()>=2)
        {
            int sidx = (stoi(s.substr(0,2)));
            if(sidx<=26)
            {
                char sletter = str[sidx];
                vector<string> twores = apc(s.substr(2, s.size()-1));

                for(int i=0;i<twores.size();i++)
                {
                    string mstr = string(1,sletter) + twores[i];
                    mres.push_back(mstr);
                }
            }
            
        }

    }
    return mres;
}

int main(int argc, char** argv)
{
    char letter = 'a';
    for(int i=1; i<=26;i++)
    {
        str[i] = letter;
        letter++;
    }
    string s = "11023";
    //10016 - invalid
    // Handle this 1023
    vector<string> res = apc(s);
    for(int i=0;i<res.size();i++)
    {
        cout<<res[i]<<endl;
    }
}