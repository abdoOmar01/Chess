import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class Board
{
    Tile[][] grid = new Tile[8][8];

    public Board(GridPane layout)
    {
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                grid[i][j] = new Tile(i, j);

                if ((i + j) % 2 == 0)
                {
                    grid[i][j].setTileImage("assets/whiteTile.jpg");
                }
                else
                {
                    grid[i][j].setTileImage("assets/brownTile.jpg");
                }

                grid[i][j].setPiece(null);
                grid[i][j].setTileImageView(grid[i][j].getTileImage());
                layout.add(grid[i][j].getTileImageView(), j, i, 1, 1);
            }
        }

        char[][] blackPieces = {
                {'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'},
                {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'}
        };

        char[][] whitePieces = {
                {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
                {'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'}
        };

        Piece piece;

        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if (blackPieces[i][j] == 'r')
                {
                    piece = new Rook(i, j, "Black", this);
                    piece.setPieceImage("assets/rook1.png");
                }
                else if (blackPieces[i][j] == 'n')
                {
                    piece = new Knight(i, j, "Black", this);
                    piece.setPieceImage("assets/king1.png");
                }
                else if (blackPieces[i][j] == 'b')
                {
                    piece = new Bishop(i, j, "Black", this);
                    piece.setPieceImage("assets/bishop1.png");
                }
                else if (blackPieces[i][j] == 'q')
                {
                    piece = new Queen(i, j, "Black", this);
                    piece.setPieceImage("assets/queen1.png");
                }
                else if (blackPieces[i][j] == 'k')
                {
                    piece = new King(i, j, "Black", this);
                    piece.setPieceImage("assets/king1.png");
                }
                else
                {
                    piece = new Pawn(i, j, "Black", this);
                    piece.setPieceImage("assets/pawn1.png");
                }

                grid[i][j].setPiece(piece);
                piece.setPieceImageView(piece.getPieceImage());
                GridPane.setMargin(piece.getPieceImageView(), new Insets(0, 0, 0, 6));
                layout.add(piece.getPieceImageView(), j, i, 1, 1);
            }
        }

        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if (whitePieces[i][j] == 'r')
                {
                    piece = new Rook(i + 6, j, "White", this);
                    piece.setPieceImage("assets/rook.png");
                }
                else if (whitePieces[i][j] == 'n')
                {
                    piece = new Knight(i + 6, j, "White", this);
                    piece.setPieceImage("assets/knight.png");
                }
                else if (whitePieces[i][j] == 'b')
                {
                    piece = new Bishop(i + 6, j, "White", this);
                    piece.setPieceImage("assets/bishop.png");
                }
                else if (whitePieces[i][j] == 'q')
                {
                    piece = new Queen(i + 6, j, "White", this);
                    piece.setPieceImage("assets/queen.png");
                }
                else if (whitePieces[i][j] == 'k')
                {
                    piece = new King(i + 6, j, "White", this);
                    piece.setPieceImage("assets/king.png");
                }
                else
                {
                    piece = new Pawn(i + 6, j, "White", this);
                    piece.setPieceImage("assets/pawn.png");
                }

                grid[i+6][j].setPiece(piece);
                piece.setPieceImageView(piece.getPieceImage());
                GridPane.setMargin(piece.getPieceImageView(), new Insets(0, 0, 0, 6));
                layout.add(piece.getPieceImageView(), j, i + 6, 1, 1);
            }
        }
    }
}
