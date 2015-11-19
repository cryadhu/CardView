package com.card;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    List<CardItems> mItems;
    Context context;
    public CardAdapter(Context context) {
        super();
        this.context=context;
        mItems = new ArrayList<CardItems>();
        CardItems item = new CardItems();
        item.setName("Arsenal FC");
        item.setDes("Arsenal Football Club is a professional football club based in Holloway, London. " +
                "The club play in the Premier League, the top flight of English football.");
        item.setThumbnail(R.drawable.ar);
        mItems.add(item);

        item = new CardItems();
        item.setName("Dragon Ball Z");
        item.setDes("\"Dragon Ball Z\" follows the adventures of Goku who, along with the Z Warriors, " +
                "defends the Earth against evil. The action adventures are entertaining and reinforce the concept of good versus evil.");
        item.setThumbnail(R.drawable.dbz);
        mItems.add(item);

        item = new CardItems();
        item.setName("Dota 2");


        item.setDes("Defense of the Ancients is a multiplayer online battle arena mod for the video game Warcraft III: " +
                "Reign of Chaos and its expansion, Warcraft III: The Frozen Throne, based on the \"Aeon of Strife\" map for StarCraft.");


        item.setThumbnail(R.drawable.dota);
        mItems.add(item);

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

        if (i==0){
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
            params.leftMargin = 30;
            params.topMargin = 75;
            float x[] = {0,1f,2.5f,4f,5.5f,7f,9.5f,10f};
            float y[] = {0,2f,3f,1f,0.5f,2f,1f,2,4f};
            Curve c =new Curve(context,x,y,viewHolder.rlIMG.getLayoutParams().height/3);
            viewHolder.rlIMG.addView(c, params);

            RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
            params1.leftMargin = 10;
            params1.topMargin = 50;
            Line l = new Line(context,0,0,3,10,0,5,viewHolder.rlIMG.getLayoutParams().height/2,((MainActivity)context).getWindowManager().getDefaultDisplay().getWidth());
            viewHolder.rlIMG.addView(l,params1);

        }else {
            viewHolder.imgThumbnail.setImageResource(nature.getThumbnail());
        }
       // viewHolder.imgThumbnail.setImageBitmap(new Bitmap(c));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imgThumbnail;
        public TextView tvT;
        public TextView tvDes;
        public RelativeLayout rlIMG;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.img_thumbnail);
            tvT = (TextView)itemView.findViewById(R.id.tv_title);
            tvDes = (TextView)itemView.findViewById(R.id.tv_des);
            rlIMG = (RelativeLayout)itemView.findViewById(R.id.rlIMG);
        }
    }
}


