package demo.model;

/**
 * Created by Shawn on 2017/4/19.
 */
public enum GenderValue {
    Male("男",1),

    Female("女",2),

    Unlimited("",3);


    String displayName;
    int value;

    GenderValue(String displayName, int value) {
        this.displayName = displayName;
        this.value = value;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static GenderValue valueOf(int value) {
        for (GenderValue genderValue : GenderValue.values()) {
            if (genderValue.value == value) {
                return genderValue;
            }
        }
        return null;
    }

    public static GenderValue nameOf(String name) {
        for (GenderValue genderValue : GenderValue.values()) {
            if (genderValue.displayName.equals(name)) {
                return genderValue;
            }
        }
        return null;
    }
}
