package ntz.testlink;

import java.net.URL;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.model.TestProject;
import ntz.exceptions.TestlinkException;

public abstract class ATestlink implements ITestlink {

	/***/
	public TestLinkAPI api = null;
	
	/***/
	private TestProject[] testProjects = null;
	
	/***/
	public ATestlink() throws TestlinkException{		
		throw new TestlinkException("[ATestlink][ERROR]: Constructor not allowed");
	}
	
	/***/
	public ATestlink(String url, String devKey) throws TestlinkException{		
		if(url.length() < 0 && devKey.length() < 0){throw new TestlinkException("[ATestlink][ERROR]: Bad url or developer key");}
		else{
			load(url,devKey);
		}
			
	}
	
	/**
	 * 
	 * @example: URL --> http://IP:PORT/lib/api/xmlrpc/v1/xmlrpc.php
	 * */
	@Override
	public boolean load(String url, String devKey) throws TestlinkException{
		boolean isLoaded = false;
		try {								
			this.api = new TestLinkAPI(new URL(url), devKey);			
			/// Load properties
			this.testProjects = this.api.getProjects();
			isLoaded = true;
		} catch (Exception e) {
			isLoaded = false;
			throw new TestlinkException("[ATestlink][ERROR]: at try to instance testlinkAPI");			
		}
		return isLoaded;
	}	
	
	/***/
	@Override
	public TestProject[] getAllTestCases() throws TestlinkException{
		return this.testProjects;
	}
}
