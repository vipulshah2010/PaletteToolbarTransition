package vipul.com.lollipopsample;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class FlowersAdapter extends BaseAdapter {

    private ArrayList<Integer> images;
    private Activity activity;

    public FlowersAdapter(Activity activity) {
        images = new ArrayList<>();
        this.activity = activity;
        for (int i = 1; i < 13; i++) {
            images.add(activity.getResources()
                    .getIdentifier("p" + i, "drawable",
                            activity.getPackageName()));
        }
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int position) {
        return images.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(activity).
                    inflate(R.layout.grid_row, parent, false);
        }

        final ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(images.get(position));

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, DetailActivity.class);
                intent.putExtra("resource", images.get(position));
                ActivityOptionsCompat options =
                        ActivityOptionsCompat.makeSceneTransitionAnimation(
                                activity, imageView, "image");
                ActivityCompat.startActivity(activity, intent, options.toBundle());
            }
        });

        return convertView;
    }
}
