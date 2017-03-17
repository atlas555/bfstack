package com.bf.blog.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdminLogPrinter extends LogPrinter {

	private static final Logger logger = LoggerFactory.getLogger(AdminLogPrinter.class);
	
	public static AdminLogPrinter getInstance() {
		return NestedClass.instance;
	}

	private static class NestedClass {
		private static AdminLogPrinter instance = new AdminLogPrinter();
	}

	@Override
	protected void doLog(String log) {
		logger.info(log);
	}
}
