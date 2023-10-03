package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationTests extends TestBase {

    private static final RegistrationPage registrationPage = new RegistrationPage();
    private final RegistrationTestData rtd = new RegistrationTestData();

    @Test
    public void successfulRegistrationInAllFieldsTest() {
        registrationPage.openPage()
                .setFirstName(rtd.FIRST_NAME)
                .setLastName(rtd.LAST_NAME)
                .setEmail(rtd.EMAIL)
                .setGender(rtd.GENDER)
                .setPhoneNumber(rtd.PHONE_NUMBER)
                .setDateOfBirth(rtd.BIRTH_DAY, rtd.BIRTH_MONTH, rtd.BIRTH_YEAR)
                .setSubjects(rtd.SUBJECTS)
                .setHobbies(rtd.HOBBIES)
                .uploadPicture(rtd.PICTURE_PATH)
                .setCurrentAddress(rtd.CURRENT_ADDRESS)
                .setState(rtd.STATE)
                .setCity(rtd.CITY)
                .submitButtonClick();

        registrationPage.checkResultModalVisible()
                .checkResultModalTitleHaveMessage(rtd.COMPLETE_SUBMIT_MESSAGE)
                .checkResult("Student Name", rtd.FIRST_NAME + " " + rtd.LAST_NAME)
                .checkResult("Student Email", rtd.EMAIL)
                .checkResult("Gender", rtd.GENDER)
                .checkResult("Mobile", rtd.PHONE_NUMBER)
                .checkResult("Date of Birth", rtd.DATE_OF_BIRTH)
                .checkResult("Subjects", String.join(", ", rtd.SUBJECTS))
                .checkResult("Hobbies", String.join(", ", rtd.HOBBIES))
                .checkResult("Picture", rtd.PICTURE_NAME)
                .checkResult("Address", rtd.CURRENT_ADDRESS)
                .checkResult("State and City", rtd.STATE + " " + rtd.CITY);
    }

    @Test
    public void successfulRegistrationInRequiredFieldsTest() {
        registrationPage.openPage()
                .setFirstName(rtd.FIRST_NAME)
                .setLastName(rtd.LAST_NAME)
                .setGender(rtd.GENDER)
                .setPhoneNumber(rtd.PHONE_NUMBER)
                .submitButtonClick();

        registrationPage.checkResultModalVisible()
                .checkResultModalTitleHaveMessage(rtd.COMPLETE_SUBMIT_MESSAGE)
                .checkResult("Student Name", rtd.FIRST_NAME + " " + rtd.LAST_NAME)
                .checkResult("Gender", rtd.GENDER)
                .checkResult("Mobile", rtd.PHONE_NUMBER);
    }

    @Test
    public void closeModalTest() {
        registrationPage.openPage()
                .setFirstName(rtd.FIRST_NAME)
                .setLastName(rtd.LAST_NAME)
                .setGender(rtd.GENDER)
                .setPhoneNumber(rtd.PHONE_NUMBER)
                .submitButtonClick();

        registrationPage.checkResultModalVisible()
                .checkResultModalTitleHaveMessage(rtd.COMPLETE_SUBMIT_MESSAGE)
                .closeResultModal()
                .checkResultModalHidden();
    }

    @Test
    public void negativeRegistrationWithInvalidPhoneNumberTest() {
        registrationPage.openPage()
                .setFirstName(rtd.FIRST_NAME)
                .setLastName(rtd.LAST_NAME)
                .setGender(rtd.GENDER)
                .setPhoneNumber(rtd.INVALID_PHONE_NUMBER)
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
