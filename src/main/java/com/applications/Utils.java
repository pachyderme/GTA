package com.applications;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Utils class.
 * 
 * @author GTA
 */
public class Utils {
    public static boolean inTest = false;
    public static String responseSubstitute = "";

    /**
     * Get the user response from command line.
     * 
     * @return
     */
    public static String getUserResponse() {

        if (!inTest) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                return br.readLine().trim();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            return responseSubstitute;
        }

        return null;
    }

    /**
     * Display a message to the output.
     * 
     * @param message
     */
    public static void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Log a message.
     * 
     * @param message
     */
    public static void logMessage(String message) {
        System.out.println("[" + message + "]");
    }
}
