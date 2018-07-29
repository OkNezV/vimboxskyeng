package vimboxskyeng.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Описание страницы авторизации <http://vimbox.skyeng.ru/>
 * @author Oksana Nezlobina <nez_oksana@mail.ru>
 */
@DefaultUrl("http://vimbox.skyeng.ru/")
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    String loginPageSelector = ".l-motion__wrap-930 .p-auth-login__holder";

    @FindBy(css = ".b-auth-login__item [name='_username']")
    public WebElement usernameField;
    @FindBy(css = ".b-auth-login__item [name='_password']")
    public WebElement passwordField;
    @FindBy(css = "button .b-gui-v2-button__label")
    public WebElement loginButton;

    /**
     * Проверяем, что страница авторизации открылась
     * @return boolean
     */
    public boolean isLoginPagePresent() {
        return waitForElementPresent(By.cssSelector(loginPageSelector));
    }

    /**
     * Заполняем поле логина
     * @param login
     */
    public void setLogin(String login) {
        usernameField.clear();
        usernameField.sendKeys(login);
    }

    /*
     * Заполняем поле пароля
     * @param password
     */
    public void setPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    /**
     * Клик по кнопке <Login>
     */
    public void clickSignIn() {
        loginButton.click();
    }
}
