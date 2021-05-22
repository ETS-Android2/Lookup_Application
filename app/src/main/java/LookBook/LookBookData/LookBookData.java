package LookBook.LookBookData;

import com.google.gson.annotations.SerializedName;

public class LookBookData {
    @SerializedName("userId")
    private String userId;

    @SerializedName("purpose")
    private String purpose;

    public LookBookData(String userId, String purpose) {
        this.userId=userId;
        this.purpose=purpose;
    }
}
