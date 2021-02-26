import org.fife.rsta.ac.LanguageSupportFactory;
import org.fife.rsta.ac.java.JavaLanguageSupport;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author Boyo
 */
public class function_File {
    GUI gui;
    String fileName;
    String fileAdress;
    boolean isSaved = false;

    public function_File(GUI gui){
        this.gui = gui;


    }
/*
 //Custom button text
        Object[] options = {"Yes, please",
                "No, thanks",
                "Cancel"};

        int n = JOptionPane.showOptionDialog(this, message, title,
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[2]);
 */
int wishToSave;

    public void newFile(){


        LanguageSupportFactory lsf = LanguageSupportFactory.get();
        JavaLanguageSupport support = (JavaLanguageSupport)lsf.
                getSupportFor(SyntaxConstants.SYNTAX_STYLE_JAVA);
        LanguageSupportFactory.get().register(gui.textArea);
        if (!gui.textArea.getText().isEmpty()
                && fileAdress == null&&fileName == null){
            //File Doesn't exist but text area is not empty
            Object[] options = {"Yes",
                    "No",
                    "Cancel"};

            wishToSave = JOptionPane.showOptionDialog(null,
                    "Do you wish to save this file?", "save",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, options, options[2]);

            if (wishToSave == JOptionPane.NO_OPTION){
                createNew();
            }else if (wishToSave == JOptionPane.YES_OPTION){
                saveAs();
                createNew();
            }else if (wishToSave == JOptionPane.CANCEL_OPTION){
                System.out.println("Canceled: New File");
            }

        }else if (fileAdress != null&&fileName != null){
            //File exists
            Object[] options = {"Yes", "No", "Cancel"};
            wishToSave = JOptionPane.showOptionDialog(null,
                    "Do you wish to save" +
                            "changes done to: "+fileAdress+fileName, "Save " + fileName +" ?",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, options, options[2]);

            if (wishToSave == JOptionPane.NO_OPTION){
                createNew();
            }else if (wishToSave == JOptionPane.YES_OPTION){
                save();
                gui.tabPanel.addTab("NewFile", gui.panelTextArea);
                createNew();
            }else if (wishToSave == JOptionPane.CANCEL_OPTION){
                System.out.println("Canceled: New File");
            }
        }else{
            ;//Add tab
            createNew();
        }

    }
    private void createNew(){//NEwFile

        isSaved =false;
        gui.textArea.setText("");
        gui.setTitle("Editor: New File");
        fileName = null;
        fileAdress = null;
        gui.tabPanel.addTab("NewFile", gui.panelTextArea);

        try{
            gui.settingsGUI.createFontSettings();
            gui.settingsGUI.addSetUpFontSize();
            gui.settingsGUI.setFontType();

        }catch (Exception e){ System.out.println(e);}

    }

    // Add a way to check, if there is text in the window, Ask if they still want to makea new file.
    public void open(){
        if (fileAdress != null & fileName != null){
            save();
        }

        FileDialog fd = new FileDialog(gui, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        if(fd.getFile()!=null){
            fileName = fd.getFile();
            fileAdress =fd.getDirectory();
            gui.setTitle(fileName);
            gui.tabPanel.addTab(fileName, gui.panelTextArea);//Add tab
            LanguageSupportFactory.get().register(gui.textArea);

        }

        try{
            gui.settingsGUI.createFontSettings();
            gui.settingsGUI.addSetUpFontSize();
            gui.settingsGUI.setFontType();
        }catch (Exception e){ System.out.println(e);}


        System.out.println("\t\nFile address: " + fileAdress +"\t\nFile name: " + fileName);
        //
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileAdress+ fileName)); // The address of a file is required to reda  a file.

            gui.textArea.setText("");

            String line = null;

            while((line = br.readLine()) !=null){
                gui.textArea.append(line+ "\n");
            }
            br.close();

        }catch (Exception e){
            System.out.println("FILE NOT OPENED");

        }
        //
    }

    public void openFromTree(String fullDirectory, String nodeName){
        if (fileAdress != null & fileName != null){
            save();
        }
            fileName = nodeName;
            fileAdress =fullDirectory;
            gui.setTitle(fileName);
            gui.tabPanel.addTab(fileName, gui.panelTextArea);//Add tab
            LanguageSupportFactory.get().register(gui.textArea);

        try{
            gui.settingsGUI.createFontSettings();
            gui.settingsGUI.addSetUpFontSize();
            gui.settingsGUI.setFontType();
        }catch (Exception e){ System.out.println(e);}


        System.out.println("\t\nFile address: " + fileAdress +"\t\nFile name: " + fileName);
        //
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileAdress+fileName)); // The address of a file is required to reda  a file.

            gui.textArea.setText("");

            String line = null;

            while((line = br.readLine()) !=null){
                gui.textArea.append(line+ "\n");
            }
            br.close();

        }catch (Exception e){
            System.out.println("FILE NOT OPENED");

        }
        //
    }
    public void save(){

        System.out.println("Save");
        isSaved = true;
        if(fileName==null){
            saveAs();
        }else{
            try{
                FileWriter fw = new FileWriter(fileAdress+fileName);
                fw.write(gui.textArea.getText());
                gui.setTitle(fileName);
                fw.close();

            }catch (Exception e){
                System.out.println("SOMETHING IS WRONG! Check the save filing.");
            }
        }
    }
    public void saveAs(){

            System.out.println("SAVE AS");
        FileDialog fd = new FileDialog(gui, "Save", FileDialog.SAVE);
        fd.setVisible(true);

        if(fd.getFile()!=null){
            fileName = fd.getFile();
            fileAdress = fd.getDirectory();

            gui.setTitle(fileName);
            isSaved = true;
        }

        try{
            FileWriter fw = new FileWriter(fileAdress+fileName);
            fw.write(gui.textArea.getText());
            fw.close();
        }catch (Exception e){
            System.out.println("SOMETHING IS WRONG! Check the save as filing.");
        }

    }

    public void exit(){
        if (fileName == null && fileAdress == null && gui.textArea.getText().isEmpty()){
            //Nothing was done, nothing exists
            System.exit(0);
        }else if(fileName == null && fileAdress == null && !gui.textArea.getText().isEmpty()){
            // File does not exist but it has content
            int n = JOptionPane.showConfirmDialog(null, "" +
                            "Do you wish to save this file?", "Save this file?",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (n == JOptionPane.NO_OPTION){// Exit without saving
                System.exit(0);
            }else if (n == JOptionPane.YES_OPTION){// Save
                saveAs();
                System.exit(0);
            }else {// Answer does not equal yes or no
                System.out.println("Exit: Canceled");
            }

        }else if (fileName != null && fileAdress != null ){ //File exists and it is not empty
            //Now check if it was already saved
            save();
            System.exit(0);
        }
    }

    public void setFileAdress(String fileAdress) {
        this.fileAdress = fileAdress;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setSaved(boolean saved) {
        isSaved = saved;
    }
}
