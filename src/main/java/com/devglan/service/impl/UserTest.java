package com.devglan.service.impl;

import static org.junit.Assert.assertEquals;

//import static org.mockito.Mockito.*;

import org.apache.catalina.users.MemoryUserDatabase;
import org.junit.Test;

/**
 * @author AMRI
 *  @Mock
	 MemoryUserDatabase databaseMock; 

	 @Rule public MockitoRule mockitoRule = MockitoJUnit.rule(); 

	  @Test
	    publicvoid testQuery()  {
		  UserServiceImpl t  = new UserServiceImpl(databaseMock); 
	        boolean check = t.query("* from t"); 
	        assertTrue(check); 
	        verify(databaseMock).query("* from t"); 
	    }
 *
 */
public class UserTest {
	
	
	@Test
	public void testAuthentificaton() {
		UserServiceImpl test = new UserServiceImpl();
	   // boolean result = test.authentificate("amri","devglan");
	   // assertEquals(true,result);
	    assert(test.authentificate("admin","1234"));
	}
	
	

}
