package vimboxskyeng.tests;

import vimboxskyeng.pages.LoginPage;
import org.junit.Test;
import vimboxskyeng.pages.MainPage;


import static org.junit.Assert.assertTrue;

/**
 * Проверка, что после продолжения урока, есть возможность его закрыть.
 * @author Oksana Nezlobina <nez_oksana@mail.ru>
 */
public class TalkingAboutHistoryLessonClosingTest extends BaseTestClass {

    @Test
    public void talking_about_history_lesson_closing_test() {
        String login = "user10025@example.com";
        String password = "password";
        String course = "Spoken";
        String level = "Advanced";

        LoginPage loginPage = new LoginPage(driver);

        // Шаг 1. Открыть <http://vimbox.skyeng.ru>
        driver.get("http://vimbox.skyeng.ru");
        assertTrue("Страница авторизации не отображается", loginPage.isLoginPagePresent());

        // Шаг 2. Авторизоваться под учеткой
        loginPage.setLogin(login);
        loginPage.setPassword(password);
        loginPage.clickSignIn();

        // Проверка, что авторизация прошла
        MainPage mainPage = new MainPage(driver);

        // Проверка, что страница с уроками открылась
        assertTrue("Страница с уроками не отображается", mainPage.isMainPagePresent());
        assertTrue("URL страницы отличается от ожидаемого", driver.getCurrentUrl().contains("vimbox.skyeng.ru/showcase"));

        // Шаг 3. Выбрать курс <Spoken>
        assertTrue("Курса <Spoken> нет в списке предлагаемых", mainPage.isCoursePresent(course));
        mainPage.clickCourse(course);

        // Шаг 4. Выбираем уровень Advanced
        assertTrue("Блок курса <Spoken> не отображается", mainPage.isCourseBlockPresent(course));
        assertTrue("Уровня <Advanced> нет в списке предлагаемых", mainPage.isLevelPresent(level));
        mainPage.clickLevel(level);

        // Шаг 5. Открыть урок <Talking about history>
        // Шаг 6. Нажать Continue to Lesson
        // Шаг 7. Закрыть урок
    }
}
