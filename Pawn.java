import javafx.scene.layout.GridPane;

public class Pawn extends Piece
{
    private boolean isFirstMove;

    public Pawn(int x, int y, String color, Board board)
    {
        super(x, y, color, board);
        isFirstMove = true;
    }

    @Override
    public void setMovableTiles()
    {
        if (movableTiles != null)
        {
            movableTiles.clear();
        }

        if (color.equals("White"))
        {
            if (x >= 1)
            {
                if (board.grid[x - 1][y].getPiece() == null)
                {
                    movableTiles.add(board.grid[x - 1][y]);

                    if (isFirstMove && board.grid[x - 2][y].getPiece() == null)
                    {
                        movableTiles.add(board.grid[x - 2][y]);
                    }
                }

                if (y <= 6 && board.grid[x - 1][y + 1].getPiece() != null &&
                        board.grid[x - 1][y + 1].getPiece().color.equals("Black"))
                {
                    movableTiles.add(board.grid[x - 1][y + 1]);
                }

                if (y >= 1 && board.grid[x - 1][y - 1].getPiece() != null &&
                        board.grid[x - 1][y - 1].getPiece().color.equals("Black"))
                {
                    movableTiles.add(board.grid[x - 1][y + 1]);
                }
            }
        }

        else
        {
            if (x <= 6)
            {
                if (board.grid[x + 1][y].getPiece() == null)
                {
                    movableTiles.add(board.grid[x + 1][y]);

                    if (isFirstMove && board.grid[x + 2][y].getPiece() == null)
                    {
                        movableTiles.add(board.grid[x + 2][y]);
                    }
                }

                if (y <= 6 && board.grid[x + 1][y + 1].getPiece() != null &&
                        board.grid[x + 1][y + 1].getPiece().color.equals("White"))
                {
                    movableTiles.add(board.grid[x + 1][y + 1]);
                }

                if (y >= 1 && board.grid[x + 1][y - 1].getPiece() != null &&
                        board.grid[x + 1][y - 1].getPiece().color.equals("White"))
                {
                    movableTiles.add(board.grid[x + 1][y - 1]);
                }
            }
        }
    }
}
