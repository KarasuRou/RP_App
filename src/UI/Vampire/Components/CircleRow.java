package UI.Vampire.Components;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CircleRow {

    private final int circleAmount;
    private final String bezeichnung;
    private final Circle[] circleRow;
    private final Color FILLED = Color.RED;
    private final Color UNFILLED = Color.WHITE;
    private final IntegerProperty value = new SimpleIntegerProperty(1);

    public CircleRow(int circleAmount, String bezeichnung) {
        this.circleAmount = circleAmount;
        this.bezeichnung = bezeichnung;
        circleRow = new Circle[this.circleAmount];
        initCircleRow();
    }

    private void initCircleRow(){
        for (int i = 0; i < circleAmount; i++) {
            Circle circle = new Circle();
            circle.setRadius(10);
            circle.setStroke(Color.BLACK);
            circle.setStrokeWidth(1);
            circle.setFill(UNFILLED);
            if (i==0)
                circle.setFill(FILLED);

            int finalI = i;
            circle.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getButton().equals(MouseButton.PRIMARY)){
                        value.setValue(finalI+1);
                        for (int y = 0; y<= finalI; y++){
                            circleRow[y].setFill(FILLED);
                        }
                        for (int y=circleAmount-1;y>finalI;y--){
                            circleRow[y].setFill(UNFILLED);
                        }
                    }
                }
            });
            circleRow[i] = circle;
        }
    }

    public Node getCircleRow() {
        HBox hBox = new HBox();
        hBox.getChildren().addAll(circleRow);
        return hBox;
    }
}
