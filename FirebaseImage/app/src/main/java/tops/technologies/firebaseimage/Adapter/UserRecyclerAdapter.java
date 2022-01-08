package tops.technologies.firebaseimage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import tops.technologies.firebaseimage.ListActivity;
import tops.technologies.firebaseimage.Model.User;
import tops.technologies.firebaseimage.R;

public class UserRecyclerAdapter extends RecyclerView.Adapter <UserRecyclerAdapter.ViewHolder>
{
    private List<User> listUsers;
    private Context context;

    public UserRecyclerAdapter(Context context, List<User> listUsers) {
        this.context=context;
        this.listUsers=listUsers;
    }

    @NonNull
    @Override
    public UserRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        //context=parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserRecyclerAdapter.ViewHolder holder, int position) {
        User user = listUsers.get(position);
        holder.name.setText(listUsers.get(position).getName());
        Picasso.with(this.context).load(user.getCategory()).into(holder.imageView);
        holder.description.setText(listUsers.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return listUsers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,description;
        ImageView imageView;
        public ViewHolder(View view) {
            super(view);
            name=view.findViewById(R.id.name);
            imageView=view.findViewById(R.id.imageView);
            description=view.findViewById(R.id.description);
        }
    }
}
