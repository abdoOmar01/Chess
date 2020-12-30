import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Tile
{
    private final int x;
    private final int y;
    private Image tileImage;
    private ImageView tileImageView;
    private Piece piece;

    public Tile(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void setTileImage(String url)
    {
        tileImage = new Image(url);
    }

    public Image getTileImage()
    {
        return tileImage;
    }

    public void setTileImageView(Image tileImage)
    {
        tileImageView = new ImageView(tileImage);
        tileImageView.setFitHeight(42);
        tileImageView.setFitWidth(42);
    }

    public ImageView getTileImageView()
    {
        return  tileImageView;
    }

    public void setPiece(Piece piece)
    {
        this.piece = piece;
    }

    public Piece getPiece()
    {
        return piece;
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
