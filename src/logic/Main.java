package logic;

import UI.Vampire.Char.Form;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Main extends Application {

    private int i;

    @Override
    public void init(){
        i = 1;
    }

    @Override
    public void start(Stage primaryStage){
        if (i != 0) {
            Form vampCharForm = new Form();
        }
        else {
            Platform.exit();
        }
    }

    @Override
    public void stop(){

    }

    public static void main(String[] args) {
        try {
            new Thread(() -> launch(args)).start();
//            new Vamp_CharController().displayTemplate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
