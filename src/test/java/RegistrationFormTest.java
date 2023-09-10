import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTest {

    @BeforeAll
    static void setUp() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void RegistrationTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("IvanovIvan123@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8005553535");

        $("#dateOfBirthInput").sendKeys(Keys.CONTROL, "A");
        $("#dateOfBirthInput").sendKeys("07 Jan 2004", Keys.ENTER);

        $("#subjectsInput").setValue("Computer Science").sendKeys(Keys.ENTER);
        $("#subjectsInput").setValue("English").sendKeys(Keys.ENTER);

        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFile(new File("resources/human.png"));
        $("#currentAddress").setValue("Pushkin street, house 333");
        $("#stateCity-wrapper #state input").setValue("NCR").sendKeys(Keys.ENTER);
        $("#stateCity-wrapper #city input").setValue("Delhi").sendKeys(Keys.ENTER);
        $("#submit").click();

        SelenideElement table = $(".table-responsive .table");
        List<SelenideElement> rows = table.findAll("tr");

        $(".modal-header .modal-title").shouldHave(text("Thanks for submitting the form"));
        rows.get(1).shouldHave(text("Ivan Ivanov"));
        rows.get(2).shouldHave(text("IvanovIvan123@gmail.com"));
        rows.get(3).shouldHave(text("Male"));
        rows.get(4).shouldHave(text("8005553535"));
        rows.get(5).shouldHave(text("07 January,2004"));
        rows.get(6).shouldHave(text("Computer Science, English"));
        rows.get(7).shouldHave(text("Reading, Music"));
        rows.get(8).shouldHave(text("human.png"));
        rows.get(9).shouldHave(text("Pushkin street, house 333"));
        rows.get(10).shouldHave(text("NCR Delhi"));
    }
}
