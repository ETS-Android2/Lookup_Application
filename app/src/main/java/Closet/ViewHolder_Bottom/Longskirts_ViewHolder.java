package Closet.ViewHolder_Bottom;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.R;

public class Longskirts_ViewHolder extends RecyclerView.ViewHolder {
    int a;
    TextView textView;
    public Longskirts_ViewHolder(@NonNull View itemView , int a ) { //뷰홀더에서 작업들 실행
        super(itemView);

        this.a = a;

        textView = itemView.findViewById(R.id.a_textview);

        textView.setText(String.valueOf(a));
    }
}

