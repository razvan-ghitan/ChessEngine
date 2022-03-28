import java.util.ArrayList;

public class Bishop extends Piece {
    Bishop(Coordonate coord, Color color, Board board) {
        super(coord, color, board);
    }

    Bishop(int row, int colomn, Color color, Board board) {
        super(row, colomn, color, board);
    }

    @Override
    ArrayList<Coordonate> getFieldsUnderAttack() {
        return null;
    }

    @Override
    ArrayList<Coordonate> getPossibleMoves() {
        return null;
    }
}
