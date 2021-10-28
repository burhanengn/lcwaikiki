package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Logs.Log;

public class ProductDetailsPage extends BasePage{

    String pageprice;
    Log log = new Log();

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailPage() {
        Boolean combine = false;
        try {
            wait(locators.addToCartButtonLocator,parameters.generalwaittime/2);
            combine = false;         
        } catch (Exception e) {}
        try {
            wait(locators.addtocartButtons,parameters.generalwaittime/2);
            combine = true;         
        } catch (Exception e) {}
        if(combine) return isDisplayed(locators.addtocartButtons);
        else return isDisplayed(locators.addToCartButtonLocator);
    }

    public void selectAttribute(By by, int i) throws InterruptedException {
        List<WebElement> Attributes = getAllAttributes(by);
        int selectAttributeindex = (int) Math.floor(Math.random() * Attributes.toArray().length/i);
        for (WebElement webElement : Attributes) {
            clear_style(parameters.clearstylescript, webElement);
        }
        wait_element(Attributes.get(selectAttributeindex), locators.productAttribute, parameters.generalwaittime);
        wait_clickible_and_click(Attributes.get(selectAttributeindex));
    }

    private List<WebElement> getAllAttributes(By by){
        return findAll(by);
    }

    public void addToCart() throws InterruptedException {
        Boolean kombine = false;
        try {
            parameters.priceFromPage = find(locators.productPrices).getText();
        } catch (Exception e) {
        }
        try {
            parameters.priceFromPage = find(locators.productPriceFromPage).getText();
        } catch (Exception e) {
        }
        
        try {
            if(find(locators.addtocartButtons).isEnabled()) {
            wait(locators.addtocartButtons,7);
            click(locators.addtocartButtons);}
            kombine = true;
        } catch (Exception e) {
        }
        wait(locators.productAttribute,parameters.generalwaittime*2);
        if(!kombine)
        {
            selectAttribute(locators.productAttribute,2);
            wait(locators.addToCartButtonLocator,parameters.generalwaittime);
            click(locators.addToCartButtonLocator);
        }
        else{
            selectAttribute(locators.productAttributeCombine,4);
        }
    }

    public boolean isProductCountUp() {
        wait(locators.cartaddedarea,parameters.generalwaittime);
        return getCartCount() > 0 ;
    }


    private int getCartCount(){
        wait(locators.cartaddedarea,parameters.generalwaittime);
        String count = find(locators.cartCountLocator).getText();
        return Integer.parseInt(count);
    }

    public void goToCart() throws InterruptedException {
        Thread.sleep(1000);
        click(locators.cartContainerLocator);
        wait(locators.cartPrice,parameters.generalwaittime);
        parameters.priceFromCart = find(locators.cartPrice).getText();
    }

    public Boolean isAllpriceSame(){
        parameters.compareresult = parameters.priceFromCart.compareTo(parameters.priceFromPage);
        parameters.teststring = Integer.toString(parameters.compareresult);
        return parameters.compareresult == 0;
    }

    public String Getmoeys(){
        return "  Page price : " + pageprice + "  Cart price : " + find(locators.productPriceFromCart).getText();
    }


}
