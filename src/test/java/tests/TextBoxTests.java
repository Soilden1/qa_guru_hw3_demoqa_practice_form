package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase {

    private static final String FULL_NAME = "Alex Egorov";
    private static final String EMAIL = "alex@egorov.com";
    private static final String CURRENT_ADDRESS = "Some address 1";
    private static final String PERMANENT_ADDRESS = "Another address 1";

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
