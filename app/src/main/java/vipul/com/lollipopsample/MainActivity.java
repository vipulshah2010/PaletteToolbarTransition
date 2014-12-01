package vipul.com.lollipopsample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.widget.GridView;


public class MainActivity extends ActionBarActivity {

    private GridView flowersGrid;
    private FlowersAdapter flowersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        flowersGrid = (GridView) findViewById(R.id.flowersGrid);

        flowersAdapter = new FlowersAdapter(this);

        flowersGrid.setAdapter(flowersAdapter);
    }
}
