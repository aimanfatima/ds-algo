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

int distance (Node* root, int d1, int d2)
{
    vector<int>* path1 = node_to_root_path(root, d1);
    vector<int>* path2 = node_to_root_path(root, d2);

    int size_common = 0;

    int i = path1->size()-1;
    int j = path2->size()-1;

    while((*path1)[i]==(*path2)[j] && i>=0 && j>=0)
    {
        size_common++;
        i--; j--;
    }

    return path1->size() + path2->size() - 2*size_common + 1;

}

int main()
{
    vector<int> dlist = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
    Node* root = construct(dlist);
    cout<<distance(root, 60, 50);
}