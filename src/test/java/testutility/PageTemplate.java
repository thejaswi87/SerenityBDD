package testutility;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class PageTemplate extends PageObject {

    public WebElement findElementByXpath(String xpath){
        try{
            return getDriver().findElement(By.xpath(xpath));
        } catch(Exception e){
            System.out.println("Exception is:" + e.getMessage());
            return findElementByXpath(xpath);
        }
    }

}
