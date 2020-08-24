package com.example.furni.helperClass;

import android.content.Context;
import android.content.Intent;
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
import com.example.furni.Spinal;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> implements Filterable{

    List<String> titles;
    List<Integer> images;
    private List<String> exampleListFull;
    LayoutInflater inflater;
    public Adapter(Context ctx, List<String> titles, List<Integer> images){

        this.titles = titles;
        this.images = images;
        this.inflater = LayoutInflater.from(ctx);
        exampleListFull = new ArrayList<>(titles);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_grid_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(titles.get(position));
        holder.gridIcon.setImageResource(images.get(position));

    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView gridIcon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textView);
            gridIcon = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "Clicked -->" +getAdapterPosition(), Toast.LENGTH_SHORT).show();
                    Intent i;
                    switch (getAdapterPosition()){
//                        case 0: i = new Intent(view.getContext(), Legs.class);view.getContext().startActivity(i);break;
//                        case 1: i = new Intent(view.getContext(), Hands.class);view.getContext().startActivity(i);break;
//                        case 2: i = new Intent(view.getContext(), Spinal.class);view.getContext().startActivity(i);break;
                          case 3: i = new Intent(view.getContext(), Hands.class);view.getContext().startActivity(i);break;
                          case 4: i = new Intent(view.getContext(), Legs.class);view.getContext().startActivity(i);break;
//                        case 5: i = new Intent(view.getContext(), Legs.class);view.getContext().startActivity(i);break;
//                        case 6: i = new Intent(view.getContext(), Legs.class);view.getContext().startActivity(i);break;
                          case 7: i = new Intent(view.getContext(), Spinal.class);view.getContext().startActivity(i);break;
                        default:break;
                    }

                }
            });
        }
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<String> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(exampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (String item : exampleListFull) {
                    if (item.toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            titles.clear();
            titles.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}
