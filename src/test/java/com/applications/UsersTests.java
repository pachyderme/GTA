package com.applications;

import org.junit.Assert;
import org.junit.Test;

public class UsersTests {
    @Test
    public void adminExists() {
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
