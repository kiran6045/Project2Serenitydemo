package starter.utility;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import starter.navigation.GoogleHomePage;

import java.util.List;
import java.util.stream.Collectors;

public class Elementutil extends PageObject {


    By links = By.partialLinkText("https://www.");

    public List<WebElementFacade> clickOnlinks() {
        List<WebElementFacade> allLinks = null;
        try {

            allLinks = findAll(links).stream().collect(Collectors.toList());
            System.out.println(allLinks);

        } catch (Exception e) {
            //print error message if web Element is not found
            System.out.println("Web Element is not found in Page");
            System.out.println(e);

        }

        return allLinks;
    }

}
