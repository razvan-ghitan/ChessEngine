import java.util.ArrayList;

public class Pawn extends Piece {
    Pawn(Coordonate coord, Color color, Board board) {
        super(coord, color, board);
    }

    Pawn(int row, int colomn, Color color, Board board) {
        super(row, colomn, color, board);
    }

    @Override
    ArrayList<Coordonate> getFieldsUnderAttack() {
        return null;
    }

    @Override
    ArrayList<Coordonate> getPossibleMoves() {
        ArrayList<Coordonate> possibleMoves = new ArrayList<>();

        Color enemyColor = color == Color.WHITE ? Color.BLACK : Color.WHITE;
        int koef = color == Color.WHITE ? 1 : -1;

        //moving forwards or double forwards
        if (!board.isPieceAt(coord.getOffset(koef,0))) {
            possibleMoves.add(coord.getOffset(koef, 0));

            if (coord.row == (color == Color.WHITE ? 1 : 6)
                    && !board.isPieceAt(coord.getOffset(koef*2, 0))){
                possibleMoves.add(coord.getOffset(koef*2, 0));
            }
        }

        //Capturing pieces
        if (board.isPieceAtOfColor(coord.getOffset(koef,1),enemyColor))
            possibleMoves.add(coord.getOffset(koef,1));

        if (board.isPieceAtOfColor(coord.getOffset(koef,-1),enemyColor))
            possibleMoves.add(coord.getOffset(koef,-1));

        ArrayList<Coordonate> toDeletion = new ArrayList<>();
        for (Coordonate cord: possibleMoves) {
            if (!board.inRange(cord)) toDeletion.add(cord);
        }
        possibleMoves.removeAll(toDeletion);
        return possibleMoves;
    }
}
