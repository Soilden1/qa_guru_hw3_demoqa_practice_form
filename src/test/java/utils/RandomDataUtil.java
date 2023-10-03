package utils;

import com.github.javafaker.Faker;

import java.util.*;

public class RandomDataUtil {

    private final Faker FAKER = new Faker(new Locale("en-GB"));
    private final String[] GENDERS = {"Male", "Female", "Other"},
            MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August",
                    "September", "October", "November", "December"},
            SUBJECTS = {"Arts", "Accounting", "Biology", "Computer Science", "Commerce", "Civics",
                    "Economics", "English", "Maths", "History", "Hindi", "Physics", "Chemistry"},
            HOBBIES = {"Sports", "Reading", "Music"};
    private final Map<String, String[]> STATES_AND_CITIES = new HashMap<>();

    {
        STATES_AND_CITIES.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        STATES_AND_CITIES.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        STATES_AND_CITIES.put("Haryana", new String[]{"Karnal", "Panipat"});
        STATES_AND_CITIES.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});
    }

    public String randomFirstName() {
        return FAKER.name().firstName();
    }

    public String randomLastName() {
        return FAKER.name().lastName();
    }

    public String randomFullName() {
        return FAKER.name().fullName();
    }

    public String randomEmail() {
        return FAKER.internet().emailAddress();
    }

    public String randomGender() {
        return FAKER.options().option(GENDERS);
    }

    public String randomPhoneNumber() {
        return FAKER.phoneNumber().subscriberNumber(10);
    }

    public String randomInvalidPhoneNumber() {
        return FAKER.phoneNumber().subscriberNumber(5);
    }

    public String randomDay() {
        int day = FAKER.random().nextInt(1, 28);
        return day < 10 ? "0" + day : String.valueOf(day);
    }

    public String randomMonth() {
        return FAKER.options().option(MONTHS);
    }

    public String randomYear() {
        return FAKER.random().nextInt(1900, 2023).toString();
    }

    public String combineIntoDate(String day, String month, String year) {
        return day + " " + month + "," + year;
    }

    public String[] randomSubjects() {
        return randomElementsFromArray(SUBJECTS);
    }

    public String[] randomHobbies() {
        return randomElementsFromArray(HOBBIES);
    }

    public String randomAddress() {
        return FAKER.address().fullAddress();
    }

    public String randomState() {
        return FAKER.options().option(STATES_AND_CITIES.keySet().toArray(new String[0]));
    }

    public String randomCityByState(String state) {
        return FAKER.options().option(STATES_AND_CITIES.get(state));
    }

    private String[] randomElementsFromArray(String[] array) {
        List<String> elements = new ArrayList<>(Arrays.asList(array));
        Collections.shuffle(elements);
        int randomCount = FAKER.random().nextInt(1, array.length - 1);
        return elements.subList(0, randomCount).toArray(new String[0]);
    }
}
