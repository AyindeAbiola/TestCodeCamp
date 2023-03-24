import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * 1.verify that the user input the correct url and is on the right webpage
 * 2. verify that when user clicks on the login/signup button,the user is directed to the right login page
 * 3. verify that user cannot log in with username less than 3 characters
 * 4. verify that user cannot log in with a wrong email address
 * 5. verify that user cannot log in with password less than or equal to one character
 *  6. verify that user is successfully directed to the computer and accessories page when the computer and accessories button is clicked
 *  7. verify that user is successfully directed to the laptop page when the laptop button is clicked
 * 8. verify that Apple Macbook is present on the laptop section
 */


public class KongaFlow {

    //import the selenium web-driver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate chromedriver
        System.setProperty("web-driver.chromedriver.exe", "resources/chromedriver.exe");
        //launch chrome driver
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);
        //input Konga url(https://www.konga.com/)
        driver.get("https://www.konga.com/");
        if (driver.getCurrentUrl().contains("https://www.konga.com/"))
            //pass
            System.out.println("correct webpage");
        else
            //fail
            System.out.println("wrong webpage");
        Thread.sleep(5000);
        //maximize the browser
        driver.manage().window().maximize();
        //click on the login/signup button to open login page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 0)
    public void positiveLogin() throws InterruptedException {
        //test 2. verify that user can log in with valid login credentials
        //input your username on the username field
        driver.findElement(By.id("username")).sendKeys("digiplusforexacademy@gmail.com");
        //input your password on the password field
        driver.findElement(By.id("password")).sendKeys("Exodus13");
        //click on the login page
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void locateComputerAndAccessories() throws InterruptedException {
        // From the Categories, click on the “Computers and Accessories”
        WebElement ComputerAndAccessories = driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]"));
        ComputerAndAccessories.click();
        String expectedUrl = "https://www.konga.com/category/accessories-computing-5227";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains("expectedUrl"))
            //pass
            System.out.println("correct computer and accessories page");
        else
            //fail
            System.out.println("wrong page");

        Thread.sleep(5000);

    }

    @Test(priority = 2)
    public void clickLaptopsSection() throws InterruptedException {
        //Click on the Laptop SubCategory
        WebElement Laptop = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span"));
        Laptop.click();
        String expectedUrl = "https://www.konga.com/category/laptops-5230";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains("expectedUrl"))
            //pass
            System.out.println("correct laptop page");
        else
            //fail
            System.out.println("wrong page");
        Thread.sleep(5000);

    }

    @Test(priority = 3)
    public void clickAppleMacBooks() throws InterruptedException {
        //Click on the Apple MacBooks
        WebElement AppleMacBooks = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]/a/label/span"));
        AppleMacBooks.click();
        String expectedTitle = "Apple MacBooks";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains("expectedTitle"))
            //pass
            System.out.println("Apple MacBooks");
        else
            //fail
            System.out.println("blank");
        Thread.sleep(5000);
    }

    @Test(priority = 4)
    public void verifyItem() throws InterruptedException {
        // Search and click on an item
        WebElement item = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[1]/div/div/div[2]/form/div[3]/button"));
        item.click();
        Thread.sleep(5000);
    }

    @Test(priority = 5)
    public void ClickAddToCart() throws InterruptedException {
        // Add an item to the cart
        WebElement AddToCart = driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]/span[1]"));
        AddToCart.click();

        String expectedTitle = "Cart Overview";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains("expectedTitle"))
            //pass
            System.out.println("Cart Overview");
        else
            //fail
            System.out.println("invalid title");
        Thread.sleep(5000);
    }

    @Test(priority = 6)
    public void clickCheckout() throws InterruptedException {
        // Click on checkout pop-ups
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 7)
    public void clickChange() throws InterruptedException {
        // Select Address / click on change
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[1]/div[2]/div/button")).click();
        Thread.sleep(5000);
        //Select add delivery address
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        Thread.sleep(5000);
    }
    @Test (priority = 8)
    public void clickAddressThere() throws InterruptedException {
        // click on the already registered address
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div[1]/form/button")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 9)
    public void clickUseAddress() throws InterruptedException {
        // click on the "use address" button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        Thread.sleep(5000);
    }
    @Test (priority = 10)
    public void clickPayNow() throws InterruptedException {
        // under the "payment options" click pay on now
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 11)
    public void clickContinueToMakePayment() throws InterruptedException {
        //Click on "continue to make payment" button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(5000);
    //Test case. verify that "continue to payment" button brings an iframe display requesting user to choose a payment option

    }


    @AfterTest
            public void closeBrowser() {
            // 12. Quit the browser
            driver.quit();
        }
}

















