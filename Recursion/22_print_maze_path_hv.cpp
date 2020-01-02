#include<bits/stdc++.h>
using namespace std;

void print_maze_path(int cr, int cc, int er, int ec, string asf)
{
    if(cr>er || cc>ec)
        return;
    if(cr==er && cc==ec)
    {
        cout<<asf<<endl;
        return;
    }
    print_maze_path(cr, cc+1, er, ec, asf + "h");
    print_maze_path(cr+1, cc, er, ec, asf + "v");
}

int main()
{
    print_maze_path(0, 0, 2, 2, "");
}