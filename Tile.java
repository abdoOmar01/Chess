public class Tile
{
    private Piece piece;
    private String color;
    private int x;
    private int y;

    public Tile(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void setPiece(Piece piece)
    {
        this.piece = piece;
    }

    public Piece getPiece()
    {
        return piece;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }
}
