package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalContentComponent {

    SelenideElement modal = $(".modal-dialog");
    SelenideElement closeButton = $("#closeLargeModal");

    public void checkVisible() {
        modal.should(visible);
    }

    public void checkHidden() {
        modal.should(hidden);
    }

    public void checkTitleHaveMessage(String message) {
        $("#example-modal-sizes-title-lg").shouldHave(text(message));
    }

    public void checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
    }

    public void close() {
        closeButton.click();
    }
}
