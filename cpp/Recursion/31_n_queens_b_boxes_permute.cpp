// n -queens
// b - boxes
// permute them 
// so for 2 queens and 4 boxes - 
// ans-

// 4p2 i.e. 12

// q1b0q2b1
// q1b0q2b2
// q1b0q2b3
// q1b1q2b0
// q1b1q2b2
// q1b1q2b3
// q1b2q2b0
// q1b2q2b1
// q1b2q2b3
// q1b3q2b0
// q1b3q2b1
// q1b3q2b2

#include<bits/stdc++.h>
using namespace std;

void print_permutations(int cq, int tq, int tb, int* visited, string asf)
{
    if(cq>=tq)
    {
        if(cq==tq)
            cout<<asf<<endl;
        return;
    }
    for(int i=0; i<tb; i++)
    {
        if(visited[i]==0)
        {
            visited[i] = 1;
            print_permutations(cq+1, tq, tb, visited, asf + "q" + to_string(cq) + " b" + to_string(i) + "   ");
            visited[i] = 0;
        }

        // WE CAN AVOID USING AN ARRAY TO KEEP VISITED INFORMATION
        // INSTEAD USE BITMASKING AS ILLUSTRATED - 

        // boxes is an integer, initialized as 0

        // for (int i=0; i<tb ;i++)
        // {
        //     if((boxes & (1<<i)) ==0) // check if ith place is 1
        //     {
        //         boxes = boxes ^ (1<<i); // change ith bit to 1
        //         printperm(cq+1, boxes, tq, tb, asf + "q"+to_string(cq)+"b"+to_string(i));
        //         boxes = boxes ^ (1<<i);
        //     }
            
        // }
    }
}

int main()
{
    int tq = 2;
    int tb = 4;
    int visited[] = {0,0,0,0};
    print_permutations(0, 2, 4, visited, "");
}