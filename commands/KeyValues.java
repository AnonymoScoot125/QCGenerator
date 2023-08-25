package commands;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

import controls.BooleanToggle;
import controls.Control;
import controls.ExpandableList;
import controls.IntegerTextField;
import controls.LabeledTextField;
import controls.OptionParameter;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class KeyValues extends Command {
    private static final String COMMAND_NAME = "$keyvalues";

    private TitledPane titledPane = new TitledPane();
    private ExpandableList<OptionParameter> expandableList = new ExpandableList<>(
            () -> new OptionParameter(getOptions()));
    private VBox vBox = new VBox();

    {
        super.addCommandNode(titledPane);
        this.titledPane.setText(COMMAND_NAME);
        this.titledPane.setAnimated(false);
        this.titledPane.setContent(vBox);

        this.vBox.getChildren().addAll(expandableList.getControlNode());
    }

    public KeyValues() {
        super(COMMAND_NAME);
    }

    @Override
    public String toString() {
        return COMMAND_NAME + "\t" + expandableList.toString();
    }

    private Map<String, Supplier<Control>> getOptions() {
        Map<String, Supplier<Control>> map = new LinkedHashMap<>();
        map.put("prop_data", () -> new PropData());
        map.put("physgun_interactions", () -> new PhysgunInteractions());
        map.put("fire_interactions", () -> new FireInteractions());
        map.put("particles", () -> new Particles());

        return map;
    }

    private class PropData extends Control {
        private static final String LABEL_BASE = "Base type";
        private static final String LABEL_HEALTH = "Health";
        private static final int DEFAULT_HEALTH = 0;

        private ExpandableList<OptionParameter> expandableList = new ExpandableList<>(
                () -> new OptionParameter(this.getOptions()));
        private HBox hBox = new HBox(expandableList.getControlNode());

        {
            this.hBox.setAlignment(Pos.CENTER_LEFT);
        }

        @Override
        public Node getControlNode() {
            return hBox;
        }

        @Override
        public String toString() {
            return expandableList.toString();
        }

        private Map<String, Supplier<Control>> getOptions() {
            Map<String, Supplier<Control>> map = new LinkedHashMap<>();
            map.put("base", () -> new LabeledTextField(LABEL_BASE, LABEL_BASE));
            map.put("health", () -> new IntegerTextField(LABEL_HEALTH, DEFAULT_HEALTH));
            map.put("allowstatic", () -> new BooleanToggle(COMMAND_NAME, isCache()));
            map.put("physicsmode", () -> new IntegerTextField(COMMAND_NAME, DEFAULT_HEALTH));
            map.put("blockLOS", () -> new BooleanToggle(COMMAND_NAME, isCache()));
            map.put("AIWalkable", () -> new BooleanToggle(COMMAND_NAME, isCache()));
            map.put("dmg.bullets", () -> null);
            map.put("dmg.club", () -> null);
            map.put("dmg.explosive", () -> null);
            map.put("damage_table", () -> null);
            map.put("explosive_damage", () -> null);
            map.put("explosive_radius", () -> null);
            map.put("breakable_model", () -> null);
            map.put("breakable_count", () -> null);
            map.put("breakable_skin", () -> null);
            map.put("multiplayer_break", () -> null);

            return map;
        }

    }

    private class PhysgunInteractions extends Control {
        private static final String LABEL_BASE = "Base type";
        private static final String LABEL_HEALTH = "Health";
        private static final int DEFAULT_HEALTH = 0;

        private ExpandableList<OptionParameter> expandableList = new ExpandableList<>(
                () -> new OptionParameter(this.getOptions()));
        private HBox hBox = new HBox(expandableList.getControlNode());

        {
            this.hBox.setAlignment(Pos.CENTER_LEFT);
        }

        @Override
        public Node getControlNode() {
            return hBox;
        }

        @Override
        public String toString() {
            return expandableList.toString();
        }

        private Map<String, Supplier<Control>> getOptions() {
            Map<String, Supplier<Control>> map = new LinkedHashMap<>();
            map.put("preferred_carryangles", () -> null);
            map.put("carry_distance_offset", () -> null);
            map.put("onworldimpact", () -> null);
            map.put("onfirstimpact", () -> null);
            map.put("onlaunch", () -> null);
            map.put("onbreak", () -> null);
            map.put("damage", () -> null);
            map.put("allow_overhead", () -> null);
            map.put("onpickup", () -> null);

            return map;
        }

    }

    private class FireInteractions extends Control {
        private static final String LABEL_BASE = "Base type";
        private static final String LABEL_HEALTH = "Health";
        private static final int DEFAULT_HEALTH = 0;

        private ExpandableList<OptionParameter> expandableList = new ExpandableList<>(
                () -> new OptionParameter(this.getOptions()));
        private HBox hBox = new HBox(expandableList.getControlNode());

        {
            this.hBox.setAlignment(Pos.CENTER_LEFT);
        }

        @Override
        public Node getControlNode() {
            return hBox;
        }

        @Override
        public String toString() {
            return expandableList.toString();
        }

        private Map<String, Supplier<Control>> getOptions() {
            Map<String, Supplier<Control>> map = new LinkedHashMap<>();
            map.put("flammable", () -> null);
            map.put("ignite halfhealth", () -> null);
            map.put("explosive_resist", () -> null);

            return map;
        }

    }

    private class Particles extends Control {
        private static final String LABEL_BASE = "Base type";
        private static final String LABEL_HEALTH = "Health";
        private static final int DEFAULT_HEALTH = 0;

        private ExpandableList<ExpandableList<OptionParameter>> expandableList = new ExpandableList<>(
                () -> new ExpandableList<>(() -> new OptionParameter(this.getOptions()), "effect"));
        private HBox hBox = new HBox(expandableList.getControlNode());

        {
            this.hBox.setAlignment(Pos.CENTER_LEFT);
        }

        @Override
        public Node getControlNode() {
            return hBox;
        }

        @Override
        public String toString() {
            return expandableList.toString();
        }

        private Map<String, Supplier<Control>> getOptions() {
            Map<String, Supplier<Control>> map = new LinkedHashMap<>();
            map.put("name", () -> null);
            map.put("attachment_type", () -> null);
            map.put("attachment_point", () -> null);

            return map;
        }

    }

}
