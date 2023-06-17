package Registration;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.generic.utility.BaseClass;
import com.repository.HomePage;
import com.repository.RegisterInfoPage;
import com.repository.RegisterPage;

@Listeners(com.generic.utility.ListneresImplementation.class)
public class RegisterTest extends BaseClass {

	public String[] getData() throws IOException {
		String GENDER = putil.getDataFromPropertiesFile("gender");
		String FIRSTNAME = putil.getDataFromPropertiesFile("firstname");
		String LASTNAME = putil.getDataFromPropertiesFile("lastname");
		String EMAIL = putil.getDataFromPropertiesFile("email");
		String PASSWORD = putil.getDataFromPropertiesFile("password");
		String CPASSWORD = putil.getDataFromPropertiesFile("cpassword");

		String data[] = { GENDER, FIRSTNAME, LASTNAME, EMAIL, PASSWORD, CPASSWORD };

		return data;
	}

	@Test
	public void registerTest() throws IOException {

		String expectedRegisterPageTitle = "Demo Web Shop. Register";

		String GENDER = putil.getDataFromPropertiesFile("gender");
		String FIRSTNAME = putil.getDataFromPropertiesFile("firstname");
		String LASTNAME = putil.getDataFromPropertiesFile("lastname");
		String EMAIL = putil.getDataFromPropertiesFile("email");
		String PASSWORD = putil.getDataFromPropertiesFile("password");
		String CPASSWORD = putil.getDataFromPropertiesFile("cpassword");

		int r = jutil.getRandomValue();

		HomePage hp = new HomePage(d);
		hp.clickOnRegisterLink();
		Assert.assertEquals(d.getTitle(), expectedRegisterPageTitle, "Error");

		RegisterPage reg = new RegisterPage(d);
		reg.register(GENDER, FIRSTNAME, LASTNAME, r + EMAIL, PASSWORD, CPASSWORD);

		RegisterInfoPage regInfo = new RegisterInfoPage(d);
		String regHeader = regInfo.getRegHeader();
		Assert.assertTrue(regHeader.equalsIgnoreCase("Your registration completed"));

	}

}
