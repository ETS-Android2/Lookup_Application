package LookBook.currentData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import LookBook.data.Item;

public class CurrentItemsData {
    @SerializedName("item")
    @Expose
    public CurrentItem[] item;

    public CurrentItem[] getItem() {
        return item ;
    }

    public void setItem(CurrentItem[] item) {
        this.item  = item;
    }
}
