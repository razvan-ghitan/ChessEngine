import java.util.ArrayList;

public class Board {
    boolean castlingShortIsPossible = true;
    boolean castlingLongIsPossible = true;

    Piece[][] board = new Piece[8][8];
    ArrayList<Piece> pieces = new ArrayList<>();

    Board(){
        setFigures();
    }

    void setFigures(){

        addPiece(new Rook(0,0,Color.WHITE,this));
        addPiece(new Rook(0,7,Color.WHITE,this));
        addPiece(new Rook(7,0,Color.BLACK,this));
        addPiece(new Rook(7,7,Color.BLACK,this));

        addPiece(new Knight(0,1,Color.WHITE,this));
        addPiece(new Knight(0,6,Color.WHITE,this));
        addPiece(new Knight(7,1,Color.BLACK,this));
        addPiece(new Knight(7,6,Color.BLACK,this));

        addPiece(new Bishop(0,2,Color.WHITE,this));
        addPiece(new Bishop(0,5,Color.WHITE,this));
        addPiece(new Bishop(7,2,Color.BLACK,this));
        addPiece(new Bishop(7,5,Color.BLACK,this));

        addPiece(new King(0,4,Color.WHITE,this));
        addPiece(new King(7,4,Color.BLACK,this));

        addPiece(new Queen(0,3,Color.WHITE,this));
        addPiece(new Queen(7,3,Color.BLACK,this));

        for (int i = 0; i < 8; i++) {
            for (int c = 0 ; c < 2 ; c++){
                addPiece(new Pawn(c == 0 ? 1 : 6, i, c == 0 ? Color.WHITE : Color.BLACK, this));
            }
        }
    }

    void addPiece(Piece piece){
        board[piece.coord.row][piece.coord.colomn] = piece;
        pieces.add(piece);
    }

    void movePiece(Piece piece, Coordonate toWhere){
        board[piece.coord.row][piece.coord.colomn]=null;
        board[toWhere.row][toWhere.colomn]=piece;
        piece.coord = toWhere;
    }

    void removePiece(Piece piece){
        if (piece == null) return;
        pieces.remove(piece);
        board[piece.coord.row][piece.coord.colomn] = null;
    }

    Piece getPiece(Coordonate coordonate){
        if (!inRange(coordonate)) return null;
        return board[coordonate.row][coordonate.colomn];
    }

    boolean isPieceAt(Coordonate coordonate){
        if (!inRange(coordonate)) return false;
        return !(getPiece(coordonate) == null);
    }

    boolean isPieceAtOfColor(Coordonate coordonate, Color color){
        if (!inRange(coordonate)) return false;
        return (isPieceAt(coordonate) && getPiece(coordonate).color == color);
    }

    boolean inRange(Coordonate coordonate){
        return coordonate.row <= 7 && coordonate.row >= 0 && coordonate.colomn <= 7
                && coordonate.colomn >= 0;
    }

    ArrayList<Coordonate> getAllPossibleMoveList(Color color){
        ArrayList<Coordonate> allPossibleMoveList = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            for (int j = 0 ; j < 8 ; j++){
                if (board[i][j].color == color){
                    allPossibleMoveList.addAll(board[i][j].getPossibleMoves());
                }
            }
        }

        return allPossibleMoveList;
    }

    @Override
    public String toString() {
        String rezult = new String("Board{" +
                "castlingShortIsPossible=" + castlingShortIsPossible +
                ", castlingLongIsPossible=" + castlingLongIsPossible+"\n");

        for (int i = 7 ; i >= 0 ; i--){
            for (int j = 0 ; j < 8 ; j++){
                if (board[i][j] != null)
                    rezult += board[i][j].getClass().getName().substring(0,1) + " ";
                else
                    rezult += "_ ";
            }
            rezult += "\n";
        }

        return rezult;
    }
}
