package logic;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SceneControllerCoach {

    //----------------------------------ATTRIBUTES

    @FXML
    private TextField newTaskTextField;

    @FXML
    private TextField motPhraseTextField;

    //----------------------------------METHODS

    @FXML
    public void refresh() {
        System.out.println("Refresh");
    }

    @FXML
    public void submitTaskId() {
        String newId = newTaskTextField.getText();
        System.out.println("La task con id " + newId + " è stata mandata ad un utente");
        newTaskTextField.setText("");

    }

    @FXML
    public void submitMotPhrase() {
        String newMotPhrase = motPhraseTextField.getText();
        System.out.println("La frase : " + newMotPhrase + " was sent to the user");
        motPhraseTextField.setText("");
    }

    @FXML
    public void exit() {
        System.exit(0);
    }

}
