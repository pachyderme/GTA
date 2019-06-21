package com.applications;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import static java.lang.System.out;
/**
 * Utils class.
 * 
 * @author GTA
 */
public class Utils {
    private static boolean inTest = false;
    private static String responseSubstitute = "";

    /**
     * Get the user response from command line.
     * 
     * @return
     */
    public static String getUserResponse() {

        if (!inTest) {
            InputStreamReader inputReader = 
                    new InputStreamReader(System.in, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(inputReader);
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
        out.println(message);
    }

    /**
     * Log a message.
     * 
     * @param message
     */
    public static void logMessage(String message) {
        out.println("[" + message + "]");
    }

    public static boolean isInTest() {
        return inTest;
    }

    public static void setInTest(boolean inTest) {
        Utils.inTest = inTest;
    }

    public static String getResponseSubstitute() {
        return responseSubstitute;
    }

    public static void setResponseSubstitute(String responseSubstitute) {
        Utils.responseSubstitute = responseSubstitute;
    }
}
