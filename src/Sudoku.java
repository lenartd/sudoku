public class Sudoku
{
    private int myBoard[][];

    public boolean setBoard(int[][] board)
    {
        myBoard = new int[9][9];

        if(board.length == 9)
        {
            for(int i =0; i<9; i++)
            {
                if(board[i].length != 9){return false;}
            }
        }
        else{return false;}

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                myBoard[i][j] = board[i][j];
            }
        }
        return true;
    }

    private boolean checkRow(int row, int num)
    {
        for(int i = 0; i<9; i++)
        {
            if(myBoard[row][i] == num){return true;}
        }
        return false;
    }

    private boolean checkColumn(int column, int num)
    {
        for(int i = 0; i<9; i++)
        {
            if(myBoard[i][column] == num){return true;}
        }
        return false;
    }

    private boolean checkBox(int row, int column, int number)
    {
        int r = row - row % 3;
        int c = column - column % 3;

        for (int i = r; i < r + 3; i++)
        {
            for (int j = c; j < c + 3; j++)
            {
                if (myBoard[i][j] == number)
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkConditions(int row, int column, int num)
    {
        return !checkRow(row, num)  &&  !checkColumn(column, num)  &&  !checkBox(row, column, num);
    }

    public boolean SolveSudoku()
    {
        for(int i = 0; i<9; i++)
        {
            for(int j = 0; j<9; j++)
            {
                if(myBoard[i][j] == 0)
                {
                    for(int k = 1; k<=9; k++)
                    {
                        if(checkConditions(i, j, k))
                        {
                            myBoard[i][j] = k;
                            if(SolveSudoku()){return true;}
                            else{myBoard[i][j] = 0;}
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void printOut()
    {
        for(int i = 0; i<9; i++)
        {
            for(int j = 0; j<9; j++)
            {
                System.out.print(myBoard[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

}
