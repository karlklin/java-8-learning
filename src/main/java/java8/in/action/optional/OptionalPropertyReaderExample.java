package java8.in.action.optional;

import org.apache.commons.lang.math.NumberUtils;

import java.util.Optional;
import java.util.Properties;

public class OptionalPropertyReaderExample {

    public int readDurationImperative(Properties properties, String name) {
        String property = properties.getProperty(name);

        if (property == null) {
            return 0;
        }

        if (NumberUtils.isNumber(property)) {
            int number = Integer.parseInt(property);

            if (number > 0) {
                return number;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    public int readDurationDeclarative(Properties properties, String name) {
        return Optional.ofNullable(properties.getProperty(name)).filter(NumberUtils::isNumber).map(Integer::parseInt).filter(i -> i > 0).orElse(0);
    }

}
