package com.alphaclicksolutions.ju5tu5.androidnewsapp.Adapter;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alphaclicksolutions.ju5tu5.androidnewsapp.Common.Common;
import com.alphaclicksolutions.ju5tu5.androidnewsapp.Interface.IconBetterIdeaService;
import com.alphaclicksolutions.ju5tu5.androidnewsapp.Interface.ItemClickListener;
import com.alphaclicksolutions.ju5tu5.androidnewsapp.Model.IconBetterIdea;
import com.alphaclicksolutions.ju5tu5.androidnewsapp.Model.WebSite;
import com.alphaclicksolutions.ju5tu5.androidnewsapp.R;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by JU5TU5 on 13-Nov-17.
 */

class ListSourceViewHolder extends RecyclerView.ViewHolder
    implements View.OnClickListener
{
    ItemClickListener itemClickListener;
    TextView source_title;
    CircleImageView source_image;

    public ListSourceViewHolder(View itemView){
        super(itemView);
        source_image=(CircleImageView)itemView.findViewById(R.id.source_image);
        source_title=(TextView)itemView.findViewById(R.id.source_name);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),false);
    }
}
public class ListSourceAdapter extends RecyclerView.Adapter<ListSourceViewHolder>{
    private Context context;
    private WebSite webSite;
    private IconBetterIdeaService mService;

    public ListSourceAdapter(Context context, WebSite webSite) {
        this.context = context;
        this.webSite = webSite;
        mService = Common.getIconService();
    }


    @Override
    public ListSourceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.source_layout,parent,false);
        return new ListSourceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ListSourceViewHolder holder, int position) {
        StringBuilder iconBetterAPI = new StringBuilder("https://icons.better-idea.org/allicons.json?url=");
        iconBetterAPI.append(webSite.getSources().get(position).getUrl());

        mService.getIconUrl(iconBetterAPI.toString())
                .enqueue(new Callback<IconBetterIdea>() {
                    @Override
                    public void onResponse(@NonNull Call<IconBetterIdea> call,@NonNull Response<IconBetterIdea> response) {
                        if (response.body()!=null && response.body().getIcons()!=null && response.body().getIcons().size() > 0)
                        {
                            Picasso.with(context)
                                    .load(response.body().getIcons().get(0).getUrl())
                                    .into(holder.source_image);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<IconBetterIdea> call,@NonNull Throwable t) {

                    }
                });

        holder.source_title.setText(webSite.getSources().get(position).getName());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                //Implement part 2.

            }
        });
    }

    @Override
    public int getItemCount() {
        return webSite.getSources().size();
    }
}
