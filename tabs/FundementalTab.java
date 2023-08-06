package tabs;

import java.util.function.Supplier;

import commands.Modelname;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class FundementalTab extends BorderPane {
	private static BorderPane borderPane = new BorderPane();
	private static FlowPane topPane = new FlowPane(new Label("Fundemental things"));
	private static VBox leftPane = new VBox(1, createButtons());
	private static ScrollPane leftScrollPane = new ScrollPane(leftPane);
	private static VBox centerPane = new VBox(5);
	private static ScrollPane centerScrollPane = new ScrollPane(centerPane);

	static {
		borderPane.getStyleClass().add("border");

		leftScrollPane.hbarPolicyProperty().setValue(ScrollBarPolicy.NEVER);

		topPane.getStyleClass().add("pane");
		leftPane.getStyleClass().add("pane");
		centerPane.getStyleClass().add("pane");

		leftPane.setPrefWidth(200);

		borderPane.setTop(topPane);
		borderPane.setLeft(leftScrollPane);
		borderPane.setCenter(centerScrollPane);
	}

	private static Label createCommandButton(String name, Supplier<Node> classConstructor) {
		Label button = new Label(name);
		button.getStyleClass().add("labeled");
		button.setOnMouseClicked(e -> {
			try {
				Node node = classConstructor.get();
				centerPane.getChildren().add(node);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		return button;
	}

	private static Label[] createButtons() {
		return new Label[] {
				createCommandButton("$modelname", Modelname::new),

		};
	}

	public static BorderPane getBorderPane() {
		return borderPane;
	}
}