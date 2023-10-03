package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase {

    private static final TextBoxPage textBoxPage = new TextBoxPage();
    private final RegistrationTestData rtd = new RegistrationTestData();

    @Test
    public void successfulFormInAllFieldsTest() {
        textBoxPage.openPage()
                .setFullName(rtd.FULL_NAME)
                .setEmail(rtd.EMAIL)
                .setCurrentAddress(rtd.CURRENT_ADDRESS)
                .setPermanentAddress(rtd.PERMANENT_ADDRESS)
                .submitButtonClick();

        textBoxPage.checkOutputVisible()
                .checkResult("Name:", rtd.FULL_NAME)
                .checkResult("Email:", rtd.EMAIL)
                .checkResult("Current Address :", rtd.CURRENT_ADDRESS)
                .checkResult("Permananet Address :", rtd.PERMANENT_ADDRESS);
    }

    @Test
    public void successfulFormInFullNameFieldTest() {
        textBoxPage.openPage()
                .setFullName(rtd.FULL_NAME)
                .submitButtonClick();

        textBoxPage.checkOutputVisible()
                .checkResult("Name:", rtd.FULL_NAME);
    }

    @Test
    public void negativeFormWithoutFillingFieldsTest() {
        textBoxPage.openPage()
                .submitButtonClick();

        textBoxPage.checkOutputHidden();
    }
}
