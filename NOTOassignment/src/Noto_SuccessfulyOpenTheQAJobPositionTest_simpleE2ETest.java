import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Noto_SuccessfulyOpenTheQAJobPositionTest_simpleE2ETest {

	public static void main(String[] args) throws InterruptedException {
		
		 // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Set the path to the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
      
        // Step 1: Open the Home page
       	System.out.println("******Step one: open Home page******");
        driver.get("https://noto360.com/");
        System.out.println("Title is: " + driver.getTitle());
        System.out.println("Step 1 - Home page opened successfully executed");
        
        // Step 2: Navigate to the Careers page
        System.out.println("******Step 2: Navigate to the Careers page******");
        driver.findElement(By.className("svelte-i8hcj0")).click();
        //Thread.sleep(1000);
        driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(4) > ul:nth-child(1) > li:nth-child(6) > a:nth-child(1) > div:nth-child(2) > p:nth-child(2)")).click();
        System.out.println("Title is: " + driver.getTitle());
        Assert.assertEquals(driver.findElement(By.className("svelte-1dv467y")).getText(), "Career in one of the fastest growing industries.");
        System.out.println("Step 2 - Navigated to the Careers page successfuly executed");
            
        // Step 3: Locate a job posting for a QA position
        System.out.println("******Step 2: Locate a job posting for a QA position******");
        WebElement qaJobPosting = driver.findElement(By.xpath("//h3[contains(@class, 'title') and contains(text(), 'QA ')]"));
		if (qaJobPosting.isDisplayed()) {
            System.out.println("QA job posting found");
            System.out.println("The QA job position is: "+driver.findElement(By.xpath("//h3[contains(@class, 'title') and contains(text(), 'QA ')]")).getText());
        } else {
            System.out.println("QA job posting not found");
        }
		String QAposition = driver.findElement(By.xpath("//h3[contains(@class, 'title') and contains(text(), 'QA ')]")).getText();
		System.out.println("Step 3: Locate a job posting for a QA position successfuly executed");
            
        // Step 4: Successfully open the QA job posting page   
		System.out.println("******Step 4: Successfully open the QA job posting page******");
		driver.findElement(By.cssSelector("button[aria-label='Reject All'] span")).click();
		Thread.sleep(1000);
		
		WebElement element = driver.findElement(By.xpath("//a[@href='/job/qa-engineer']//span[contains(text(),'Learn More')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
		element.click();
		System.out.println("The title of the job position page is: " + driver.getTitle());
		System.out.println("Step 4: open the QA job posting page successfuly executed");
		
		// driver.close(); // if you use close instead of quit I advise to use in cmd 'taskkill /F /IM chromedriver.exe' after you're done with the tests.
		//driver.quit();
		
        }

	}
	


