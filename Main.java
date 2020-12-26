import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.scene.Scene;
import javafx.scene.text.Font;


//Class must extend Application class
public class Main extends Application
{
    public static void main(String[] args)
    {
        //The starting method
        launch(args);
    }

    public void start(Stage primaryStage)
    {
        //Each image must have its corresponding view to display it
        Image piece, logo;
        ImageView pieceView, logoView;

        //Layout for the chess board
        GridPane gridLayout = new GridPane();

        //Scene for the chess board
        Scene board = new Scene(gridLayout, 400, 380);

        //Sets the label for the main menu above the logo
        //and then sets the font to be "Diablo Heavy"
        //Font my not be displayed properly if it's not installed
        Label chess = new Label();
        chess.setText("Chess");
        chess.setFont(new Font("Diablo Heavy", 30));
        StackPane.setMargin(chess, new Insets(0, 10, 300, 0));

        //The logo for the menu
        logo = new Image("assets/icon.png");
        logoView = new ImageView(logo);
        logoView.setFitWidth(290);
        logoView.setFitHeight(193);
        StackPane.setMargin(logoView, new Insets(0 ,0 ,100 ,0));

        //The buttons in the menu
        //The start button goes to the scene of the board (the actual game)
        //and the exit button closes the program
        Button startGame = new Button("Start Game");
        Button exitGame = new Button("Exit Game");
        startGame.setFont(new Font("Diablo Heavy", 16));
        exitGame.setFont(new Font("Diablo Heavy", 14));
        startGame.setTooltip(new Tooltip("Play a game of chess with another player"));
        startGame.setOnAction(e -> primaryStage.setScene(board));
        exitGame.setOnAction(e -> primaryStage.close());

        //Layout for the main menu
        //The stack pane arranges the nodes in a stack so it was the better option
        //The margin for both buttons is set to make them appear below the logo
        StackPane menuLayout = new StackPane();
        StackPane.setMargin(startGame, new Insets(120, 8, 0, 0));
        StackPane.setMargin(exitGame, new Insets(200, 8, 0, 0));
        menuLayout.getChildren().addAll(logoView, startGame, exitGame, chess);
        menuLayout.setAlignment(Pos.CENTER);

        //Scene for the menu
        Scene menu = new Scene(menuLayout, 400, 380);

        Board chessBoard = new Board(gridLayout);

        //The arrays containing the black and white pieces
        //r for rook, n for knight, b for bishop, q for queen, k for king and p for pawn
        char[][] blackPieces = {
                {'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'},
                {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'}
        };

        char[][] whitePieces = {
                {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
                {'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'}
        };

        //These two loop are identical to the loop for making the grid
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                String pieceName = "";

                if (blackPieces[i][j] == 'p') {
                    pieceName = "assets/pawn1.png";
                } else if (blackPieces[i][j] == 'r') {
                    pieceName = "assets/rook1.png";
                } else if (blackPieces[i][j] == 'n') {
                    pieceName = "assets/knight1.png";
                } else if (blackPieces[i][j] == 'b') {
                    pieceName = "assets/bishop1.png";
                } else if (blackPieces[i][j] == 'q') {
                    pieceName = "assets/queen1.png";
                } else if (blackPieces[i][j] == 'k') {
                    pieceName = "assets/king1.png";
                }

                piece = new Image(pieceName);
                pieceView = new ImageView(piece);
                pieceView.setFitWidth(30);
                pieceView.setFitHeight(30);
                gridLayout.add(pieceView, j, i, 1, 1);
                GridPane.setMargin(pieceView, new Insets(0, 0, 0, 6));
            }
        }

        //In order to make the white pieces appear in the bottom two rows,
        //the row index in incremented by 6, while the column index is left as it is
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                String pieceName = "";

                if (whitePieces[i][j] == 'p') {
                    pieceName = "assets/pawn.png";
                } else if (whitePieces[i][j] == 'r') {
                    pieceName = "assets/rook.png";
                } else if (whitePieces[i][j] == 'n') {
                    pieceName = "assets/knight.png";
                } else if (whitePieces[i][j] == 'b') {
                    pieceName = "assets/bishop.png";
                } else if (whitePieces[i][j] == 'q') {
                    pieceName = "assets/queen.png";
                } else if (whitePieces[i][j] == 'k') {
                    pieceName = "assets/king.png";
                }

                piece = new Image(pieceName);
                pieceView = new ImageView(piece);
                pieceView.setFitWidth(30);
                pieceView.setFitHeight(30);
                gridLayout.add(pieceView, j, i+6, 1, 1);
                GridPane.setMargin(pieceView, new Insets(0, 0, 0, 6));
            }
        }

        gridLayout.setAlignment(Pos.TOP_CENTER);

        //The stage's title and icon
        //The stage's default scene is set to the main menu
        primaryStage.setTitle("Chess");
        primaryStage.getIcons().add(new Image("assets/icon.jpg"));
        primaryStage.setScene(menu);
        primaryStage.show();
    }
}