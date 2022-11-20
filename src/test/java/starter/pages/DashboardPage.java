package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends PageObject {

    static final Logger log = Logger.getLogger(DashboardPage.class);

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    private static WebElementFacade dashboard;
    @FindBy(xpath = "//a[@href='/web/index.php/admin/viewAdminModule']")
    private static WebElementFacade adminbutton;

    @Step
    public String validateDashboard() {
        String value = null;
        try {
            value = dashboard.getText();
        } catch (Exception e) {
            Assert.assertTrue("unable to get dashboard text after login" + e, false);
        }
        return value;
    }

    @Step
    public void clickOnAdminButton() {

        try {
            adminbutton.click();
        }
        catch (Exception e) {
            Assert.assertTrue("unable to click on Admin button " + e, false);
        }
    }


}
