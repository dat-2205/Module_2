import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassRegex {
    private static final String CLASS_REGEX = "^[CAP]{1}[0-9]{4}[GHIKLM]{1}";

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(CLASS_REGEX);
        Matcher matcher = pattern.matcher(regex.trim());
        return matcher.matches();
    }
}
