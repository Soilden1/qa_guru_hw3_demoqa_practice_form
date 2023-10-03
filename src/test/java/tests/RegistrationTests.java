package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationTests extends TestBase {

    private static final RegistrationPage registrationPage = new RegistrationPage();
    private final RegistrationTestData rtd = new RegistrationTestData();

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

    @Test
    public void negativeRegistrationWithoutFillingFieldsTest() {
        registrationPage.openPage()
                .submitButtonClick();

        registrationPage.checkResultModalHidden();
    }
}
