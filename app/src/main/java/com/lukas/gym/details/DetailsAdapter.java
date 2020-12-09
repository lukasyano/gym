package com.lukas.gym.details;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.lukas.gym.R;

import java.util.ArrayList;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.ViewHolder> {

    private ArrayList<Object> data = new ArrayList<>();

    public void setData(ArrayList<Object> usersData) {
        data = usersData;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_users, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Object gym = data.get(position);
        viewHolder.getTextView().setText(gym.toString());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    /**
     * Inner class for ViewHolder
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.user_name_view);
        }

        public TextView getTextView() {
            return textView;
        }
    }
}
