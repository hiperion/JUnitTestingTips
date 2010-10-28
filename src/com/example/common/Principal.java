package com.example.common;

import org.apache.log4j.Logger;
import org.junit.Rule;
import org.junit.rules.TestWatchman;
import org.junit.runners.model.FrameworkMethod;

public class Principal {

	@Rule
	public TestWatchman watchman = new TestWatchman() {
			public void starting(FrameworkMethod method) {
				log.info("Being run..." + method.getName());
			}
		};
	protected static Logger log = Logger.getLogger(Class.class);

	public Principal() {
		super();
	}

}