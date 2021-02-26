import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;

import com.jgoodies.forms.factories.*;
import org.fife.rsta.ac.LanguageSupport;
import org.fife.rsta.ac.LanguageSupportFactory;
import org.fife.rsta.ac.java.JavaLanguageSupport;
import org.fife.rsta.ac.js.JavaScriptLanguageSupport;
import org.fife.ui.autocomplete.*;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.fife.ui.rtextarea.SearchContext;
import org.fife.ui.rtextarea.SearchEngine;

/**
 * @author Boyo
 */
 
public class GUI extends JFrame {

    public GUI(String futurePlanString) {
        initComponents(futurePlanString);

        setUndecorated(true);
        this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

    }

    /**
     * Create a simple provider that adds some Java-related completions.
     */

    public void initComponents(String futurePlanString) {


        this.futurePlanString = futurePlanString;
        menuBar = new JMenuBar();
        menuFile = new JMenu();
        iOpen = new JMenuItem();
        iOpenFolder = new JMenuItem();
        iNew = new JMenuItem();
        iNewWindow = new JMenuItem();
        iSave = new JMenuItem();
        iSaveAs = new JMenuItem();
        iAutoSave = new JCheckBoxMenuItem();
        menuLanguages = new JMenu();
        title = new JMenuItem();
        iJava = new JMenuItem();
        iC = new JMenuItem();
        iXml = new JMenuItem();
        menuSettings = new JMenuItem();
        iPrint = new JMenuItem();
        iExportPDF = new JMenuItem();
        iExit = new JMenuItem();
        menuEdit = new JMenu();
        willDelete = new JMenuItem();
        iFind = new JMenuItem();
        iReplace = new JMenuItem();
        iTimeDate = new JMenuItem();
        menuSpacer = new JMenuItem();
        buttonStop = new JButton();
        ButtonStart = new JButton();
        panelTree = new JPanel();
        scrollPanelTree = new JScrollPane();
        tree = new JTree();
        tooLBar = new JToolBar();
        buttonOpenPath = new JButton();
        buttonRefresh = new JButton();
        toolBarSpacer = new JLabel();
        panelTextTabs = new JPanel();
        tabPanel = new JTabbedPaneCloseButton(this);
        panelTextArea = new JPanel();
        iRefresh = new JMenuItem("Refresh");
        file = new function_File(this);

        About = new JMenu();
        toDo = new JMenuItem();

        createToolBar();
        //======== this ========
        setTitle("Editor");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        ImageIcon img =new ImageIcon(getClass().getResource("/Moke.png"));
        this.setIconImage(img.getImage());

        keyHander = new KeyHandler(this);

        //============ Key Listeners ================
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                file.exit();

            }
        });

        textArea.addKeyListener(keyHander);
        this.addKeyListener(keyHander);

        //======== menuBar ========
        {
            //======== menuFile ========
            {
                menuFile.setText("File");

                //---- iOpen ----
                iOpen.setText("Open                      Ctrl+O");
                iOpen.setHorizontalAlignment(SwingConstants.LEFT);
                iOpen.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                menuFile.add(iOpen);

                //---- iOpenFolder ----
                iOpenFolder.setText("Open Path          Ctrl+Alt+O");
                iOpenFolder.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                iOpenFolder.setHorizontalAlignment(SwingConstants.LEFT);
                iOpenFolder.setEnabled(true);
                menuFile.add(iOpenFolder);
                menuFile.addSeparator();

                //---- iNew ----
                iNew.setText("New                       Ctrl+N");
                iNew.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                iNew.setHorizontalAlignment(SwingConstants.LEFT);
                menuFile.add(iNew);

                //---- iNewWindow ----
                iNewWindow.setText("New WIndow");
                iNewWindow.setHorizontalAlignment(SwingConstants.LEFT);
                iNewWindow.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                iNewWindow.setEnabled(false);
                menuFile.add(iNewWindow);

                menuFile.addSeparator();

                //---- iSave ----
                iSave.setText("Save                      Ctrl+S");
                iSave.setHorizontalAlignment(SwingConstants.LEFT);
                iSave.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                menuFile.add(iSave);

                //---- iSaveAS ----
                iSaveAs.setText("Save As                 Ctrl+Alt+S");
                iSaveAs.setHorizontalAlignment(SwingConstants.LEFT);
                iSaveAs.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                menuFile.add(iSaveAs);
                menuFile.addSeparator();

                //---- iAutoSave ----
                iAutoSave.setText("Auto Save");
                iAutoSave.setHorizontalAlignment(SwingConstants.LEFT);
                iAutoSave.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                menuFile.add(iAutoSave);

                //---- Refresh ---------
                iRefresh.setHorizontalAlignment(SwingConstants.LEFT);
                iRefresh.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                menuFile.add(iRefresh);


                //======== menuLanguages ========
                {
                    menuLanguages.setText("Langauge");
                    menuLanguages.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                    menuLanguages.setHorizontalAlignment(SwingConstants.LEFT);
                    menuLanguages.setEnabled(false);
                    //---- title ----
                    title.setText("One at a time");
                    title.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                    title.setHorizontalAlignment(SwingConstants.RIGHT);
                    title.setBorder(Borders.DLU7);
                    title.setEnabled(false);
                    menuLanguages.add(title);

                    //---- iJava ----
                    iJava.setText("Java");
                    iJava.setHorizontalAlignment(SwingConstants.LEFT);
                    iJava.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                    menuLanguages.add(iJava);

                    //---- iC ----
                    iC.setText("C#");
                    iC.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                    iC.setHorizontalAlignment(SwingConstants.LEFT);
                    menuLanguages.add(iC);

                    //---- iXml ----
                    iXml.setText("XML");
                    iXml.setHorizontalAlignment(SwingConstants.LEFT);
                    iXml.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                    menuLanguages.add(iXml);
                }
                menuFile.add(menuLanguages);
                menuFile.addSeparator();

                //---- menuSettings ----
                menuSettings.setText("Settings                   Ctrl + . ");
                menuSettings.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                menuSettings.setHorizontalAlignment(SwingConstants.LEFT);
                menuFile.add(menuSettings);
                menuFile.addSeparator();

                //---- iPrint ----
                iPrint.setText("Print                        Ctrl+P");
                iPrint.setHorizontalAlignment(SwingConstants.LEFT);
                iPrint.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                iPrint.setEnabled(false);
                menuFile.add(iPrint);

                //---- iExportPDF ----
                iExportPDF.setText("Export to PDF");
                iExportPDF.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                iExportPDF.setHorizontalAlignment(SwingConstants.LEFT);
                menuFile.add(iExportPDF);
                iExportPDF.setEnabled(false);
                menuFile.addSeparator();

                //---- iExit ----
                iExit.setText("Exit");
                iExit.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                iExit.setHorizontalAlignment(SwingConstants.LEFT);
                menuFile.add(iExit);
            }
            menuBar.add(menuFile);

            //======== menuEdit ========
            {
                menuEdit.setText("Edit");

                //---- willDelete ----
                menuEdit.add(createMenuItem(RTextArea.getAction(RTextArea.UNDO_ACTION)));

                menuEdit.add(createMenuItem(RTextArea.getAction(RTextArea.REDO_ACTION)));
                menuEdit.addSeparator();
                menuEdit.add(createMenuItem(RTextArea.getAction(RTextArea.CUT_ACTION)));
                menuEdit.add(createMenuItem(RTextArea.getAction(RTextArea.COPY_ACTION)));
                menuEdit.add(createMenuItem(RTextArea.getAction(RTextArea.PASTE_ACTION)));
                menuEdit.add(createMenuItem(RTextArea.getAction(RTextArea.DELETE_ACTION)));
                menuEdit.addSeparator();
                menuEdit.add(createMenuItem(RTextArea.getAction(RTextArea.SELECT_ALL_ACTION)));

                menuEdit.addSeparator();

                //---- iFind ----
                iFind.setText("Find");
//                iFind.setHorizontalAlignment(SwingConstants.LEFT);
//                iFind.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                iFind.setEnabled(true);
                menuEdit.add(iFind);

                //---- iReplace ----
                iReplace.setText("Find/Replace");
//                iReplace.setHorizontalAlignment(SwingConstants.LEFT);
//                iReplace.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                iReplace.setEnabled(false);
                menuEdit.add(iReplace);
                menuEdit.addSeparator();

                //---- iTimeDate ----
                iTimeDate.setText("Time&Date");
//                iTimeDate.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//                iTimeDate.setHorizontalAlignment(SwingConstants.LEFT);
                menuEdit.add(iTimeDate);

            }
            menuBar.add(menuEdit);

            {//=============== ABOUT ===================

                toDo.setText("To-Do");
                About.add(toDo);
                toDo.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                toDo.setHorizontalAlignment(SwingConstants.LEFT);


                About.setText("About");
                menuBar.add(About);
            }
        }
        setJMenuBar(menuBar);

        //======== panelTree ========
        {
            panelTree.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(
                    0, 0, 0, 0), "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder
                    .BOTTOM, new java.awt.Font("", java.awt.Font.BOLD, 12), Color.
                    gray), panelTree.getBorder()));
            panelTree.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                @Override
                public void propertyChange(java.
                                                   beans.PropertyChangeEvent e) {
                    if ("".equals(e.getPropertyName())) throw new RuntimeException();
                }
            });
            panelTree.setLayout(new BorderLayout());

            //======== scrollPanelTree ========
            {

                //---- tree ----
                tree.setModel(new DefaultTreeModel(
                        new DefaultMutableTreeNode("Empty") {
                            {
                            }
                        }));
                tree.setShowsRootHandles(true);
                scrollPanelTree.setViewportView(tree);
                buttonOpenPath.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        toolBarSpacer.setText("                     ");
                        chooseFolder();

                    }
                });

                buttonRefresh.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        toolBarSpacer.setText("                              ");
                    }
                });
            }
            panelTree.add(scrollPanelTree, BorderLayout.CENTER);

            //======== tooLBar ========
            {
                tooLBar.setFloatable(false);
                tooLBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

                //---- buttonOpenPath ----
                buttonOpenPath.setIcon(new ImageIcon(getClass().getResource("/openpPath.png")));
                tooLBar.add(buttonOpenPath);

                //---- buttonRefresh ----
                buttonRefresh.setIcon(new ImageIcon(getClass().getResource("/refreshFolder.png")));
                tooLBar.add(buttonRefresh);
            }
            panelTree.add(tooLBar, BorderLayout.NORTH);

            //---- toolBarSpacer ----
            toolBarSpacer.setText("                                       ");
            panelTree.add(toolBarSpacer, BorderLayout.SOUTH);
        }
        contentPane.add(panelTree, BorderLayout.WEST);

        //======== panelTextTabs ========
        {
            panelTextTabs.setLayout(new BorderLayout());

            //======== tabPanel ========
            {

                iTimeDate.setEnabled(false);
                //======== panelTextArea ========
                {
                    panelTextArea.setLayout(new BorderLayout());

                    //======== scrollPanelTextArea ========
                    {

                        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
                        textArea.setAntiAliasingEnabled(true);

                        textArea.setCodeFoldingEnabled(true);
                        panelTextArea.add(scrollPanelTextArea);

                    }
                    panelTextArea.add(scrollPanelTextArea, BorderLayout.CENTER);
                    panelTextArea.add(findToolBar, BorderLayout.NORTH);


                    findToolBar.setVisible(false);

                    //\\\\\\\\\\\\\\ FInd
                    // it will be set visible when selected in the find menu
                    //panelTree  tooLBar

                    //They will be hiden for now
                    panelTree.setVisible(false);
                    tree.addMouseListener(new PopClickListener(this));
                    tooLBar.addMouseListener(new PopClickListener(this));
                    panelTree.addMouseListener(new PopClickListener(this));

                }//The panel Text Area is created when you open a file worry about the containing of the panel

            }

            panelTextTabs.add(tabPanel, BorderLayout.CENTER);

            file.newFile();



            // Main Menu


        }
        contentPane.add(panelTextTabs, BorderLayout.CENTER);
        setSize(700, 470);
        setLocationRelativeTo(getOwner());




        //========= ACTION LISTENERS ============

        //--------- FILE MENU --------
        iOpen.addActionListener(this::actionPerformed);
        iOpen.setActionCommand("open");
        iOpenFolder.addActionListener(this::actionPerformed);
        iOpenFolder.setActionCommand("openFolder");
        iNew.addActionListener(this::actionPerformed);
        iNew.setActionCommand("new");
        iNewWindow.addActionListener(this::actionPerformed);
        iNewWindow.setActionCommand("newWindow");
        iSave.addActionListener(this::actionPerformed);
        iSave.setActionCommand("save");
        iSaveAs.addActionListener(this::actionPerformed);
        iSaveAs.setActionCommand("saveAs");
        iAutoSave.addActionListener(this::actionPerformed);
        iAutoSave.setActionCommand("autoSave");
        menuSettings.addActionListener(this::actionPerformed);
        menuSettings.setActionCommand("settings");
        iExportPDF.addActionListener(this::actionPerformed);
        iExportPDF.setActionCommand("pdf");
        iPrint.addActionListener(this::actionPerformed);
        iPrint.setActionCommand("print");
        iExit.addActionListener(this::actionPerformed);
        iExit.setActionCommand("exit");

        iFind.addActionListener(this::actionPerformed);
        iFind.setActionCommand("find");
        // languages
        iJava.addActionListener(this::actionPerformed);
        iJava.setActionCommand("java");
        iC.addActionListener(this::actionPerformed);
        iC.setActionCommand("c");
        iXml.addActionListener(this::actionPerformed);
        iXml.setActionCommand("xml");

        iRefresh.addActionListener(this::actionPerformed);
        iRefresh.setActionCommand("refresh");


        toDo.addActionListener(this::actionPerformed);
        toDo.setActionCommand("toDo");
    }


    public JMenuBar menuBar;
    public JMenu menuFile;
    public JMenuItem iOpen;
    public JMenuItem iOpenFolder;
    public JMenuItem iNew;
    public JMenuItem iNewWindow;
    public JMenuItem iSave;
    public JMenuItem iSaveAs;
    public JCheckBoxMenuItem iAutoSave;
    public JMenu menuLanguages;
    public JMenuItem title;
    public JMenuItem iJava;
    public JMenuItem iC;
    public JMenuItem iXml;
    public JMenuItem menuSettings;
    public JMenuItem iPrint;
    public JMenuItem iExportPDF;
    public JMenuItem iExit;
    public JMenu menuEdit;
    public JMenuItem willDelete;
    public JMenuItem iFind;
    public JMenuItem iReplace;
    public JMenuItem iTimeDate;
    public JMenuItem menuSpacer;
    public JButton buttonStop;
    public JButton ButtonStart;
    public JPanel panelTree;
    public JScrollPane scrollPanelTree;
    public JTree tree;
    public JToolBar tooLBar;
    public JButton buttonOpenPath;
    public JButton buttonRefresh;
    public JLabel toolBarSpacer;
    public JPanel panelTextTabs;
    public JTabbedPaneCloseButton tabPanel;
    public function_File file;
    public settingsGUI settingsGUI = new settingsGUI(this, this);
    public JPanel panelTextArea = new JPanel(new BorderLayout());
    public RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);
    public RTextScrollPane scrollPanelTextArea = new RTextScrollPane(textArea);
    private JMenuItem iRefresh;
    private Settings settings = new Settings();
    private KeyHandler keyHander;
    private JMenu About;
    private JMenuItem toDo;

    private     String futurePlanString;
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "open":
                System.out.println("open");
                file.open();
                break;
            case "openFolder":
                System.out.println("openFolder"); //OFF
                panelTree.setVisible(true);

                /*
                        Then Show the folder Selection
                        And load it into the JTree
                     */
                break;
            case "new":
                System.out.println("new");
                file.newFile();
                break;
            case "newWindow":
                System.out.println("newWindow");// OFF
                break;
            case "save":
                System.out.println("save");
                file.save();
                break;
            case "saveAs":
                System.out.println("saveAs");
                file.saveAs();
                break;
            case "autoSave":
                System.out.println("autoSave");

                break;
            case "settings":
                System.out.println("settings");
                openSettings();
                break;
            case "refresh":
                refreshProgram("No further plans");
                break;

            case "pdf":
                System.out.println("pdf");

                break;
            case "print":
                System.out.println("print");

                break;
            case "exit":
                System.out.println("exit");
                file.exit();
                break;
            case "java":
                System.out.println("java");

                break;
            case "c":
                System.out.println("c");

                break;
            case "xml":
                System.out.println("xml");

                break;
            case "find":
                System.out.println("find");
                addFind();
                break;
            case "timeDate":
                System.out.println("timeDate");

                break;
            case "findReplace":
                System.out.println("findReplace");

                break;
            case "toDo":
                System.out.println("To do");
                showInfo();
                tabPanel.addTab("Menu", new mainPanel(this, futurePlanString));





                break;

        }
    }

    public void refreshProgram(String futurePlanString){
        try {
            this.dispose();
            settings.createGUI(futurePlanString);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    public void addFind() {
        if (findToolBar.isVisible()) {
            findToolBar.setVisible(false);
        } else {
            findToolBar.setVisible(true);
        }

    }

    public void openSettings() {
        settingsGUI.setVisible(true);
        settingsGUI.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        try{ settingsGUI.setSelectedTheme();
            settingsGUI.setSelectedFontType();
        }catch (Exception e){} }

    public String getThemeSelected() {
        String varName = (String) settingsGUI.themeComboBox.getSelectedItem();
        return varName;
    }

    private static JMenuItem createMenuItem(Action action) {
        JMenuItem item = new JMenuItem(action);
        item.setToolTipText(null); // Swing annoyingly adds tool tip text to the menu item
        return item;
    }

    public JToolBar findToolBar = new JToolBar();
    private JTextField searchField = new JTextField();
    private final JButton nextButton = new JButton();
    private JButton prevButton = new JButton();
    private JCheckBox regexCB = new JCheckBox();
    private JCheckBox matchCaseCB = new JCheckBox();
    private JButton exitFind = new JButton();

    public void createToolBar() {
    	
        findToolBar.add(searchField);

        //---- button2 ----
        nextButton.setText("Find Next");
        findToolBar.add(nextButton);

        //---- button1 ----
        prevButton.setText("Find Previous");
        findToolBar.add(prevButton);

        //---- checkBox1 ----
        regexCB.setText("Regex");
        findToolBar.add(regexCB);

        //---- checkBox2 ----
        matchCaseCB.setText("Match case");
        findToolBar.add(matchCaseCB);

        exitFind.setText("Exit");
        findToolBar.add(exitFind);


        exitFind.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addFind();
            }
        });

        searchField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Search field being used");

                // "FindNext" => search forward, "FindPrev" => search backward
                String command = e.getActionCommand();
                boolean forward = "FindNext".equals(command);

                // Create an object defining our search parameters.
                SearchContext context = new SearchContext();
                String text = searchField.getText();
                if (text.length() == 0) {
                    return;
                }
                context.setSearchFor(text);
                context.setMatchCase(matchCaseCB.isSelected());
                context.setRegularExpression(regexCB.isSelected());
                context.setSearchForward(forward);
                context.setWholeWord(false);

                boolean found = SearchEngine.find(textArea, context).wasFound();
                if (!found) {
                    JOptionPane.showMessageDialog(searchField, "Text not found");// It was this not textArea
                }
            }
        });

    }


    public void showInfo() {
        JOptionPane.showMessageDialog(this,
                        "Thank you for trying my program Out from Boyo!\n",
                "Info Version: 5.9.3",
                JOptionPane.ERROR_MESSAGE);
    }

