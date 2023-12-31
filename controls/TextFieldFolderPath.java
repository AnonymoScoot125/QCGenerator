package controls;

import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import tabs.Main;

public class TextFieldFolderPath extends Control {
    private String defaultValue;
    private String referenceFolder;
    private String fileExtensionName;
    private Label label = new Label();
    private TextField textField = new TextField();
    private DirectoryChooser directoryChooser = new DirectoryChooser();
    private Button fileButton = new Button();
    private HBox hBox = new HBox(label, textField, fileButton);

    {
        this.hBox.setAlignment(Pos.CENTER_LEFT);
        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("/resources/folder.png")));
        imageView.setFitWidth(15);
        imageView.setFitHeight(15);
        this.fileButton.setGraphic(imageView);
        this.fileButton.setOnAction(e -> {
            File selectedDirectory = directoryChooser.showDialog(Main.getStage());
            if (selectedDirectory != null) {
                if (referenceFolder != null && selectedDirectory.getAbsolutePath().indexOf(referenceFolder) != -1) {
                    String leftover = selectedDirectory.getAbsolutePath()
                            .substring(selectedDirectory.getAbsolutePath().indexOf(referenceFolder)
                                    + referenceFolder.length());
                    textField.setText(leftover + "\\");

                } else {
                    textField.setText(selectedDirectory.getAbsolutePath() + "\\");
                }
            }
        });
    }

    public TextFieldFolderPath(String text, String defaultValue) {
        this(text, defaultValue, "");
    }

    public TextFieldFolderPath(String text, String defaultValue, String referenceFolder) {
        this(text, defaultValue, referenceFolder, "");
    }

    public TextFieldFolderPath(String text, String defaultValue, String referenceFolder, String fileExtensionName) {
        this.label.setText(text);
        this.defaultValue = defaultValue;
        this.referenceFolder = referenceFolder;
        this.fileExtensionName = fileExtensionName;
    }

    public String getText() {
        return textField.getText().isEmpty() ? inQuotes(formatFileName(defaultValue, fileExtensionName))
                : inQuotes(formatFileName(textField.getText(), fileExtensionName));
    }

    @Override
    public Node getControlNode() {
        return hBox;
    }

    @Override
    public String toString() {
        return getText();
    }

}
