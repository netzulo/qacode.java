package ntz.drivers.navs.pages;

import ntz.exceptions.PageException;

public interface IPageSearch {

	void search(String txtSearch);

	void search(String txtSearch, int posBy) throws PageException;

	void search(String txtSearch, String txtBy) throws PageException;	
		
	String getSearchFilter(int posBy) throws PageException;
}
