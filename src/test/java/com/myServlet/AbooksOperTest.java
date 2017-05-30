package com.myServlet;

import static org.junit.Assert.*;

import org.junit.Test;

public class AbooksOperTest {

	@Test
	public void testCheckSex() {
		assertEquals(true, new AbooksOper().checkSex("男"));
		assertEquals(true, new AbooksOper().checkSex("女"));
		assertEquals(false, new AbooksOper().checkSex("1"));
		assertEquals(false, new AbooksOper().checkSex("你"));
	}
}
