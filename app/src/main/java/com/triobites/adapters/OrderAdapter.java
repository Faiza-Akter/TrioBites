package com.triobites.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.triobites.R;
import com.triobites.models.Order;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private final List<Order> orders;

    public OrderAdapter(List<Order> orders) {
        this.orders = orders;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_order, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        Order order = orders.get(position);
        holder.dishTextView.setText(order.getDishName());
        holder.quantityTextView.setText("Qty: " + order.getQuantity());
        holder.dateTextView.setText("Date: " + new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(order.getOrderDate()));
        holder.totalTextView.setText("Total: " + order.getTotalAmount() + " BDT");
    }


    @Override
    public int getItemCount() {
        return orders.size();
    }

    static class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView dishTextView, quantityTextView, dateTextView, totalTextView;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            dishTextView = itemView.findViewById(R.id.tvOrderDish);
            quantityTextView = itemView.findViewById(R.id.tvOrderQuantity);
            dateTextView = itemView.findViewById(R.id.tvOrderDate);
            totalTextView = itemView.findViewById(R.id.tvOrderTotal);
        }
    }
}
