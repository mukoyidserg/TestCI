package qaTest2;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTaxCalc {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.gecko.driver",
				"C://Users//SERG//Downloads//TestAutomationLessons//Sergii Mukoid//src//lesson5//geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		driver = new MarionetteDriver(capabilities);
		 baseUrl = "http://services.deloitte.ie/";
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  }

		  @Test
		  public void testSerg6() throws Exception {
		    driver.get(baseUrl + "/tc/Default.aspx");
		    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtIncome")).clear();
		    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtIncome")).sendKeys("10000");
		    driver.findElement(By.id("ctl00_ContentPlaceHolder1_butSubmit")).click();
		    assertEquals("ˆ2,000.00", driver.findElement(By.id("ctl00_ContentPlaceHolder1_lblCYTaxLowerRate")).getText());
		  }

		  @After
		  public void tearDown() throws Exception {
		    driver.quit();
		    String verificationErrorString = verificationErrors.toString();
		    if (!"".equals(verificationErrorString)) {
		      fail(verificationErrorString);
		    }
		  }

		  private boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }

		  private boolean isAlertPresent() {
		    try {
		      driver.switchTo().alert();
		      return true;
		    } catch (NoAlertPresentException e) {
		      return false;
		    }
		  }

		  private String closeAlertAndGetItsText() {
		    try {
		      Alert alert = driver.switchTo().alert();
		      String alertText = alert.getText();
		      if (acceptNextAlert) {
		        alert.accept();
		      } else {
		        alert.dismiss();
		      }
		      return alertText;
		    } finally {
		      acceptNextAlert = true;
		    }
		  }
		}
