import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Set;

/**
 * @author Boyo
 */
public class KeyHandler implements KeyListener {

    Settings settings = new Settings();
    GUI gui;
    public KeyHandler(GUI gui){
        this.gui = gui;
    }

    public void keyTyped(KeyEvent e) { }

    public void keyPressed(KeyEvent e) {
        if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_O){
            gui.file.open();
        }else if (e.isControlDown()
                && e.isShiftDown() && e.getKeyCode()==KeyEvent.VK_O){
            //Open Folder
        }else if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_N){
            gui.file.newFile();
        }else if (e.isControlDown()
                && e.isShiftDown() && e.getKeyCode()==KeyEvent.VK_N){
            try {
                settings.createGUI("New");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }else if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S){
            gui.file.save();
        }else if (e.isControlDown()
                && e.isShiftDown() && e.getKeyCode()==KeyEvent.VK_S){

            gui.file.saveAs();
        }else if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_P){
            //Print
        }else if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_PERIOD){
            gui.openSettings();
        }else if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_F){
            gui.addFind();
        }else if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_CLOSE_BRACKET){
            // get the current font
            Font f = gui.textArea.getFont();

            // create a new, smaller font from the current font
            Font f2 = new Font(f.getFontName(), f.getStyle(), f.getSize()+2);

            // set the new font in the editing area
            gui.textArea.setFont(f2);
        }else if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_OPEN_BRACKET){
            System.out.println("LESS SIZE");
            // get the current font
            Font f = gui.textArea.getFont();
            // create a new, smaller font from the current font
            Font f2 = new Font(f.getFontName(), f.getStyle(), f.getSize()-2);

            // set the new font in the editing area
            gui.textArea.setFont(f2);
        }

    }

    public void keyReleased(KeyEvent e) {

    }
}
