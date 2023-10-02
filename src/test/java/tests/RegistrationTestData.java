package tests;

import static utils.RandomDataUtil.*;

public class RegistrationTestData {

    public static final String FIRST_NAME = randomFirstName(),
            LAST_NAME = randomLastName(),
            FULL_NAME = randomFullName(),
            EMAIL = randomEmail(),
            GENDER = randomGender(),
            PHONE_NUMBER = randomPhoneNumber(),
            INVALID_PHONE_NUMBER = randomInvalidPhoneNumber(),
            BIRTH_DAY = randomDay(),
            BIRTH_MONTH = randomMonth(),
            BIRTH_YEAR = randomYear(),
            DATE_OF_BIRTH = combineIntoDate(BIRTH_DAY, BIRTH_MONTH, BIRTH_YEAR),
            PICTURE_NAME = "human.png",
            PICTURE_PATH = "img/" + PICTURE_NAME,
            CURRENT_ADDRESS = randomAddress(),
            PERMANENT_ADDRESS = randomAddress(),
            STATE = randomState(),
            CITY = randomCityByState(STATE),
            COMPLETE_SUBMIT_MESSAGE = "Thanks for submitting the form";

    public static final String[] SUBJECTS = randomSubjects(),
            HOBBIES = randomHobbies();
}
