import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.ProductListPage;

public class Test_lcwaikiki extends BaseTest {

    
    HomePage homePage ;
    ProductListPage productsPage ;
    ProductDetailsPage productDetailPage ;
    CartPage cartPage ;


    @Test
    @Order(1)
    public void initialize_home_page(){
        homePage = new HomePage(driver);
        productDetailPage = new ProductDetailsPage(driver);
        productsPage = new ProductListPage(driver);
        cartPage = new CartPage(driver);
        Assertions.assertTrue(homePage.isHomePage(),
        "Home page not initialized");
    }

    @Test
    @Order(2)
    public void login_to_site(){
        homePage.loginToTheSite();
        Assertions.assertTrue(homePage.isloginToSite(),
        "Login failed");
    }


    @Test
    @Order(3)
    public void search_product(){
        homePage.searchBox(parameters.search_input);
        Assertions.assertTrue(productsPage.isOnProductPage() ,
        "Not on products page!");
    }

    @Test
    @Order(4)
    public void select_a_product(){
        homePage.ScrollDown();
        productsPage.moreProductClick();
        productsPage.selectProduct();
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(),
        "Not on product detail page!");
    }

    @Test
    @Order(5)
    public void add_product_to_cart() throws InterruptedException{
        productDetailPage.addToCart();
        productDetailPage.goToCart();
        Assertions.assertTrue(productDetailPage.isAllpriceSame(),
        "The prices on the product page and in the cart are not same PagePrice: " + productDetailPage.parameters.priceFromPage + " - CartPrice: " + productDetailPage.parameters.priceFromCart);
    }

    @Test
    @Order(6)
    public void go_to_cart(){
        cartPage.increaseQuantity();
        Assertions.assertTrue(cartPage.isOrderQuantityIncreased(),
        "Order quantity could not increased. quantity :"+ cartPage.new_quantity);
    }

    @Test
    @Order(7)
    public void remote_orders(){
        cartPage.removeOrder();
        Assertions.assertTrue(cartPage.checkCartIsEmpty(),
        "Cart is not empty");}
    

}