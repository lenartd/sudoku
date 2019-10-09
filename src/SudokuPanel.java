public class SudokuPanel
{
    public static int[][] grid =
            {
            {1,0,0,0,2,6,0,3,9},
            {0,0,8,7,0,0,6,0,1},
            {0,0,0,0,0,0,2,0,0},
            {4,0,0,9,0,0,5,1,6},
            {0,0,0,0,0,0,0,0,0},
            {7,9,6,0,0,4,0,0,8},
            {0,0,9,0,0,0,0,0,0},
            {3,0,1,0,0,2,9,0,0},
            {6,4,0,1,8,0,0,0,3},
            };

    private int[][] board;

    public void SudokuPanel(int[][] board)
    {
        this.board = new int[9][9];

        for(int i =0; i<9; i++)
        {
            for(int j =0; j<9; i++)
            {
                board[i][j] = grid[i][j];
            }
        }
    }

    public boolean checkRow(int row, int num)
    {
        for(int i = 0; i<9; i++)
        {
            if(this.board[row][i] == num){return true;}
        }
        return false;
    }

    public boolean checkColumn(int column, int num)
    {
        for(int i = 0; i<9; i++)
        {
            if(this.board[i][column] == num){return true;}
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
                if (board[i][j] == number)
                {
                    return true;
                }
            }
        }
        return false;
    }

    /*
    private boolean checkConditions(int row, int column, int num)
    {
        return !checkRow(row, num)  &&  !checkColumn(column, num)  &&  !checkBox(row, column, num);
    }
    */
}
