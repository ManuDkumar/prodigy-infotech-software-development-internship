# Sudoku Solver

## Overview

A console-based Java program that automatically solves a Sudoku puzzle using a backtracking algorithm.
The program takes an unsolved Sudoku grid (with empty cells represented as 0) and fills in the missing numbers while ensuring all Sudoku rules are satisfied.


## Features

- Automatically solves a 9x9 Sudoku puzzle

- Uses the backtracking algorithm

- Ensures valid placement according to Sudoku rules

- Displays the completed Sudoku grid


## Algorithm Used

The program uses a backtracking approach:

1. Find an empty cell in the grid.

2. Try placing numbers from 1 to 9.

3. Check if the number is valid:

    &nbsp; - Not already present in the same row 

    &nbsp; - Not already present in the same column 

    &nbsp; - Not already present in the 3x3 subgrid 

4. If valid, place the number and continue recursively.

5. If no valid number works, backtrack and try a different number.


## Concepts Demonstrated

- Recursion

- Backtracking algorithms

- 2D arrays

- Constraint validation

- Algorithmic problem solving


## How to Run

1. Open the project in Eclipse / STS.

2. Run SudokuSolver.java.

3. The program will solve the predefined Sudoku puzzle and display the completed grid.


## Author: 
Manu Kumar H N

## Year: 
2026