JFileChooser chooser;
    public void chooseFolder(){

        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //
        // disable the "All files" option.
        //
        chooser.setAcceptAllFileFilterUsed(false);
        //
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): "
                    +  chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : "
                    +  chooser.getSelectedFile());
        }
        else {
            System.out.println("No Selection ");
        }
        panelTree.remove(scrollPanelTree);

        panelTree.add(new FileTree(new File(String.valueOf(chooser.getSelectedFile())), this), BorderLayout.CENTER);
        repaint();
    }
}

 class FileTree extends JPanel {
    /** Construct a FileTree */

    GUI gui;
    public FileTree(File dir, GUI gui) {
        this.gui=gui;
        setLayout(new BorderLayout());

        // Make a tree list with all the nodes, and make it a JTree
        JTree tree = new JTree(addNodes(null, dir));

        // Add a listener
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) e
                        .getPath().getLastPathComponent();

                if (node.toString().contains(".java")||node.toString().contains(".txt")//Writing Type
                ||node.toString().contains(".xml")||node.toString().contains(".html") ){
                    System.out.println("File supported:  " + node);

                   TreePath eaf = tree.getSelectionPath();
                   System.out.println(eaf+"\n\n");

                   /*
                   Here is where we Open file
                   by getting the path
                    */
                    String nodePath = String.valueOf(eaf.getParentPath());
                    System.out.println("Before: "+nodePath);
                    nodePath = nodePath.replaceAll("[\\[\\]\\(\\)]", "");
                    System.out.println("After: "+nodePath);
                    
                    gui.file.openFromTree(nodePath+"\\",node.toString());

                }else if (node.toString().contains(".jpeg")||node.toString().contains(".png")){//Images
                    System.out.println("Image Selected");
                }else{
                    System.out.println("You selected:  " + node);
                } }});

        // Lastly, put the JTree into a JScrollPane.
        JScrollPane scrollpane = new JScrollPane();
        scrollpane.getViewport().add(tree);
        add(BorderLayout.CENTER, scrollpane);

        final File homeName = new File(System.getProperty("user.home"));
        String settingsPath = homeName+"\\editorStaff\\Settings\\settingsSave.txt";

        try {
            String selected = Files.readAllLines(Paths.get(settingsPath)).get(0);

            switch (selected) {
                case"FlatLightLaf.xml":
                    break;
                case"DarkFlat.xml":
                    tree.setBackground(new Color(45,45,45));
                    break;

                case"Carbon.xml":
                    break;

                case"DeepSeaOcean.xml":
                    break;

                case"materialDesignDark.xml":
                    break;

                case"HighContrast.xml":
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /** Add nodes from under "dir" into curTop. Highly recursive. */
    DefaultMutableTreeNode addNodes(DefaultMutableTreeNode curTop, File dir) {
        String curPath = dir.getPath();
        DefaultMutableTreeNode curDir = new DefaultMutableTreeNode(curPath);
        if (curTop != null) { // should only be null at root
            curTop.add(curDir);
        }
        Vector ol = new Vector();
        String[] tmp = dir.list();
        for (int i = 0; i < tmp.length; i++)
            ol.addElement(tmp[i]);
        Collections.sort(ol, String.CASE_INSENSITIVE_ORDER);
        File f;
        Vector files = new Vector();
        // Make two passes, one for Dirs and one for Files. This is #1.
        for (int i = 0; i < ol.size(); i++) {
            String thisObject = (String) ol.elementAt(i);
            String newPath;
            if (curPath.equals("."))
                newPath = thisObject;
            else
                newPath = curPath + File.separator + thisObject;
            if ((f = new File(newPath)).isDirectory())
                addNodes(curDir, f);
            else
                files.addElement(thisObject);
        }

        // Pass two: for files.
        /*
         * Pass two: for files.
         */
        for (int fnum = 0; fnum < files.size(); fnum++)
            curDir.add(new DefaultMutableTreeNode(files.elementAt(fnum)));
        return curDir;

    }

    public Dimension getMinimumSize() {
        return new Dimension(200, 400);
    }

    public Dimension getPreferredSize() {
        return new Dimension(200, 400);
    }
}

