package com.myBean;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CheckPhoneTest {

	boolean result = true;
	String input = "";
	
	@Parameters
	public static Collection<Object[]> t(){
		return Arrays.asList(new Object[][]{
			{true,"15967153342"},
			{false,"12345678912"},
			{false,"23453425"},
			{false,"你好"},
			{false,"napdk"}
		});
		
	}
	
	public CheckPhoneTest(boolean result,String input){
		this.result=result;
		this.input=input;
	}
	
	@Test
	public void testIsPhone() {
		assertEquals(result, new CheckPhone().isPhone(input));
	}

}
