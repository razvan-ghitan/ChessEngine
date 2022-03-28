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

    static void makeMove(Move move){
        makeMove(move.from, move.to, move.promotion);
    }

    static void makeMove(Coordonate fromWhere, Coordonate toWhere){
        makeMove(fromWhere, toWhere, null);
    }

    static void makeMove(Coordonate fromWhere, Coordonate toWhere, Character promotion){
        Piece movingPiece = board.getPiece(fromWhere);
        if (movingPiece == null) return;
        movingPiece.makeMove(toWhere);

        if (promotion != null){
            switch (promotion){
                case 'q' : board.replacePiece(toWhere, new Queen(toWhere, movingColor, board)); break;
                case 'r' : board.replacePiece(toWhere, new Rook(toWhere, movingColor, board)); break;
                case 'b' : board.replacePiece(toWhere, new Bishop(toWhere, movingColor, board)); break;
                case 'n' : board.replacePiece(toWhere, new Knight(toWhere, movingColor, board)); break;
            }
        }

        movingColor = movingColor == Color.WHITE ? Color.BLACK : Color.WHITE;
        moveCounter++;
    }

    static void drawCurrentState(){
        System.out.println("Move nr."+moveCounter);
        if (board != null) System.out.println(board);
    }

    static void generateMove(){
        ArrayList<Move> possibleMoves = board.getAllPossibleMoveList(movingColor);

        System.out.println("Possible moves:" + possibleMoves);

        if (possibleMoves == null || possibleMoves.size() == 0){
            System.out.println("resign");
            return;
        }

        for(Move move : possibleMoves){
            if (board.getPiece(move.from) instanceof King && Math.abs(move.to.colomn - move.from.colomn) > 1 ){
                makeMove(move);
                System.out.println(move);
                return;
            }
        }

        Random random = new Random();

        Move chosen = possibleMoves.get(random.nextInt(possibleMoves.size()));
        makeMove(chosen);
        System.out.println(chosen);
    }
}
