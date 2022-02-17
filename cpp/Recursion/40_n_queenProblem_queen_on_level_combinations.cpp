#include<bits/stdc++.h>
using namespace std;

int c=0;

bool isvalid(vector<vector<int>> &board, int i, int j)
{
    int ii, jj;
    for( ii=i-1; ii>=0; ii--)
        if(board[ii][j]>0)
            return false;
    for(jj=j-1; jj>=0;jj--)
        if(board[i][jj]>0)
            return false;
    for(ii=i-1, jj=j-1; ii>=0 && jj>=0; ii--, jj--)
        if(board[ii][jj]>0)
            return false;
    for(ii=i-1, jj=j+1; ii>=0 && jj<board.size(); ii--, jj++)
        if(board[ii][jj]>0)
            return false;

    for(int jj=j+1; jj<board.size();jj++)
        if(board[i][jj]>0)
            return false;
    for(int ii=i+1; ii<board.size();ii++)
        if(board[ii][j]>0)
            return false;
    for(ii=i+1, jj=j-1; ii<board.size() && jj>=0; ii++, jj--)
        if(board[ii][jj]>0)
            return false;

    for(ii=i+1, jj=j+1; ii<board.size() && jj<board.size(); ii++, jj++)
        if(board[ii][jj]>0)
            return false;
    return true;
}

void nqp_q(vector<vector<int>> &board, int qpsf, int lqwpiwb)
{
    if(qpsf>board.size())
    {
        c++;
        for(int i=0; i<board.size(); i++)
        {
            for(int j=0; j<board.size(); j++)
            {
                cout<<board[i][j]<<" ";
            }
            cout<<endl;
        }
        return;
    }

    for(int b=lqwpiwb+1;b<16;b++)
    {
       int i= b/4;
       int j= b%4;

            if(board[i][j]==0 && isvalid(board, i, j))
            {
                board[i][j] = qpsf;
                nqp_q(board, qpsf+1, b);
                board[i][j] = 0;
            }
        
    }
}

int main(int argc, char** argv)
{
    vector<vector<int>> board = {{0 ,0 , 0, 0},
    {0 ,0 , 0, 0},
    {0 ,0 , 0, 0},
    {0 ,0 , 0, 0}};
    nqp_q(board, 1, -1);
    cout<<c<<endl;
}