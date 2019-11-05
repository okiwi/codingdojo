import java.util.Arrays;
import java.util.List;

public class Mileage {

    public static final List<String> BIRTH_OF_JACKY = Arrays.asList(
            "01011970",
            "010170"
    );

    private String mileage;

    public Mileage(String mileage) {
        this.mileage = mileage;
    }


    public boolean isLicensedToKill() {
        if (this.mileage.contains("00")) return true;
        return this.mileage.endsWith("007");
    }

    public boolean isJamesBond(){
        if(isLicensedToKill() && this.mileage.endsWith("007")) return true;
        return false;
    }

    public boolean isJackyBirthDate() {
        return BIRTH_OF_JACKY.contains(this.mileage);
    }


    public boolean isAscending(){
        for (int digit = 0; digit < this.mileage.length()-1; digit++) {
            if (1 != distanceBetweenChars(this.mileage.charAt(digit), this.mileage.charAt(digit + 1))) {
                return false;
            }
        }
        return true;
    }

    private int distanceBetweenChars(char left, char right) {
        return right - left;
    }
}
