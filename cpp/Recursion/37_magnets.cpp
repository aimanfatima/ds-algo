// tsa

#include<bits/stdc++.h>
using namespace std;

int sumrowp(vector<vector<char>> rules, int i)
{
    int sum = 0;
    for(int j=0; j<rules[0].size();j++)
        if(rules[i][j]=='+')
            sum++;
    return sum;
}
int sumrowm(vector<vector<char>> rules, int i)
{
    int sum = 0;
    for(int j=0; j<rules[0].size();j++)
        if(rules[i][j]=='-')
            sum++;
    return sum;
}

int sumcolp(vector<vector<char>> rules, int j)
{
    int sum = 0;
    for(int i=0; i<rules.size();i++)
        if(rules[i][j]=='+')
            sum++;
    return sum;
}
int sumcolm(vector<vector<char>> rules, int j)
{
    int sum = 0;
    for(int i=0; i<rules.size();i++)
        if(rules[i][j]=='-')
            sum++;
    return sum;
}

bool can_place_hp(vector<vector<char>> &rules, int i, int j, int left[], int right[], int top[], int bottom[])
{
    if(i>=1 && rules[i-1][j]=='+')
        return false;
    else if(j-1>=0 && rules[i][j-1]=='+')
        return false;
    else if(j+2<rules[0].size() && rules[i][j+2]=='-')
        return false;
    else if(i-1>=0 && rules[i-1][j+1]=='-')
        return false;
    else
    {
        if(left[i]!=-1 && sumrowp(rules, i)>=left[i])
            return false;
        if(right[i]!=-1 && sumrowm(rules,i)>=right[i])
            return false;
        if(top[j]!=-1 && sumcolp(rules,j)>=top[j])
            return false;
        if(bottom[j+1]!=-1 && sumcolm(rules,j+1)>=bottom[j+1])
            return false;
    }
    return true;
}
bool can_place_hm(vector<vector<char>> &rules, int i, int j, int left[], int right[], int top[], int bottom[])
{
    if(i>=1 && rules[i-1][j]=='-')
        return false;
    else if(j-1>=0 && rules[i][j-1]=='-')
        return false;
    else if(j+2<rules[0].size() && rules[i][j+2]=='+')
        return false;
    else if(i-1>=0 && rules[i-1][j+1]=='+')
        return false;
    else 
    {
        if(left[i]!=-1 && sumrowp(rules, i)>=left[i])
            return false;
        if(right[i]!=-1 && sumrowm(rules,i)>=right[i])
            return false;
        if(bottom[j]!=-1 && sumcolm(rules,j)>=bottom[j])
            return false;
        if(top[j+1]!=-1 && sumcolp(rules,j+1)>=top[j+1])
            return false;
    }
        return true;
}
bool can_place_vp(vector<vector<char>> &rules, int i, int j, int left[], int right[], int top[], int bottom[])
{
    if(i-1>=0 && rules[i-1][j]=='+')
        return false;
    else if(j-1>=0 && rules[i][j-1]=='+')
        return false;
    else if(j-1>=0 && rules[i+1][j-1]=='-')
        return false;
    else if(i+2<rules.size() && rules[i+2][j]=='-')
        return false;
    else 
    {
        if(top[j]!=-1 && sumcolp(rules,j)>=top[j])
            return false;
        if(bottom[j]!=-1 && sumcolm(rules,j)>=bottom[j])
            return false;
        if(left[i]!=-1 && sumrowp(rules,i)>=left[i])
            return false;
        if(right[i+1]!=-1 && sumrowm(rules,i+1)>=right[i+1])
            return false;
    }
        return true;

}
bool can_place_vm(vector<vector<char>> &rules, int i, int j, int left[], int right[], int top[], int bottom[])
{
    if(i-1>=0 && rules[i-1][j]=='-')
        return false;
    else if(j-1>=0 && rules[i][j-1]=='-')
        return false;
    else if(j-1>=0 && rules[i+1][j-1]=='+')
        return false;
    else if(i+2<rules.size() && rules[i+2][j]=='+')
        return false;
    else 
    {
        if(top[j]!=-1 && sumcolp(rules,j)>=top[j])
            return false;
        if(bottom[j]!=-1 && sumcolm(rules,j)>=bottom[j])
            return false;
        if(right[i]!=-1 && sumrowm(rules,i)>=right[i])
            return false;
        if(left[i+1]!=-1 && sumrowp(rules,i+1)>=left[i+1])
            return false;
    }
        return true;
}

void placeHp(vector<vector<char>> &rules,int i,int j)
{
    rules[i][j] = '+';
    rules[i][j+1] = '-';
}
void placeHm(vector<vector<char>> &rules,int i,int j)
{
    rules[i][j] = '-';
    rules[i][j+1] = '+';
}
void placeHx(vector<vector<char>> &rules,int i,int j)
{
    rules[i][j] = 'X';
    rules[i][j+1] = 'X';
}

void placeVp(vector<vector<char>> &rules,int i,int j)
{
    rules[i][j] = '+';
    rules[i+1][j] = '-';
}
void placeVm(vector<vector<char>> &rules,int i,int j)
{
    rules[i][j] = '-';
    rules[i+1][j] = '+';
}
void placeVx(vector<vector<char>> &rules,int i,int j)
{
    rules[i][j] = 'X';
    rules[i+1][j] = 'X';
}

