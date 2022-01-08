package tops.technologies.adapteri3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

    public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

        private ArrayList<Model> list;
        private Context context;
        
        public Adapter(ArrayList<Model> list, Context context) {
            this.list = list;
            this.context = context;
        }
        
        public void filterList(ArrayList<Model> filterllist) {
            list = filterllist;
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
            Model model = list.get(position);
            holder.name.setText(model.getName());
            holder.description.setText(model.getDescription());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private TextView name, description;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.Name);
                description = itemView.findViewById(R.id.Description);
            }
        }
    }