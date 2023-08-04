package commands;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Parameter;
import Value;

public class Command {
	private String commandName;
	private ArrayList<Parameter> parameterList = new ArrayList<>();

	public Command(String command) {
		String line;
		try (BufferedReader reader = new BufferedReader(new FileReader("commands.txt"))) {
			while ((line = reader.readLine()) != null) {
				String[] words = line.split("\\s+");

				if (!command.equals(words[0]))
					continue;
				commandName = words[0];
				for (int i = 1; i < words.length; i++) {
					parameterList.add(getParameter(words[i]));
				}
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Parameter getParameter(String input) {
		switch (input) {
			case "String":
				return new Value<String>();
			default:
				return null;
		}
	}

	// public Command(String commandName) {
	// this(commandName, "_invalidParameter_");
	// }

	// public Command(String commandName, String parameterName) {
	// this.commandName = commandName;
	// this.parameterName = parameterName;
	// }

	public String getCommandName() {
		return commandName;
	}

	// public String getParameterName() {
	// return parameterName;
	// }

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("$" + this.commandName + "\t");

		for (Parameter parameter : parameterList) {
			stringBuilder.append(parameter.toString());
		}
		return stringBuilder.toString();
	}
}
