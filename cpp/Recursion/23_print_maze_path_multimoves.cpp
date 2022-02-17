// Given n X m maze (er - end row, ec - end column)
// You are currently at (0,0) position, 
// Print all the paths in the base case
// to from current position (0,0) to (n-1, m-1) using all three moves - "h", "v" and "d"
// Also, you may take a jump of any number of steps at a time. 

// Hence the result must have strings with letters of form -  H1, H2, H3, V1, V2, V3, D1, D2, D3 and so on..

#include<bits/stdc++.h>
using namespace std;

int c = 0;

void print_maze_path_mm(int cr, int cc, int er, int ec, string asf)
{
    if(cr==er && cc==ec)
    {
        c++;
        cout<<asf<<endl;
        return;
    }

    if(cr>er || cc > ec)
        return;
    for(int i=1; i<=ec;i++) // H calls
    {
        print_maze_path_mm(cr, cc+i, er, ec, asf + "h" + to_string(i));
    }

    for(int i=1; i<=ec; i++) // V calls
    {
        print_maze_path_mm(cr+i, cc, er, ec, asf + "v" + to_string(i));
    }

    for(int i=1; i<=er && i<=ec; i++) // D calls
    {
        print_maze_path_mm(cr+i, cc+i, er, ec, asf + "d" + to_string(i));
    }
}

int main()
{
    print_maze_path_mm(0, 0, 2, 2, "");
    cout<<c<<endl;
}