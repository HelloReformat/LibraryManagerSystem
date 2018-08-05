package util;

import java.sql.Connection;

import org.junit.Test;

public class test {

	@Test
	public void test() {
		Connection con =  MysqlUtil.getCon();
	}

}
