# Phase 2

## Compilation steps
Our archive has been created in accordance with the requirements of the task provided by the Algorithm Design's team. Along the source files in `src/`, we created a
Makefile that contains `build`, `run` and `clean` rules. In order to compile the program, it is necesarry to enter in a linux terminal the following command: `make build`. After that, for running the actual program we will use: `xboard -fcp "make run" -debug`.

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
While receiving input from the xboard, we analyse it and then proceed with the specific command on the board. The complexity of these operations is `O(1)`.

In order to make a move (both calculus and sending the command to stdout), we will generate a list of possibles pieces that can be moved by traversal of all the pieces from the current state of the board. These operations depend on the number of pieces on the board, complexity being `O(N)`, where N < 50.

During this phase, we choose randomly the pawn (from the available ones) that will be moved first. This selection takes `O(1)` so it does not influence the overall
complexity of the program

## Bibliography
Some of the sources we used for [creating the Makefile](https://makefiletutorial.com/), [debugging methods/classes](https://docs.oracle.com/en/java/), [better understanding of the xboard](https://www.gnu.org/software/xboard/engine-intf.html)
, [finding out about en passant](https://en.wikipedia.org/wiki/En_passant) and [details about castling](https://en.wikipedia.org/wiki/Castling).
