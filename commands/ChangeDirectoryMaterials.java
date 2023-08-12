package commands;

import controls.ExpandableList;
import controls.TextFieldFolderPath;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

public class ChangeDirectoryMaterials extends Command {

	private static final String COMMAND_NAME = "$cdmaterials";
	private static final String LABEL_MATERIAL_PATH = "Folder Path";
	private static final String DEFAULT_MATERIAL_PATH = "__folder_path";
	private static final String REFERENCE_FOLDER_PATH = "materials\\";

	private TitledPane titledPane = new TitledPane();
	private VBox vBox = new VBox();
	private ExpandableList<TextFieldFolderPath> expandableList = new ExpandableList<>(
			() -> new TextFieldFolderPath(LABEL_MATERIAL_PATH, DEFAULT_MATERIAL_PATH, REFERENCE_FOLDER_PATH));

	{
		super.addCommandNode(titledPane);
		this.titledPane.setText(COMMAND_NAME);
		this.titledPane.setAnimated(false);
		this.titledPane.setContent(vBox);

		this.vBox.getChildren().addAll(expandableList.getControlNode());
	}

	public ChangeDirectoryMaterials() {
		super(COMMAND_NAME);
	}

	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder(COMMAND_NAME + "\t");

		for (TextFieldFolderPath textField : expandableList.getControls()) {
			sBuilder.append(inQuotes(textField.getText()) + "\t");
		}

		return sBuilder.toString().trim();
	}
}
