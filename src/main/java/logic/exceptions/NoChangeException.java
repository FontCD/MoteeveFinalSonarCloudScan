package logic.exceptions;

import javax.swing.*;

public class NoChangeException extends Exception{

    public void noChangeMessage () {
        JOptionPane.showMessageDialog(null, "Non hai cambi a disposizione, aspetta che te ne venga aggiunto uno!", "ERROR MESSAGE", JOptionPane.INFORMATION_MESSAGE);
    }
}
