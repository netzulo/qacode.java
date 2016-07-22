package ntz.app.unitaries;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class IControlTest {
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
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
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
