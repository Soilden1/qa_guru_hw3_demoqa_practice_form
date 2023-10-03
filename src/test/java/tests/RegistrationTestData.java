package tests;

import utils.RandomDataUtil;

public class RegistrationTestData {

    private final RandomDataUtil rd = new RandomDataUtil();

    public final String FIRST_NAME = rd.randomFirstName(),
            LAST_NAME = rd.randomLastName(),
            FULL_NAME = rd.randomFullName(),
            EMAIL = rd.randomEmail(),
            GENDER = rd.randomGender(),
            PHONE_NUMBER = rd.randomPhoneNumber(),
            INVALID_PHONE_NUMBER = rd.randomInvalidPhoneNumber(),
            BIRTH_DAY = rd.randomDay(),
            BIRTH_MONTH = rd.randomMonth(),
            BIRTH_YEAR = rd.randomYear(),
            DATE_OF_BIRTH = rd.combineIntoDate(BIRTH_DAY, BIRTH_MONTH, BIRTH_YEAR),
            PICTURE_NAME = "human.png",
            PICTURE_PATH = "img/" + PICTURE_NAME,
            CURRENT_ADDRESS = rd.randomAddress(),
            PERMANENT_ADDRESS = rd.randomAddress(),
            STATE = rd.randomState(),
            CITY = rd.randomCityByState(STATE),
            COMPLETE_SUBMIT_MESSAGE = "Thanks for submitting the form";

    public final String[] SUBJECTS = rd.randomSubjects(),
            HOBBIES = rd.randomHobbies();
}
