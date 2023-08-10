package commands;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import tabs.FundementalTab;

public abstract class Command extends FlowPane {
	private static final int BUTTON_SIZE = 25;

	private Button buttonUp = new Button("\u25B2");
	private Button removeButton = new Button("\u2212");
	private Button buttonDown = new Button("\u25BC");
	private HBox controlBox = new HBox();

	private String commandName;
	private Node commandNode;

	{
		this.buttonUp.getStyleClass().add("control-position");
		this.removeButton.getStyleClass().add("control-remove");
		this.buttonDown.getStyleClass().add("control-position");

		this.buttonUp.setPrefSize(BUTTON_SIZE, BUTTON_SIZE);
		this.removeButton.setPrefSize(BUTTON_SIZE, BUTTON_SIZE);
		this.buttonDown.setPrefSize(BUTTON_SIZE, BUTTON_SIZE);

		this.buttonUp.setOnAction(e -> {
			VBox centerPane = FundementalTab.getCenterPane();
			int currentIndex = centerPane.getChildren().indexOf(this);
			if (currentIndex > 0) {
				centerPane.getChildren().remove(this);
				centerPane.getChildren().add(currentIndex - 1, this);
			}
		});
		this.buttonDown.setOnAction(e -> {
			VBox centerPane = FundementalTab.getCenterPane();
			int currentIndex = centerPane.getChildren().indexOf(this);
			if (currentIndex < centerPane.getChildren().size() - 1) {
				centerPane.getChildren().remove(this);
				centerPane.getChildren().add(currentIndex + 1, this);
			}
		});
		this.removeButton.setOnAction(e -> {
			FundementalTab.getCenterPane().getChildren().remove(this);
		});

		controlBox.getChildren().addAll(buttonUp, removeButton, buttonDown);
		this.getChildren().add(controlBox);
		this.getStyleClass().add("command-flow");
	}

	public Command(String commandName) {
		this.commandName = commandName;
	}

	public String getCommandName() {
		return commandName;
	}

	protected void addCommandNode(Node commandNode) {
		this.commandNode = commandNode;
		this.getChildren().add(this.commandNode);
	}

	protected String inQuotes(String inpuString) {
		return "\"" + inpuString + "\"";
	}

	protected String inQuotes(Boolean inputBoolean) {
		return "\"" + inputBoolean.toString() + "\"";
	}

	protected String inQuotes(Integer inputInteger) {
		return "\"" + inputInteger.toString() + "\"";
	}

	protected String formatFileName(String inpuString, String fileName) {
		if (inpuString.endsWith(fileName))
			return inpuString;
		else
			return inpuString + fileName;
	}

	@Override
	public abstract String toString();
}
