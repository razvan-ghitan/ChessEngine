import java.util.ArrayList;
import java.util.Random;

public class Logic {
    static Board board;
    static int moveCounter;
    static Color movingColor;
    static Color myColor;

    static void init(){
        board = new Board();
        movingColor = Color.WHITE;
        myColor = Color.BLACK;
        moveCounter = 0;
    }

    static void makeMove(Coordonate fromWhere, Coordonate toWhere){
        Piece movingPiece = board.getPiece(fromWhere);
        if (movingPiece == null) return;
        movingPiece.makeMove(toWhere);

        movingColor = movingColor == Color.WHITE ? Color.BLACK : Color.WHITE;
        moveCounter++;
    }

    static void drawCurrentState(){
        System.out.println("Move nr."+moveCounter);
        if (board != null) System.out.println(board);
    }

    static void generateMove(){
        ArrayList<Piece> possiblePieces = new ArrayList<>();

        for (Piece piece : board.pieces) {
            if (piece.color == myColor && piece.getPossibleMoves()!=null
                    && !piece.getPossibleMoves().isEmpty()){
                possiblePieces.add(piece);
            }
        }

        if (possiblePieces.isEmpty()){
            System.out.println("resign");
            return;
        }

        Random random = new Random();

        Piece pieceToMove = possiblePieces.get(random.nextInt(possiblePieces.size()));
        Coordonate coordonateToMove = pieceToMove.getPossibleMoves()
                .get(random.nextInt(pieceToMove.getPossibleMoves().size()));

        if (coordonateToMove.row == 0 || coordonateToMove.row == 7)
            System.out.println("move "+pieceToMove.coord+""+coordonateToMove+"q");
        else
            System.out.println("move "+pieceToMove.coord+""+coordonateToMove);
        makeMove(pieceToMove.coord,coordonateToMove);
    }
}
