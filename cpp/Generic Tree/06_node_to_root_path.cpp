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

vector<int>* node_to_root_path(Node* root, int data)
{
    if(root->data == data)
    {
        vector<int>* bres = new vector<int>();
        bres->push_back(root->data);
        return bres;
    }
    vector<int>* mres = new vector<int>();
    for(int i=0; i<root->children.size(); i++)
    {
        vector<int>* rres = node_to_root_path(root->children[i], data);
        if(rres->size() > 0)
        {
            rres->push_back(root->data);
            return rres;
        }
    }
    return mres; // or don't initialize mres and simply return NULL
}

int main()
{
    vector<int> dlist = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
    Node* root = construct(dlist);
    vector<int>* path = node_to_root_path(root, 60);

    for(int i=0; i < path->size(); i++)
    {
        cout<<(*path)[i]<<"    ";
    }
}