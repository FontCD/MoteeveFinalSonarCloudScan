package logic.view.fxview;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import logic.Connectivity;
import logic.asktomoteeve.AskToMoteeveBooleanBean;
import logic.asktomoteeve.AskToMoteeveController;
import logic.asktomoteeve.AskToMoteeveMotPhrBean;
import logic.changetask.ChangeTaskBooleanBean;
import logic.changetask.ChangeTaskController;
import logic.changetask.ChangeTaskIdBean;
import logic.exceptions.InvalidStringException;

import javax.swing.*;

public class SceneControllerCoach {

    //----------------------------------ATTRIBUTES

    @FXML
    private TextField newTaskTextField;

    @FXML
    private TextField motPhraseTextField;

    //----------------------------------METHODS

    @FXML
    public void submitTaskId() {
        ChangeTaskController controller = new ChangeTaskController();
        ChangeTaskBooleanBean booleanBean = controller.checkForATaskRequest();

        if(booleanBean.getBean()){

            String newId = newTaskTextField.getText();

            try {
                Integer.parseInt(newId);
            }catch (NumberFormatException e){
                newTaskTextField.setText("");
            }

            int toChange = Integer.parseInt(newId);

            ChangeTaskIdBean retBean = new ChangeTaskIdBean();
            retBean.setBean(toChange);
            controller.changeTask(retBean);

            JOptionPane.showMessageDialog(null,"La Task con id " + newId + " è stata inviata al tuo apprendista","TASK INVIATA CON SUCCESSO", JOptionPane.INFORMATION_MESSAGE);
            newTaskTextField.setText("");

        } else {
            JOptionPane.showMessageDialog(null,"Al momento non hai alcuna richiesta. Attendi che te arrivi una.","NESSUNA RICHIESTA TROVATA", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    //INVIA UNA FRASE MOTIVAZIONALE ALL' APPRENDISTA
    @FXML
    public void submitMotPhrase() {
        AskToMoteeveController controller = new AskToMoteeveController();
        AskToMoteeveBooleanBean bean = controller.checkRequest();
        if(bean.getBean()) {
            String newMotPhrase = motPhraseTextField.getText();

            try {
                AskToMoteeveMotPhrBean insertBean = new AskToMoteeveMotPhrBean();
                insertBean.setBean(newMotPhrase);
                controller.insertMotivationalPhrase(insertBean);
                JOptionPane.showMessageDialog(null, "La frase che hai scritto è stata inviata al tuo apprendista", "FRASE MOTIVAZIONALE INVIATA CON SUCCESSO", JOptionPane.INFORMATION_MESSAGE);
                motPhraseTextField.setText("");
            } catch (InvalidStringException e) {
                e.invalidStringMessage();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Al momento non hai alcuna richiesta. Attendi che te arrivi una.", "NESSUNA RICHIESTA TROVATA", JOptionPane.INFORMATION_MESSAGE);
        }

    }
    @FXML
    public void exit() {
        Connectivity.disconnect(Connectivity.getConn());
        System.exit(0);
    }

}
