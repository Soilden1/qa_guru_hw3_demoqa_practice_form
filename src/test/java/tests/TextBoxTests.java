package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static tests.RegistrationTestData.*;

public class TextBoxTests extends TestBase {

    private static final TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    public void successfulFormInAllFieldsTest() {
        textBoxPage.openPage()
                .setFullName(FULL_NAME)
                .setEmail(EMAIL)
                .setCurrentAddress(CURRENT_ADDRESS)
                .setPermanentAddress(PERMANENT_ADDRESS)
                .submitButtonClick();

        textBoxPage.checkOutputVisible()
                .checkResult("Name:", FULL_NAME)
                .checkResult("Email:", EMAIL)
                .checkResult("Current Address :", CURRENT_ADDRESS)
                .checkResult("Permananet Address :", PERMANENT_ADDRESS);
    }

    @Test
    public void successfulFormInFullNameFieldTest() {
        textBoxPage.openPage()
                .setFullName(FULL_NAME)
                .submitButtonClick();

        textBoxPage.checkOutputVisible()
                .checkResult("Name:", FULL_NAME);
    }

    @Test
    public void negativeFormWithoutFillingFieldsTest() {
        textBoxPage.openPage()
                .submitButtonClick();

        textBoxPage.checkOutputHidden();
    }
}
