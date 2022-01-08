package tops.technologies.enr;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.List;
import java.util.zip.Inflater;

public class UserRecyclerAdapter extends RecyclerView.Adapter <UserRecyclerAdapter.ViewHolder>{
    int c;

    private List<Products> productsListcopy;

    public UserRecyclerAdapter(List<Products> productsListcopy) {
        this.productsListcopy=productsListcopy;
    }

    @NonNull
    @Override
    public UserRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler,parent,false);
        return new ViewHolder(view);
    }




    @Override
    public void onBindViewHolder(@NonNull UserRecyclerAdapter.ViewHolder holder, int position) {
        holder.name.setText(productsListcopy.get(position).getName());
        holder.price.setText(String.valueOf(productsListcopy.get(position).getPrice()));
        ListActivity.total+=productsListcopy.get(position).getPrice();
    }

    @Override
    public int getItemCount() {
        return productsListcopy.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name,price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
        }
    }
}
