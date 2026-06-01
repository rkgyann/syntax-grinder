#include <stdio.h>
#include <stdlib.h>

struct Node
{
    int data;
    struct Node *left;
    struct Node *right;
};

// Create New Node
struct Node* createNode(int value)
{
    struct Node* newNode =
        (struct Node*)malloc(sizeof(struct Node));

    newNode->data = value;
    newNode->left = NULL;
    newNode->right = NULL;

    return newNode;
}

// Search for duplicate value
int searchNode(struct Node* root, int value)
{
    if(root == NULL)
        return 0;

    if(root->data == value)
        return 1;

    return searchNode(root->left, value) ||
           searchNode(root->right, value);
}

// Insert into BST
struct Node* insertBST(struct Node* root, int value)
{
    if(root == NULL)
        return createNode(value);

    if(value < root->data)
        root->left = insertBST(root->left, value);

    else if(value > root->data)
        root->right = insertBST(root->right, value);

    return root;
}

// Display Tree Sideways
void displayTree(struct Node* root, int space)
{
    if(root == NULL)
        return;

    space += 8;

    displayTree(root->right, space);

    printf("\n");

    for(int i = 8; i < space; i++)
        printf(" ");

    printf("%d\n", root->data);

    displayTree(root->left, space);
}

// Find Root-to-Node Path
int findPath(struct Node* root, int target,
             int path[], int *size)
{
    if(root == NULL)
        return 0;

    path[*size] = root->data;
    (*size)++;

    if(root->data == target)
        return 1;

    if(findPath(root->left, target, path, size) ||
       findPath(root->right, target, path, size))
        return 1;

    (*size)--;

    return 0;
}

// Graphical Path Display
void displayPathGraphically(int path[], int size)
{
    printf("\n");
    printf("====================================\n");
    printf("        ROOT TO NODE PATH\n");
    printf("====================================\n\n");

    for(int i = 0; i < size; i++)
    {
        printf("           [%d]\n", path[i]);

        if(i != size - 1)
        {
            printf("             |\n");
            printf("             v\n");
        }
    }

    printf("\n");
}

// Display Ancestors
void displayAncestors(int path[], int size)
{
    printf("\nAncestors : ");

    if(size == 1)
    {
        printf("Root Node Has No Ancestors");
        return;
    }

    for(int i = 0; i < size - 1; i++)
    {
        printf("%d", path[i]);

        if(i < size - 2)
            printf(" -> ");
    }

    printf("\n");
}

int main()
{
    struct Node* root = NULL;

    int n;
    int value;

    printf("====================================\n");
    printf(" BINARY TREE ANCESTOR FINDER PROJECT\n");
    printf("====================================\n\n");

    printf("Enter Number of Nodes : ");
    scanf("%d", &n);

    for(int i = 1; i <= n; i++)
    {
        while(1)
        {
            printf("\nEnter Value For Node %d : ", i);

            if(scanf("%d", &value) != 1)
            {
                printf("Invalid Input!\n");
                printf("Please Enter Integers Only.\n");

                while(getchar() != '\n');
                continue;
            }

            if(searchNode(root, value))
            {
                printf("Duplicate Value Found!\n");
                printf("Please Enter Another Value.\n");
                continue;
            }

            root = insertBST(root, value);

            printf("\nCurrent Binary Tree:\n");
            displayTree(root, 0);

            break;
        }
    }

    printf("\n\n====================================\n");
    printf("         FINAL BINARY TREE\n");
    printf("====================================\n");

    displayTree(root, 0);

    int target;

    printf("\n\nEnter Node Value To Find Ancestors : ");
    scanf("%d", &target);

    int path[100];
    int size = 0;

    if(findPath(root, target, path, &size))
    {
        printf("\nNode Found : %d\n", target);

        printf("\nPath : ");

        for(int i = 0; i < size; i++)
        {
            printf("%d", path[i]);

            if(i != size - 1)
                printf(" -> ");
        }

        printf("\n");

        displayPathGraphically(path, size);

        displayAncestors(path, size);
    }
    else
    {
        printf("\nNode Not Found In Tree!\n");
    }

    return 0;
}