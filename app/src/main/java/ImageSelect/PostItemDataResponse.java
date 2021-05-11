package ImageSelect;

import com.google.gson.annotations.SerializedName;

public class PostItemDataResponse {
    @SerializedName("userID")
    public String userID;

    @SerializedName("imageID")
    public int imageID;

    @SerializedName("Purpose")
    public int Purpose;

    public String getUserID() {
        return userID;
    }

    public int getImageID() {
        return imageID;
    }

    public int getPurpose() {
        return Purpose;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public void setPurpose(int purpose) {
        Purpose = purpose;
    }
}
