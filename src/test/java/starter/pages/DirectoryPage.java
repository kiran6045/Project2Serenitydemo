package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

public class DirectoryPage extends PageObject {

    static final Logger log = Logger.getLogger(LoginPage.class);

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    private static WebElementFacade submitbutton;


    @FindBy(xpath = "//a[@href='/web/index.php/directory/viewDirectory']")
    private static WebElementFacade directorylink;
    //

    @FindBy(xpath = "//div[@class='oxd-grid-4']//following::p[@class='oxd-text oxd-text--p orangehrm-directory-card-header --break-words'][1]")
    private static WebElementFacade employename;

    ////div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/span
    @FindBy(xpath = "//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/span")
    private static WebElementFacade records;

    ////p[@class='oxd-text oxd-text--p orangehrm-directory-card-header --break-words']
    @FindBy(xpath = "//div[@class='oxd-grid-3']//following::p[@class='oxd-text oxd-text--p orangehrm-directory-card-subtitle --break-words'][1]")
    private static WebElementFacade designation;





    public void clickOnDirectory() {
        try {
            directorylink.click();

        } catch (Exception e) {
            Assert.assertTrue("unable to click on directory  " + e, false);
        }
    }

    @Step
    public String enterEmployeeName() {
        String value =null;
        try {

          value=  employename.getText();

        } catch (Exception e) {
            Assert.assertTrue("unable to enter employee  " + e, false);
        }
        return value;
    }

    @Step
    public String getrecordsfetched() {

        String employenamedesign=null;

        try {
            employenamedesign= designation.getText();

        } catch (Exception e) {
            Assert.assertTrue("unable to fetch data " + e, false);
        }
        return employenamedesign;
    }
}
