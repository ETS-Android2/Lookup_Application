package LookBook.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import LookBook.data.Item;
public class ItemsData {
    @SerializedName("item")
    @Expose
    public Item[] item;

    public Item[] getItem() {
        return item ;
    }

    public void setItem(Item[] item) {
        this.item  = item;
    }
}
