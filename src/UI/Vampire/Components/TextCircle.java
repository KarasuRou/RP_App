package UI.Vampire.Components;

import UI.Vampire.Components.CircleRow.CircleRow;
import UI.Vampire.Components.CircleRow.PrefilledCircle;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class TextCircle {

    private final VBox root = new VBox();
    private final HBox hBox = new HBox();
    private final VBox V1 = new VBox();
    private final VBox V2 = new VBox();

    public TextCircle(String Ueberschrift){
        Text text = new Text(Ueberschrift);
        text.getStyleClass().add("H2");
        root.getChildren().addAll(text, hBox);
        root.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(V1, V2);
    }

    public CircleRow addRow(String designation, int CircleAmount, PrefilledCircle prefilledCircle){
        Text text = new Text(designation);
        text.getStyleClass().add("normalText");
        V1.getChildren().add(text);
        CircleRow circleRow = new CircleRow(CircleAmount,designation, prefilledCircle);
        V2.getChildren().add(circleRow.getCircleRow());
        return circleRow;
    }

    public Node getTextCircle(){
        return root;
    }

    public void addNewStyle(String Style){
        root.getStyleClass().add(Style);
    }
}
