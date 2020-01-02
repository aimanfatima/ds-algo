// program to print all the possible combinations of string (in base case)
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

void print_keypad(string ques, string asf) // asf - answer so far
{
    if(ques=="")
    {
        cout<<asf<<endl;
        return;
    }
    char ch = ques[0];
    string keys = arr[ch - '0'];

    for(int i=0; i<keys.size(); i++)
    {
        print_keypad(ques.substr(1), asf + keys[i]);
    }
}

int main()
{
    print_keypad("682", "");
}