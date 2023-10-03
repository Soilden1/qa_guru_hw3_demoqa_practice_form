package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import pages.components.CalendarComponent;
import pages.components.DropDownListComponent;
import pages.components.ModalContentComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    // Components and selenide elements
    CalendarComponent calendar = new CalendarComponent();
    DropDownListComponent dropDownList = new DropDownListComponent();
    ModalContentComponent resultTable = new ModalContentComponent();

    SelenideElement titleLabel = $(".practice-form-wrapper"),
                    firstNameInput = $("#firstName"),
                    lastNameInput = $("#lastName"),
                    emailInput = $("#userEmail"),
                    genderWrapper = $("#genterWrapper"),
                    phoneNumberInput = $("#userNumber"),
                    dateOfBirthInput = $("#dateOfBirthInput"),
                    subjectsInput = $("#subjectsInput"),
                    hobbiesWrapper = $("#hobbiesWrapper"),
                    uploadPictureInput = $("#uploadPicture"),
                    currentAddress = $("#currentAddress"),
                    state = $("#state"),
                    city = $("#city"),
                    submitButton = $("#submit");

    // Actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        titleLabel.shouldHave(text("Student Registration Form"));
        removeBannersAndFooters();
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        phoneNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String... subjects) {
        for (String subject : subjects) {
            subjectsInput.setValue(subject).sendKeys(Keys.ENTER);
        }
        return this;
    }

    public RegistrationPage setHobbies(String... hobbies) {
        for (String hobby : hobbies) {
            hobbiesWrapper.$(byText(hobby)).click();
        }
        return this;
    }

    public RegistrationPage uploadPicture(String path) {
        uploadPictureInput.uploadFromClasspath(path);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        state.click();
        dropDownList.selectValue(state, value);
        return this;
    }

    public RegistrationPage setCity(String value) {
        city.click();
        dropDownList.selectValue(city, value);
        return this;
    }

    public void submitButtonClick() {
        submitButton.click();
    }

    public RegistrationPage checkResultModalVisible() {
        resultTable.checkVisible();
        return this;
    }

    public RegistrationPage checkResultModalHidden() {
        resultTable.checkHidden();
        return this;
    }

    public RegistrationPage checkResultModalTitleHaveMessage(String messages) {
        resultTable.checkTitleHaveMessage(messages);
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        resultTable.checkResult(key, value);
        return this;
    }

    public RegistrationPage closeResultModal() {
        resultTable.close();
        return this;
    }

    private void removeBannersAndFooters() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }
}
