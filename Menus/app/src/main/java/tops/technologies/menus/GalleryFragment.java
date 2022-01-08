package tops.technologies.menus;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;

public class GalleryFragment extends Fragment
{
    Gallery gallery;
    ImageView selectedImage;
    Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        context = container.getContext();
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        gallery = view.findViewById(R.id.imagegallery);
        selectedImage=view.findViewById(R.id.imageView);
        gallery.setSpacing(1);
        final GalleryImageAdapter galleryImageAdapter= new GalleryImageAdapter(context);
        gallery.setAdapter(galleryImageAdapter);


        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                selectedImage.setImageResource(galleryImageAdapter.mImageIds[position]);
            }
        });
        return view;
    }
}