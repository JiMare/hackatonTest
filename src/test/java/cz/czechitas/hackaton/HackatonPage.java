package cz.czechitas.hackaton;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import cz.czechitas.*;

public class HackatonPage {

    private final WebDriver driver;

    private final int maxWaitInSeconds = 10;
    private final By searchOnLoginPage = By.id("SubmitLogin");
    private final By searchSignInButton = By.className("user_login");
    private final By searchemail = By.id("email");
    private final By searchpassword = By.id("passwd");
    private final By seacrhSubmitButton = By.id("SubmitLogin");
    private final By searchOnMyAccountPage = By.className("page-heading");

    public HackatonPage(WebDriver driver){
        this.driver = driver;
    }

    public void openPage() {
        driver.navigate().to(Settings.baseUrl);
    }

    public void login(){
        WebElement signInButton = driver.findElement(searchSignInButton);
        signInButton.click();
    }

    public String getNameofElementonLoginPage(){
        WebElement elementOnLoginPageAwaited = new WebDriverWait(driver, maxWaitInSeconds)
                .until(d->d.findElement(searchOnLoginPage));
        return elementOnLoginPageAwaited.getAttribute("name");
    }

    public String loginComplete(){
        driver.navigate().to(Settings.loginPage);
        WebElement email = driver.findElement(searchemail);
        email.sendKeys("hackaton@czechitas.cz");
        WebElement password = driver.findElement(searchpassword);
        password.sendKeys("testujeme");
        WebElement submitButton = driver.findElement(seacrhSubmitButton);
        submitButton.click();
        WebElement ele = new WebDriverWait(driver, maxWaitInSeconds).until(d->d.findElement(searchOnMyAccountPage));
        return ele.getText();
    }
}
