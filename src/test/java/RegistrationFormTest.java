import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTest {

    private static final String FIRST_NAME = "Ivan";
    private static final String LAST_NAME = "Ivanov";
    private static final String EMAIL = "IvanovIvan123@gmail.com";
    private static final String GENDER = "Male";
    private static final String PHONE_NUMBER = "8005553535";
    private static final String DATE_OF_BIRTH_DAY = "30";
    private static final String DATE_OF_BIRTH_MONTH = "July";
    private static final String DATE_OF_BIRTH_YEAR = "2023";
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

    @BeforeAll
    static void setUp() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void registrationTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(FIRST_NAME);
        $("#lastName").setValue(LAST_NAME);
        $("#userEmail").setValue(EMAIL);
        $("#genterWrapper").$(byText(GENDER)).click();
        $("#userNumber").setValue(PHONE_NUMBER);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(DATE_OF_BIRTH_MONTH);
        $(".react-datepicker__year-select").selectOption(DATE_OF_BIRTH_YEAR);
        String dayLocator = ".react-datepicker__day--0" + DATE_OF_BIRTH_DAY;
        $(dayLocator + ":not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").setValue(SUBJECT1).sendKeys(Keys.ENTER);
        $("#subjectsInput").setValue(SUBJECT2).sendKeys(Keys.ENTER);

        $("#hobbiesWrapper").$(byText(HOBBY1)).click();
        $("#hobbiesWrapper").$(byText(HOBBY2)).click();

        $("#uploadPicture").uploadFromClasspath(PICTURE_PATH);
        $("#currentAddress").setValue(CURRENT_ADDRESS);

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").click();
        $(".modal-dialog").should(visible);
        $("#example-modal-sizes-title-lg").shouldHave(text(COMPLETE_SUBMIT_MESSAGE));
        $(".table-responsive .table").shouldHave(
                text(FIRST_NAME + " " + LAST_NAME),
                text(EMAIL),
                text(GENDER),
                text(PHONE_NUMBER),
                text(DATE_OF_BIRTH),
                text(SUBJECT1 + ", " + SUBJECT2),
                text(HOBBY1 + ", " + HOBBY2),
                text(PICTURE_NAME),
                text(CURRENT_ADDRESS),
                text(STATE + " " + CITY));
    }
}
