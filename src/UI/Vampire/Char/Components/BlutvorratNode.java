package UI.Vampire.Char.Components;

import UI.Vampire.Components.RectangleRow;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class BlutvorratNode {

    private final VBox root = new VBox();
    private final static RectangleRow rR = new RectangleRow(20, "Blutvorrat", false, 2);

    public BlutvorratNode(){
        root.setAlignment(Pos.CENTER);
        Label label = new Label("Blutvorrat");
        label.getStyleClass().add("H2");
        root.getChildren().addAll(label, rR.getRectangleBox());
    }

    public Node getBlutvorratNode(){
        return root;

    }

    public void setBlutvorrat(int blutvorrat) {
        rR.getValue().setValue(blutvorrat);
    }
}
