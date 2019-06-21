package com.applications;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Files manager class.
 * @author kevin
 *
 */
public class FilesManager {

    public static ArrayList<String> readFile (String path) {
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
                e.printStackTrace();
            } finally {
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return results;
    }
    
    /**
     * Save the lines in the file.
     * @param <T>
     * 
     * @param users
     */
    public static <T> void saveItemsInFile(String path, ArrayList<T> items) {
        try {
            FileOutputStream fos = new FileOutputStream(path);

            try {
                Iterator<T> it = items.iterator();
                while (it.hasNext()) {
                    Object item = it.next();
                    byte[] outputResult = String.join(";", item.toString()).getBytes();
                    fos.write(outputResult);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fos != null) {
                        fos.flush();
                        fos.close();
                    } else {
                        Utils.logMessage("fileOutPutStream déjà vide");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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
                e.printStackTrace();
            }
        }
    }
}
