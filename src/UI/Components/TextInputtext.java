package UI.Components;

import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TextInputtext {

    private final VBox root = new VBox();

//    public TextInputtext(String labelText){
//        hBox.setAlignment(Pos.CENTER);
//        hBox.getChildren().addAll(V1, V2);
//        Label label = new Label();
//        TextField textField = new TextField();
//        label.setText(labelText);
//        V1.getChildren().add(label);
//        V2.getChildren().add(textField);
//    }

    public TextInputtext(){
    }

    public void addRow(String labelText){ //StringProperty
        HBox hBox = new HBox();
        Label label = new Label(labelText);
        label.getStyleClass().add("normalText");
        TextField textField = new TextField();
        hBox.getChildren().add(label);
        hBox.getChildren().add(textField);
        root.getChildren().add(hBox);
//        return textField.textProperty();
    }

    public Node getTextInputtext() {
        return root;
    }

    public void addNewStyle(String Style){
        root.getStyleClass().add(Style);
    }
}
