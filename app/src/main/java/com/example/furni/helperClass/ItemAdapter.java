package com.example.furni.helperClass;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.furni.Hands;
import com.example.furni.Legs;
import com.example.furni.R;
import com.example.furni.living_room;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{
    List<String> titles;
    List<Integer> images;


    LayoutInflater inflater;


    public ItemAdapter(Context ctx, List<String> titles, List<Integer> images) {

        this.titles = titles;
        this.images = images;

        this.inflater = LayoutInflater.from(ctx);
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.items_custom_grid_layout, parent, false);
        return new ViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {
        holder.title.setText(titles.get(position));
        holder.gridIcon.setImageResource(images.get(position));


    }

    @Override
    public int getItemCount() {
        return titles.size();    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView gridIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_name);
            gridIcon = itemView.findViewById(R.id.item_image);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "Opening the product on website" , Toast.LENGTH_SHORT).show();
                    Intent i;
                    switch (getAdapterPosition()){
                        case 0: Uri uri = Uri.parse("https://www.amazon.in/Slipstick-CB654-Furniture-Risers-Supports/dp/B01FN4KGD8/ref=sr_1_5?dchild=1&keywords=chair+raisers&qid=1598883589&sr=8-5");
                                i = new Intent(Intent.ACTION_VIEW,uri);view.getContext().startActivity(i);
                                break;
                        case 1: Uri uri_1 = Uri.parse("https://www.amazon.in/MK-Multi-Purpose-Wardrobe-Refrigerator-Furniture/dp/B07QV8VDSF/ref=sr_1_6?dchild=1&keywords=chair+raisers&qid=1598883589&sr=8-6");
                            i = new Intent(Intent.ACTION_VIEW,uri_1);view.getContext().startActivity(i);
                            break;
                        case 2: Uri uri_2 = Uri.parse("https://www.amazon.in/TRADERS-ROUND-STAINLESS-STEEL-COLOUR/dp/B078WXF4J6/ref=pd_sbs_60_18?_encoding=UTF8&pd_rd_i=B078WXF4J6&pd_rd_r=ee0ec2ba-3978-4145-a7a7-e6b4eb4ec086&pd_rd_w=oL6YN&pd_rd_wg=sIMg4&pf_rd_p=00b53f5d-d1f8-4708-89df-2987ccce05ce&pf_rd_r=1H2WY2CN65QT0WCBKE8P&psc=1&refRID=1H2WY2CN65QT0WCBKE8P");
                            i = new Intent(Intent.ACTION_VIEW,uri_2);view.getContext().startActivity(i);
                            break;
                        case 3: Uri uri_3 = Uri.parse("https://www.amazon.in/Lepose-4-Pieces-Wardrobe-Refrigerator-Furniture/dp/B07XZRXCJD/ref=sr_1_1?dchild=1&keywords=Lepose+4-Pieces+Almirah%2C+Wardrobe%2C+Refrigerator+Stand+%28Grey+Black%29+Washing+Machine+Stand%2CFurniture+Base+Stand&qid=1598891485&sr=8-1");
                            i = new Intent(Intent.ACTION_VIEW,uri_3);view.getContext().startActivity(i);
                            break;
                        
                        default:break;
                    }
                }
            });
        }
    }



}
