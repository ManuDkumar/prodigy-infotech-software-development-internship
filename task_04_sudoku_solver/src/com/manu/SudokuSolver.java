package com.manu;

public class SudokuSolver {

    private static final int SIZE = 9;

    public static void main(String[] args) {

        int[][] board = {
                {5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9}
        };
        
        if (solveSudoku(board)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
    }

    // Backtracking solver
    public static boolean solveSudoku(int[][] board) {

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {

                if (board[row][col] == 0) {

                    for (int num = 1; num <= 9; num++) {

                        if (isValid(board, row, col, num)) {

                            board[row][col] = num;

                            if (solveSudoku(board)) {
                                return true;
                            }

                            board[row][col] = 0; // backtrack
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    // Check if number placement is valid
    public static boolean isValid(int[][] board, int row, int col, int num) {

        for (int i = 0; i < SIZE; i++) {

            if (board[row][i] == num) return false;
            if (board[i][col] == num) return false;

            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;

            if (board[boxRow][boxCol] == num) return false;
        }

        return true;
    }

    // Print Sudoku grid
    public static void printBoard(int[][] board) {

        System.out.println("Solved Sudoku:");

        for (int row = 0; row < SIZE; row++) {

            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col] + " ");
            }

            System.out.println();
        }
    }
}