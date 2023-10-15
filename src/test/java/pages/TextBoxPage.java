package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.OutputComponent;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {

    OutputComponent output = new OutputComponent();

    SelenideElement fullNameInput = $("#userName"),
                    emailInput = $("#userEmail"),
                    currentAddressInput = $("#currentAddress"),
                    permanentAddressInput = $("#permanentAddress"),
                    submitButton = $("#submit");

    @Step("Открыть страницу")
    public TextBoxPage openPage() {
        open("/text-box");
        removeBannersAndFooters();
        return this;
    }

    @Step("Ввести полное имя: {value}")
    public TextBoxPage setFullName(String value) {
        fullNameInput.setValue(value);
        return this;
    }

    @Step("Ввести email: {value}")
    public TextBoxPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    @Step("Ввести текущий адрес: {value}")
    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    @Step("Ввести постоянный адрес {value}")
    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    @Step("Нажать кнопку отправки формы")
    public void submitButtonClick() {
        submitButton.click();
    }

    @Step("Вывод отображается")
    public TextBoxPage checkOutputVisible() {
        output.checkVisible();
        return this;
    }

    @Step("Вывод не отображается")
    public TextBoxPage checkOutputHidden() {
        output.checkHidden();
        return this;
    }

    @Step("Проверить результат для {key} : {value}")
    public TextBoxPage checkResult(String key, String value) {
        output.checkResult(key, value);
        return this;
    }

    @Step("Удалить баннеры и футеры")
    private void removeBannersAndFooters() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }
}
