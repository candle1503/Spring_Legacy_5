package com.coupang.s5;

import static org.junit.Assert.assertNull;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class Test1 extends AbstractTestCase{

	@Autowired
	private DataSource datasource;
	
	@Test
	public void test() throws Exception {
		// assert : 단정문
		assertNull(datasource);
		//assertEquals(1, datasource);
	}
	public void go() {
		
	}
	
}
