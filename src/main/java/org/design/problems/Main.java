package org.design.problems;

import org.design.problems.connectfour.Game;
import org.design.problems.connectfour.Grid;
import org.design.problems.connectfour.Player;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Rows for connect four game ");
        int row = input.nextInt();
        System.out.println();
        System.out.print("Enter Columns for connect four game ");
        int col = input.nextInt();
        System.out.println();
        Grid grid = new Grid(row, col);
        Game game = new Game(grid, 4, 2);
        game.play();
    }
}