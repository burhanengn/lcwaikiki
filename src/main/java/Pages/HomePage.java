package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class HomePage extends BasePage {

    //setting classes
    LoginPage loginpage;


    //setting functions
    public HomePage(WebDriver driver) {
        super(driver);
        action = new Actions(driver);
        loginpage = new LoginPage(driver);
    }

    public Boolean isHomePage(){
        return isDisplayed(locators.homepageContainer);
    }

    public void ScrollDown(){
        Scroll(parameters.scrollScript);
    }

    public void searchBox(String text){
        click(locators.searcharea);
        type(locators.searchBoxLocator , text);
        click(locators.searchButton);
    }

    public void loginToTheSite(){
        click(locators.signInButton);
        wait(locators.eMailArea,parameters.generalwaittime);
        loginpage.Login(parameters.usereMail, parameters.loginpassword);
    }

    public Boolean isloginToSite(){
        wait(locators.myAccountButton,parameters.generalwaittime);
        moveToElement(locators.myAccountButton);
        return isDisplayed(locators.myAccountButton);
    }

    public void acceptCookies(){
        if (isDisplayed(locators.acceptCookiesLocator)){
            click(locators.acceptCookiesLocator);
        }
    }
}
