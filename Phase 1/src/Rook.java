import java.util.ArrayList;

public class Rook extends Piece {
    Rook(Coordonate coord, Color color, Board board) {
        super(coord, color, board);
    }

    Rook(int row, int colomn, Color color, Board board) {
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
