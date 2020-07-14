package com.example.class8.Adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.class8.Model.Item;
import com.example.class8.R;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Item}.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<Item> mValues;

    public MyItemRecyclerViewAdapter(List<Item> items) {
        mValues = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mItemName.setText(mValues.get(position).getName());
        holder.mContentView.setText("Amount: " + mValues.get(position).getAmount());
        holder.itemView.setOnLongClickListener(view -> {
            removeItem(position);
            return true;
        });

        holder.itemView.setOnClickListener(view -> {
            holder.mItemName.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public void addItem(Item item) {
        mValues.add(item);
        notifyItemInserted(mValues.size() - 1);
    }

    private void removeItem(int position) {
        mValues.remove(position);
        notifyItemRemoved(position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mItemName;
        public final TextView mContentView;
        public Item mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mItemName = (TextView) view.findViewById(R.id.item_name);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @NonNull
        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}