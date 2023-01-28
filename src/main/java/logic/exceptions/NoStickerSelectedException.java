package logic.exceptions;

import javax.swing.*;

public class NoStickerSelectedException extends IndexOutOfBoundsException {

    public void noStickerSelectedError() {
        JOptionPane.showMessageDialog(null, "Seleziona uno sticker", "ERROR MESSAGE", JOptionPane.INFORMATION_MESSAGE);
    }

}
