package UI.Vampire.Components;

import UI.Vampire.Components.CircleRow.CircleRow;
import UI.Vampire.Components.CircleRow.PrefilledCircle;
import javafx.beans.property.Property;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class InputtextCircle {

    private final VBox root = new VBox();
    private final VBox hBox = new VBox();

    public InputtextCircle(String Ueberschrift){
        Text text = new Text(Ueberschrift);
        text.getStyleClass().add("H2");
        root.getChildren().addAll(text, hBox);
        root.setAlignment(Pos.CENTER);
    }

    public Property[] addRow(String designation, int CircleAmount, PrefilledCircle prefilledCircle){
        HBox V1 = new HBox();
        TextField textField = new TextField();
        CircleRow circleRow = new CircleRow(CircleAmount,designation,prefilledCircle);
        V1.getChildren().add(textField);
        V1.getChildren().add(circleRow.getCircleRow());
        hBox.getChildren().add(V1);

        Property[] properties = new Property[2];
        properties[0] = circleRow.getValue();
        properties[1] = textField.textProperty();
        return properties;
    }

    public Node getInputtextCircle(){
        return root;
    }

    public void addNewStyle(String Style){
        root.getStyleClass().add(Style);
    }
}
