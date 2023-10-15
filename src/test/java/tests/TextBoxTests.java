package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

@Tag("demoqa_text_box_test")
@Owner("dimacm14")
public class TextBoxTests extends TestBase {

    private final TextBoxPage textBoxPage = new TextBoxPage();
    private final RegistrationTestData rtd = new RegistrationTestData();

    @Test
    public void successfulFormInAllFieldsTest() {
        textBoxPage.openPage()
                .setFullName(rtd.fullName)
                .setEmail(rtd.email)
                .setCurrentAddress(rtd.currentAddress)
                .setPermanentAddress(rtd.permanentAddress)
                .submitButtonClick();

        textBoxPage.checkOutputVisible()
                .checkResult("Name:", rtd.fullName)
                .checkResult("Email:", rtd.email)
                .checkResult("Current Address :", rtd.currentAddress)
                .checkResult("Permananet Address :", rtd.permanentAddress);
    }

    @Test
    public void successfulFormInFullNameFieldTest() {
        textBoxPage.openPage()
                .setFullName(rtd.fullName)
                .submitButtonClick();

        textBoxPage.checkOutputVisible()
                .checkResult("Name:", rtd.fullName);
    }

    @Test
    public void negativeFormWithoutFillingFieldsTest() {
        textBoxPage.openPage()
                .submitButtonClick();

        textBoxPage.checkOutputHidden();
    }
}
