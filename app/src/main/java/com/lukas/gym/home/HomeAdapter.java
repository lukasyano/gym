package com.lukas.gym.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.lukas.gym.R;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private ArrayList<Object> data = new ArrayList<>();
    private GymItemClickListener listener;

    public HomeAdapter(GymItemClickListener gymListener){
        listener = gymListener;
    }

    public void setData(ArrayList<Object> gymsData) {
        data = gymsData;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_gym, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Object gym = data.get(position);
        viewHolder.getTextView().setText(gym.toString());

        viewHolder.rootView.setOnClickListener(v -> {
            listener.onGymItemClick(gym);
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    /**
     * Inner class for ViewHolder
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ViewGroup rootView;
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            rootView = view.findViewById(R.id.root_view);
            textView = view.findViewById(R.id.gym_name_view);
        }

        public TextView getTextView() {
            return textView;
        }
    }
}
