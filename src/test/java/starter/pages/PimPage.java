package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import starter.navigation.NavigateTo;

public class PimPage extends PageObject {

    @Steps
    static
    NavigateTo navigateTo;

    static WebDriver driver;
    @FindBy(xpath = "//a[@href='/web/index.php/pim/viewPimModule']")
    private static WebElementFacade pimbutton;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    private static WebElementFacade addbutton;
    @FindBy(xpath = "//input[@name='firstName']")
    private static WebElementFacade firstname;

    @FindBy(xpath = "//input[@name='middleName']")
    private static WebElementFacade middlename;
    @FindBy(xpath = "//input[@name='lastName']")
    private static WebElementFacade lastName;

    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']//child::div[@class='oxd-input-group oxd-input-field-bottom-space']//following::input[@class='oxd-input oxd-input--active']")
    private static WebElementFacade employeeid;


    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    private static WebElementFacade savebutton;
    // //h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")
    private static WebElementFacade add_employee_txt;

    @Step
    public static void clickOnPim() {
       pimbutton.click();
    }
    @Step
    public static void enterEmployeeDeatils(String firstname1, String employeenumber)  {
        addbutton.click();

        firstname.sendKeys(firstname1);
        middlename.sendKeys(firstname1);
        lastName.sendKeys(firstname1);
        employeeid.sendKeys(employeenumber);

    }
    public static void clickOnSaveButton() {
        String value=add_employee_txt.getText();
        Assert.assertEquals(value,"Add Employee");
        savebutton.click();
    }


}
