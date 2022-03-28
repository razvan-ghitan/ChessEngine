public class Coordonate {
    int row,colomn;

    Coordonate(int row, int colomn){
        this.row = row;
        this.colomn = colomn;
    }

    Coordonate(String coordonate){
        this.row = (int)((coordonate.charAt(1)) - '0' - 1);
        this.colomn = (int)((coordonate.charAt(0)) - 'a');
    }

    Coordonate getOffset(int row, int colomn){
        return new Coordonate(this.row + row, this.colomn + colomn);
    }

    @Override
    public String toString() {
        return ((char)(colomn+'a'))+(Integer.toString(row+1));
    }
}
