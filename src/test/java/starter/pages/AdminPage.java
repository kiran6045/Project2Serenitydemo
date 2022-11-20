package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class AdminPage extends PageObject {

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    private static WebElementFacade addbutton;
    @FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@class=\"oxd-input oxd-input--active\"]")
    private static WebElementFacade userrole;

    // //button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    private static WebElementFacade submitbutton;

    @FindBy(xpath = "//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//span[@class='oxd-text oxd-text--span']")
    private static WebElementFacade user_role_txt;



    @Step
    public void enterUserRole(String userRole) {
        try {
            userrole.withTimeoutOf(Duration.ofSeconds(10)).sendKeys(userRole);
            Thread.sleep(3000);

            submitbutton.withTimeoutOf(Duration.ofSeconds(10)).waitUntilClickable().click();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    @Step
    public static String getUserRole() {
       return user_role_txt.withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible().getText();
    }
}
