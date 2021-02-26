import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatHighContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatMaterialDesignDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDeepOceanContrastIJTheme;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.Theme;

import javax.annotation.processing.SupportedSourceVersion;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 * @author Boyo
 */
public class Settings {

    final File homeName = new File(System.getProperty("user.home"));
    String settingsPath = homeName+"\\editorStaff\\Settings\\settingsSave.txt";

    public void createGUI(String futurePlanString) throws IOException {

        String selected = Files.readAllLines(Paths.get(settingsPath)).get(0);
        switch (selected){//
            case"FlatLightLaf.xml":
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        FlatLightLaf.install();
                        GUI gui = new GUI(futurePlanString);
                        gui.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                        gui.setVisible(true);

                        changeStyleViaThemeXml(gui.textArea, "Themes/FlatLightLaf.xml");

                    }
                });
                break;
            case"DarkFlat.xml":
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        FlatDarkLaf.install();

                        GUI gui = new GUI(futurePlanString);
                        gui.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                        gui.setVisible(true);
                        changeStyleViaThemeXml(gui.textArea, "Themes/DarkFlat.xml");

                        gui.panelTree.setBackground(new Color(49,49,49));
                        gui.tooLBar.setBackground(new Color(49,49,49));
                        gui.panelTextTabs.setBackground(new Color(49,49,49));
                        gui.tree.setBackground(new Color(45,45,45));

                    }
                });
                break;
            case"Carbon.xml":
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        FlatCarbonIJTheme.install();
                        GUI gui = new GUI(futurePlanString);
                        gui.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                        gui.setVisible(true);
                        changeStyleViaThemeXml(gui.textArea, "Themes/Carbon.xml");

                    }
                });
                break;
            case"DeepSeaOcean.xml":
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        FlatMaterialDeepOceanContrastIJTheme.install();
                        GUI gui = new GUI(futurePlanString);
                        gui.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                        gui.setVisible(true);
                        changeStyleViaThemeXml(gui.textArea, "Themes/DeepSeaOcean.xml");
                        gui.scrollPanelTextArea.setBorder(null);
                    }
                });
                break;
            case"materialDesignDark.xml":
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        FlatMaterialDesignDarkIJTheme.install();
                        GUI gui = new GUI(futurePlanString);
                        gui.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                        gui.setVisible(true);
                        changeStyleViaThemeXml(gui.textArea, "Themes/materialDesignDark.xml");
                    }
                });
                break;
            case"HighContrast.xml":
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        FlatHighContrastIJTheme.install();
                        GUI gui = new GUI(futurePlanString);
                        gui.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                        gui.setVisible(true);
                        changeStyleViaThemeXml(gui.textArea, "Themes/HighContrast.xml");
                    }
                });
                break;
        }
        /*
            After Selecting The Settings
            Next Time you load the program the theme will be set
            By selecting a theme it writes it down in the file

         */
    }
    private void changeStyleViaThemeXml(RSyntaxTextArea textArea, String fileStringXml) {
        try {
            Theme theme = Theme.load(getClass().getResourceAsStream(
                    fileStringXml));
            theme.apply(textArea);
        } catch (IOException ioe) { // Never happens
            ioe.printStackTrace();
        }
    }
    public void getPath(String fileToPath){
        File fileFindPath = new File(fileToPath);
        System.out.println("This is the name: "+fileFindPath.getAbsoluteFile());
        System.out.println("This is the path: "+fileFindPath.getAbsolutePath());
    }


    private void createUserDir(final String dirName) throws IOException {//Create folders
        final File homeDir = new File(System.getProperty("user.home"));
        final File dir = new File(homeDir, dirName);
        System.out.println("Created");
        if (!dir.exists() && !dir.mkdirs()) {
            throw new IOException("Unable to create " + dir.getAbsolutePath());
        }
    }
}