void unplaceH(vector<vector<char>> &rules,int i,int j)
{
    rules[i][j] = 'L';
    rules[i][j+1] = 'R';
}
void unplaceV(vector<vector<char>> &rules,int i,int j)
{
    rules[i][j] = 'T';
    rules[i+1][j] = 'B';
}

void showboard(vector<vector<char>> &rules)
{
    for(int i=0; i<rules.size();i++)
    {
        for(int j=0; j<rules[i].size(); j++)
        {
            cout<<rules[i][j]<<" ";
        }
        cout<<endl;
    }
}

bool check_top(vector<vector<char>> &rules, int top[])
{
    for(int j=0; j<6; j++)
    {
        if(top[j]!=-1 && sumcolp(rules,j)!=top[j])
            return false;
    }
    return true;
}

bool check_bottom(vector<vector<char>> &rules, int bottom[])
{
    for(int j=0; j<6; j++)
    {
        if(bottom[j]!=-1 && sumcolm(rules,j)!=bottom[j])
            return false;
    }
    return true;
}
bool check_left(vector<vector<char>> &rules, int left[])
{
    for(int i=0; i<5; i++)
    {
        if(left[i]!=-1 && sumrowp(rules,i)!=left[i])
            return false;
    }
    return true;
}
bool check_right(vector<vector<char>> &rules, int right[])
{
    for(int i=0; i<5; i++)
    {
        if(right[i]!=-1 && sumrowm(rules,i)!=right[i])
            return false;
    }
    return true;
}

void magnets(int top[], int bottom[], int left[], int right[], vector<vector<char>> &rules, int bno)
{
    if(bno == 30)
    {
        //cout<<"base"<<endl;
        if(check_top(rules, top) && check_bottom(rules, bottom) && check_left(rules, left) && check_right(rules, right))
        {
            for(int j=0;j<6;j++)
                if(top[j]!=-1)
                    cout<<" "<<sumcolp(rules,j);
            cout<<endl;
            
            for(int i=0; i<rules.size();i++)
            {
                if(left[i]!=-1)
                    cout<<sumrowp(rules,i)<<" ";
                else cout<<" ";
                for(int j=0; j< rules[i].size();j++)
                {
                    cout<<rules[i][j]<<" ";
                }
                if(right[i]!=-1)
                    cout<<sumrowm(rules,i)<<" ";
                else cout<<" ";
                cout<<endl;
            }
            for(int j=0;j<6;j++)
                if(bottom[j]!=-1)
                    cout<<" "<<sumcolm(rules,j);
            cout<<endl;
        }
        
        return;
    }
    int i = bno / 6;
    int j = bno % 6;

    //cout<<bno<<" "<<i<<" "<<j<<endl;
    //showboard(rules);
    //cout<<endl;

    if(rules[i][j]=='L')
    {
        if(can_place_hp(rules, i, j, left, right, top, bottom))
        {
            placeHp(rules, i, j);
            //showboard(rules);
            magnets(top, bottom, left, right, rules, bno+1);
            unplaceH(rules, i , j);
        }
        if(can_place_hm(rules, i, j, left , right, top, bottom))
        {
            placeHm(rules, i, j);
            magnets(top, bottom, left, right, rules, bno+1);
            unplaceH(rules, i , j);
        }
         //PUT XX
            placeHx(rules, i, j);
            magnets(top, bottom, left, right, rules, bno+1);
            unplaceH(rules, i , j);
        
        
    }
    else if(rules[i][j]=='T')
    {
        if(can_place_vp(rules, i, j, left, right, top, bottom))
        {
            placeVp(rules, i, j);
            magnets(top, bottom, left, right, rules, bno+1);
            unplaceV(rules, i , j);
        }
        if(can_place_vm(rules, i, j, left , right, top, bottom))
        {
            placeVm(rules, i, j);
            magnets(top, bottom, left, right, rules, bno+1);
            unplaceV(rules, i , j);
        }
         //PUT XX
            placeVx(rules, i, j);
            magnets(top, bottom, left, right, rules, bno+1);
            unplaceV(rules, i , j);
    
        
    }
    else
    {
        magnets(top, bottom, left, right, rules, bno+1);
    }
    
    
}

int main(int argc, char** argv)
{
        //int M = 5, N = 6
        int top[] = { 1, -1, -1, 2, 1, -1 };
        int bottom[] = { 2, -1, -1, 2, -1, 3 };
        int left[] = { 2, 3, -1, -1, -1 };
        int right[] = { -1, -1, -1, 1, -1 };
        vector<vector<char>> rules= 
                        {{ 'L', 'R', 'L', 'R', 'T', 'T'},
                        { 'L', 'R', 'L', 'R', 'B', 'B' },
                        { 'T', 'T', 'T', 'T', 'L', 'R' },
                        { 'B', 'B', 'B', 'B', 'T', 'T' },
                        { 'L','R', 'L', 'R', 'B', 'B' }};
        
        magnets(top, bottom, left, right, rules, 0);

}