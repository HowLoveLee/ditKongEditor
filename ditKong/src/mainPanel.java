import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;
import com.jgoodies.forms.factories.*;
/**
 * @author Boyo
 */
public class mainPanel extends JPanel implements ActionListener{

    GUI gui;
    public mainPanel(GUI gui, String futurePlanString) {

        initComponents(futurePlanString);

        this.gui = gui;
    }

    private void initComponents(String futurePlanString) {

        panel1 = new JPanel();
        label29 = new JLabel();
        label10 = new JLabel();
        label16 = new JLabel();
        label27 = new JLabel();
        separator3 = new JPopupMenu.Separator();
        separator4 = new JPopupMenu.Separator();
        label32 = new JLabel();
        label42 = new JLabel();
        separator5 = new JPopupMenu.Separator();
        separator6 = new JPopupMenu.Separator();
        label41 = new JLabel();
        label40 = new JLabel();
        label39 = new JLabel();
        label38 = new JLabel();
        separator7 = new JPopupMenu.Separator();
        separator8 = new JPopupMenu.Separator();
        label37 = new JLabel();
        label36 = new JLabel();
        separator9 = new JPopupMenu.Separator();
        separator10 = new JPopupMenu.Separator();
        label35 = new JLabel();
        label34 = new JLabel();
        label33 = new JLabel();
        label25 = new JLabel();
        separator11 = new JPopupMenu.Separator();
        separator12 = new JPopupMenu.Separator();
        label26 = new JLabel();
        label31 = new JLabel();
        label24 = new JLabel();
        label19 = new JLabel();
        label22 = new JLabel();
        label21 = new JLabel();
        label20 = new JLabel();
        label17 = new JLabel();
        separator14 = new JPopupMenu.Separator();
        separator13 = new JPopupMenu.Separator();
        label18 = new JLabel();
        label23 = new JLabel();
        label30 = new JLabel();
        label28 = new JLabel();
        label43 = new JLabel();
        label44 = new JLabel();
        panel2 = new JPanel();
        scrollPane1 = new JScrollPane();
        mainMenuTextArea = new JTextArea();

        scrollPane1.setBorder(null);
        //=========== this ===========
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border
        .EmptyBorder ( 0, 0 ,0 , 0) ,  "" , javax. swing .border . TitledBorder. CENTER ,javax
        . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "", java .awt . Font. BOLD ,
        12 ) ,java . awt. Color .red ) , getBorder () ) );  addPropertyChangeListener( new java. beans
        .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "bord\u0065r" .equals ( e.
        getPropertyName () ) )throw new RuntimeException( ) ;} } );
        setLayout(new BorderLayout());

        //=========== panel1 ===========
        {
            panel1.setBorder(new CompoundBorder(
                new TitledBorder("Shortcuts"),
                Borders.DLU2));
            panel1.setLayout(new GridLayout(21, 2));

            //---- label29 ----
            label29.setText("Open");
            panel1.add(label29);

            //---- label10 ----
            label10.setText("Ctrl + O");
            panel1.add(label10);

            //---- label16 ----
            label16.setText("Open Folder    ");
            panel1.add(label16);

            //---- label27 ----
            label27.setText("Ctrl + Alt + O");
            panel1.add(label27);
            panel1.add(separator3);
            panel1.add(separator4);

            //---- label32 ----
            label32.setText("New");
            panel1.add(label32);

            //---- label42 ----
            label42.setText("Ctrl + N");
            panel1.add(label42);
            panel1.add(separator5);
            panel1.add(separator6);

            //---- label41 ----
            label41.setText("Save");
            panel1.add(label41);

            //---- label40 ----
            label40.setText("Ctrl + S");
            panel1.add(label40);

            //---- label39 ----
            label39.setText("Save As");
            panel1.add(label39);

            //---- label38 ----
            label38.setText("Ctrl + Alt + S");
            panel1.add(label38);
            panel1.add(separator7);
            panel1.add(separator8);

            //---- label37 ----
            label37.setText("Settings");
            panel1.add(label37);

            //---- label36 ----
            label36.setText("Ctrl + .");
            panel1.add(label36);
            panel1.add(separator9);
            panel1.add(separator10);

            //---- label35 ----
            label35.setText("Undo");
            panel1.add(label35);

            //---- label34 ----
            label34.setText("Ctrl + Z");
            panel1.add(label34);

            //---- label33 ----
            label33.setText("Redo");
            panel1.add(label33);

            //---- label25 ----
            label25.setText("Ctrl + Y");
            panel1.add(label25);
            panel1.add(separator11);
            panel1.add(separator12);

            //---- label26 ----
            label26.setText("Cut");
            panel1.add(label26);

            //---- label31 ----
            label31.setText("Ctrl + X");
            panel1.add(label31);

            //---- label24 ----
            label24.setText("Copy");
            panel1.add(label24);

            //---- label19 ----
            label19.setText("Ctrl + C");
            panel1.add(label19);

            //---- label22 ----
            label22.setText("Paste");
            panel1.add(label22);

            //---- label21 ----
            label21.setText("Ctrl + V");
            panel1.add(label21);

            //---- label20 ----
            label20.setText("Delete");
            panel1.add(label20);

            //---- label17 ----
            label17.setText("Delete");
            panel1.add(label17);
            panel1.add(separator14);
            panel1.add(separator13);

            //---- label18 ----
            label18.setText("Select All");
            panel1.add(label18);

            //---- label23 ----
            label23.setText("Ctrl + A");
            panel1.add(label23);

            //---- label30 ----
            label30.setText("Find");
            panel1.add(label30);

            //---- label28 ----
            label28.setText("Ctrl + F");
            panel1.add(label28);

            //---- label43 ----
            label43.setText("Find/Replace");
            panel1.add(label43);

            //---- label44 ----
            label44.setText("Ctrl + R");
            panel1.add(label44);
        }
        add(panel1, BorderLayout.WEST);

        //======== panel2 ========
        {
            panel2.setBorder(new CompoundBorder(
                new TitledBorder("Future Plans"),
                Borders.DLU2));
            panel2.setLayout(new BorderLayout());

            //======== scrollPane1 ========
            {

                //---- mainMenuTextArea ----
                mainMenuTextArea.setText("                                          ");
                mainMenuTextArea.setEditable(false);
                scrollPane1.setViewportView(mainMenuTextArea);

                mainMenuTextArea.setText(futurePlanString);
            }
            panel2.add(scrollPane1, BorderLayout.CENTER);

            JPanel bottomPanel = new JPanel(new GridLayout(0,2));
            JPanel listThemes = new JPanel(new GridLayout(3,3));

            listThemes.setBorder(new CompoundBorder(
                    new TitledBorder("Themes"),
                    Borders.DLU2));
            JLabel theme1 = new JLabel("Light Theme");
            listThemes.add(theme1);
            JLabel theme2 = new JLabel("Flat Dark");
            listThemes.add(theme2);
            JLabel theme3 = new JLabel("Carbon");
            listThemes.add(theme3);
            JLabel theme4 = new JLabel("Deep Sea");
            listThemes.add(theme4);
            JLabel theme5 = new JLabel("Material Design");
            listThemes.add(theme5);
            JLabel theme6 = new JLabel("Black Contrast");
            listThemes.add(theme6);
            bottomPanel.add(listThemes);

            /*
            You can add something later to  bottomPanel
             */

            JPanel snakeGame = new JPanel();
            JButton buttonSnakeGame = new JButton("Close Menu");
            snakeGame.add(buttonSnakeGame);
            bottomPanel.add(snakeGame);
            buttonSnakeGame.addActionListener(this::actionPerformed);
            buttonSnakeGame.setActionCommand("close");

            add(bottomPanel,BorderLayout.SOUTH);
        }
        add(panel2, BorderLayout.CENTER);

    }

    private JPanel panel1;
    private JLabel label29;
    private JLabel label10;
    private JLabel label16;
    private JLabel label27;
    private JPopupMenu.Separator separator3;
    private JPopupMenu.Separator separator4;
    private JLabel label32;
    private JLabel label42;
    private JPopupMenu.Separator separator5;
    private JPopupMenu.Separator separator6;
    private JLabel label41;
    private JLabel label40;
    private JLabel label39;
    private JLabel label38;
    private JPopupMenu.Separator separator7;
    private JPopupMenu.Separator separator8;
    private JLabel label37;
    private JLabel label36;
    private JPopupMenu.Separator separator9;
    private JPopupMenu.Separator separator10;
    private JLabel label35;
    private JLabel label34;
    private JLabel label33;
    private JLabel label25;
    private JPopupMenu.Separator separator11;
    private JPopupMenu.Separator separator12;
    private JLabel label26;
    private JLabel label31;
    private JLabel label24;
    private JLabel label19;
    private JLabel label22;
    private JLabel label21;
    private JLabel label20;
    private JLabel label17;
    private JPopupMenu.Separator separator14;
    private JPopupMenu.Separator separator13;
    private JLabel label18;
    private JLabel label23;
    private JLabel label30;
    private JLabel label28;
    private JLabel label43;
    private JLabel label44;
    private JPanel panel2;
    private JScrollPane scrollPane1;
    private JTextArea mainMenuTextArea;

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case"close":
                gui.tabPanel.removeTabAt(gui.tabPanel.getSelectedIndex());
                break;
        }
    }

}
