package LookBook.ImageAdapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.R;
import java.util.ArrayList;
import LookBook.ImageAdapter.ListItem_temp;

public class ImageAdapter_temp extends BaseAdapter {
    ArrayList<ListItem_temp> items=new ArrayList<>();
    Context context;

    public void addItem(ListItem_temp item){
        items.add(item);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position){
        return items.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        context=viewGroup.getContext();
        ListItem_temp listItemTemp=items.get(i);

        if(view==null){
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.lookbook_listitem_temp, viewGroup, false);
        }

        ImageView imageView=view.findViewById(R.id.image_view);
        imageView.setImageURI(listItemTemp.getUri());
        TextView numText=view.findViewById(R.id.numText);
        numText.setText(listItemTemp.getNumber());

        return view;
    }
}
