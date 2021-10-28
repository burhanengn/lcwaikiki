import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Constants.Constants;
import Constants.Constants.Locators;
import Constants.Constants.Parameters;
import TestLogs.Logs;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(Logs.class)
public class BaseTest {

    WebDriver driver ;
    Locators locators;
    Parameters parameters;


    @BeforeAll
    public void setUp(){
        this.locators = new Constants().new Locators();
        this.parameters = new Constants().new Parameters();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(parameters.homeUrl);
        driver.manage().window().maximize();
    }
//
//    @AfterAll
//    public void tearDown(){
//        driver.quit();
//    }

}
