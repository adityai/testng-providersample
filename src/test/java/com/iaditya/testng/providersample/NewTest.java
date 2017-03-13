package com.iaditya.testng.providersample;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * TestNG sample to load unique test data based on test method name with one dataProvider
 * 
 * @author adityai
 *
 */
public class NewTest {
	/**
	 * Simple test method that loads test data from the master data provider
	 * 
	 * @param a
	 * @param b
	 */
  @Test(dataProvider="masterDataProvider")
  public void testMethod1(int a, int b) {
	  Assert.assertEquals(a, 1);
	  Assert.assertEquals(b, 1);
  }

	/**
	 * Simple test method that loads test data from the master data provider
	 * 
	 * @param a
	 * @param b
	 */
  @Test(dataProvider="masterDataProvider")
  public void testMethod2(int a, int b) {
	  Assert.assertEquals(a, 2);
	  Assert.assertEquals(b, 2);
  }
  
  /**
   * Single data provider for providing unique data to each test method
   * @param method
   * @return
   */
  @DataProvider(name="masterDataProvider")
  private Object[][] getData(Method method) {
	  Object[][] data = null;
	  
	  if ("testMethod1".equals(method.getName())) {
		  data = new Object[][] {{1,1}};
	  }
	  else if ("testMethod2".equals(method.getName())) {
		  data = new Object[][] {{2,2}};
	  }
	return data;
  }
}
