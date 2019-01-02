package ba.unsa.etf.rpr;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static String ispisiGradove() {
        return new String("Beč");
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println("Problem sa otvaranjem prozora");
        System.exit(0);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
