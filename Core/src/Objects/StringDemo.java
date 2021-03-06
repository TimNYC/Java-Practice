package Objects;

/**
 * Created by Tim Wang on 3/27/2016.
 */

//Always override toString
public class StringDemo {
    private int areaCode;
    private int prefix;
    private int lineNumber;
    /**
     * Returns the string representation of this phone number.
     * The string consists of fourteen characters whose format
     * is "(XXX) YYY-ZZZZ", where XXX is the area code, YYY is
     * the prefix, and ZZZZ is the line number. (Each of the
     * capital letters represents a single decimal digit.)
     *
     * If any of the three parts of this phone number is too small
     * to fill up its field, the field is padded with leading zeros.
     * For example, if the value of the line number is 123, the last
     * four characters of the string representation will be "0123".
     *
     * Note that there is a single space separating the closing
     * parenthesis after the area code from the first digit of the
     * prefix.
     */
    @Override public String toString() {
        return String.format("(%03d) %03d-%04d",
                areaCode, prefix, lineNumber);
    }
}
