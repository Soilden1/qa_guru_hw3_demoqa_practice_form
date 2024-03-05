package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

@Tag("saby")
public class Sabytest extends LocalTestBase {
    @Test
    public void openTest() {
        open("https://test-online.sbis.ru/");
    }
}
