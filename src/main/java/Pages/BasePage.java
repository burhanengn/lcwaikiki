package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constants.Constants;
import Constants.Constants.Locators;
import Constants.Constants.Parameters;

public class BasePage {

    WebDriver driver ;
    Actions action;
    WebDriverWait wait;
    public Locators locators;
    public Parameters parameters;

    public BasePage(WebDriver driver){
        this.driver = driver ;
        action = new Actions(driver);
        this.wait = new WebDriverWait(driver, 20);
        this.locators = new Constants().new Locators();
        this.parameters = new Constants().new Parameters();
    }

    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }

    public void wait_clickible_and_click(WebElement locatore){
        new WebDriverWait(driver, parameters.generalwaittime).until(ExpectedConditions.elementToBeClickable(locatore)).click();
    }

    public void click(By locator){
        find(locator).click();
    }

    public void type(By locator , String text){
        find(locator).sendKeys(text);
    }

    public Boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }

    public void wait(By by, int second){
        wait = new WebDriverWait(driver, second);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
    public void wait_element(WebElement element,By by, int second){
        wait = new WebDriverWait(driver, second);
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(element, by));
    }

    public void clear_style(String script,WebElement webElement){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script,webElement);
    }

    public void Scroll(String script){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script);
    }

    public void moveToElement(By by){
        action.moveToElement(find(by)).build().perform();
    }

}
