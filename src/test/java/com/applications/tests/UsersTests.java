package com.applications.tests;

import org.junit.Assert;
import org.junit.Test;

import com.applications.User;

/**
 * Users tests class.
 * @author GTA
 */
public class UsersTests {
    @Test
    public void user() {
        User user = new User("kevin");
        
        user.getType();
        user.setType("Type");
        user.getName();
        user.setName("Kevin");
        user.getId();
        user.setId(0);
        
        Assert.assertEquals(user.getName(), "Kevin");
    }
}
