package com.applications.tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.applications.LogsManager;
import com.applications.User;
import com.applications.Utils;

/**
 * Logs manager tests.
 * @author kevin
 *
 */
public class LogsManagerTests {
    /**
     * Tasks manager.
     */
    private transient LogsManager logsManager;

    @Before
    public void beforeTests() {
        logsManager = new LogsManager(new User("Test"));
        logsManager.deleteLogsFile();
        Utils.inTest = true;
    }

    @Test
    public void logsEmpty() {
        logsManager.deleteLogsFile();

        List<String> logs = logsManager.getLogsFromFile();

        Assert.assertTrue(logs.isEmpty());
    }

    @Test
    public void getUsersFilled() {
        logsManager.deleteLogsFile();

        logsManager.addLog("un log");

        List<String> logs = logsManager.getLogsFromFile();

        Assert.assertFalse(logs.isEmpty());
    }

}
