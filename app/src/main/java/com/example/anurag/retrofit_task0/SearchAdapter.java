package com.example.anurag.retrofit_task0;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchHolder>{

    private Activity activity;
    private ArrayList<SearchedCharacter> searchedCharacters;

    public SearchAdapter(Activity activity, ArrayList<SearchedCharacter> searchedCharacters) {
        this.activity = activity;
        this.searchedCharacters = searchedCharacters;
    }

    @Override
    public SearchHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.list_item_search, parent, false);
        return new SearchHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchHolder holder, final int position) {
        holder.name.setText(searchedCharacters.get(position).getData().getName());
        String imageUrl = "https://api.got.show" + searchedCharacters.get(position).getData().getImageLink();
        if(searchedCharacters.get(position).getData().getImageLink() != null) {
            Picasso.get().load(imageUrl).into(holder.imageView);
        }else{
            holder.imageView.setBackgroundResource(R.mipmap.ic_launcher);
        }
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RealmHelper.SaveCharacter(searchedCharacters.get(position));
                Intent intent = new Intent(activity, DetailActivity.class);
                intent.putExtra("id", searchedCharacters.get(position).getTimestamp());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return searchedCharacters.size();
    }

    class SearchHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name;
        RelativeLayout relativeLayout;
        public SearchHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            relativeLayout = itemView.findViewById(R.id.main);

        }
    }

}
