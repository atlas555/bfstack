package com.bf.blog.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActionLogPrinter extends LogPrinter {

	private static final Logger logger = LoggerFactory.getLogger(ActionLogPrinter.class);
	
	public static ActionLogPrinter getInstance() {
		return NestedClass.instance;
	}

	private static class NestedClass {
		private static ActionLogPrinter instance = new ActionLogPrinter();
	}

	@Override
	protected void doLog(String log) {
		logger.info(log);
	}
}
