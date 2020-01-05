//  10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1

#include<bits/stdc++.h>
using namespace std;

class Node
{
    public:
    int data;
    vector<Node*> children;

    Node(int data)
    {
        this->data = data;
    }
};

Node* construct(vector<int>& dlist)
{
    stack<Node*> st;
    Node* root = NULL;

    for(int i=0; i<dlist.size(); i++)
    {
        if(dlist[i]!=-1)
        {
            Node* node = new Node(dlist[i]);
            if(st.empty())
            {
                root = node;
            }
            else
            {
                st.top()->children.push_back(node);
            }

            st.push(node);
        }
        else
        {
            st.pop();
        }
    }
    return root;
}

void display(Node* root)
{
    cout<<root->data<<"     .   ";
    for(int i=0; i<root->children.size(); i++)
        cout<<root->children[i]->data<<"    ";
    cout<<endl;

    for(int i=0; i<root->children.size(); i++)
        display(root->children[i]);
}

int max(Node* root)
{
    int mres = root->data;

    for(int i=0; i < root->children.size(); i++)
    {
        int rres = max(root->children[i]);
        if(rres > mres)
            mres = rres;
    }
    return mres;
}

int main()
{
    vector<int> dlist = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
    Node* root = construct(dlist);
    cout<<max(root);
}