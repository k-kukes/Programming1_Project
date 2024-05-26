package util;

public class Util {

    public static String toTitleCase(String strIn) {
        int indexSpace = strIn.indexOf(" ");
        String fname = strIn.substring(0, 1).toUpperCase() + strIn.substring(1, indexSpace).toLowerCase();
        String lname = strIn.substring(indexSpace + 1, indexSpace + 2).toUpperCase() +
                strIn.substring(indexSpace + 2).toLowerCase();
        return fname + lname;
    }
}
