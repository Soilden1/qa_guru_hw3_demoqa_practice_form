package utils;

import com.github.javafaker.Faker;

import java.util.*;

public class RandomDataUtil {

    private static final Faker FAKER = new Faker(new Locale("en-GB"));
    private static final String[] GENDERS = {"Male", "Female", "Other"},
            MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August",
                    "September", "October", "November", "December"},
            SUBJECTS = {"Arts", "Accounting", "Biology", "Computer Science", "Commerce", "Civics",
                    "Economics", "English", "Maths", "History", "Hindi", "Physics", "Chemistry"},
            HOBBIES = {"Sports", "Reading", "Music"};
    private static final Map<String, String[]> STATES_AND_CITIES = new HashMap<>();

    static {
        STATES_AND_CITIES.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        STATES_AND_CITIES.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        STATES_AND_CITIES.put("Haryana", new String[]{"Karnal", "Panipat"});
        STATES_AND_CITIES.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});
    }

    public static String randomFirstName() {
        return FAKER.name().firstName();
    }

    public static String randomLastName() {
        return FAKER.name().lastName();
    }

    public static String randomFullName() {
        return FAKER.name().fullName();
    }

    public static String randomEmail() {
        return FAKER.internet().emailAddress();
    }

    public static String randomGender() {
        return FAKER.options().option(GENDERS);
    }

    public static String randomPhoneNumber() {
        return FAKER.phoneNumber().subscriberNumber(10);
    }

    public static String randomInvalidPhoneNumber() {
        return FAKER.phoneNumber().subscriberNumber(5);
    }

    public static String randomDay() {
        int day = FAKER.random().nextInt(1, 28);
        return day < 10 ? "0" + day : String.valueOf(day);
    }

    public static String randomMonth() {
        return FAKER.options().option(MONTHS);
    }

    public static String randomYear() {
        return FAKER.random().nextInt(1900, 2023).toString();
    }

    public static String combineIntoDate(String day, String month, String year) {
        return day + " " + month + "," + year;
    }

    public static String[] randomSubjects() {
        return randomElementsFromArray(SUBJECTS);
    }

    public static String[] randomHobbies() {
        return randomElementsFromArray(HOBBIES);
    }

    public static String randomAddress() {
        return FAKER.address().fullAddress();
    }

    public static String randomState() {
        return FAKER.options().option(STATES_AND_CITIES.keySet().toArray(new String[0]));
    }

    public static String randomCityByState(String state) {
        return FAKER.options().option(STATES_AND_CITIES.get(state));
    }

    private static String[] randomElementsFromArray(String[] array) {
        List<String> elements = new ArrayList<>(Arrays.asList(array));
        Collections.shuffle(elements);
        int randomCount = FAKER.random().nextInt(0, array.length - 1);
        return elements.subList(0, randomCount).toArray(new String[0]);
    }
}
