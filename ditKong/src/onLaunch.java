import java.awt.desktop.SystemEventListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
/**
 * @author Boyo
 */
public class onLaunch {
    public onLaunch(boolean Create, String futurePlanString) throws IOException {

        if (Create){
            checkForExist(futurePlanString);
        }else{
            System.out.println("Just want adds");
        }

    }

    private void checkForExist(String futurePlanString) throws IOException {
        final File homeName = new File(System.getProperty("user.home"));
        String folderName = "editorStaff\\Settings";
        final File dir = new File(homeName, folderName);
        Path path = Path.of(String.valueOf(dir));


        if (Files.exists(path)) {
            System.out.println("Directory exists\n\n");
            System.out.println("Launching Editor");

            Settings open = new Settings();
            open.createGUI(futurePlanString);

        }else{
            System.out.println("Directory Does not exist");
            System.out.println("Creating Directory....");
            createUserDir("editorStaff\\Settings");

            /*
            Now Create the file
            with Default settings

            Carbon.xml
            Font: Type: Size
            arial
            242

             */
            try {//Tries to create file
                File settingFile = new File(dir+"\\"+"settingsSave.txt");
                if (settingFile.createNewFile()) {
                    System.out.println("File created: " + settingFile.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            try {//Writes Default Settings
                FileWriter myWriter = new FileWriter(dir+"\\"+"settingsSave.txt");
                myWriter.write("FlatLightLaf.xml\n" +
                        "Font: Type: Size\n" +
                        "Consolas\n" +
                        "14\n");
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            System.out.println("Launching Editor");
            Settings open = new Settings();
            open.createGUI(futurePlanString);

        }
    }


    private void createUserDir(final String dirName) throws IOException {
        final File homeDir = new File(System.getProperty("user.home"));
        final File dir = new File(homeDir, dirName);
        System.out.println("Created");
        if (!dir.exists() && !dir.mkdirs()) {
            throw new IOException("Unable to create " + dir.getAbsolutePath());
        }
    }


}
