package ntz.testlink;

import ntz.exceptions.TestlinkException;
/**
* @author netzulo.com
* @since 2016-08-05
* @version 0.5.7
*/
public class TestlinkBase extends ATestlink implements ITestlink {

	public TestlinkBase(String url, String devKey) throws TestlinkException {
		super(url, devKey);
	}

	public TestlinkBase() throws TestlinkException {
		super();
	}

}
