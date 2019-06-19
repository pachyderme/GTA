package com.applications;
import org.junit.Assert;
import org.junit.Test;

public class TestUser {
	@Test
	public void connection() {
		Application application = new Application();
		String name = "Kevin";
		User userConnected = application.connection(name);
	    Assert.assertEquals(userConnected.name,name);
	    
	}
}
