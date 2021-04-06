package UI.Components;

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

    public void addRow(String designation, int CircleAmount){
        HBox V1 = new HBox();
        TextField textField = new TextField();
        V1.getChildren().add(textField);
        V1.getChildren().add(new CircleRow(CircleAmount,designation).getCircleRow());
        hBox.getChildren().add(V1);
    }

    public Node getInputtextCircle(){
        return root;
    }

    public void addNewStyle(String Style){
        root.getStyleClass().add(Style);
    }
}
