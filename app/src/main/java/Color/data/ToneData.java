package Color.data;


import com.google.gson.annotations.SerializedName;

public class ToneData {
    @SerializedName("toneInOn")
    private String toneInOn;




    public ToneData(String toneInOn) {
        this.toneInOn=toneInOn;

    }
}
