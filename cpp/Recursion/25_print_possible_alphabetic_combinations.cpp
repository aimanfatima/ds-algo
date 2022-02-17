#include<bits/stdc++.h>
using namespace std;

char str[27] ;

void printcoding(string ques, string ans)
{
    if(ques.size()==0)
    {
        cout<<ans<<endl;
        return;
    }

    char fch = ques[0];
    string fstr = string(1,(str[fch - '0']));
    int sch = stoi(ques.substr(0,2));
    string sstr = string(1,(str[sch]));

    if(ques.size()>=1 && (fch-'0'!=0) )
    {
        printcoding(ques.substr(1), ans+fstr);
        if(ques.size()>=2)
            printcoding(ques.substr(2), ans+sstr);
    }
    
}

int main()
{
    char letter = 'a';
    for(int i=1; i<=26;i++)
    {
        str[i] = letter;
        letter++;
    }
    string s = "1023";
    printcoding(s,"");
}