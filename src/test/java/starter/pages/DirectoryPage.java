package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import starter.utility.Elementutil;

import java.util.List;
import java.util.stream.Collectors;

public class DirectoryPage extends PageObject {

    static final Logger log = Logger.getLogger(LoginPage.class);


Elementutil elementutil = new Elementutil();
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    private static WebElementFacade submitbutton;


    @FindBy(xpath = "//a[@href='/web/index.php/directory/viewDirectory']")
    private static WebElementFacade directorylink;
    //

    @FindBy(xpath = "//div[@class='oxd-grid-4']//following::p[@class='oxd-text oxd-text--p orangehrm-directory-card-header --break-words']")
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
    public boolean getEmployeeName() {

        try {
//            List<String> list=findAll("//div[@class='oxd-grid-4']//following::p[@class='oxd-text oxd-text--p orangehrm-directory-card-header --break-words']").stream()
//                    .map(WebElementFacade::getText)
//                    .collect(Collectors.toList());

            List<String> list= elementutil.findelements("//div[@class='oxd-grid-4']//following::p[@class='oxd-text oxd-text--p orangehrm-directory-card-header --break-words']");

         for (int i=0;i< list.size();i++)
         {
             if(list.get(i).equalsIgnoreCase("Odis Adalwin"))
             {
                 return true;
             }
         }

        } catch (Exception e) {
            Assert.assertTrue("unable to get employee  " + e, false);
        }

        return false;
    }

    @Step
    public boolean getrecordsfetched() {

        try {
//            List<String> list=findAll("//div[@class='oxd-grid-3']//following::p[@class='oxd-text oxd-text--p orangehrm-directory-card-subtitle --break-words']").stream()
//                    .map(WebElementFacade::getText)
//                    .collect(Collectors.toList());

            List<String> list= elementutil.findelements("//div[@class='oxd-grid-3']//following::p[@class='oxd-text oxd-text--p orangehrm-directory-card-subtitle --break-words']");


            for (int i=0;i< list.size();i++)
            {
                if(list.get(i).equalsIgnoreCase("Chief Technical Officer"))
                {
                    return true;
                }
            }

        } catch (Exception e) {
            Assert.assertTrue("unable to get employee designation  " + e, false);
        }

        return false;
    }
}
