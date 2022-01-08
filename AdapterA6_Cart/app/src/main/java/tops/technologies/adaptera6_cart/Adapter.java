package tops.technologies.adaptera6_cart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    public static int total;
    public static ArrayList<ModelClass> list;
    private Context context;

    public Adapter(ArrayList<ModelClass> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        ModelClass model = list.get(position);
        holder.name.setText(model.getName());
        holder.quantity.setText(String.valueOf(model.getQuantity()));
        holder.rate.setText(model.getRate());
        holder.total.setText(String.valueOf(Integer.parseInt(model.getRate()) * model.getQuantity()));
        holder.plus.setOnClickListener(v -> {
            model.setQuantity(model.getQuantity()+ 1);
            holder.quantity.setText(String.valueOf(model.getQuantity()));
            holder.total.setText(String.valueOf(Integer.parseInt(model.getRate()) * model.getQuantity()));
            calculatetotal();
        });
        holder.minus.setOnClickListener(v -> {
            if (model.getQuantity() > 0) {
                model.setQuantity(model.getQuantity()- 1);
                holder.quantity.setText(String.valueOf(model.getQuantity()));
                holder.total.setText(String.valueOf(Integer.parseInt(model.getRate()) * model.getQuantity()));
                calculatetotal();
            }
        });
    }
    private void calculatetotal() {
        int i=0;
        total=0;
        while(i<list.size()){
            total=total + (Integer.valueOf(list.get(i).getRate()) * list.get(i).getQuantity());
            i++;
        }
        MainActivity.maintotal.setText(""+total);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name, quantity, rate, total;
        private ImageView plus, minus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.Name);
            quantity = itemView.findViewById(R.id.Quantity);
            rate = itemView.findViewById(R.id.Rate);
            total = itemView.findViewById(R.id.Total);
            plus = itemView.findViewById(R.id.plus);
            minus = itemView.findViewById(R.id.minus);
        }
    }
}
