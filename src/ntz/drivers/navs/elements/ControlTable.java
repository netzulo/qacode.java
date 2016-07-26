package ntz.drivers.navs.elements;

import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ntz.exceptions.ControlException;
import ntz.tests.errors.ITestErrorMessage;
/**
* @author netzulo.com
* @since 2016-07-25
* @version 0.5.5
* 
* <p></p>
* <p></p>
* <p></p>
*/
public class ControlTable extends ControlBase implements IControl{

	/**Fields************************************************************************************/
	private ControlBase[][] tableGrid;
	private int tableCellsTotal;
	//---	
	private List<WebElement> tableBodyRows;
	private List<WebElement> tableBodyCells;
	private int tableHeight;
	private int tableWidth;
	
	/**Constructors******************************************************************************/
	public ControlTable(WebDriver driver) throws ControlException {
		super(driver);
		throw new ControlException("[ControlTable][WARNING]: constructor without table element can't work, denied constructor");
	}
	
	public ControlTable(WebDriver driver,WebElement currentEle) throws ControlException {
		super(driver, currentEle);		
		if(this.tagName.equalsIgnoreCase("table") == false){
			throw new ControlException(ITestErrorMessage.ERROR_tableWrongTagname);
		}else{
			//Todo OK
			tableLoad();
			tableRead();
		}		
	}

	public ControlTable(WebDriver driver, String cssSelector) throws ControlException {
		super(driver, cssSelector);
		if(this.tagName.equalsIgnoreCase("table") == false){
			throw new ControlException(ITestErrorMessage.ERROR_tableWrongTagname);
		}else{
			//Todo OK
			tableLoad();
			tableRead();
		}		
	}

	/**Private methods***************************************************************************/
	
	/**
	 * Read rows and columns size to set properties of this
	 * @throws ControlException 
	 * */
	private void tableLoad() throws ControlException {
		int tableBodyRowsTotal = -1, tableBodyCellsTotal = -1;
		
		try {				
			this.tableBodyRows = this.element.findElements(By.cssSelector("tr"));
			this.tableBodyCells = this.element.findElements(By.cssSelector("td"));
			
			this.tableHeight = tableBodyRowsTotal = tableBodyRows.size();
			tableBodyCellsTotal = tableBodyCells.size();					
			
			this.tableWidth = tableBodyCellsTotal/tableBodyRowsTotal;					
			//--		
			this.tableGrid = new ControlBase[tableHeight][tableWidth];
			//--	
			this.tableCellsTotal = tableBodyCells.size();
		} catch (Exception e) {
			throw new ControlException(ITestErrorMessage.ERROR_tableLoad);
		}
	}

	private void tableRead() throws ControlException{
		try {
			int extCounter = 0;
			for (int rowPos = 0; rowPos < tableHeight; rowPos++) {				
				for (int cellPos = 0; cellPos < tableWidth; cellPos++) {					
					tableGrid[rowPos][cellPos] = new ControlBase(this.driver,tableBodyCells.get(extCounter));
					extCounter++;
				}
			}			
		} catch (Exception e) {
			throw new ControlException(ITestErrorMessage.ERROR_tableLoad);
		}
	}
	
	/**Protected methods*************************************************************************/
	/**GETs & SETs*******************************************************************************/	
		
	public ControlBase[][] getTableGrid(){
		return this.tableGrid;
	}
	
	public ControlBase getCellFromGrid(int row, int column){
		return tableGrid[row][column];
	}
	
	public boolean isContainOnCell(int row, int column, String textToSearch){		
		String txt = tableGrid[row][column].text;
		
		return txt.contains(textToSearch);
	}
	
	public ControlBase getCellFromList(int cellPosition) throws ControlException{
		return new ControlBase(this.driver,tableBodyCells.get(cellPosition));
	}	
	
	public int getCellsTotal(){
		return this.tableCellsTotal;
	}
		
	public StringBuilder getCellsToStringBuilder(){
		StringBuilder sb = new StringBuilder();
		for (ControlBase[] cell : ((ControlTable)this).getTableGrid()) {
			for (int i = 0; i < cell.length; i++) {
				String txt = cell[i].text;				
				sb.append(txt);
				sb.append("|");
			}
		}		
		return sb;
	}
	
	public Hashtable<Integer,ControlBase> getCellsTotoHashTable(){
		Hashtable<Integer,ControlBase> ht = new Hashtable<>();
		int counter = 0;
		for (ControlBase[] cell : ((ControlTable)this).getTableGrid()) {
			for (int i = 0; i < cell.length; i++) {										
				ht.put(counter, cell[i]);
				counter++;
			}
		}		
		return ht;
	}
	
	public Hashtable<Integer,String> getCellsTotoHashTableText(){
		Hashtable<Integer,String> ht = new Hashtable<>();		
		int counter = 0;
		for (ControlBase[] cell : this.getTableGrid()) {
			for (int i = 0; i < cell.length; i++) {										
				ht.put(counter, cell[i].text);
				counter++;
			}
		}		
		return ht;
	}
	
		
	public boolean isContain(String text){
		boolean isContain = false;
		Hashtable<Integer,String> tbl = getCellsTotoHashTableText();				
		isContain = tbl.containsValue(text);

		return isContain;
	}
	
	public String getCellsToString(){
		StringBuilder sb = new StringBuilder();
		
		for (ControlBase[] cell : this.getTableGrid()) {
			for (int i = 0; i < cell.length; i++) {
				String txt = cell[i].text;				
				sb.append(txt);
			}
		}		
		return sb.toString();
	}
	
}
