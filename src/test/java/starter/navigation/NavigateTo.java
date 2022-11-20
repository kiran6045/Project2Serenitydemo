package starter.navigation;

import net.thucydides.core.annotations.Step;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

public class NavigateTo {

    static final Logger log = Logger.getLogger(NavigateTo.class);
    OrangeHrmPage orangeHrmPage;

    @Step("Open the orange home page")
    public void  theOrangeHomePage() {
        PropertyConfigurator.configure("log4j.properties");
        orangeHrmPage.open();
    }


    @Step
    public  WebDriver getDriver()
    {
        return  orangeHrmPage.getDriver();
    }
}
