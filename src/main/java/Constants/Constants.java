package Constants;

import org.openqa.selenium.By;

public class Constants {

    public class Locators{

    //For cart page

    public By orderQuantityAdder = By.className("plus");
    public By orderQuantityValue = By.className("item-quantity-input");
    public By yourCartUpdatedText = By.xpath("//span[@class='rd-cart-item-price mb-15']");
    public By cartPrice = By.xpath("//span[@class='rd-cart-item-price mb-15']");
    public By removeOrderButton = By.xpath("//i[@class='fa fa-trash-o']");
    public By removeOrderFloatinButton = By.xpath("//a[@class='inverted-modal-button sc-delete ins-init-condition-tracking']");
    public By cartEmptyText = By.xpath("//p[@class='cart-empty-title']");
    public By dialogPage = By.xpath("//div[@class='modal fade delete-cart-item-modal in']");

    //For Home page
    
    public By acceptCookiesLocator = By.id("sp-cc-accept");
    public By signInButton = By.xpath("//a[@href='https://www.lcwaikiki.com/tr-TR/TR/giris']");
    public By homepageContainer = By.className("homepage-container");
    public By welcomeText = By.className("action-btn btn-block loginClass");
    public By myAccountButton = By.xpath("//button[@class='dropdown-toggle striped-button']/span[@class='dropdown-label']");
    public By searchBoxLocator = By.id("search_input");
    public By submitButtonLocator = By.id("nav-search-submit-button");
    public By searchButton = By.className("searchButton");
    public By searcharea = By.id("search_input");

    //For Login page

    public By eMailArea = By.id("LoginEmail");
    public By passTextArea = By.id("Password");
    public By LoginButton = By.id("loginLink");

    //For Product Details page
    
    public By addToCartButtonLocator = By.id("pd_add_to_cart");
    public By addtocartButtons = By.xpath("//div[@class='sizeAndCart']/a[@class='add-to-cart fav addToCart']");
    public By productPrices = By.xpath("//*[@id='container']/div[1]/div[2]/div[4]/div[1]/div[2]/div[1]/div[3]/p/span");
    public By cartaddedarea = By.className("//span[@class='spanCart cart-item-count header-cart-quantity']");
    public By productAttribute = By.xpath("//a[@data-tracking-category='UrunDetay'][@data-tracking-label='BedenSecenekleri']");
    public By productAttributeCombine = By.xpath("//*[@id='option-size'][1]/a[@data-tracking-category='UrunDetay'][@data-tracking-label='BedenSecenekleri']");
    public By productPriceFromPage = By.xpath("//div[@class='col-xs-12 price-area']/div/div/span[@class='price']");
    public By productPriceFromCart = By.className("amount");
    public By cartCountLocator = By.id("spanCart");
    public By cartContainerLocator = By.xpath("//a[@href='https://www.lcwaikiki.com/tr-TR/TR/sepetim']");

    //For Products List page

    
    public By shippingOptionLocator = By.id("filter-label");
    public By productNameLocator = new By.ByClassName("product-item-wrapper");
    public By showMoreButton = new By.ByClassName("lazy-load-button");
    }

    public class Parameters{

        public String orderQuantity = "value";
        public String usereMail = "burhan_45432@hotmail.com";
        public String loginpassword = "Burhaengi454";
        public String scrollScript = "window.scrollTo(0, document.body.scrollHeight-1000)";
        public String homeUrl = "https://www.lcwaikiki.com/tr-TR/TR";
        public String search_input = "pantolan";
        public int generalwaittime = 20;
        public String priceFromCart = "";
        public String priceFromPage = "";
        public String teststring;
        public String clearstylescript = "arguments[0].removeAttribute('style')";
        public int compareresult;
    }
    
}
