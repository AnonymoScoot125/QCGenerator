package commands;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import tabs.FundementalTab;

public abstract class Command extends FlowPane {
	private static final int BUTTON_SIZE = 25;

	private String commandName;
	private Label labelName;
	private static int nums = 0;

	public Command(String commandName) {
		this.commandName = commandName;

		HBox handlingBox = new HBox();

		Button buttonUp = new Button("\u25B2");
		Button removeButton = new Button("\u2212");
		Button buttonDown = new Button("\u25BC");
		buttonUp.getStyleClass().add("control-position");
		removeButton.getStyleClass().add("control-remove");
		buttonDown.getStyleClass().add("control-position");
		buttonUp.setPrefSize(BUTTON_SIZE, BUTTON_SIZE);
		removeButton.setPrefSize(BUTTON_SIZE, BUTTON_SIZE);
		buttonDown.setPrefSize(BUTTON_SIZE, BUTTON_SIZE);

		handlingBox.getChildren().addAll(buttonUp, removeButton, buttonDown);

		TitledPane titledPane = new TitledPane(commandName, new Label("commandName"));
		titledPane.setAnimated(false);

		this.getChildren().addAll(handlingBox, titledPane);

		buttonUp.setOnAction(e -> {
			VBox centerPane = FundementalTab.getCenterPane();
			int currentIndex = centerPane.getChildren().indexOf(this);
			if (currentIndex > 0) {
				centerPane.getChildren().remove(this);
				centerPane.getChildren().add(currentIndex - 1, this);
			}
		});
		buttonDown.setOnAction(e -> {
			VBox centerPane = FundementalTab.getCenterPane();
			int currentIndex = centerPane.getChildren().indexOf(this);
			if (currentIndex < centerPane.getChildren().size() - 1) {
				centerPane.getChildren().remove(this);
				centerPane.getChildren().add(currentIndex + 1, this);
			}
		});
		removeButton.setOnAction(e -> {
			FundementalTab.getCenterPane().getChildren().remove(this);
		});

		this.getStyleClass().add("command-flow");
	}

	public String getCommandName() {
		return commandName;
	}

	public String getStringRepresentation() {
		StringBuilder sb = new StringBuilder();

		sb.append("$" + commandName + "\t");
		sb.append(toString());

		return sb.toString();
	}

	@Override
	public abstract String toString();
}
