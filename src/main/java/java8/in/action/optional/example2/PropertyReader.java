package java8.in.action.optional.example2;

import java.util.Optional;
import java.util.Properties;

public class PropertyReader {

    public int readDurationImperative(Properties properties, String name) {
        String property = properties.getProperty(name);

        if (property == null) {
            return 0;
        }

        try {
            int number = Integer.parseInt(property);


            if (number > 0) {
                return number;
            } else {
                return 0;
            }
        } catch (NumberFormatException nfe) {
            return 0;
        }
    }

    public int readDurationDeclarative(Properties properties, String name) {
        return Optional.ofNullable(properties.getProperty(name)).map(Integer::parseInt).filter(i -> i > 0).orElse(0);
    }

}
