package ImageSelect;

import com.google.gson.annotations.SerializedName;

public class PostItemData {

    @SerializedName("userID")
    public String userID;

    @SerializedName("imageID")
    public int imageID;

    @SerializedName("Purpose")
    public int Purpose;

    PostItemData(String userID, int imageID, int Purpose){
        this.userID=userID;
        this.imageID=imageID;
        this.Purpose=Purpose;
    }



}
