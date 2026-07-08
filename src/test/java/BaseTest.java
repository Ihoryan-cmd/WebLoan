import common.ConfigReader;
import common.LoanAppHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected LoanAppHelper helper;
    protected ConfigReader config;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        helper = new LoanAppHelper();
        config = new ConfigReader();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();

    }
}
