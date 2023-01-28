package logic.exceptions;

import javax.swing.*;

public class InvalidStringException extends Exception{
    public void invalidStringMessage(){
        JOptionPane.showMessageDialog(null, "Hai inserito una stringa non valida. Riprova.", "ERROR MESSAGE",JOptionPane.INFORMATION_MESSAGE);
    }
}
