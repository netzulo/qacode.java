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
* @since 2016-07-22
* @version 0.5.1
* 
* <p></p>
* <p></p>
* <p></p>
*/
public class bug_ControlTable extends ControlBase implements IControl{

	/**Fields************************************************************************************/
	private bug_ControlCell[][] tableGrid;
	private int tableCellsTotal;
	//---	
	private List<WebElement> tableBodyRows;
	private List<WebElement> tableBodyCells;
	private int tableHeight;
	private int tableWidth;
	
	/**Constructors******************************************************************************/
	public bug_ControlTable(WebElement currentEle) throws ControlException {
		super(currentEle);		
		if(this.tagName.equalsIgnoreCase("table") == false){
			throw new ControlException(ITestErrorMessage.ERROR_tableWrongTagname);
		}else{
			//Todo OK
			tableLoad();
			tableRead();
		}		
	}

	public bug_ControlTable(WebDriver driver, String cssSelector) throws ControlException {
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
			this.tableBodyRows = this.element.findElements(By.cssSelector("tbody tr"));
			this.tableBodyCells = this.element.findElements(By.cssSelector("tbody td"));
			
			this.tableHeight = tableBodyRowsTotal = tableBodyRows.size();
			tableBodyCellsTotal = tableBodyCells.size();					
			
			this.tableWidth = tableBodyCellsTotal/tableBodyRowsTotal;					
			//--		
			this.tableGrid = new bug_ControlCell[tableHeight][tableWidth];
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
					tableGrid[rowPos][cellPos] = new bug_ControlCell(tableBodyCells.get(extCounter));
					extCounter++;
				}
			}			
		} catch (Exception e) {
			throw new ControlException(ITestErrorMessage.ERROR_tableLoad);
		}
	}
	
	/**Protected methods*************************************************************************/
	/**GETs & SETs*******************************************************************************/	
		
	public bug_ControlCell[][] getTableGrid(){
		return this.tableGrid;
	}
	
	public bug_ControlCell getCellFromGrid(int row, int column){
		return tableGrid[row][column];
	}
	
	public boolean isContainOnCell(int row, int column, String textToSearch){		
		String txt = tableGrid[row][column].getText();
		
		return txt.contains(textToSearch);
	}
	
	public bug_ControlCell getCellFromList(int cellPosition) throws ControlException{
		return new bug_ControlCell(tableBodyCells.get(cellPosition));
	}	
	
	public int getCellsTotal(){
		return this.tableCellsTotal;
	}
		
	public StringBuilder getCellsToStringBuilder(){
		StringBuilder sb = new StringBuilder();
		for (bug_ControlCell[] cell : ((bug_ControlTable)this).getTableGrid()) {
			for (int i = 0; i < cell.length; i++) {
				String txt = cell[i].getText();				
				sb.append(txt);
				sb.append("|");
			}
		}		
		return sb;
	}
	
	public Hashtable<Integer,bug_ControlCell> getCellsTotoHashTable(){
		Hashtable<Integer,bug_ControlCell> ht = new Hashtable<>();
		int counter = 0;
		for (bug_ControlCell[] cell : ((bug_ControlTable)this).getTableGrid()) {
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
		for (bug_ControlCell[] cell : this.getTableGrid()) {
			for (int i = 0; i < cell.length; i++) {										
				ht.put(counter, cell[i].getText());
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
		
		for (bug_ControlCell[] cell : this.getTableGrid()) {
			for (int i = 0; i < cell.length; i++) {
				String txt = cell[i].getText();				
				sb.append(txt);
			}
		}		
		return sb.toString();
	}
	
}
