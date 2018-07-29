package vimboxskyeng.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Базовый класс, от которого наследуются все тесты,
 * и содержит методы работы с драйвером.
 *
 * @author Oksana Nezlobina <nez_oksana@mail.ru>
 */
public class BaseTestClass {

    public WebDriver driver;
    private final int DEFAULT_IMPLICITLY_WAIT = 15000;

    /**
     * Инициализатор теста. Аннотация @Before отмечает метод как метод
     * инициализации теста. Метод инициализации теста выполняется перед каждым
     * тестом в тестовом классе.
     */
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/nezlobinaoksana/Tools/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICITLY_WAIT, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }

    /**
     * Финализатор теста. Аннотация @After помечает метод как метод финализации
     * теста. Метод финализатора теста выполняется после каждого теста в
     * тестовом классе.
     */
    @After
    public void tearDown() {
        driver.quit();
    }
}
