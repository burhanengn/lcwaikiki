package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public int new_quantity;
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void increaseQuantity(){
        wait(locators.orderQuantityAdder,parameters.generalwaittime);
        click(locators.orderQuantityAdder);
    }
    public boolean isOrderQuantityIncreased() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait(locators.yourCartUpdatedText,parameters.generalwaittime);
        String quantity = find(locators.orderQuantityValue).getAttribute(parameters.orderQuantity);
        new_quantity = Integer.parseInt(quantity);
        return  new_quantity == 2 ;
    }

    public void removeOrder(){
        wait(locators.removeOrderButton,parameters.generalwaittime);
        click(locators.removeOrderButton);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.switchTo().activeElement();  
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait(locators.dialogPage,parameters.generalwaittime);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.switchTo().activeElement();  
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        click(locators.removeOrderFloatinButton);
    }

    public Boolean checkCartIsEmpty(){
        wait(locators.cartEmptyText,parameters.generalwaittime);
        return isDisplayed(locators.cartEmptyText);
    }
}
