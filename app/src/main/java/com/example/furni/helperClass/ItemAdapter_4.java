package com.example.furni.helperClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.furni.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter_4 extends RecyclerView.Adapter<ItemAdapter_4.ViewHolder> {

    List<String> titles;
    List<Integer> images;

    LayoutInflater inflater;

    public ItemAdapter_4(Context ctx, List<String> titles, List<Integer> images) {

        this.titles = titles;
        this.images = images;
        this.inflater = LayoutInflater.from(ctx);
    }
    @NonNull
    @Override
    public ItemAdapter_4.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.items_custom_grid_layout, parent, false);
        return new ViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter_4.ViewHolder holder, int position) {
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
                    Toast.makeText(view.getContext(), "Clicked -->" +getAdapterPosition(), Toast.LENGTH_SHORT).show();
/*                    Intent i;
                    switch (getAdapterPosition()){
                        case 0: i = new Intent(view.getContext(), living_room.class);view.getContext().startActivity(i);break;
//                        case 1: i = new Intent(view.getContext(), Hands.class);view.getContext().startActivity(i);break;
//                        case 2: i = new Intent(view.getContext(), Legs.class);view.getContext().startActivity(i);break;
//                        case 3: i = new Intent(view.getContext(), Legs.class);view.getContext().startActivity(i);break;
//                        case 4: i = new Intent(view.getContext(), Legs.class);view.getContext().startActivity(i);break;
//                        case 5: i = new Intent(view.getContext(), Legs.class);view.getContext().startActivity(i);break;
//                        case 6: i = new Intent(view.getContext(), Legs.class);view.getContext().startActivity(i);break;
//                        case 7: i = new Intent(view.getContext(), Legs.class);view.getContext().startActivity(i);break;
                        default:break;
                    }*/
                }
            });
        }
    }
}
