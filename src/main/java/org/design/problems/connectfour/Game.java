package org.design.problems.connectfour;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class Game {
    private static Scanner input = new Scanner(System.in);
    private Player[] players;
    private int targetScore;
    private int connectN;
    private Grid grid;
    Map<String, Integer> score;
    public Game(Grid grid, int connectN, int targetScore){
        this.grid = grid;
        this.connectN = connectN;
        this.targetScore = targetScore;

        this.players = new Player[2];
        players[0] = new Player("Player 1", GridPosition.YELLOW);
        players[1] = new Player("Player 2", GridPosition.RED);

        this.score = new HashMap<>();
        for(Player player: players){
            this.score.put(player.getName(), 0);
        }
    }
    private void printBoard(){
        System.out.println("Board: ");
        int[][] grid = this.grid.getGrid();
        for(int i = 0; i < grid.length; i++){
            StringBuilder row = new StringBuilder();
            for(int piece: grid[i]){
                if(piece == GridPosition.EMPTY.ordinal()){
                    row.append("0 ");
                } else if(piece == GridPosition.YELLOW.ordinal()){
                    row.append("1 ");
                } else if(piece == GridPosition.RED.ordinal()){
                    row.append("2 ");
                }
            }
            System.out.println(row.toString());
        }
        System.out.println();
    }

    private int[] playMove(Player player){
        printBoard();
        System.out.println(player.getName() + "'s turn");
        int colCount = this.grid.getColumnCount();
        System.out.print("Enter column between 0 and " + (colCount - 1) + " to add piece: ");
        int col = input.nextInt();
        int row = this.grid.placePiece(col, player.getColor());
        return new int[]{row, col};
    }
    private Player playRound(){
        while (true){
            for(Player player: this.players){
                int[] pos = playMove(player);
                int row = pos[0];
                int col = pos[1];
                if(this.grid.checkWin(this.connectN, row, col, player.getColor())){
                    this.score.put(player.getName(), this.score.get(player.getName()) + 1);
                    return player;
                }
            }
        }
    }
    public void play() {
        System.out.println("Play game");
        int maxScore = 0;
        Player winner = null;
        while (maxScore < this.targetScore) {
            winner = playRound();
            System.out.println(winner.getName() + " won the round \n");
            maxScore = Math.max(this.score.get(winner.getName()), maxScore);

            this.grid.initGrid(); // reset grid
        }
        System.out.println(winner.getName() + " has won the game with maxScore " + maxScore);
    }
}










