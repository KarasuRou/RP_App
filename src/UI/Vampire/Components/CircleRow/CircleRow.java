package UI.Vampire.Components.CircleRow;

import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    private final IntegerProperty value = new SimpleIntegerProperty(0);

    public CircleRow(int circleAmount, String bezeichnung, PrefilledCircle prefilledCircle) {
        this.circleAmount = circleAmount;
        this.bezeichnung = bezeichnung;
        circleRow = new Circle[this.circleAmount];
        initCircleRow(prefilledCircle);
        value.setValue(setValue(prefilledCircle));
        value.addListener((observable, oldValue, newValue) -> {
            int neuerValue = newValue.intValue() - 1;
            for (int y = 0; y<= neuerValue; y++){
                circleRow[y].setFill(FILLED);
            }
            for (int y=circleAmount-1;y>neuerValue;y--){
                circleRow[y].setFill(UNFILLED);
            }});
    }

    public Node getCircleRow() {
        HBox hBox = new HBox();
        hBox.getChildren().addAll(circleRow);
        return hBox;
    }

    public IntegerProperty getValue(){
        return value;
    }

    private void initCircleRow(PrefilledCircle prefilledCircle){
        for (int i = 0; i < circleAmount; i++) {
            Circle circle = new Circle();
            circle.setRadius(10);
            circle.setStroke(Color.BLACK);
            circle.setStrokeWidth(1);
            circle.setFill(UNFILLED);
            if (i==0 && prefilledCircle.equals(PrefilledCircle.ONE))
                circle.setFill(FILLED);

            int finalI = i;
            circle.setOnMouseClicked(event ->
            {
                if (event.getButton().equals(MouseButton.PRIMARY)){
                    value.setValue(finalI+1);
                    for (int y = 0; y<= finalI; y++){
                        circleRow[y].setFill(FILLED);
                    }
                    for (int y=circleAmount-1;y>finalI;y--){
                        circleRow[y].setFill(UNFILLED);
                    }
                }
                else if (event.getButton().equals(MouseButton.SECONDARY) &&
                            finalI == 0 &&
                            prefilledCircle.equals(PrefilledCircle.ZERO)){
                    value.setValue(finalI);
                    for (int y=circleAmount-1;y>=finalI;y--)
                        circleRow[y].setFill(UNFILLED);
                }
            });
            circleRow[i] = circle;
        }
    }

    private int setValue(PrefilledCircle prefilledCircle){
        if (prefilledCircle.equals(PrefilledCircle.ONE))
            return 1;
        else
            return 0;
    }
}
