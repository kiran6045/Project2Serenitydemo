package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.apache.log4j.Logger;
import org.junit.Assert;
import starter.navigation.NavigateTo;
import starter.pages.*;


public class OrangehrmStepDefinition {

    static final Logger log = Logger.getLogger(OrangehrmStepDefinition.class);
    @Steps
    NavigateTo navigateTo;
    @Steps
    LoginPage loginPage;
    @Steps
    DashboardPage dashboardPage;
    @Steps
    AdminPage adminPage;

    @Steps
    PimPage pimPage;

    @Steps
    DirectoryPage directoryPage;





    @Given("Browser is launched and OrangehrmPage page is displayed")
    public void browser_is_launched_and_OrangehrmPage_page_is_displayed() {
        navigateTo.theOrangeHomePage();
        log.info("orange home page displayed successfully");

    }


    @When("Enter the Login details  {string} and  {string}")
    public void enter_the_Login_details_and(String user, String pass) {
        loginPage.enterLoginCred(user, pass);
        log.info("entered username and passed successfully");
        loginPage.clickOnLoginButton();
        log.info("clicked on login button succesfully");
    }

    @Then("Validate dashboard is available after successfull login")
    public void validate_dashboard_is_available_after_successfull_login() {
        String value = dashboardPage.validateDashboard();
        Assert.assertEquals(value, "Dashboard");
        log.info("Dashboard validation successfully");
        System.out.println("validation successfully passed");

    }
    @Given("User should be able to click on Admin and navigate to Admin Page")
    public void user_should_be_able_to_click_on_Admin_and_navigate_to_Admin_Page() {
       dashboardPage.clickOnAdminButton();
        log.info("clicked on admin button successfully");
    }
    @When("Search {string} from System users tab")
    public void search_from_System_users_tab(String user_role) {
     adminPage.enterUserRole(user_role);
        log.info("user_role  entered sucessfully");

    }

    @Then("Validate {string} is fetched Successfully")
    public void validate_is_fetched_Successfully(String user_role) {

        String userrole_value=adminPage.getUserRole();
        Assert.assertEquals(userrole_value,user_role);
        log.info("user_role validated  sucessfully in admin page");
        System.out.println("valdated sucessfully");

    }
    @Given("User should be able to click on PIM and navigate to PIM Page")
    public void user_should_be_able_to_click_on_PIM_and_navigate_to_PIM_Page() {
        pimPage.clickOnPim();
        log.info("clicked on pim button successfully");

    }

    @When("Enter {string} and {string} in required fields")
    public void enter_and_in_required_fields(String EmployeeName, String EmployeeNumber)  {
        pimPage.enterEmployeeDeatils(EmployeeName,EmployeeNumber);
        log.info("entered  EmployeeName & EmployeeNumber successfully");

    }

    @Then("click on save button")
    public void click_on_save_button() {
        pimPage.clickOnSaveButton();
        log.info("clicked on save button successfully in pim page");
        System.out.println("succesfully saved");

    }
    @Given("User should be able to click on directory and navigate to directory Page")
    public void user_should_be_able_to_click_on_directory_and_navigate_to_directory_Page() {
        directoryPage.clickOnDirectory();
        System.out.println("clicked on Directory button successfully");
        log.info("clicked on Directory button successfully");

    }

    @When("validate the employee odis adalwin is CTO")
    public void enter_in_required_fields_and_search() {
      boolean value= directoryPage.getEmployeeName();
        Assert.assertEquals(true,value);
        log.info("employee odis adalwin is validated sucessfully");

    }


    @Then("Validate user is able to view the fetched employee")
    public void validate_user_is_able_to_view_the_fetched_employee() {
        boolean value=directoryPage.getrecordsfetched();
        System.out.println(value);
        Assert.assertEquals(value,true);
        log.info("employee odis adalwin is CTO validated sucessfully");

    }
}
