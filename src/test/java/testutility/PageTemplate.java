package testutility;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public abstract class PageTemplate extends PageObject {

    private static int EXPLICT_WAIT_TIME = 20;
    private static int IMPLICIT_WAIT_TIME = 10;
    private static int maxNoOfRetries = 2;

    public WebElement findElementByXpath(String xpath){
        try{
            return getDriver().findElement(By.xpath(xpath));
        } catch(Exception e){
            System.out.println("Exception is:" + e.getMessage());
            return findElementByXpath(xpath);
        }
    }

    public void refreshDriver(){
        getDriver().navigate().refresh();
        waitABit(3000);
    }

    protected void click(WebElement element){
        int counter = 0;

        while (maxNoOfRetries > 0 && counter!=maxNoOfRetries){
            try{
                element.click();break;
            }catch(Exception e){
                System.out.println("Exception.." + e.getMessage());
                getDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
                JavascriptExecutor executor = (JavascriptExecutor) getDriver();
                executor.executeScript("arguments[0].click();", element);
            }
            counter++;
        }
        if (counter == maxNoOfRetries)
            element.click();
    }
}
