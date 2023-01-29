package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Data;

import java.io.File;
import java.util.List;
import java.util.Random;

@Data
public class DataFaker {
    private static final Random random = new Random();
    private static DataFaker instance;

    private List<String> firstname;
    private List<String> lastname;
    private List<String> gender;
    private List<String> countryEN;
    private List<String> countryTR;
    private List<String> cities;
    private List<String> gameOfThronesCharacters;

    private DataFaker() {
    }

    public static DataFaker getInstance() {
        if (instance == null) {
            try {
                ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
                instance = mapper.readValue(new File("./src/test/resources/data_faker.yaml"), DataFaker.class);
            } catch (Exception e) {
                Log.fail("Config Dosyası Okunurken hata alındı!", e);
            }
        }
        return instance;
    }

    public String getRandomFirstName() {
        return firstname.get(random.nextInt(firstname.size()));
    }

    public String getRandomLastName() {
        return lastname.get(random.nextInt(lastname.size()));
    }

    public String getRandomGender() {
        return gender.get(random.nextInt(gender.size()));
    }

    public String getRandomCountryEN() {
        return countryEN.get(random.nextInt(countryEN.size()));
    }

    public String getRandomCountryTR() {
        return countryTR.get(random.nextInt(countryTR.size()));
    }

    public String getRandomCities() {
        return cities.get(random.nextInt(cities.size()));
    }

    public String getRandomGameOfThronesCharacters() {
        return gameOfThronesCharacters.get(random.nextInt(gameOfThronesCharacters.size()));
    }


    /**
     * Random kullanılarak fake bir data olusturuluyor
     *
     * @param min = min doğum tarihi
     * @param max = max doğrum tarihi
     */
    public int nextInt(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    /**
     * Returns a string with the '#' characters in the parameter replaced with random digits between 0-9 inclusive.
     * <p/>
     * For example, the string "ABC##EFG" could be replaced with a string like "ABC99EFG".
     */
    public String numerify(String numberString) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberString.length(); i++) {
            if (numberString.charAt(i) == '#') {
                sb.append(random.nextInt(10));
            } else {
                sb.append(numberString.charAt(i));
            }
        }

        return sb.toString();
    }

    public String subscriberNumber(int length) {
        StringBuilder subscriberNumber = new StringBuilder();
        for (int i = 0; i < length; i++) {
            subscriberNumber.append("#");
        }
        return numerify(subscriberNumber.toString());
    }

}
