package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.RegistrationTestData.*;

public class RegistrationTests extends TestBase {

    private static final RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void successfulRegistrationInAllFieldsTest() {
        registrationPage.openPage()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setEmail(EMAIL)
                .setGender(GENDER)
                .setPhoneNumber(PHONE_NUMBER)
                .setDateOfBirth(BIRTH_DAY, BIRTH_MONTH, BIRTH_YEAR)
                .setSubjects(SUBJECTS)
                .setHobbies(HOBBIES)
                .uploadPicture(PICTURE_PATH)
                .setCurrentAddress(CURRENT_ADDRESS)
                .setState(STATE)
                .setCity(CITY)
                .submitButtonClick();

        registrationPage.checkResultModalVisible()
                .checkResultModalTitleHaveMessage(COMPLETE_SUBMIT_MESSAGE)
                .checkResult("Student Name", FIRST_NAME + " " + LAST_NAME)
                .checkResult("Student Email", EMAIL)
                .checkResult("Gender", GENDER)
                .checkResult("Mobile", PHONE_NUMBER)
                .checkResult("Date of Birth", DATE_OF_BIRTH)
                .checkResult("Subjects", String.join(", ", SUBJECTS))
                .checkResult("Hobbies", String.join(", ", HOBBIES))
                .checkResult("Picture", PICTURE_NAME)
                .checkResult("Address", CURRENT_ADDRESS)
                .checkResult("State and City", STATE + " " + CITY);
    }

    @Test
    public void successfulRegistrationInRequiredFieldsTest() {
        registrationPage.openPage()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setGender(GENDER)
                .setPhoneNumber(PHONE_NUMBER)
                .submitButtonClick();

        registrationPage.checkResultModalVisible()
                .checkResultModalTitleHaveMessage(COMPLETE_SUBMIT_MESSAGE)
                .checkResult("Student Name", FIRST_NAME + " " + LAST_NAME)
                .checkResult("Gender", GENDER)
                .checkResult("Mobile", PHONE_NUMBER);
    }

    @Test
    public void closeModalTest() {
        registrationPage.openPage()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setGender(GENDER)
                .setPhoneNumber(PHONE_NUMBER)
                .submitButtonClick();

        registrationPage.checkResultModalVisible()
                .checkResultModalTitleHaveMessage(COMPLETE_SUBMIT_MESSAGE)
                .closeResultModal()
                .checkResultModalHidden();
    }

    @Test
    public void negativeRegistrationWithInvalidPhoneNumberTest() {
        registrationPage.openPage()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setGender(GENDER)
                .setPhoneNumber(INVALID_PHONE_NUMBER)
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
