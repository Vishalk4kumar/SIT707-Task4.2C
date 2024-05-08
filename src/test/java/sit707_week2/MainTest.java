package sit707_week2;

import org.junit.After;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class MainTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\narwa\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testValidLogin() {
        // Navigate to login page
        driver.get("https://www.bunnings.com.au/login");

        // Enter valid username and password
        WebElement usernameField = driver.findElement(By.id("okta-signin-username"));
        usernameField.sendKeys("valid_username");

        WebElement passwordField = driver.findElement(By.id("okta-signin-password"));
        passwordField.sendKeys("valid_password");

        // Submit the form
        WebElement signInButton = driver.findElement(By.id("okta-signin-submit"));
        signInButton.click();

     // Verify successful login
        assertTrue("Login should be successful", driver.getPageSource().contains("Welcome"));
    }

    @Test
    public void testInvalidUsername() {
        // Navigate to login page
        driver.get("https://www.bunnings.com.au/login");

        // Enter invalid username and valid password
        WebElement usernameField = driver.findElement(By.id("okta-signin-username"));
        usernameField.sendKeys("invalid_username");

        WebElement passwordField = driver.findElement(By.id("okta-signin-password"));
        passwordField.sendKeys("valid_password");

        // Submit the form
        WebElement signInButton = driver.findElement(By.id("okta-signin-submit"));
        signInButton.click();

     // Verify failed login
        assertTrue("Login should fail", driver.getPageSource().contains("Login Failed"));
    }

    @Test
    public void testInvalidPassword() {
        // Navigate to login page
        driver.get("https://www.bunnings.com.au/login");

        // Enter valid username and invalid password
        WebElement usernameField = driver.findElement(By.id("okta-signin-username"));
        usernameField.sendKeys("valid_username");

        WebElement passwordField = driver.findElement(By.id("okta-signin-password"));
        passwordField.sendKeys("invalid_password");

        // Submit the form
        WebElement signInButton = driver.findElement(By.id("okta-signin-submit"));
        signInButton.click();

     // Verify failed login
        assertTrue("Login should fail", driver.getPageSource().contains("Login Failed"));
    }

    @Test
    public void testInvalidCredentials() {
        // Navigate to login page
        driver.get("https://www.bunnings.com.au/login");

        // Enter invalid username and invalid password
        WebElement usernameField = driver.findElement(By.id("okta-signin-username"));
        usernameField.sendKeys("invalid_username");

        WebElement passwordField = driver.findElement(By.id("okta-signin-password"));
        passwordField.sendKeys("invalid_password");

        // Submit the form
        WebElement signInButton = driver.findElement(By.id("okta-signin-submit"));
        signInButton.click();

     // Verify failed login
        assertTrue("Login should fail", driver.getPageSource().contains("Login Failed"));
    }

    @Test
    public void testEmptyUsernameValidPassword() {
        // Navigate to login page
        driver.get("https://www.bunnings.com.au/login");

        // Leave username field empty and enter valid password
        WebElement passwordField = driver.findElement(By.id("okta-signin-password"));
        passwordField.sendKeys("valid_password");

        // Submit the form
        WebElement signInButton = driver.findElement(By.id("okta-signin-submit"));
        signInButton.click();

     // Verify failed login
        assertTrue("Login should fail", driver.getPageSource().contains("Login Failed"));
    }

    @Test
    public void testValidUsernameEmptyPassword() {
        // Navigate to login page
        driver.get("https://www.bunnings.com.au/login");

        // Enter valid username and leave password field empty
        WebElement usernameField = driver.findElement(By.id("okta-signin-username"));
        usernameField.sendKeys("valid_username");

        // Submit the form
        WebElement signInButton = driver.findElement(By.id("okta-signin-submit"));
        signInButton.click();

     // Verify failed login
        assertTrue("Login should fail", driver.getPageSource().contains("Login Failed"));
    }

    @Test
    public void testEmptyUsernameEmptyPassword() {
        // Navigate to login page
        driver.get("https://www.bunnings.com.au/login");

        // Leave both username and password fields empty
        // Submit the form
        WebElement signInButton = driver.findElement(By.id("okta-signin-submit"));
        signInButton.click();

     // Verify failed login
        assertTrue("Login should fail", driver.getPageSource().contains("Login Failed"));
    }

    @After
    public void tearDown() {
        // Close WebDriver
        driver.quit();
    }

	@Test
	public void testStudentIdentity() {
		String studentId = "222342946";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Vishal Kumar";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
}
