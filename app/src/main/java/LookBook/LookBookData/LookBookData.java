package LookBook.LookBookData;

import com.google.gson.annotations.SerializedName;

public class LookBookData {
    @SerializedName("userId")
    private String userId;

    @SerializedName("purpose")
    private String purpose;

    @SerializedName("tempConvert")
    private int tempConvert;

    public LookBookData(String userId, String purpose, int tempConvert) {
        this.userId=userId;
        this.purpose=purpose;
        this.tempConvert=tempConvert;
    }
}
