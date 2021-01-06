package com.example.palakArora_COMP304_Lab2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends ArrayAdapter <Home>{

    private Context context;
    private List<Home> homeList = new ArrayList<>();

//    public HomeAdapter(@NonNull Context context, @SuppressLint("SupportAnnotationUsage") @LayoutRes ArrayList<Home> list){
    public HomeAdapter(Context context, ArrayList<Home> list){
        super(context, 0 , list);
        this.context = context;
        homeList = list;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem==null){
            listItem= LayoutInflater.from(context).inflate( R.layout.list_item,parent,false );
        }


        Home home=homeList.get( position );
        ImageView imageView = (ImageView)listItem.findViewById( R.id.image_View_list );
        imageView.setImageResource( home.getImage() );

        TextView tvAddress =(TextView)listItem.findViewById( R.id.textView_opt1 );
        tvAddress.setText( home.getAddress() );
        TextView tvPrice = (TextView)listItem.findViewById( R.id.textView_opt2 );
        tvPrice.setText( home.getPrice());


        final CheckBox checkBox = listItem.findViewById(R.id.checkboxlist);
        checkBox.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                if(checkBox.isChecked())
                {
                    Program.selectedHomes.add(homeList.get( position ));
                }
                else
                {
                    Program.selectedHomes.remove(homeList.get( position ));
                }

            }
        });

        return listItem;

    }


}
