package LookBook.ImageAdapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.R;
import java.util.ArrayList;

import LookBook.ImageAdapter.Data;

public class ImageAdapter extends BaseAdapter {
    public ArrayList<Data> itemList = new ArrayList<>();
    public String id;

    public ImageAdapter(Context con){
        final Context context = con;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Data> getItemList() {
        return itemList;
    }

    public String getId() {
        return id;
    }

    public void setItemList(ArrayList<Data> itemList) {
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final Context context = parent.getContext();
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lookbook_image, parent, false);
        }

        ImageView img = convertView.findViewById(R.id.image_view);
        //img.setPadding(8, 8, 8, 8);
        //img.setScaleType(ImageView.ScaleType.CENTER_CROP);

        Data userItem = itemList.get(position);

        if(userItem.getUri()!=null) {
            img.setImageURI(userItem.getUri());

            /*
            RequestOptions options = new RequestOptions()
                    .centerCrop()
                    .placeholder(R.mipmap.ic_launcher_round)
                    .error(R.mipmap.ic_launcher_round);
            Glide.with(context).load(userItem.getUrl()).apply(options).into(img);
             */
        }

        //if read image from server, use this code to use glide library

        //img.setImageResource(userItem.getUrl());

        return convertView;
    }

    //style정보 포함할지
    public void addList(Uri uri){
        Data item = new Data(uri);
        itemList.add(item);
    }
    //Add menuActivityList listview information
}
