package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

@Tag("demoqa_registration_test")
@Feature("Регистрация")
@Owner("dimacm14")
@Severity(SeverityLevel.BLOCKER)
public class RegistrationTests extends TestBase {

    private final RegistrationPage registrationPage = new RegistrationPage();
    private final RegistrationTestData rtd = new RegistrationTestData();

    @Story("Регистрация с заполнением всех полей")
    @DisplayName("Регистрация с заполнением всех полей")
    @Test
    public void successfulRegistrationInAllFieldsTest() {
        registrationPage.openPage()
                .setFirstName(rtd.firstName)
                .setLastName(rtd.lastName)
                .setEmail(rtd.email)
                .setGender(rtd.gender)
                .setPhoneNumber(rtd.phoneNumber)
                .setDateOfBirth(rtd.birthDay, rtd.birthMonth, rtd.birthYear)
                .setSubjects(rtd.subjects)
                .setHobbies(rtd.hobbies)
                .uploadPicture(rtd.picturePath)
                .setCurrentAddress(rtd.currentAddress)
                .setState(rtd.state)
                .setCity(rtd.city)
                .submitButtonClick();

        registrationPage.checkResultModalVisible()
                .checkResultModalTitleHaveMessage(rtd.completeSubmitMessage)
                .checkResult("Student Name", rtd.firstName + " " + rtd.lastName)
                .checkResult("Student Email", rtd.email)
                .checkResult("Gender", rtd.gender)
                .checkResult("Mobile", rtd.phoneNumber)
                .checkResult("Date of Birth", rtd.dateOfBirth)
                .checkResult("Subjects", String.join(", ", rtd.subjects))
                .checkResult("Hobbies", String.join(", ", rtd.hobbies))
                .checkResult("Picture", rtd.pictureName)
                .checkResult("Address", rtd.currentAddress)
                .checkResult("State and City", rtd.state + " " + rtd.city);
    }

    @Story("Регистрация с заполнением обязательных полей")
    @DisplayName("Регистрация с заполнением обязательных полей")
    @Test
    public void successfulRegistrationInRequiredFieldsTest() {
        registrationPage.openPage()
                .setFirstName(rtd.firstName)
                .setLastName(rtd.lastName)
                .setGender(rtd.gender)
                .setPhoneNumber(rtd.phoneNumber)
                .submitButtonClick();

        registrationPage.checkResultModalVisible()
                .checkResultModalTitleHaveMessage(rtd.completeSubmitMessage)
                .checkResult("Student Name", rtd.firstName + " " + rtd.lastName)
                .checkResult("Gender", rtd.gender)
                .checkResult("Mobile", rtd.phoneNumber);
    }

    @Story("Регистрация с заполнением обязательных полей")
    @DisplayName("Результирующее модальное окно закрывается при нажатии кнопки 'Close'")
    @Test
    public void closeModalTest() {
        registrationPage.openPage()
                .setFirstName(rtd.firstName)
                .setLastName(rtd.lastName)
                .setGender(rtd.gender)
                .setPhoneNumber(rtd.phoneNumber)
                .submitButtonClick();

        registrationPage.checkResultModalVisible()
                .checkResultModalTitleHaveMessage(rtd.completeSubmitMessage)
                .closeResultModal()
                .checkResultModalHidden();
    }

    @Story("Регистрация с заполнением обязательных полей")
    @DisplayName("При вводе невалидного номера телефона результирующее модальное окно не отображается")
    @Test
    public void negativeRegistrationWithInvalidPhoneNumberTest() {
        registrationPage.openPage()
                .setFirstName(rtd.firstName)
                .setLastName(rtd.lastName)
                .setGender(rtd.gender)
                .setPhoneNumber(rtd.invalidPhoneNumber)
                .submitButtonClick();

        registrationPage.checkResultModalHidden();
    }

    @Story("Регистрация с заполнением обязательных полей")
    @DisplayName("При клике на кнопку 'Submit' без заполнения обязательных полей результирующее модальное окно не отображается")
    @Test
    public void negativeRegistrationWithoutFillingFieldsTest() {
        registrationPage.openPage()
                .submitButtonClick();

        registrationPage.checkResultModalHidden();
    }
}
