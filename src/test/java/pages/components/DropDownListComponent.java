package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;

public class DropDownListComponent {

    public void selectValue(SelenideElement dropDownList, String value) {
        dropDownList.$(byText(value)).click();
    }
}
