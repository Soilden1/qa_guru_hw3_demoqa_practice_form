package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class OutputComponent {

    SelenideElement output = $("#output");

    public void checkVisible() {
        output.should(visible);
    }

    public void checkHidden() {
        output.should(visible);
    }

    public void checkResult(String key, String value) {
        output.$(byText(key)).parent().shouldHave(text(value));
    }
}
