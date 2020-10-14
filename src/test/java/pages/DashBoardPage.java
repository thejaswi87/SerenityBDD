package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import testutility.PageTemplate;

public class DashBoardPage extends PageTemplate {

    @FindBy(xpath="//a[contains(text(), 'Welcome')]")
    WebElementFacade loginConfirmation;
    public String confirmLogin(){
        return loginConfirmation.getText();
    }
}
