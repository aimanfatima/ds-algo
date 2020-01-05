//  10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1

// SIZE - total number of nodes

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

int size(Node* root)
{
    int msize = 1;
    for(int i=0; i<root->children.size(); i++)
        msize += size(root->children[i]);

    return msize;
}

int main()
{
    vector<int> dlist = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
    Node* root = construct(dlist);
    cout<<size(root)<<endl;
}