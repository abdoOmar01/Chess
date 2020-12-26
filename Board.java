import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Board
{
    public Tile[][] grid = new Tile[8][8];

    public Board(GridPane layout)
    {
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                grid[i][j] = new Tile(i, j);

                if ((i + j) % 2 == 0)
                {
                    grid[i][j].setColor("assets/brownTile.jpg");
                }
                else
                {
                    grid[i][j].setColor("assets/whiteTile.jpg");
                }

                Image tile = new Image(grid[i][j].getColor());
                ImageView tileView = new ImageView(tile);
                tileView.setFitWidth(42);
                tileView.setFitHeight(42);
                layout.add(tileView, j, i, 1,1);
            }
        }
    }
}
