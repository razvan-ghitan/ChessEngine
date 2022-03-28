# Phase 1

## Compilation steps
Our archive has been created in accordance with the requirements of the task provided by the Algorithm Design's team. Along the source files in `src/`, we created a
Makefile that contains `build`, `run` and `clean` rules. In order to compile the program, it is necesarry to enter in a linux terminal the following command: `make build`.
After that, for running the actual program we will use: `xboard -fcp "make run" -debug`.

## Details
Our approach includes the following classes inside the program:
  - `Main`: here we read and process input from xboard commands.
  - `Logic`: here we keep general information about the status of the game, such as number of moves, color of the moving player.
  - `Board`: for internal representation of the board.
  - `Piece`: abstract class representing a piece.
  - `Pawn`: one of the classes that inherits the Piece class and implements the specific behavior.
  - `Rook`, `Knight`, `Bishop`, `King`, `Queen`: these classes inherit the Piece class too and exist only for defining the board.
  - `Coordonate`: here we define the coordinates.

## Algorithmic approach

## Bibliography

## Technologies used
  - At the begining of the project, we were asked to choose between `C++` and `Java` as our desired language. The result was, of course, the one we managed to get a taste of during our freshman year and worked until that moment. The winner between these two was `Java`.
  - During the implementation, we encountered some of the most important features of chess engines, such as `m-WAY Search Trees` and `Alpha-Beta Pruning`.

## Details
The homework was divided into 3 stages of sprint implementation and at the end there was a contest between all of our bots and also against a very capable one, implemented by the team of Algorithm Design, using AI. Ours did pretty well, scoring 1.15/2 overall.

This is our project, with details about every stage's implementation:
  - `Phase 1/`: Getting used to XBoard platform whilist analysing the input from the engine and correctly moving a pawn across the board.
  - `Phase 2/`: Implementing all legal moves for every piece, alongside the 3 Check rule, En Passant, Mate and Stalemate.
  - `Phase 3/`: Choosing an advanced algorithm to increase the quality of the moves and implementing the specific heuristics.

You can find more information about the task [here](https://ocw.cs.pub.ro/courses/pa/regulament-proiect-2021).
