package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import testutility.PageTemplate;

public class HRMLoginPage extends PageTemplate {

        @FindBy(xpath="//input[@id='txtUsername']")
        WebElementFacade userName;
        public void enterUserName(String name){
                userName.sendKeys(name);
        }

        @FindBy(xpath="//input[@id='txtPassword']")
        WebElementFacade loginPassword;
        public void enterPassword(String password){
                loginPassword.sendKeys(password);
        }

        @FindBy(xpath="//input[@id='btnLogin']")
        WebElementFacade loginButton;
        public void clickLoginBtn(){
                loginButton.click();
        }

        public String getLoginError(String errorMsg){
                String xpath = "//span[contains(text(), '"+ errorMsg +"')]";
                return findElementByXpath(xpath).getText();
        }
}


