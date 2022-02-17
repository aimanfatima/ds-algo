#include<bits/stdc++.h>
using namespace std;

bool is_valid(int row, int col, vector<vector<int>> &box, int data)
{
    for(int i=0; i<9; i++)
    {
        if(box[i][col]==data)
            return false;
    }

    for(int i=0; i<9; i++)
    {
        if(box[row][i]==data)
            return false;
    }

    int smrc = row / 3 * 3;
    int smcc = col / 3 * 3;
    for(int ii = smrc; ii < smrc + 3; ii++)
    {
        for(int jj = smcc; jj < smcc + 3; jj++)
        {
            if(box[ii][jj] == data)
            {
                return false;
            }
        }
    }

    return true;
}

void sudoku(int bno, vector<vector<int>> &box)
{
    if(bno==81)
    {
        for(int i=0; i<box.size(); i++)
        {
            for(int j=0; j<box[i].size(); j++)
            {
                cout<<box[i][j]<<" ";
            }
            cout<<endl;
        }
        cout<<"-------------------------\n";
        return;
    }
    int row = bno/9;
    int col = bno%9;

    if(box[row][col]==0)
    {
        for(int i=1; i<=9; i++)
        {
            if(is_valid(row, col, box, i))
            {
                box[row][col] = i;
                sudoku(bno+1, box);
                box[row][col] = 0;
            }
        }
    }
    else
    {
        sudoku(bno+1, box);
    }
    
}

int main()
{
    vector<vector<int>> box = 
    {
        {5,0,6,0,0,2,1,0,0},
        {0,9,8,0,0,0,0,0,0},
        {4,0,0,1,0,0,0,0,0},
        {0,0,0,0,3,0,0,8,2},
        {7,0,0,2,0,4,0,0,5},
        {9,5,0,0,8,0,0,0,0},
        {0,0,0,0,0,7,0,0,3},
        {0,0,0,0,0,0,5,4,0},
        {0,0,9,5,0,0,2,0,1}
    };
    sudoku(0, box);
}