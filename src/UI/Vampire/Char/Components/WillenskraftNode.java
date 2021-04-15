package UI.Vampire.Char.Components;

import UI.Vampire.Components.CircleRow.CircleRow;
import UI.Vampire.Components.CircleRow.PrefilledCircle;
import UI.Vampire.Components.RectangleRow;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class WillenskraftNode {

    private final VBox root = new VBox();
    private final static CircleRow cR = new CircleRow(10,"Willenskraft", PrefilledCircle.ZERO);
    private final static RectangleRow rR = new RectangleRow(10,"Willenskraft",false,1);

    public WillenskraftNode(){
        root.setAlignment(Pos.CENTER);
        Label label = new Label("Willenskraft");
        label.getStyleClass().add("H2");
        root.getChildren().addAll(label, cR.getCircleRow(), rR.getRectangleBox());
    }

    public Node getWillenskraftNode(){
        return root;
    }

    public void setWillenskraft(int willenskraft, int willenskraftPool) { //TODO
    }
}
