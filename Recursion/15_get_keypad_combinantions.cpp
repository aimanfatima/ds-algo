// program to return all the possible combinations of string
// that we can make using the keypad in conevtional phones.

// example - 
// keypad

// 0       1       2       3       4       5       6       7       8       9
// ".;"    "abc"   "def"   "ghi"   "jkl"   "mno"   "pqrs"  "tuv"   "wx"    "yz"

// so possible string using "21"
// da      db      dc      ea      eb      ec      fa      fb      fc

#include<bits/stdc++.h>
using namespace std;

string arr[] = {".;","abc","def","ghi","jkl","mno","pqrs","tuv","wx","yz"};

vector<string>* get_keypad_combinations(string &s, int sp)
{
    if(sp == s.size())
    {
        vector<string>* bres = new vector<string>();
        bres->push_back("");
        return bres;
    }
    vector<string>* rres = get_keypad_combinations(s, sp+1);
    int keypad_number = (int)s[sp]-'0';
    string keypad_comb = arr[keypad_number];

    vector<string>* mres = new vector<string>();

    for(int i=0; i<keypad_comb.size(); i++)
    {
        char char_to_be_appended = keypad_comb[i];
        for(int j= 0; j < rres->size(); j++)
        {
            string str = char_to_be_appended + (*rres)[j];
            mres->push_back(str);
        }
    }
    return mres;
}

int main()
{
    // string s = "21";
    // output - da    db    dc    ea    eb    ec    fa    fb    fc
    string s = "682";
    vector<string>* ans = get_keypad_combinations(s, 0);

    for(auto it = ans->begin(); it!=ans->end(); it++)
        cout<<*it<<endl;
    
    cout<<endl;
}

