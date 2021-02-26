import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * @author Boyo
 */
class panelPopUp extends JPopupMenu {
    JMenuItem hidePath, openFolder, CreateFolder;

    GUI gui;
    public panelPopUp(GUI gui) {
        this.gui =  gui;
        openFolder = new JMenuItem("Open Folder");
        add(openFolder);

        CreateFolder = new JMenuItem("Create Folder");
        add(CreateFolder);

        hidePath = new JMenuItem("Hide Path");
        add(hidePath);

        openFolder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Opening Folder");
                }});

        CreateFolder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Creating Folder");
                 }});

        hidePath.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("ClosingLeftPanel");
                gui.panelTree.setVisible(false); }});
    }
}

class PopClickListener extends MouseAdapter {
    GUI gui;
    public PopClickListener(GUI gui){
        this.gui = gui;
    }
    public void mousePressed(MouseEvent e) {
        if (e.isPopupTrigger())
            doPop(e);

    }

    public void mouseReleased(MouseEvent e) {
        if (e.isPopupTrigger())
            doPop(e);

    }

    private void doPop(MouseEvent e) {
        panelPopUp menu = new panelPopUp(gui);
        menu.show(e.getComponent(), e.getX(), e.getY());


    }
}


