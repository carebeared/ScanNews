package com.example.eight.scannews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eight.scannews.beans.NewsBean;

import java.util.List;

/**
 * Created by eight on 2017/6/10.
 */

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    private List<NewsBean> data;
    private boolean isShowFooter = true;
    private Context context;

    private OnItemClickListener onItemClickListener;

    public NewsAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<NewsBean> data) {
        this.data = data;
        this.notifyDataSetChanged();
    }

    public NewsBean getItem(int position) {
        return data == null ? null : data.get(position);
    }

    public boolean isShowFooter() {
        return isShowFooter;
    }

    public void setShowFooter(boolean showFooter) {
        isShowFooter = showFooter;
    }

    @Override
    public int getItemViewType(int position) {
        if (!isShowFooter) {
            return TYPE_ITEM;
        }
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.news_list_item, parent, false);ImageView newspicture = (ImageView) view.findViewById(R.id.news_picture);
            return new ItemViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.footer_item, parent, false);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            return new FooterViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            NewsBean newsBean = data.get(position);
            if (newsBean == null) {
                return;
            }

        }
    }

    @Override
    public int getItemCount() {
        int f = isShowFooter ? 1 : 0;
        if (data == null) {
            return f;
        }
        return data.size() + f;
    }

    public class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView newsTime;
        public TextView newsPublic;
        public TextView newsContent;
        public ImageView newsPicture;

        public ItemViewHolder(View itemView) {
            super(itemView);
            newsTime = (TextView) itemView.findViewById(R.id.news_time);
            newsPublic = (TextView) itemView.findViewById(R.id.news_public);
            newsContent = (TextView) itemView.findViewById(R.id.news_content);
            newsPicture = (ImageView) itemView.findViewById(R.id.news_picture);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(v, this.getPosition());
            }
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
