package LookBook.currentData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import LookBook.data.ResponseData;

public class CurrentWeatherData {
    @SerializedName("response")
    @Expose
    private CurrentResponseData response;

    public CurrentResponseData getResponse() {
        return response;
    }

    public void setResponse(CurrentResponseData response) {
        this.response = response;
    }
}
