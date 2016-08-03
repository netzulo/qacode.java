package ntz.testlink;

import ntz.exceptions.TestlinkException;

public class TestlinkBase extends ATestlink implements ITestlink {

	public TestlinkBase(String url, String devKey) throws TestlinkException {
		super(url, devKey);
	}

	public TestlinkBase() throws TestlinkException {
		super();
	}

	
}
