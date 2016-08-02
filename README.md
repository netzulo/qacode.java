# ntzXagobah
Since 2013 : Open Source library for QA functional testing throught selenium, integration with testlink and jenkins


## Start to Create your automation code

- Create Pages object model class
- Create Models object model class
- Use common method on page to load all Properties marked with annotations @FindBy, @FindsBy
- Load selectors over models objects
- Create *TestSuite* class
- Create *TestCases* methods on *TestSuite* class

---

```
@BeforeClass
public void OpenSuite() throws TrandashaException, PageException {
	try {
		this.logBeforeClass(this.getClass().getName());
		
		this.bot = new TrandashaBase(DriverType.LOCAL, BrowserMode.CHROME);
		this.page = this.pageInit(bot, new PageBase(bot,"http://demoqa.com/",true));			
	} catch (Exception | AssertionError e) { onErrorAtFinish(e);}			
}
	
@AfterClass
public void CloseSuite() throws PageException{
	try {
		this.botFinish(bot);			
		
		this.logAfterClass(this.getClass().getName());				
	} catch (Exception | AssertionError e) { onErrorAtFinish(e);}	
}
```

```

@Test
public void LoadPageControls_on_model_creation() throws PageException {
	try {						
	
  	this.page.addModel(new ModelBase(bot,
		  "#site_navigation > div > div.collapse.navbar-collapse.navbar-ex1-collapse"
  	  "#post-9 > div > div:nth-child(1)",
      "#post-9 > div > div:nth-child(2)",
		  "#post-9 > div > div:nth-child(3)",
  	  "#post-9 > div > div.col-md-6.tabcontents"
	  ));
	  
		List<IModel> models = this.page.getModels();
		
	} catch (Exception | AssertionError e) { onErrorAtFinish(e); }
}

```

---

Test it!

---

Testlink integration: OFF
Jenkins integration: OFF
