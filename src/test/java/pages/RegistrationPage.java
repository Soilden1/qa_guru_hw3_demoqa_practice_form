package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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
    @Step("Открыть страницу регистрации")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        titleLabel.shouldHave(text("Student Registration Form"));
        removeBannersAndFooters();
        return this;
    }

    @Step("Ввести имя: {value}")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Ввести фамилию: {value}")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Ввести email: {value}")
    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    @Step("Выбрать пол: {value}")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Ввести номер телефона: {value}")
    public RegistrationPage setPhoneNumber(String value) {
        phoneNumberInput.setValue(value);
        return this;
    }

    @Step("Ввести дату рождения: {day}.{month}.{year}")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    @Step("Ввести предметы: {subjects}")
    public RegistrationPage setSubjects(String... subjects) {
        for (String subject : subjects) {
            subjectsInput.setValue(subject).sendKeys(Keys.ENTER);
        }
        return this;
    }

    @Step("Выбрать увлечения: {hobbies}")
    public RegistrationPage setHobbies(String... hobbies) {
        for (String hobby : hobbies) {
            hobbiesWrapper.$(byText(hobby)).click();
        }
        return this;
    }

    @Step("Загрузить картинку по пути {path}")
    public RegistrationPage uploadPicture(String path) {
        uploadPictureInput.uploadFromClasspath(path);
        return this;
    }

    @Step("Ввести текущий адрес: {value}")
    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    @Step("Выбрать штат: {value}")
    public RegistrationPage setState(String value) {
        state.click();
        dropDownList.selectValue(state, value);
        return this;
    }

    @Step("Выбрать город: {value}")
    public RegistrationPage setCity(String value) {
        city.click();
        dropDownList.selectValue(city, value);
        return this;
    }

    @Step("Нажать кнопку отправки формы")
    public void submitButtonClick() {
        submitButton.click();
    }

    @Step("Результирующее модальное окно отображается")
    public RegistrationPage checkResultModalVisible() {
        resultTable.checkVisible();
        return this;
    }

    @Step("Результирующее модальное окно не отображается")
    public RegistrationPage checkResultModalHidden() {
        resultTable.checkHidden();
        return this;
    }

    @Step("Результирующее модальное окно содержит сообщение '{messages}' в заголовке")
    public RegistrationPage checkResultModalTitleHaveMessage(String messages) {
        resultTable.checkTitleHaveMessage(messages);
        return this;
    }

    @Step("Проверить результат для {key} : {value}")
    public RegistrationPage checkResult(String key, String value) {
        resultTable.checkResult(key, value);
        return this;
    }

    @Step("Закрыть результирующее модальное окно")
    public RegistrationPage closeResultModal() {
        resultTable.close();
        return this;
    }

    @Step("Удалить баннеры и футеры")
    private void removeBannersAndFooters() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }
}
