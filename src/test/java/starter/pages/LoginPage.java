package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    static final Logger log = Logger.getLogger(LoginPage.class);

    @FindBy(xpath = "//input[@name='username']")
    private static WebElementFacade username;


    @FindBy(xpath = "//input[@name='password']")
    private static WebElementFacade password;

    @FindBy(xpath = "//button[@type='submit']")
    private static WebElementFacade loginbutton;

    @Step
    public void enterLoginCred(String user, String pass) {
        try {
            username.sendKeys(user);
            password.sendKeys(pass);
        } catch (Exception e) {
            Assert.assertTrue("unable to enter credentials  " + e, false);
        }
    }

    @Step
    public void clickOnLoginButton() {
        try {
            loginbutton.click();
        }
        catch (Exception e) {
            Assert.assertTrue("unable to click on login button " + e, false);
        }
    }
}
