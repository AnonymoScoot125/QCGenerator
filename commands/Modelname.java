package commands;

import controls.TextFieldFolderPath;
import javafx.scene.control.TitledPane;

public class Modelname extends Command {

    private static final String COMMAND_NAME = "$modelname";
    private static final String LABEL_NAME = "Model name";
    private static final String FOLDER_NAME = "models\\";
    private static final String DEFAULT_VALUE = "__default.mdl";
    private static final String FILE_EXTENSION_NAME = ".mdl";

    private TitledPane titledPane = new TitledPane();
    private TextFieldFolderPath filePath = new TextFieldFolderPath(LABEL_NAME, DEFAULT_VALUE, FOLDER_NAME,
            FILE_EXTENSION_NAME);

    {
        super.addCommandNode(titledPane);
        this.titledPane.setAnimated(false);
        this.titledPane.setText(COMMAND_NAME);
        this.titledPane.setContent(filePath.getControlNode());
    }

    public Modelname() {
        super(COMMAND_NAME);
    }

    @Override
    public String toString() {
        return COMMAND_NAME + "\t" + filePath.getText();
    }

}
