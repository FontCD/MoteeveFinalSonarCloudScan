package logic.exceptions;

import javax.swing.*;

public class NoSlotSelectedException extends IndexOutOfBoundsException {

    public void noSlotSelectedError() {
        JOptionPane.showMessageDialog(null, "Seleziona uno slot", "ERROR MESSAGE", JOptionPane.INFORMATION_MESSAGE);
    }

}
