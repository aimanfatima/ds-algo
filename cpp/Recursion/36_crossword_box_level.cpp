// tsa

#include<bits/stdc++.h>
using namespace std;


bool can_place_horizontally(vector<vector<char>> &board, int i, int j, string word)
{
    if(j+word.size()>board.size())
        return false;
    else if(j>0 && board[i][j-1]!='+') // left side bhi hai, aur wahan plus bhi pda hai
        return false;
    else if(j+word.size()<board.size() && board[i][j+word.size()]!='+') // right side bhi hai and plus bhi hai
        return false;
    else
    {
        for(int jj=0; jj<word.size(); jj++)
        {
            if(board[i][jj+j]!='-' && board[i][jj+j]!=word[jj])
                return false;
        }
        return true;
    }
    
}

bool can_place_vertically(vector<vector<char>> &board, int i, int j, string word)
{
    if(i+word.size()>board.size())
        return false;
    else if(i>0 && board[i-1][j]!='+')
        return false;
    else if(i+word.size()<board.size() && board[i+word.size()][j]!='+')
        return false;
    else
    {
        for(int ii=0; ii<word.size(); ii++)
        {
            if(board[ii+i][j]!='-' && board[ii+i][j]!=word[ii])
                return false;
        }
        return true;
    }
}

void placeH(vector<vector<char>> &board, int i, int j, string word, bool dipit[])
{
    for(int jj=0;jj<word.size();jj++)
    {
        if(board[i][jj+j]=='-')
        {
            dipit[jj] = true;
            board[i][jj+j] = word[jj];
        }
        else
        {
            dipit[jj] =  false;
        }
        
        
    }
}

void placeV(vector<vector<char>> &board, int i, int j, string word, bool dipit[])
{
    for(int ii=0;ii<word.size();ii++)
    {
        dipit[ii] = board[i+ii][j]=='-';
        board[i+ii][j] = word[ii];
    }
}

void unplaceV(vector<vector<char>> &board, int i, int j, string word, bool dipit[])
{
    for(int ii=0; ii<word.size(); ii++)
    {
        if(dipit[ii]==true)
            board[ii+i][j] = '-';
    }
}

void unplaceH(vector<vector<char>> &board, int i, int j, string word, bool dipit[])
{
    for(int jj=0; jj<word.size(); jj++)
    {
        if(dipit[jj]==true)
            board[i][jj+j] = '-';
    }
}


void crossword(vector<vector<char>> &board, vector<string> &words, vector<bool> &check,  int bno)
{
    if(bno==board.size()*board.size())
    {
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
    
    int row = bno/board.size();
    int col = bno%board.size();

    cout<<row<<col<<endl;

    int c=0;
    if(board[row][col]!='+')
    {

    for(int i=0; i<words.size(); i++)
    {
        if(board[row][col]==words[i][0])
                c++;
        if(check[i]==false)
        {
            
            if(can_place_horizontally(board, row, col, words[i]))
            {
                cout<<words[i]<<bno<<"h"<<endl;
                check[i] = true;
                bool dipit[words[i].size()] = {0};
                placeH(board, row, col, words[i], dipit);
                crossword(board, words, check, bno+1);
                unplaceH(board, row, col, words[i], dipit);
                check[i] = false;
            }
            if(can_place_vertically(board, row, col, words[i]))
            {
                cout<<words[i]<<bno<<"v"<<endl;
                check[i] = true;
                bool dipit[words[i].size()] = {0};
                placeV(board, row, col, words[i], dipit);
                crossword(board, words, check, bno+1);
                unplaceV(board, row, col, words[i], dipit);
                check[i] = false;
            }
            
        }
    }

    }
    else if(board[row][col]=='+' || c==0)
    {
        crossword(board, words, check, bno+1);
    }
    
}

int main(int argc, char** argv)
{
    vector<vector<char>> board {
        {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
        {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
        {'+', '-', '-', '-', '-', '-', '-', '-', '+', '+'},
        {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
        {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
        {'+', '-', '-', '-', '-', '-', '-', '+', '+', '+'},
        {'+', '-', '+', '+', '+', '-', '+', '+', '+', '+'},
        {'+', '+', '+', '+', '+', '-', '+', '+', '+', '+'},
        {'+', '+', '+', '+', '+', '-', '+', '+', '+', '+'},
        {'+', '+', '+', '+', '+', '+', '+', '+', '+', '+'}
    };

    vector<string> words {"agra", "norway", "england", "gwalior"};
    vector<bool> check = {false, false, false, false};
    crossword(board, words,check, 0);
}