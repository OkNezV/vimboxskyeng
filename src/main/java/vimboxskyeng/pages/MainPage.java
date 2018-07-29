package vimboxskyeng.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Описание главной страницы <vimbox.skyeng.ru>
 * @author Oksana Nezlobina <nez_oksana@mail.ru>
 */
public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    String mainPageSelector = "vim-rooms-student-showcase-page .content-holder";
    String courseLocator = "//*[@data-qa-id='programs-item']//div[2][contains(text(), '%s')]";
    String courseBlockLocator = "//vim-rooms-program-list//*[@class='program-list_title_2k9an'][contains(text(), '%s')]";
    String levelCourseLocator = "//*[@data-qa-id='tabs-item'][contains(text(), '%s')]";

    @FindBy(css = ".b-auth-login__item [name='_username']")
    public WebElement usernameField;
    @FindBy(css = ".b-auth-login__item [name='_password']")
    public WebElement passwordField;
    @FindBy(css = "button .b-gui-v2-button__label")
    public WebElement loginButton;
    @FindBy(xpath = "//*[@data-qa-id='programs-item']//div[2][contains(text(), 'Spoken')]")
    public WebElement course;
    @FindBy(xpath = "//*[@data-qa-id='tabs-item'][contains(text(), 'Advanced')]")
    public WebElement levelCourse;

    /**
     * Проверяем, что страница с уроками открылась
     * @return boolean
     */
    public boolean isMainPagePresent() {
        return waitForElementPresent(By.cssSelector(mainPageSelector));
    }

    /**
     * Проверяем, что курс <name> присутвует
     * @param name
     * @return boolean
     */
    public boolean isCoursePresent(String name){
        return waitForElementPresent(By.xpath(String.format(courseLocator, name)));
    }

    /**
     * Клик по указанному курсу
     * @param name
     */
    public void clickCourse(String name) {
        course.click();
    }

    /**
     * Проверяем, что блок курса <name> появился
     * @param name
     * @return boolean
     */
    public boolean isCourseBlockPresent(String name){
        return waitForElementPresent(By.xpath(String.format(courseBlockLocator, name)));
    }

    /**
     * Проверяем, что уровень <name> присутвует
     * @param name
     * @return boolean
     */
    public boolean isLevelPresent(String name){
        return waitForElementPresent(By.xpath(String.format(levelCourseLocator, name)));
    }

    /**
     * Клик по указанному уровню
     * @param name
     */
    public void clickLevel(String name) {
        levelCourse.click();
    }
}
