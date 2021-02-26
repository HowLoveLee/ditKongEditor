import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

/**
 * @author 6dc
 *
 * A class which creates a JTabbedPane and auto sets a close button when you add a tab
 *
 */
public class JTabbedPaneCloseButton extends JTabbedPane {

   public GUI gui;
    public JTabbedPaneCloseButton(GUI gui) {
        super();
        this.gui = gui;
    }

    /* Override Addtab in order to add the close Button everytime */
    @Override
    public void addTab(String title, Icon icon, Component component, String tip) {
        super.addTab(title, icon, component, tip);
        int count = this.getTabCount() - 1;
        setTabComponentAt(count, new CloseButtonTab(component, title, icon));
    }

    @Override
    public void addTab(String title, Icon icon, Component component) {
        addTab(title, icon, component, null);
    }

    @Override
    public void addTab(String title, Component component) {
        addTab(title, null, component);
    }

    /* addTabNoExit */
    public void addTabNoExit(String title, Icon icon, Component component, String tip) {
        super.addTab(title, icon, component, tip);
    }

    public void addTabNoExit(String title, Icon icon, Component component) {
        addTabNoExit(title, icon, component, null);
    }

    public void addTabNoExit(String title, Component component) {
        addTabNoExit(title, null, component);
    }

    /* Button */
    public class CloseButtonTab extends JPanel {
        private Component tab;

        public CloseButtonTab(final Component tab, String title, Icon icon) {
            this.tab = tab;
            setOpaque(false);
            FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 3, 3);
            setLayout(flowLayout);
            JLabel jLabel = new JLabel(title);
            jLabel.setIcon(icon);
            add(jLabel);
            //Add your own Icon here -----------------------------------------------------------------------------------------------

            Icon iconExit = new ImageIcon("Resources/FileExit.png");
            JButton button = new JButton(iconExit);
            button.setBorder(null);
            button.setMargin(new Insets(0, 0, 0, 0));
            button.addMouseListener(new CloseListener(tab));
            add(button);
        }
    }
    /* ClickListener */
    public class CloseListener implements MouseListener
    {
        private Component tab;

        public CloseListener(Component tab){
            this.tab=tab;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource() instanceof JButton){
                JButton clickedButton = (JButton) e.getSource();


                try{ //System.out.println(gui.tabPanel.getTitleAt(0)); Gets the name of the tab. such as Filename.txt
                    /*
                        Now If the tab is not a file just exit without anything
                        If you exit a file
                            *Set the fileName and file Address to null
                     */
                    if (gui.tabPanel.getTitleAt(0).equals("Menu")){
                        System.out.println("You exited the menu!");

                        JTabbedPane tabbedPane = (JTabbedPane) clickedButton.getParent().getParent().getParent();
                        tabbedPane.remove(tab);

                    }else{// Its a file
                        System.out.println("Its a file you are trying to close");

                         /*
                            setFileAdress setFileName
                            Ask user if he wants to save file
                            Custom button text
                            If empty Exit
                            if file does not exist but not empty do this
                         */

                        if (gui.file.fileName == null && gui.file.fileAdress == null){
                            if(gui.textArea.getText().isEmpty()){// Theres nothing
                                System.out.println("!File and Empty");
                                JTabbedPane tabbedPane = (JTabbedPane) clickedButton.getParent().getParent().getParent();
                                tabbedPane.remove(tab);
                            }else{// !File but not empty
                                System.out.println("!File and !Empty");

                                //Custom button text
                                Object[] options = {"Yes", "No", "Cancel"};

                                int n = JOptionPane.showOptionDialog(null, "Do you wish to save" +
                                                " this to a  file?"
                                        , "Save File?",
                                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                                        null, options, options[2]);

                                if (n==0){//Yes
                                    gui.file.saveAs();
                                    JTabbedPane tabbedPane = (JTabbedPane) clickedButton.getParent().getParent().getParent();
                                    tabbedPane.remove(tab);
                                }else if (n==1){//No
                                    JTabbedPane tabbedPane = (JTabbedPane) clickedButton.getParent().getParent().getParent();
                                    tabbedPane.remove(tab);
                                }else{//Cancel
                                    System.out.println("Cancel Closing File");
                                }
                            }
                        }else if (gui.file.fileName != null && gui.file.fileAdress != null){
                            gui.file.save();
                            System.out.println("Saving and Closing File from: CLOSE BY EXIT TAB");
                            JTabbedPane tabbedPane = (JTabbedPane) clickedButton.getParent().getParent().getParent();
                            tabbedPane.remove(tab);
                        }

                    }
                }catch (Exception ex){ System.out.println(ex); }

            }
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource() instanceof JButton){
                JButton clickedButton = (JButton) e.getSource();
                //   clickedButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,3));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(e.getSource() instanceof JButton){
                JButton clickedButton = (JButton) e.getSource();
                //   clickedButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,3));
            }
        }
    }


/*
    Loops throughout all tabs to locate the one that meets the requirements
 */
    public int findTabByName(String title, JTabbedPane tab)
    {
        int tabCount = tab.getTabCount();
        for (int i=0; i < tabCount; i++)
        {
            String tabTitle = tab.getTitleAt(i);
            if (tabTitle.equals(title)) return i;
        }
        return -1;
    }

}
