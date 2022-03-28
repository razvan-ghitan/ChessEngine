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
  - `Rook`, `Knight`, `Bishop`, `King`, `Queen`: these classes inherit the Piece class too and implements the specific behavior.
  - `Coordonate`: here we define the coordinates.
  - `Move`: here we store informations about a move.
  - `En passant`: here we keep the coordonate of the pawn that can be captured when doing En passant.
  - `Ray`: this class allows the line traversal of the board and calculates the danger of the previous cell (taking into consideration the rest of the pieces).

## Algorithmic approach
În timpul receptionarii comenzilor primite la stdin de la xboard, noi le vom
analiza și vom putea interpreta comanda sau simula mișcarea primită în structura
internă a programului, acest lucru fiind realizat în complexitate O(1).


Pentru a realiza o mișcare (calculul unei mișcării și trimiterea ei la stdout), noi
vom genera lista de piese care pot fi mutate, acest lucru fiind realizat printr-o
parcurgere a unei liste de piese aflate pe tablă, căutare ce se realizează în
complexitate O(n), n fiind numărul de piese de pe tablă.


În implementarea noastră, piesa care urmează a fi mutată este aleasă în mod
aleator dintre piesele disponibile. Această selecție este realizată în O(1), deci nu
influențează complexitatea algoritmului.


Parcurgerea board-ului în implementarea clasei Ray pentru a determina dacă o
piesă se află în șah sau în pericolul de a intra în șah este realizata în O(n), n fiind
dimensiunea tablei.

## Bibliography
Some of the sources we used for [creating the Makefile](https://makefiletutorial.com/), [debugging methods/classes](https://docs.oracle.com/en/java/), [better understanding of the xboard](https://www.gnu.org/software/xboard/engine-intf.html)
, [finding out about en passant](https://en.wikipedia.org/wiki/En_passant) and [details about castling](https://en.wikipedia.org/wiki/Castling).
