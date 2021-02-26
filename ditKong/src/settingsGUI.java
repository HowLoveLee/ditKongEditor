import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 * @author Boyo
 */

public class settingsGUI extends JDialog  implements  ActionListener{
    private final GUI gui;
    public settingsGUI(Window owner, GUI gui) {
        super(owner);
        initComponents();

        this.gui = gui;

    }

    private void initComponents() {

        exitPanel = new JPanel();
        saveLabel = new JLabel();
        buttonSaveChanges = new JButton();
        buttonCancelChanges = new JButton();
        backgroundPanel = new JPanel();
        themePanel = new JPanel();
        themeSelectLabel = new JLabel();
        themeComboBox = new JComboBox<>();
        syntaxtLabel = new JLabel();
        syntaxtSelection = new JComboBox<>();
        fontPanel = new JPanel();
        fontTypeLabel = new JLabel();
        fontTypeSelection = new JComboBox<>();
        fontSizeLabel = new JLabel();

        //======== this ========
        setTitle("Settings");
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== exitPanel ========
        {
            exitPanel.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder
            ( 0, 0 ,0 , 0) ,  "Version: 5.9.3" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border
            .TitledBorder . BOTTOM, new java. awt .Font ( "", java .awt . Font. BOLD ,12 ) , Color .darkGray ) ,exitPanel. getBorder () ) ); exitPanel. addPropertyChangeListener(new java. beans .PropertyChangeListener ( ){ @Override public void
            propertyChange (java . beans. PropertyChangeEvent e) { if( "" .equals ( e. getPropertyName () ) )throw new RuntimeException( )
            ;} } );
            exitPanel.setLayout(new GridLayout(0, 3));

            //---- saveLabel ----
            saveLabel.setText("Save Changes?");
            saveLabel.setHorizontalAlignment(SwingConstants.CENTER);
            exitPanel.add(saveLabel);

            //---- button3 ----
            buttonSaveChanges.setText("Yes");
            exitPanel.add(buttonSaveChanges);

            //---- button4 ----
            buttonCancelChanges.setText("No");
            buttonCancelChanges.setEnabled(true);
            exitPanel.add(buttonCancelChanges);

            buttonSaveChanges.addActionListener(this);
            buttonSaveChanges.setActionCommand("yes");
            buttonCancelChanges.addActionListener(this);
            buttonCancelChanges.setActionCommand("no");
        }
        contentPane.add(exitPanel, BorderLayout.SOUTH);

        //======== backgroundPanel ========
        {
            backgroundPanel.setLayout(new GridLayout(2, 0));

            //======== themePanel ========
            {
                themePanel.setBorder(new TitledBorder("Theme"));
                themePanel.setLayout(new GridLayout(2, 2));

                //---- themeSelectLabel ----
                themeSelectLabel.setText("Selected Theme");
                themeSelectLabel.setHorizontalAlignment(SwingConstants.CENTER);
                themePanel.add(themeSelectLabel);

                //---- themeComboBox ----
                themeComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
                    "Flat Light",
                    "Flat Dark",
                    "Carbon",
                    "Deep Sea",
                    "Material Design",
                    "Black Contrast"
                }));
                themePanel.add(themeComboBox);


                //---- syntaxt ----
                syntaxtLabel.setText("Syntaxt");
                syntaxtLabel.setHorizontalAlignment(SwingConstants.CENTER);
                syntaxtLabel.setEnabled(false);
                themePanel.add(syntaxtLabel);

                //---- comboBox5 ----
                syntaxtSelection.setEnabled(false);
                syntaxtSelection.setModel(new DefaultComboBoxModel<>(new String[] {
                    "Default"
                }));
                themePanel.add(syntaxtSelection);
            }
            backgroundPanel.add(themePanel);

            //======== fontPanel ========
            {


                fontPanel.setBorder(new TitledBorder("Font"));
                fontPanel.setLayout(new GridLayout(2, 2));

                //---- label30 ----
                fontTypeLabel.setText("Font Type");
                fontTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
                fontPanel.add(fontTypeLabel);

                //---- comboBox6 ----
                fontTypeSelection.setModel(new DefaultComboBoxModel<>(new String[] {
                    "Arial",
                    "JetBrains Mono",
                    "Consolas"

                }));
                fontPanel.add(fontTypeSelection);

                //---- label31 ----
                fontSizeLabel.setText("Font Size");
                fontSizeLabel.setHorizontalAlignment(SwingConstants.CENTER);
                fontPanel.add(fontSizeLabel);
                fontPanel.add(fontSize);


            }
            backgroundPanel.add(fontPanel);
        }
        contentPane.add(backgroundPanel, BorderLayout.CENTER);
        setSize(295, 300);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Juan Perez
    private JPanel exitPanel;
    private JLabel saveLabel;
    private JButton buttonSaveChanges;
    private JButton buttonCancelChanges;
    private JPanel backgroundPanel;
    private JPanel themePanel;
    private JLabel themeSelectLabel;
    public JComboBox<String> themeComboBox;
    private JLabel syntaxtLabel;
    private JComboBox<String> syntaxtSelection;
    private JPanel fontPanel;
    private JLabel fontTypeLabel;
    private JComboBox<String> fontTypeSelection;
    private JLabel fontSizeLabel;
    private JSlider fontSize=new JSlider(1,60);


    public void setSelectedFontType()throws IOException{
        final File homeName = new File(System.getProperty("user.home"));
        final String settingsPath = homeName+"\\editorStaff\\Settings\\settingsSave.txt";
        String fontToSelect = Files.readAllLines(Paths.get(settingsPath)).get(2);

        switch (fontToSelect){//Arial
            case"Arial"://Arial
                fontTypeSelection.setSelectedItem("Arial");
                break;
            case"JetBrains Mono"://JetBrains Mono
                fontTypeSelection.setSelectedItem("JetBrains Mono");
                break;
            case"Consolas"://Consolas
                fontTypeSelection.setSelectedItem("Consolas");
                break;
        }

    }
    public void setSelectedTheme() throws IOException {
        final File homeName = new File(System.getProperty("user.home"));
        final String settingsPath = homeName+"\\editorStaff\\Settings\\settingsSave.txt";
        String themeToSelect = Files.readAllLines(Paths.get(settingsPath)).get(0);

        switch (themeToSelect){
            case"FlatLightLaf.xml"://FlatLightLaf.xml
                themeComboBox.setSelectedItem("Flat Light");
                break;
            case"DarkFlat.xml"://DarkFlat.xml
                themeComboBox.setSelectedItem("Flat Dark");
                break;
            case"Carbon.xml"://Carbon.xml
                themeComboBox.setSelectedItem("Carbon");
                break;
            case"DeepSeaOcean.xml"://DeepSeaOcean.xml
                themeComboBox.setSelectedItem("Deep Sea");
                break;
            case"materialDesignDark.xml"://materialDesignDark.xml
                themeComboBox.setSelectedItem("Material Design");
                break;
            case"HighContrast.xml"://HighContrast.xml
                themeComboBox.setSelectedItem("Black Contrast");
                break;

        }

    }
    private String getThemeSelected(){
        String varName = (String)themeComboBox.getSelectedItem();

        return varName;
    }

    private void writeTheme() throws IOException {
        /*
        Install RSyntaxTextArea
            Create All Themes
            For text Area Only

          On Settings (createGUI)
          REad the first line and create a switch statement
          If this install that flatlaf theme and set theme
         */

        final File homeName = new File(System.getProperty("user.home"));
        String settingsPath = homeName+"\\editorStaff\\Settings\\settingsSave.txt";
        
        switch (getThemeSelected()){

            case"Flat Light":

                modifyFile(settingsPath, Files.readAllLines
                        (Paths.get(settingsPath)).get(0), "FlatLightLaf.xml");
                System.out.println("Theme changed to FlatLight");
                break;
            case"Flat Dark":
                modifyFile(settingsPath, Files.readAllLines
                        (Paths.get(settingsPath)).get(0), "DarkFlat.xml");//
                System.out.println("Theme changed to flatDark");
                break;
            case"Carbon":
                modifyFile(settingsPath, Files.readAllLines
                        (Paths.get(settingsPath)).get(0), "Carbon.xml");
                System.out.println("Theme changed to Carbon");
                break;
            case"Deep Sea":
                modifyFile(settingsPath, Files.readAllLines
                        (Paths.get(settingsPath)).get(0), "DeepSeaOcean.xml");
                System.out.println("Theme changed to DeepSeaOcean");
                break;
            case"Material Design":
                modifyFile(settingsPath, Files.readAllLines
                        (Paths.get(settingsPath)).get(0), "materialDesignDark.xml");
                System.out.println("Theme changed to materialDesignDark");
                break;
            case"Black Contrast":
                modifyFile(settingsPath, Files.readAllLines
                        (Paths.get(settingsPath)).get(0), "HighContrast.xml");
                System.out.println("Theme changed to HighContrast");
                break;
        }
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {

            case"yes":

                try {
                    //Font Writing
                    writeTheme();

                    //Font type
                    writeFontType();
                    setFontType();

                    //Font Size
                    saveFontSize();



                    this.setVisible(false);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                refreshQuestion("Refresh", "Restart now?");
                break;
            case"no":
                this.setVisible(false);
                break;
        }
    }
     /*                   When user clicks okay it will overwrite the current
                        Font type
                        Font Size
                        Initiate JSlider On GUI
                        And create an obj here of GUI
     */

    public void createFontSettings() throws IOException {

        String stringVal = Files.readAllLines(Paths.get(settingsPath)).get(3);
        int defaultVal = Integer.parseInt(stringVal);

        fontSize.setValue(defaultVal);// Here get the value fron the settingsSave.txt
        System.out.println("Font Size: "+defaultVal);


        fontSize.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent ce)
            {
                writeFontSize();
            }
        });


    }

    final File homeName = new File(System.getProperty("user.home"));
    final String settingsPath = homeName+"\\editorStaff\\Settings\\settingsSave.txt";

    public void saveFontSize() throws IOException {
        final File homeName = new File(System.getProperty("user.home"));
        final String settingsPath = homeName+"\\editorStaff\\Settings\\settingsSave.txt";
        String oldFontSizeVal = Files.readAllLines(Paths.get(settingsPath)).get(3);
        String newfontValue= String.valueOf(fontSize.getValue());
        modifyFile(settingsPath, oldFontSizeVal, newfontValue);
    }
    public void writeFontSize(){
        gui.textArea.setFont(new Font(getFontSelected(),Font.BOLD,fontSize.getValue()));

    }
    public void addSetUpFontSize() throws IOException {
        final File homeName = new File(System.getProperty("user.home"));
        final String settingsPath = homeName+"\\editorStaff\\Settings\\settingsSave.txt";
        String stringVal = Files.readAllLines(Paths.get(settingsPath)).get(3);
        int defaultVal = Integer.parseInt(stringVal);

        System.out.println("We created the textArea value: "+defaultVal);


        /*

        Now Create the add Function For the font name, add it here
         */
        gui.textArea.setFont(new Font(getFontSelected(),Font.BOLD, defaultVal));
    }


    //addSetUpFontSize
    public void setFontType() throws IOException {//Inconsolata JetBrains Mono Consolas
        final File homeName = new File(System.getProperty("user.home"));
        final String settingsPath = homeName+
                "\\editorStaff\\Settings\\settingsSave.txt";
        String newFontType = Files.readAllLines(Paths.get(settingsPath)).get(2);
        gui.textArea.setFont(new Font(newFontType,Font.BOLD,fontSize.getValue()));
        System.out.println("New font saved: "+newFontType);

    }

    public void writeFontType() throws IOException {
        final File homeName = new File(System.getProperty("user.home"));
        String settingsPath = homeName+"\\editorStaff\\Settings\\settingsSave.txt";

        switch (getFontSelected()){

            case"Arial":
                modifyFile(settingsPath, Files.readAllLines
                        (Paths.get(settingsPath)).get(2), "Arial");
                System.out.println("Font changed to Arial");
                break;
            case"JetBrains Mono":
                modifyFile(settingsPath, Files.readAllLines
                        (Paths.get(settingsPath)).get(2), "JetBrains Mono");
                System.out.println("Font changed to JetBrains Mono");
                break;

            case"Consolas":
                modifyFile(settingsPath, Files.readAllLines
                        (Paths.get(settingsPath)).get(2), "Consolas");
                System.out.println("Font changed to Consolas");
                break;
        }
    }

    private String getFontSelected(){

        String fontType = (String)fontTypeSelection.getSelectedItem();

        return fontType;
    }

    private void modifyFile(String filePath, String oldString, String newString) {
        File fileToBeModified = new File(filePath);

        String oldContent = "";

        BufferedReader reader = null;

        FileWriter writer = null;

        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));

            //Reading all the lines of input text file into oldContent

            String line = reader.readLine();

            while (line != null)
            {
                oldContent = oldContent + line + System.lineSeparator();

                line = reader.readLine();
            }

            //Replacing oldString with newString in the oldContent

            String newContent = oldContent.replaceAll(oldString, newString);

            //Rewriting the input text file with newContent

            writer = new FileWriter(fileToBeModified);

            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources

                reader.close();

                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void refreshQuestion(String title, String message){
        //Custom button text
        Object[] options = {"Yes",
                "No"};

        int n = JOptionPane.showOptionDialog(this, message, title,
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);


        if (n== 0){//Yes
            gui.refreshProgram("No further plans");
        }else{//No or X button

        }
    }
}
