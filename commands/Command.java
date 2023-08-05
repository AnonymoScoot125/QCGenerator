package commands;

public abstract class Command {
	private String commandName;

	public Command(String commandName) {
		this.commandName = commandName;
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
