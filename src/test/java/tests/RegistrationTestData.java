package tests;

import utils.RandomDataUtil;

public class RegistrationTestData {

    private final RandomDataUtil rd = new RandomDataUtil();

    public final String firstName = rd.randomFirstName(),
            lastName = rd.randomLastName(),
            fullName = rd.randomFullName(),
            email = rd.randomEmail(),
            gender = rd.randomGender(),
            phoneNumber = rd.randomPhoneNumber(),
            invalidPhoneNumber = rd.randomInvalidPhoneNumber(),
            birthDay = rd.randomDay(),
            birthMonth = rd.randomMonth(),
            birthYear = rd.randomYear(),
            dateOfBirth = rd.combineIntoDate(birthDay, birthMonth, birthYear),
            pictureName = "human.png",
            picturePath = "img/" + pictureName,
            currentAddress = rd.randomAddress(),
            permanentAddress = rd.randomAddress(),
            state = rd.randomState(),
            city = rd.randomCityByState(state),
            completeSubmitMessage = "Thanks for submitting the form";

    public final String[] subjects = rd.randomSubjects(),
            hobbies = rd.randomHobbies();
}
