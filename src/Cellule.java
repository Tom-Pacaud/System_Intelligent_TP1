public class Cellule {

    private int x;
    private int y;

    private char typeOccupation; //libre, reine, menacee par une reine

    public Cellule (int x, int y, char typeOccupation) {
        this.x = x;
        this.y = y;
        this.typeOccupation = typeOccupation;

    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setTypeOccupation(char typeOccupation) {
        this.typeOccupation = typeOccupation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getTypeOccupation() {
        return typeOccupation;
    }
}
