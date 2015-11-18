package com.card;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    List<CardItems> mItems;

    public CardAdapter() {
        super();
        mItems = new ArrayList<CardItems>();
        CardItems nature = new CardItems();
        nature.setName("Arsenal FC");
        nature.setDes("Arsenal Football Club is a professional football club based in Holloway, London. " +
                "The club play in the Premier League, the top flight of English football.");
        nature.setThumbnail(R.drawable.ar);
        mItems.add(nature);

        nature = new CardItems();
        nature.setName("Dragon Ball Z");
        nature.setDes("\"Dragon Ball Z\" follows the adventures of Goku who, along with the Z Warriors, " +
                "defends the Earth against evil. The action adventures are entertaining and reinforce the concept of good versus evil.");
        nature.setThumbnail(R.drawable.dbz);
        mItems.add(nature);

        nature = new CardItems();
        nature.setName("Dota 2");
        nature.setDes("Defense of the Ancients is a multiplayer online battle arena mod for the video game Warcraft III: " +
                "Reign of Chaos and its expansion, Warcraft III: The Frozen Throne, based on the \"Aeon of Strife\" map for StarCraft.");
        nature.setThumbnail(R.drawable.dota);
        mItems.add(nature);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view_card_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        CardItems nature = mItems.get(i);
        viewHolder.tvT.setText(nature.getName());
        viewHolder.tvDes.setText(nature.getDes());
        viewHolder.imgThumbnail.setImageResource(nature.getThumbnail());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imgThumbnail;
        public TextView tvT;
        public TextView tvDes;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.img_thumbnail);
            tvT = (TextView)itemView.findViewById(R.id.tv_title);
            tvDes = (TextView)itemView.findViewById(R.id.tv_des);
        }
    }
}


