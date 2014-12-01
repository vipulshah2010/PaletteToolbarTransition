package vipul.com.lollipopsample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;


public class DetailActivity extends ActionBarActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ImageView imageView = (ImageView) findViewById(R.id.detailImage);
        final View rootLayout = findViewById(R.id.rootLayout);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                getIntent().getIntExtra("resource", -1));
        Palette.generateAsync(bitmap, new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                rootLayout.setBackgroundColor(palette.getVibrantSwatch().getRgb());
                toolbar.setBackgroundColor(palette.getLightVibrantSwatch().getRgb());
                imageView.setImageResource(getIntent().getIntExtra("resource", -1));
            }
        });


    }
}
