package Registration;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.generic.utility.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateRegisterPageTest extends BaseClass{

	@Test
	public void createRegisterPageTest() throws IOException {

		FileInputStream file = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties properties = new Properties();
		properties.load(file);
		

		WebDriver d = null;
		int r = jutil.getRandomValue();

		String BROWSER = properties.getProperty("browser");
		String gender = properties.getProperty("gender");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			d = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			d = new FirefoxDriver();
		} else {
			System.out.println("Please enter valid browser name...!");
		}

		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		d.get("https://demowebshop.tricentis.com/");

		d.findElement(By.linkText("Register")).click();

		WebElement regPageInfo = d.findElement(By.xpath("//h1[.='Register']"));
		String regPageHeader = regPageInfo.getText();
		if (regPageHeader.equalsIgnoreCase("Register")) {
			System.out.println(regPageHeader + ": Clicked Successfully");
		} else {
			System.out.println("Failed");
		}

		WebElement GenderMale = d.findElement(By.id("gender-male"));
		WebElement GenderFemale = d.findElement(By.id("gender-female"));

		if (gender.equalsIgnoreCase("male")) {
			GenderMale.click();
		} else if (gender.equalsIgnoreCase("female")) {
			GenderFemale.click();
		}

		WebElement FirstNameTextField = d.findElement(By.id("FirstName"));
		WebElement LastNameTextField = d.findElement(By.id("LastName"));
		WebElement EmailTextField = d.findElement(By.id("Email"));
		WebElement PasswordTextField = d.findElement(By.id("Password"));
		WebElement CPasswordTextField = d.findElement(By.id("ConfirmPassword"));
		WebElement RegisterBtn = d.findElement(By.id("register-button"));
		
	
		
		String FIRSTNAME = properties.getProperty("firstname");
		String LASTNAME = properties.getProperty("lastname");
		String EMAIL = properties.getProperty("email");
		String PASSWORD = properties.getProperty("password");
		String CPASSWORD = properties.getProperty("cpassword");
		
		FirstNameTextField.sendKeys(FIRSTNAME);
		LastNameTextField.sendKeys(LASTNAME);
		EmailTextField.sendKeys(r+EMAIL);
		PasswordTextField.sendKeys(PASSWORD);
		CPasswordTextField.sendKeys(CPASSWORD);
		RegisterBtn.sendKeys(Keys.ENTER);
		
//		RegisterBtn.click();
		
		WebElement regCompleteInfo = d.findElement(By.xpath("//div[@class='result']"));
		String regCompleteHeader = regCompleteInfo.getText();
		if (regCompleteHeader.equalsIgnoreCase("Your registration completed")) {
			System.out.println("Registration Complete");
		}else {
			System.out.println("Failed");
		}

		d.quit();

	}
}
