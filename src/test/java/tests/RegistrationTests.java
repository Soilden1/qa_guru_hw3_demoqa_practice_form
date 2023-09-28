package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationTests extends TestBase {

    // Test data
    private static final String FIRST_NAME = "Ivan";
    private static final String LAST_NAME = "Ivanov";
    private static final String EMAIL = "IvanovIvan123@gmail.com";
    private static final String GENDER = "Male";
    private static final String PHONE_NUMBER = "8005553535";
    private static final String INVALID_PHONE_NUMBER = "111";
    private static final String DATE_OF_BIRTH_DAY = "30";
    private static final String DATE_OF_BIRTH_MONTH = "July";
    private static final String DATE_OF_BIRTH_YEAR = "2004";
    private static final String DATE_OF_BIRTH = DATE_OF_BIRTH_DAY + " " + DATE_OF_BIRTH_MONTH + "," + DATE_OF_BIRTH_YEAR;
    private static final String SUBJECT1 = "Computer Science";
    private static final String SUBJECT2 = "English";
    private static final String HOBBY1 = "Reading";
    private static final String HOBBY2 = "Music";
    private static final String PICTURE_PATH = "img/human.png";
    private static final String PICTURE_NAME = "human.png";
    private static final String CURRENT_ADDRESS = "Pushkin street, house 333";
    private static final String STATE = "NCR";
    private static final String CITY = "Delhi";
    private static final String COMPLETE_SUBMIT_MESSAGE = "Thanks for submitting the form";

    private static final RegistrationPage registrationPage = new RegistrationPage();

    // Tests
    @Test
    public void successfulRegistrationInAllFieldsTest() {
        registrationPage.openPage()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setEmail(EMAIL)
                .setGender(GENDER)
                .setPhoneNumber(PHONE_NUMBER)
                .setDateOfBirth(DATE_OF_BIRTH_DAY, DATE_OF_BIRTH_MONTH, DATE_OF_BIRTH_YEAR)
                .setSubjects(SUBJECT1, SUBJECT2)
                .setHobbies(HOBBY1, HOBBY2)
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
                .checkResult("Subjects", SUBJECT1 + ", " + SUBJECT2)
                .checkResult("Hobbies", HOBBY1 + ", " + HOBBY2)
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
