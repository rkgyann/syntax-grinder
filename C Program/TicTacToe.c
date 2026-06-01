#include <stdio.h>

char board[3][3];
char player = 'X';

// Function to initialize board
void initializeBoard()
{
    char ch = '1';

    for(int i = 0; i < 3; i++)
    {
        for(int j = 0; j < 3; j++)
        {
            board[i][j] = ch++;
        }
    }
}

// Function to display board
void displayBoard()
{
    printf("\n");

    for(int i = 0; i < 3; i++)
    {
        printf(" %c | %c | %c ", board[i][0], board[i][1], board[i][2]);

        if(i < 2)
            printf("\n---|---|---\n");
    }

    printf("\n");
}

// Function to place mark
int placeMark(int position)
{
    int row = (position - 1) / 3;
    int col = (position - 1) % 3;

    if(position < 1 || position > 9)
        return 0;

    if(board[row][col] == 'X' || board[row][col] == 'O')
        return 0;

    board[row][col] = player;
    return 1;
}

// Function to check winner
int checkWinner()
{
    for(int i = 0; i < 3; i++)
    {
        if(board[i][0] == player &&
           board[i][1] == player &&
           board[i][2] == player)
            return 1;

        if(board[0][i] == player &&
           board[1][i] == player &&
           board[2][i] == player)
            return 1;
    }

    if(board[0][0] == player &&
       board[1][1] == player &&
       board[2][2] == player)
        return 1;

    if(board[0][2] == player &&
       board[1][1] == player &&
       board[2][0] == player)
        return 1;

    return 0;
}

// Function to switch player
void switchPlayer()
{
    if(player == 'X')
        player = 'O';
    else
        player = 'X';
}

int main()
{
    int position;
    int moves = 0;

    initializeBoard();

    printf("================================\n");
    printf("      TIC TAC TOE GAME\n");
    printf("================================\n");

    while(moves < 9)
    {
        displayBoard();

        printf("\nPlayer %c, Enter Position (1-9): ", player);
        scanf("%d", &position);

        if(!placeMark(position))
        {
            printf("Invalid Move! Try Again.\n");
            continue;
        }

        moves++;

        if(checkWinner())
        {
            displayBoard();
            printf("\nPlayer %c Wins!\n", player);
            return 0;
        }

        switchPlayer();
    }

    displayBoard();
    printf("\nMatch Draw!\n");

    return 0;
}