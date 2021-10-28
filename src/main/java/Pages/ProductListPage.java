package Pages;

import org.openqa.selenium.*;

import java.util.List;

public class ProductListPage extends BasePage {

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    public void moreProductClick(){ find(locators.showMoreButton).click();}

    public boolean isOnProductPage() {
        wait(locators.shippingOptionLocator,parameters.generalwaittime);
        return isDisplayed(locators.shippingOptionLocator);
    }

    public void selectProduct() {
        int selectProductindex = (int) Math.floor(Math.random() * getAllProducts().toArray().length);
        getAllProducts().get(selectProductindex).click();
    }
    private List<WebElement> getAllProducts(){
        return findAll(locators.productNameLocator);
    }
}
