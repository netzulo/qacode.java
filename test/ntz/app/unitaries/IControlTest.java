package ntz.app.unitaries;

import org.testng.annotations.Test;

import ntz.drivers.ITrandasha.BrowserMode;
import ntz.drivers.ITrandasha.DriverType;
import ntz.drivers.TrandashaBase;
import ntz.drivers.navs.elements.IControl;
import ntz.drivers.navs.pages.APage;
import ntz.drivers.navs.pages.IPage;
import ntz.drivers.navs.pages.PageBase;
import ntz.exceptions.TrandashaException;
import ntz.exceptions.ModelException;
import ntz.exceptions.PageException;
import ntz.tests.TestInfoBase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.List;

import org.testng.annotations.AfterClass;

public class IControlTest extends TestInfoBase{
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  
  private IPage page;
  
  @SuppressWarnings("unused")
  private IControl control;
  
  
  @SuppressWarnings("unused")
  @BeforeClass
  public void beforeClass() throws TrandashaException, PageException, ModelException{
	   this.botInit(new TrandashaBase(DriverType.LOCAL,BrowserMode.CHROME));	
	   
	   page = this.pageInit(bot, new PageBase(bot,"http://demoqa.com/",true){});
	   APage _page = (APage) page;
	   List<IControl> controls = _page.getModels().get(0).getControls();	   	  
	   control = _page.getModel(0).getControls().get(0);
	   control = _page.getModel(0).getControl(0);
  }

  @AfterClass
  public void afterClass() {
	  this.botFinish(bot);
  }


  @Test
  public void childrenByCss() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void childrenByXPath() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void childrensByCss() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void childrensByXPath() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void click() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void clickJS() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getElement() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getScreenShot() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getText() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void loadControl() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void readAttributes() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void readTagText() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void setDriver() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void takeScreenShot() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void takeScreenShotWebDriver() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void textClear() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void textClearAndWrite() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void textWrite() {
    throw new RuntimeException("Test not implemented");
  }
}
