package com.lakeside.gadsleaderboard.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.lakeside.gadsleaderboard.R;
import com.lakeside.gadsleaderboard.ui.model.Leader;

import java.util.ArrayList;
import java.util.List;

public class LeaderBoardAdapter extends RecyclerView.Adapter<LeaderBoardAdapter.ViewHolder> {

    private List<Leader> leaders = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    public LeaderBoardAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.leader_board_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Leader leader = leaders.get(position);
        holder.bind(leader);
    }

    @Override
    public int getItemCount() {
        return leaders == null ? 0 : leaders.size();
    }

    public void setLeaders(List<Leader> leaders) {
        this.leaders = leaders;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView learnerName, learnerAttributes;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            learnerName = itemView.findViewById(R.id.learnerName);
            learnerAttributes = itemView.findViewById(R.id.learnerAttributes);
            image = itemView.findViewById(R.id.appCompatImageView);
        }

        public void bind(Leader leader) {

            learnerName.setText(leader.getName());
            if(leader.getHours() > 0 ) {
                learnerAttributes.setText(
                        String.format(context.getResources().getString(R.string.learning_hours_format),
                                leader.getHours(), leader.getCountry())
                );
            }else {
                learnerAttributes.setText(
                        String.format(context.getString(R.string.skill_IQ_format),
                                leader.getScore(), leader.getCountry())
                );
            }

            Glide.with(itemView).
                    load(leader.getBadgeUrl())
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(image);
        }
    }

}
