package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashBoardPage;
import pages.HRMLoginPage;

public class HRMLoginSteps {

    HRMLoginPage hrmLoginPage;
    DashBoardPage dashBoardPage;

    @Given("^I am on HRMLogin page$")
    public void navigateToHomePage(){
        hrmLoginPage.open();
    }

    @Given("^I enter (.*) username and (.*) password$")
    public void enterUsernamePassword(String userName, String passWord){
        if(userName.equalsIgnoreCase("blank")){
            hrmLoginPage.enterPassword(passWord);
        }else if(passWord.equalsIgnoreCase("blank")) {
            hrmLoginPage.enterUserName(userName);
        }else if(!(userName.equalsIgnoreCase("blank") && passWord.equalsIgnoreCase("blank"))){
            hrmLoginPage.enterUserName(userName);
            hrmLoginPage.enterPassword(passWord);
        }
    }

    @When("^I click on login button$")
    public void clickLoginButton(){
        hrmLoginPage.clickLoginBtn();
    }

    @Then("^Login should be successfull$")
    public void validateLogin(){
        Assert.assertTrue("Login is not successful", dashBoardPage.confirmLogin().contains("Welcome"));
    }

    @Then("^Login is unsuccessfull because of (InvalidCredentials|BlankUsername|BlankPassword)$")
    public void validateLoginForInvalidCredentials(String reason){
        switch(reason){
            case "InvalidCredentials":
                Assert.assertTrue("Login is unsuccessful due to invalid credentials", hrmLoginPage.getLoginError("Invalid credentials").contentEquals("Invalid credentials"));
                break;
            case "BlankUsername":
                Assert.assertTrue("Login is unsuccessful due to blank username", hrmLoginPage.getLoginError("Username cannot be empty").contentEquals("Username cannot be empty"));
                break;
            default:
                Assert.assertTrue("Login is unsuccessful due to blank password", hrmLoginPage.getLoginError("Password cannot be empty").contentEquals("Password cannot be empty"));
        }
    }
}
