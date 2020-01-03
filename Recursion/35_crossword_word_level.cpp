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

void crossword(vector<vector<char>> &board, vector<string> &words, int wpsf)
{
    if(wpsf == words.size())
    {
        for(int i=0;i<board.size();i++)
        {
            for(int j=0;j<board.size();j++)
            {
                cout<<board[i][j]<<" ";
            }
            cout<<endl;
        }
        return;
    }
    cout<<wpsf<<words[wpsf]<<" na"<<endl;
    for(int i=0; i<board.size();i++)
    {
        for(int j=0;j<board.size();j++)
        {
            if(board[i][j]=='-' || board[i][j]==words[wpsf][0])
            {
                if(can_place_horizontally(board, i, j, words[wpsf]))
                {
                    bool dipit[words[wpsf].size()] = {0};
                    placeH(board, i, j, words[wpsf],dipit);
                    cout<<i<<" "<<j<<"h ea"<<endl;
                    crossword(board, words, wpsf+1);
                    cout<<i<<" "<<j<<"h eb"<<endl;
                    unplaceH(board, i, j, words[wpsf],dipit);
                }
                if(can_place_vertically(board, i, j, words[wpsf]))
                {
                    bool dipit[words[wpsf].size()] = {0};
                    placeV(board, i, j, words[wpsf],dipit);
                    cout<<i<<" "<<j<<"v ea"<<endl;
                    crossword(board, words, wpsf+1);
                    cout<<i<<" "<<j<<"v eb"<<endl;
                    unplaceV(board, i, j, words[wpsf],dipit);
                }
            }
        }
    }
    cout<<wpsf<<words[wpsf]<<" nb"<<endl;
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
    crossword(board, words, 0);
}