package com.applications;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Files manager class.
 * @author kevin
 *
 */
public class FilesManager {

    public static List<String> readFile (String path) {
        ArrayList<String> results = new ArrayList<String>();

        createFileIsNotExists(path);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            try {
                String line = reader.readLine();
                while (line != null) {
                    results.addAll(Arrays.asList(line.split(";")));
                    line = reader.readLine();
                }
            } catch (IOException e) {
                Utils.logMessage(e.toString());
            } finally {
                reader.close();
            }
        } catch (IOException e) {
            Utils.logMessage(e.toString());
        }

        return results;
    }
    
    /**
     * Save the lines in the file.
     * @param <T>
     * 
     * @param users
     */
    public static <T> void saveItemsInFile(String path, List<T> items) {
        try {
            FileOutputStream fos = new FileOutputStream(path);

            try {
                Iterator<T> iterator = items.iterator();
                while (iterator.hasNext()) {
                    Object item = iterator.next();
                    byte[] outputResult = item.toString().getBytes(StandardCharsets.UTF_8);
                    fos.write(outputResult);

                    if (iterator.hasNext()) {                        
                        byte[] separator = ";".getBytes(StandardCharsets.UTF_8);
                        fos.write(separator);
                    }
                }
            } catch (FileNotFoundException e) {
                Utils.logMessage(e.toString());
            } catch (IOException e) {
                Utils.logMessage(e.toString());
            } finally {
                try {
                    if (fos != null) {
                        fos.flush();
                        fos.close();
                    } else {
                        Utils.logMessage("fileOutPutStream déjà vide");
                    }
                } catch (IOException e) {
                    Utils.logMessage(e.toString());
                }
            }
        } catch (IOException e) {
            Utils.logMessage(e.toString());
        }
    }

    /**
     * Delete the file.
     * 
     * @return boolean
     */
    public static boolean deleteFile(String path) {
        File file = new File(path);
        return file.delete();
    }

    /**
     * Check if the file exists.
     * 
     * @return boolean
     */
    public static boolean fileExists(String path) {
        File file = new File(path);
        return file.exists();
    }

    public static void createFileIsNotExists(String path) {
        if (!fileExists(path)) {
            Utils.logMessage("Création du fichier " + path);

            File file = new File(path);
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                Utils.logMessage(e.toString());
            }
        }
    }
}
