package demo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.detDSA;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    @SuppressWarnings("deprecation")
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.makemytrip.com/");
        Thread.sleep(2000);
        String homepageURL = driver.getCurrentUrl();
        if(homepageURL.contains("makemytrip")) {
            System.out.println("TestCase01 Passed : WebPage contains the expected URL"); 
        } 
        else {
            System.out.println("TestCase01 Failed : WebPage does not contains the expected URL"); 
        }
    }


    public void testCase02() throws InterruptedException {
        System.out.println("Start Test case: testCase02");
        driver.get("https://www.makemytrip.com/");
        Thread.sleep(4000);
        WebElement addAlert = driver.findElement(By.xpath("//iframe[@title='notification-frame-~197145416']"));
        driver.switchTo().frame(addAlert);
        WebElement dismiss = driver.findElement(By.xpath("//*[@id='webklipper-publisher-widget-container-notification-close-div']"));
        dismiss.click();
        
        WebElement fromButton = driver.findElement(By.xpath("//div[@class='flt_fsw_inputBox searchCity inactiveWidget ']"));
        fromButton.click();
        WebElement departure = driver.findElement(By.xpath("//input[@placeholder='From']"));
        departure.sendKeys("blr");
        Thread.sleep(2000);
        WebElement selectdeparture = driver.findElement(By.xpath("//div[@class='calc60']//p[text()='Bengaluru, India']"));
        selectdeparture.click();
        Thread.sleep(2000);

        WebElement toButton = driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div/div[2]/div[1]/div[2]"));
        toButton.click();
        WebElement destination = driver.findElement(By.xpath("//input[@placeholder='To']"));
        destination.sendKeys("del");
        Thread.sleep(2000);
        WebElement selectdestination = driver.findElement(By.xpath("//div[@class='calc60']//p[text()='New Delhi, India']"));
        selectdestination.click();
        Thread.sleep(2000);

       final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='datePickerContainer']")));
        WebElement destDate = driver.findElement(By.xpath("//div[@class='DayPicker-Day'][contains(@aria-label,'Fri Mar 29 2024')]"));
        destDate.click();

        WebElement searchButton = driver.findElement(By.xpath("//p[@class='makeFlex vrtlCenter ']/a[@class='primaryBtn font24 latoBold widgetSearchBtn ']"));
        searchButton.click();
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpth))

        WebElement pricePerAdult = driver.findElement(By.xpath("//div[@class='blackText fontSize18 blackFont white-space-no-wrap clusterViewPrice']"));
        String price = pricePerAdult.getText();
        System.out.println("Price per Adult --" + price);
        System.out.println("End TestCase02");
       

    }

    public void testCase03() throws InterruptedException {
        System.out.println("Start Test case: testCase03");
        driver.get("https://www.makemytrip.com/");
        Thread.sleep(5000);
        // WebElement addAlert = driver.findElement(By.xpath("//iframe[@title='notification-frame-~197145416']"));
        // driver.switchTo().frame(addAlert);
        // WebElement dismiss = driver.findElement(By.xpath("//*[@id='webklipper-publisher-widget-container-notification-close-div']"));
        // dismiss.click();
        WebElement trainTicket = driver.findElement(By.xpath("//a[@href='https://www.makemytrip.com/railways/']"));
        trainTicket.click();
        Thread.sleep(2000);
        // WebElement trainsOption = driver.findElement(By.xpath("//span[contains(text(),'Trains')]"));
        // trainsOption.click();

        
        WebElement fromButton = driver.findElement(By.id("fromCity"));
        fromButton.click();
        WebElement fromInput = driver.findElement(By.xpath("//input[@placeholder='From']"));
        fromInput.sendKeys("ypr");
        Thread.sleep(2000);
        // Select the first suggestion from the dropdown
        WebElement fromFirstOption = driver.findElement(By.xpath("//ul[contains(@class,'react-autosuggest__suggestions-list')]/li[1]"));
        fromFirstOption.click();
        Thread.sleep(2000);

        // WebElement toButton = driver.findElement(By.id("toCity"));
        // toButton.click();
        WebElement toInput = driver.findElement(By.xpath("//input[@placeholder='To']"));
        toInput.sendKeys("ndls");
        WebElement toFirstOption = driver.findElement(By.xpath("//ul[contains(@class,'react-autosuggest__suggestions-list')]/li[1]"));   //*[@id="react-autowhatever-1-section-0-item-0"]
        toFirstOption.click();

        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='datePickerContainer']")));
        WebElement destDate = driver.findElement(By.xpath("//div[@class='DayPicker-Day'][contains(@aria-label,'Fri Mar 29 2024')]"));
        destDate.click();

        WebElement selectClass = driver.findElement(By.xpath("//ul/li[@data-cy='3A']"));
        selectClass.click();
        Thread.sleep(2000);

        WebElement submit = driver.findElement(By.xpath("//a[text()='Search']"));
        submit.click();

        WebElement priceFor3AC = driver.findElement(By.xpath("//*[@id='train_options_29-03-2024_0']/div[1]/div[2]"));
        String price = priceFor3AC.getText();
        System.out.println("Price per Adult --" + price);
    
        
        System.out.println("End TestCase03");
        
        
    }    

       
    @SuppressWarnings("deprecation")
    public void testCase04() throws InterruptedException {
        System.out.println("Start Test case: testCase04");
        driver.get("https://www.makemytrip.com/");
        Thread.sleep(4000);
        // WebElement addAlert = driver.findElement(By.xpath("//iframe[@title='notification-frame-~2514399ba']"));         ////iframe[@title='notification-frame-~10cb5088a']
        // driver.switchTo().frame(addAlert);
        // WebElement dismiss = driver.findElement(By.xpath("//*[@id='webklipper-publisher-widget-container-notification-close-div']"));
        // dismiss.click();
        driver.get("https://www.makemytrip.com/bus-tickets/");

        // Implicitly wait for the page to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Find and click on the "From" city input field
        WebElement fromCityInput = driver.findElement(By.xpath("//input[@id='fromCity']"));
        fromCityInput.click();

        // Enter "Bangalore" in the "From" city input field
        fromCityInput.sendKeys("bangl");

        // Select "Bangalore, Karnataka" from the suggestion dropdown
        WebElement fromCityOption = driver.findElement(By.xpath("//span[contains(text(),'Bangalore, Karnataka')]"));
        fromCityOption.click();

        // Find and click on the "To" city input field
        WebElement toCityInput = driver.findElement(By.xpath("//input[@placeholder=\"To\"]"));
        toCityInput.click();

        // Enter "Delhi" in the "To" city input field
        toCityInput.sendKeys("del");

        // Select "Delhi" from the suggestion dropdown
        WebElement toCityOption = driver.findElement(By.xpath("//span[contains(text(),'Delhi')]"));
        toCityOption.click();

        // Select the date (29th March)
        WebElement dateInput = driver.findElement(By.xpath("//div[@class='bus_sw datePickerContainer']"));
        dateInput.click();

        // Find and click on the 29th March date
        WebElement date29March = driver.findElement(By.xpath("//div[@aria-label='Fri Mar 29 2024']"));
        date29March.click();

        // Find and click on the "Search" button
        WebElement searchButton = driver.findElement(By.xpath("//button[@id='search_button']"));
        searchButton.click();

        // Explicitly wait for the search results to load
        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='error-view makeFlex column hrtlCenter vrtlCenter']")));

        // Check if any search results are displayed
        WebElement searchResults = driver.findElement(By.xpath("//div[@class='error-view makeFlex column hrtlCenter vrtlCenter']"));
        if (searchResults.getText().contains("No buses found for 29 Mar")) {
            System.out.println("No bus tickets found from Bangalore to Delhi on March 29th.");
        } else {
            System.out.println("Bus tickets found from Bangalore to Delhi on March 29th.");
        }
    }


        

}
   