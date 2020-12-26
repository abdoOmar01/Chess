import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;

public class AlertBox
{
    public static void display(String scene, Stage primaryStage, Scene menu)
    {
        Stage alert = new Stage();
        Label message = new Label();
        Button button1 = new Button();
        Button button2 = new Button();
        StackPane alertLayout = new StackPane();

        message.setFont(new Font("Diablo Heavy", 16));
        button1.setFont(new Font("Diablo Heavy", 14));
        button2.setFont(new Font("Diablo Heavy", 14));

        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setTitle("Confirmation");
        alert.setWidth(500);
        alert.setHeight(150);

        if (scene.equals("menu"))
        {
            message.setText("Are you sure you want to exit?");
            button1.setText("Yes");
            button2.setText("No");

            StackPane.setMargin(message, new Insets(0, 0, 60, 0));
            StackPane.setMargin(button1, new Insets(0, 90, 0, 0));
            StackPane.setMargin(button2, new Insets(0, 0, 0, 80));

            button1.setOnAction(e ->
            {
                alert.close();
                primaryStage.close();
            });
            button2.setOnAction(e -> alert.close());
        }
        else if (scene.equals("board"))
        {
            message.setText("Are you sure you want to exit the match?");
            button1.setText("Resume Match");
            button2.setText("Return to Menu");

            StackPane.setMargin(message, new Insets(0, 0, 60, 0));
            StackPane.setMargin(button1, new Insets(0, 180, 0, 0));
            StackPane.setMargin(button2, new Insets(0, 0, 0, 160));

            button1.setOnAction(e -> alert.close());
            button2.setOnAction(e ->
            {
                alert.close();
                primaryStage.setScene(menu);
            });
        }

        alertLayout.getChildren().addAll(message, button1, button2);

        Scene alertScene = new Scene(alertLayout);
        alert.getIcons().add(new Image("assets/icon.jpg"));
        alert.setScene(alertScene);
        alert.showAndWait();
    }
}
