package utils;

import com.github.javafaker.Faker;

import java.util.*;

public class RandomDataUtil {

    private final Faker faker = new Faker(new Locale("en-GB"));
    private final String[] genders = {"Male", "Female", "Other"},
            months = {"January", "February", "March", "April", "May", "June", "July", "August",
                    "September", "October", "November", "December"},
            subjects = {"Arts", "Accounting", "Biology", "Computer Science", "Commerce", "Civics",
                    "Economics", "English", "Maths", "History", "Hindi", "Physics", "Chemistry"},
            hobbies = {"Sports", "Reading", "Music"};
    private final Map<String, String[]> statesAndCities = new HashMap<>();

    {
        statesAndCities.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        statesAndCities.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        statesAndCities.put("Haryana", new String[]{"Karnal", "Panipat"});
        statesAndCities.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});
    }

    public String randomFirstName() {
        return faker.name().firstName();
    }

    public String randomLastName() {
        return faker.name().lastName();
    }

    public String randomFullName() {
        return faker.name().fullName();
    }

    public String randomEmail() {
        return faker.internet().emailAddress();
    }

    public String randomGender() {
        return faker.options().option(genders);
    }

    public String randomPhoneNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String randomInvalidPhoneNumber() {
        return faker.phoneNumber().subscriberNumber(5);
    }

    public String randomDay() {
        int day = faker.random().nextInt(1, 28);
        return day < 10 ? "0" + day : String.valueOf(day);
    }

    public String randomMonth() {
        return faker.options().option(months);
    }

    public String randomYear() {
        return faker.random().nextInt(1900, 2023).toString();
    }

    public String combineIntoDate(String day, String month, String year) {
        return day + " " + month + "," + year;
    }

    public String[] randomSubjects() {
        return randomElementsFromArray(subjects);
    }

    public String[] randomHobbies() {
        return randomElementsFromArray(hobbies);
    }

    public String randomAddress() {
        return faker.address().fullAddress();
    }

    public String randomState() {
        return faker.options().option(statesAndCities.keySet().toArray(new String[0]));
    }

    public String randomCityByState(String state) {
        return faker.options().option(statesAndCities.get(state));
    }

    private String[] randomElementsFromArray(String[] array) {
        List<String> elements = new ArrayList<>(Arrays.asList(array));
        Collections.shuffle(elements);
        int randomCount = faker.random().nextInt(1, array.length - 1);
        return elements.subList(0, randomCount).toArray(new String[0]);
    }
}
