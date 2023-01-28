package logic;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import logic.view.cliview.CLIChoose;
import logic.view.fxview.SceneController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class Main extends Application {

    //STRINGA CHE STABILISCE SE UTILIZZARE MOTEEVE IN VERSIONE RIGA DI COMANDO
    // O IN VERSIONE INTERFACCIA GRAFICA JAVAFX
    public static final String VIEW = "FX";
    public static void main(String[] args) throws SQLException, IOException {
        if(VIEW.equals("CLI")){
            //START DELL' INTERFACCIA A RIGA DI COMANDO
            CLIChoose cli = new CLIChoose();
            cli.firstPage();
        } else if (VIEW.equals("FX")){
            //START DELL' INTERFACCIA GRAFICA JAVAFX
            launch(args);
        }
    }

    //SETUP DELLO STAGE INIZIALE (CASO INTERFACCIA GRAFICA JAVAFX)
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("startScene.fxml")));
        Scene mainScene = new Scene(root);
        stage.setTitle("Moteeve");
        stage.setResizable(false);
        stage.setScene(mainScene);
        Connectivity.setConnection();
        SceneController.setUp();
        stage.show();
    }

}
