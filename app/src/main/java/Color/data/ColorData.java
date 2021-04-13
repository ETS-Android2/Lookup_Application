package Color.data;

import com.google.gson.annotations.SerializedName;

public class ColorData {
    @SerializedName("top_color1")
    private String top_color1;

    @SerializedName("top_color2")
    private String top_color2;

    @SerializedName("top_color3")
    private String top_color3;



    public ColorData(String top_color1, String top_color2, String top_color3) {
        this.top_color1=top_color1;
        this.top_color2=top_color2;
        this.top_color3 = top_color3;

    }
}