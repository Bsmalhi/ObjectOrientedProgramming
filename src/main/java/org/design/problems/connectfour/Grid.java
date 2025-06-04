package org.design.problems.connectfour;

public class Grid {
    private int rows;
    private int columns;
    private int[][] grid;

    public Grid(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        initGrid();
    }

    void initGrid() {
        this.grid = new int[rows][columns];
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++) {
                grid[i][j] = GridPosition.EMPTY.ordinal();
            }
        }
    }

    public int[][] getGrid(){
        return this.grid;
    }

    public int getColumnCount(){
        return this.columns;
    }

    // in connect four the piece always drops in the empty row cell
    // and player picks the column
    public int placePiece(int column, GridPosition piece){
        if(column < 0 || column > this.columns)
            throw new Error("Invalid column");
        if(piece == GridPosition.EMPTY)
            throw new Error("Invalid piece");
        for(int i = rows - 1; i >= 0; i--){
            if(grid[i][column] == GridPosition.EMPTY.ordinal()){
                grid[i][column] = piece.ordinal();
                return i;
            }
        }
        return -1; // no empty column
    }

    // here we check if horizontally or diagonally or vertically pieces can connect
    public boolean checkWin(int connectN, int row, int col, GridPosition piece){
        int count = 0;
        // check horizontally
        for(int c = 0; c < this.columns; c++){
            if(grid[row][c] == piece.ordinal()){
                count++;
            } else {
                count = 0;
            }
            if(count == connectN)
                return true;
        }

        // check vertically
        count = 0;
        for(int r = 0; r < this.rows; r++){
            if(grid[r][col] == piece.ordinal()){
                count++;
            } else {
                count = 0;
            }
            if(count == connectN)
                return true;
        }

        // check diagonally
        count = 0;
        for(int r = 0; r < this.rows; r++){
            int c = row + col - r; // r + c = row + col for diagonal
            if(c >= 0 && c < this.columns && grid[r][c] == piece.ordinal()){
                count ++;
            } else {
                count = 0;
            }
            if(count == connectN)
                return true;
        }

        // check anti-diagonally
        count = 0;
        for(int r = 0; r < this.rows; r++){
            int c =  col - row + r;
            if(c >= 0 && c < this.columns && grid[r][c] == piece.ordinal()){
                count ++;
            } else {
                count = 0;
            }
            if(count == connectN)
                return true;
        }
        return false;
    }
}
