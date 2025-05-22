import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPageTest(){
        open("https://github.com");
    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepositoryTest(String repo) {
        $(".search-input-container").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").submit();
    }

    @Step("Кликаем по ссылке репозитория {repo}")
    public void clickOnRepozitoryLinkTest(String repo) {
        $(linkText("Artemtester2021/demoqa-tests-35")).click();
    }

    @Step("Открываем таб Issue")
    public void openIssueTabTest() {
        $("#issues-tab").click();
    }

    @Step("Проверяем содержание вкладки Issue {RESULT}")
    public void shouldSeeIssueWithResultTest(String RESULT) {
        $(withText(RESULT)).should(Condition.exist);
    }
}
