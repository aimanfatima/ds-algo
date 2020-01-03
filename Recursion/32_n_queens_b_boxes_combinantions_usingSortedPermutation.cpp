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

// Meaning of " USING SORTED PERMUTATION "
// Here we are using the same solution as that in 31st program, 
// but we are restricting ourselves to only one sorted permutations

// In other words, we pick a sorted permutation for dropping to combinantions

#include<bits/stdc++.h>
using namespace std;

void print_combinations(int cq, int tq, int tb, int* visited, string asf)
{
    if(cq >= tq)
    {
        if(cq==tq)
            cout<<asf<<endl;
        return;
    }
    for(int i=0; i<tb; i++)
    {
        if(visited[i]==0)
        {
            for(int j=0; j<=i; j++) // observe this
                visited[j] = 1;
            print_combinations(cq+1, tq, tb, visited, asf + "q" + to_string(cq) + " b" + to_string(i) + "   ");
            for(int j=0; j<=i; j++)
                visited[j] = 0;
        }
    }
}

int main()
{

    int tq = 2;
    int tb = 4;

    int visited[] = {0,0,0,0};
    print_combinations(0, tq, tb, visited, "");

}