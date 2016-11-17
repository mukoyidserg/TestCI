package qaTest2;

import org.junit.After;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class SeleniumTutorialsPoint {
    MarionetteDriver wd;
    
    @Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver",
				"C://Users//SERG//Downloads//TestAutomationLessons//Sergii Mukoid//src//lesson5//geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		wd = new MarionetteDriver(capabilities);
		// wd = new FirefoxDriver();
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

    @Test
    public void serg2() {
        wd.get("http://www.tutorialspoint.com/");
        wd.findElement(By.linkText("Learn Java")).click();
        wd.findElement(By.linkText("Java - Numbers")).click();
        assertEquals("Java Tutorial", wd.findElement(By.cssSelector("li.heading")).getText());
    }
    
    @After
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
