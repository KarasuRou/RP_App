package logic.updater;

import UI.Main;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Updater {

    private boolean available = false;
    private File file;
    private URL url;
    private String[] paths;
    private String newVersion;

    public Updater(){
        try {
            paths = getPaths();
            file = new File(paths[0]);
            url = new URL(paths[1] + "version.txt");
            checkUpdateAvailability();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String[] getPaths() throws Exception{
        File configFile = new File("application.conf");
        Scanner scanner = new Scanner(configFile);
        int i = 0;
        String[] paths = new String[2];
        while (scanner.hasNext() && i != 2){
            String string = scanner.nextLine();
            if (string.contains("updater.file:")) {
                string = string.replaceAll("\\s","").replace("updater.file:", "");
                paths[i++] = string;
            } else if (string.contains("updater.url:")) {
                string = string.replaceAll("\\s","").replace("updater.url:", "");
                paths[i++] = string;
            }
        }
        return paths;
    }

    private void checkUpdateAvailability() throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputLine;
        String versionText = "";
        while ((inputLine = input.readLine()) != null){versionText += inputLine;}
        input.close();

        Scanner scanner = new Scanner(file);
        String thisVersionText = "";
        while (scanner.hasNext()) {thisVersionText += scanner.nextLine();}
        scanner.close();
        if (Double.parseDouble(versionText) > Double.parseDouble(thisVersionText)){available = true;newVersion = versionText;}
        else {available = false;}
    }

    public boolean isUpdateAvailable(){
        return available;
    }

    public void loadUpdate() throws Exception{
        BufferedInputStream in = new BufferedInputStream(new URL(paths[1] + newVersion + "/RP_Application.jar").openStream());
        FileOutputStream fileOutputStream = new FileOutputStream("RP_Application.jar");
        byte[] dataBuffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
            fileOutputStream.write(dataBuffer, 0, bytesRead);
        }
        fileOutputStream.close();
        in.close();
    }

    public void update() throws Exception{
        FileWriter fileWriter = new FileWriter("version.txt",false);
        fileWriter.write(newVersion+"\n");
        fileWriter.close();
    }

    public void restart() throws Exception {
        String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        File currentJar = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI());

        if(!currentJar.getName().endsWith(".jar"))
            return;

        ArrayList<String> command = new ArrayList<>();
        command.add(javaBin);
        command.add("-jar");
        command.add(currentJar.getPath());

        ProcessBuilder builder = new ProcessBuilder(command);
        builder.start();
        System.exit(0);
    }
}
