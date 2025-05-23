import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SellenideSearchIssueInGitHub {


    @Test
    @DisplayName("Чистый Selenide (с Listener)")
    public void testIssueSearchTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".search-input-container").click();
        $("#query-builder-test").sendKeys("Artemtester2021/demoqa-tests-35");
        $("#query-builder-test").submit();

        $(linkText("Artemtester2021/demoqa-tests-35")).click();
        $("#issues-tab").click();
        $(withText("No results")).should(Condition.exist);

    }
}
