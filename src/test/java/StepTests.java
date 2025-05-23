import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepTests {

    private static final String REPOZITORY = "Artemtester2021/demoqa-tests-35";
    private static final String RESULT = "No results";

    @Test
    @DisplayName("Лямбда шаги через step (name, () -> {})")
    public void lambdaStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOZITORY, () -> {
            $(".search-input-container").click();
            $("#query-builder-test").sendKeys("Artemtester2021/demoqa-tests-35");
            $("#query-builder-test").submit();
        });
        step("Кликаем по ссылке репозитория " + REPOZITORY, () -> {
            $(linkText("Artemtester2021/demoqa-tests-35")).click();
        });
        step("Открываем таб Issue", () ->{
            $("#issues-tab").click();
        });
        step("Проверяем содержание вкладки Issue " + RESULT, () -> {
            $(withText(RESULT)).should(Condition.exist);
        });
    }

    @Test
    @DisplayName("Проверка через аннотации")
    public void testAnnotatedStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPageTest();
        steps.searchForRepositoryTest(REPOZITORY);
        steps.clickOnRepozitoryLinkTest(REPOZITORY);
        steps.openIssueTabTest();
        steps.shouldSeeIssueWithResultTest(RESULT);
    }
}
