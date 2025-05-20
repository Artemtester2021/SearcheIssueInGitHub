import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    @Test
    public void testIssueSearch() {
        open("https://github.com");

        $(".search-input-container").click();
        $("#query-builder-test").sendKeys("Artemtester2021/demoqa-tests-35");
        $("#query-builder-test").submit();

        $(linkText("Artemtester2021/demoqa-tests-35")).click();
        $("#issues-tab").click();
        $(withText("No results")).should(Condition.exist);

    }
}
