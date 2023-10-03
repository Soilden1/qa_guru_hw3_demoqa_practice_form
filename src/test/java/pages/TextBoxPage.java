package pages;

import com.codeborne.selenide.SelenideElement;
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

    public TextBoxPage openPage() {
        open("/text-box");
        removeBannersAndFooters();
        return this;
    }

    public TextBoxPage setFullName(String value) {
        fullNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public void submitButtonClick() {
        submitButton.click();
    }

    public TextBoxPage checkOutputVisible() {
        output.checkVisible();
        return this;
    }

    public TextBoxPage checkOutputHidden() {
        output.checkHidden();
        return this;
    }

    public TextBoxPage checkResult(String key, String value) {
        output.checkResult(key, value);
        return this;
    }

    private void removeBannersAndFooters() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }
}
