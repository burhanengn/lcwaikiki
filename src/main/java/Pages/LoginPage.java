package Pages;

import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        
    }

    public void Login(String eMail, String pass){
        type(locators.eMailArea, eMail);
        type(locators.passTextArea, pass);
        click(locators.LoginButton);
    }

}
