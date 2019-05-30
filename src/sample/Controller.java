package sample;     //注意！

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    TextField FileAddressField;
    @FXML
    TextFlow CommandFlow;
    @FXML
    AnchorPane AP;

    private String SelectedImagePath;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void OpenImage() {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "image files: bmp, png, jpg",
                "*.bmp", "*.png", "*.jpg"); // more file extensions can be added

        fileChooser.getExtensionFilters().add(extFilter);

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            ImageView iv = new ImageView(new Image(selectedFile.toURI().toString()));
            iv.setFitWidth(400);
            iv.setFitHeight(250);
            iv.setPreserveRatio(true);
            iv.setSmooth(true);
            iv.setCache(false);

            AP.getChildren().clear();
            AP.getChildren().add(iv);

            SelectedImagePath = selectedFile.getAbsolutePath();

            FileAddressField.setText(SelectedImagePath);
            PutText(SelectedImagePath + " has been opened\n", false, Color.BLACK, "Menlo", 20);
//            CommandFlow.getChildren().add(new Text(SelectedImagePath + " has been opened\n"));
        }
    }

    @FXML
    void RunProccess() {
//        CommandFlow.getChildren().clear(); /* clears CommandFlow (right) */
//        TODO run main program with this method
//        This method is already linked with "RUN" button
//        code in the body of this method will run
//        once button is pressed
        CommandFlow.getChildren().add(new Text("RUN button is pressed\n"));
    }


    //  This method can be used outside (in other files)
    //  to add text to the CommandFlow (right)
    // clearField == true, CommandFlow we'll be cleared
    public void PutText(String text, boolean clearField, Color color, String fontName, int size) {
        if (clearField)
            CommandFlow.getChildren().clear();

        Text caption = new Text(text);
        caption.setFont(Font.font (fontName, size));
        caption.setFill(color);

        CommandFlow.getChildren().add(caption);
    }

    // This method can be used outside (in other files)
    // Returns path to the opened image
    public String getSelectedImagePath() {
        return SelectedImagePath;
    }
}