package commands;

import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

public abstract class Command extends FlowPane {
	private String commandName;
	private Label labelName;

	public Command(String commandName) {
		this.commandName = commandName;
		this.labelName = new Label(commandName);
		this.getChildren().add(labelName);
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
