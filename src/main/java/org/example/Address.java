package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@Setter

public class Address {
    private int streetNo;
    private String street;
    private String city;
    private String province;
    private String postalCode;
    private String country;

    public Address(int streetNo, String street, String city, String province, String postalCode, String country) {
        if (isPostalCodeValid(postalCode)) {
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode.toUpperCase();
            this.country = country;
        } else {
            this.streetNo = 0;
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
            this.country = null;
        }

    }

    /**
     * checks if a postal code is valid or not
     *
     * @param postalCode the postal code string
     * @return if the postal code is valid it returns true, if it's not valid it returns false
     */
    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode != null) {
            int len = postalCode.length();

            if (len == 6) {
                for (int i = 0; i < len; i++) {
                    char c = postalCode.charAt(i);

                    switch (i) {
                        case 1, 3, 5:
                            if (!Character.isDigit(c)) {
                                return false;
                            }
                            break;

                        default:
                            if (!Character.isLetter(c)) {
                                return false;
                            }
                    }
                }
                return true;
            }

            if (len == 7) {
                for (int i = 0; i < len; i++) {
                    char c = postalCode.charAt(i);

                    switch (i) {
                        case 0, 2, 5:
                            if (!Character.isLetter(c)) {
                                return false;
                            }
                            break;

                        case 1, 4, 6:
                            if (!Character.isDigit(c)) {
                                return false;
                            }
                            break;

                        default:
                            if (c != ' ') {
                                return false;
                            }
                    }
                }
                return true;
            }
        }
        return false;
    }
}
