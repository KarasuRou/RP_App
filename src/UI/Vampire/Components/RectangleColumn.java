package UI.Vampire.Components;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectangleColumn {

    private final int rectangleAmount;
    private final String bezeichnung;
    private final Rectangle[] rectangleColumn;
    private final HBox root = new HBox();
    private final Color FILLED = Color.RED;
    private final Color UNFILLED = Color.WHITE;
    private final IntegerProperty value = new SimpleIntegerProperty(0);

    public RectangleColumn(int rectangleAmount, String bezeichnung, Boolean alreadyOneActive) {
        this.rectangleAmount = rectangleAmount;
        this.bezeichnung = bezeichnung;
        rectangleColumn = new Rectangle[this.rectangleAmount];
        initRectangleColumn(alreadyOneActive);
        value.setValue(setValue(alreadyOneActive));
    }
    private int setValue(Boolean alreadyOneActive){
        if (alreadyOneActive)
            return 1;
        else
            return 0;
    }

    private void initRectangleColumn(Boolean alreadyOneActive){
        for (int i = 0; i < rectangleAmount; i++) {
            Rectangle rectangle = new Rectangle();
            rectangle.setWidth(20);
            rectangle.setHeight(20);
            rectangle.setStroke(Color.BLACK);
            rectangle.setStrokeWidth(1);
            rectangle.setFill(UNFILLED);
            if (i==0 && alreadyOneActive)
                rectangle.setFill(FILLED);

            int finalI = i;
            rectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getButton().equals(MouseButton.PRIMARY)){
                        value.setValue(finalI+1);
                        for (int y = 0; y<= finalI; y++){
                            rectangleColumn[y].setFill(FILLED);
                        }
                        for (int y=rectangleAmount-1;y>finalI;y--){
                            rectangleColumn[y].setFill(UNFILLED);
                        }
                    }
                    else if (event.getButton().equals(MouseButton.SECONDARY) && finalI == 0 && !alreadyOneActive){
                        value.setValue(finalI);
                        for (int y=rectangleAmount-1;y>=finalI;y--)
                            rectangleColumn[y].setFill(UNFILLED);
                    }
                }
            });
            rectangleColumn[finalI] = rectangle;
        }
        root.getChildren().addAll(rectangleColumn);
    }

    public Node getRectangleBox() {
        return root;
    }

    public IntegerProperty getValue(){
        return value;
    }
}
