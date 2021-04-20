package Color.data;


import com.google.gson.annotations.SerializedName;

public class ToneData {
    @SerializedName("toneInOn")
    private int InOn;
    private int InOn2;
    private int InOn3;


    public ToneData(int InOn) {
        this.InOn=InOn;
        this.InOn2=InOn2;
        this.InOn3=InOn3;

    }
}
