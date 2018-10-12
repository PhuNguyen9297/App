package com.example.lenovo.app.Control;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.lenovo.app.R;
import com.example.lenovo.app.model.testing;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {

    private Context context;
    private List<testing> list;

    public FeedAdapter(Context context, List<testing> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.test, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        testing test1 = list.get(position);
        String s = test1.getBody();
        holder.contentTv.setText(s);
        //holder.contentTv.setText("huyen");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView commentTv, contentTv, scoreTv;
        public ImageButton downvoteBtn, upvoteBtn, commentBtn;

        public ViewHolder(View view){
            super(view);
            commentTv = (TextView) view.findViewById(R.id.commentTv);
            contentTv = (TextView)view.findViewById(R.id.contentTv);
            scoreTv = (TextView)view.findViewById(R.id.scoreTv);
            downvoteBtn = (ImageButton) view.findViewById(R.id.downvoteBtn);
            upvoteBtn = (ImageButton)view.findViewById(R.id.upvoteBtn);
            commentBtn = (ImageButton)view.findViewById(R.id.commentBtn);
        }
    }
}