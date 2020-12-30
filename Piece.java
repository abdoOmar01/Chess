import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public abstract class Piece
{
    protected int x;
    protected int y;
    protected final String color;
    protected Image pieceImage;
    protected ImageView pieceImageView;
    protected ArrayList<Tile> movableTiles = new ArrayList<Tile>();
    protected final Board board;

    public abstract void setMovableTiles();

    public Piece(int x, int y, String color, Board board)
    {
        this.x = x;
        this.y = y;
        this.color = color;
        this.board = board;

        setMovableTiles();
    }

    public void move(Tile tile)
    {
        x = tile.getX();
        y = tile.getY();
        GridPane.setRowIndex(pieceImageView, x);
        GridPane.setColumnIndex(pieceImageView, y);

        setMovableTiles();
    }

    public void setPieceImage(String url)
    {
        pieceImage = new Image(url);
    }

    public Image getPieceImage()
    {
        return pieceImage;
    }

    public void setPieceImageView(Image pieceImage)
    {
        pieceImageView = new ImageView(pieceImage);
        pieceImageView.setFitWidth(30);
        pieceImageView.setFitHeight(30);

        pieceImageView.setOnDragDetected(e ->
        {
            Dragboard db = pieceImageView.startDragAndDrop(TransferMode.ANY);

            ClipboardContent content = new ClipboardContent();
            content.putImage(pieceImage);

            db.setContent(content);

            e.consume();

        });
    }

    public ImageView getPieceImageView()
    {
        return pieceImageView;
    }

    public ArrayList<Tile> getMovableTiles()
    {
        return movableTiles;
    }

    public String getColor()
    {
        return color;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getX()
    {
        return x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getY()
    {
        return y;
    }
}
