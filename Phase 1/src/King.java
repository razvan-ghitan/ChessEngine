import java.util.ArrayList;

public class King extends Piece {
    King(Coordonate coord, Color color, Board board) {
        super(coord, color, board);
    }

    King(int row, int colomn, Color color, Board board) {
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
