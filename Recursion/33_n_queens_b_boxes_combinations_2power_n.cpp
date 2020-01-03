// n - queens
// b - boxes
// print all possible combinations 
// i.e. order of queen dosent matter 
// so for 2 queens and 4 boxes - 
// ans-

// 4c2 i.e. 6

// q1b0q2b1
// q1b0q2b2
// q1b0q2b3
// q1b1q2b0
// q1b1q2b2
// q1b1q2b3

// Meaning of " USING 2 to the power n method "
// Here we take boxes on level and queen as options,
// Unlike previous two solutions where we had 
// queens on levels and boxes as options 

#include<bits/stdc++.h>
using namespace std;

void print_combinantions(int cb, int cq, int tq, int tb, string asf)
{
    if(cb >= tb)
    {
        if(cq==tq)
            cout<<asf<<endl;
        return;
    }
    print_combinantions(cb+1,cq+1, tq, tb, asf +"q"+ to_string(cq) + " b" + to_string(cb) + "     ");
    print_combinantions(cb+1,cq, tq, tb, asf);    
}

int main()
{
    int tq = 2;
    int tb = 4;
    print_combinantions(0,0, tq, tb, "");
}