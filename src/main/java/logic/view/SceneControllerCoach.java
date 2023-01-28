package logic.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;

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
        JOptionPane.showMessageDialog(null,"La Task con id " + newId + " è stata inviata al tuo apprendista","TASK INVIATA CON SUCCESSO", JOptionPane.INFORMATION_MESSAGE);
        newTaskTextField.setText("");

    }

    @FXML
    public void submitMotPhrase() {
        String newMotPhrase = motPhraseTextField.getText();
        JOptionPane.showMessageDialog(null,"La frase che hai scritto è stata inviata al tuo apprendista","FRASE MOTIVAZIONALE INVIATA CON SUCCESSO", JOptionPane.INFORMATION_MESSAGE);
        motPhraseTextField.setText("");
    }

    @FXML
    public void exit() {
        System.exit(0);
    }

}
