package com.er_to_go;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class BodyPartActivity extends Activity {


    static String[] names = {"Head", "Leg", "Arm", "Chest", "Stomach", "Other"};
    static int[] images = {R.drawable.head2, R.drawable.leg2, R.drawable.arm2, R.drawable.chest2, R.drawable.stomach2, R.drawable.question_mark};

    ImageView image;
    ImageView heatMap;
    static View api_loading2;
    static BodyPartActivity sd;
    public static TextView fetched2;


    int value;

    Button body_part_finish;

    ConstraintLayout constraintLayout;
    ConstraintSet constraintSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.self_diag_part);

        fetched2 = findViewById(R.id.fetched2);
        api_loading2 = findViewById(R.id.api_loading2);

        sd = this;

        TextView name = findViewById(R.id.BODY_PART_NAME);
        image = findViewById(R.id.BODY_PART_IMAGE);
        heatMap = findViewById(R.id.BODY_PART_HEATMAP);
        body_part_finish = findViewById(R.id.body_part_finish);

        Bundle b = getIntent().getExtras();
        value = -1; // or other values
        if(b != null)
            value = b.getInt("key");
        else
            return;

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BodyPartActivity.this, ClientQueue.class);
                Bundle b = new Bundle();
                b.putInt("age", Integer.parseInt(((TextView)findViewById(R.id.age_text)).getText().toString()));
                b.putInt("intensity", ((SeekBar)findViewById(R.id.seekBar)).getProgress());
                b.putInt("bodypart", value);
                b.putBoolean("reoccuring", ((Switch)findViewById(R.id.switch_reoccuring)).isChecked());
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }
        };
        body_part_finish.setOnClickListener(listener);

        name.setText(getName(value));
        image.setImageResource(getImage(value));


        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String selected = parent.getItemAtPosition(pos).toString();

                setLoading(true);

                fetched2.setText("");
                FetchAPI fa = new FetchAPI();
                fa.setData(selected);
                fa.set2(true);
                fa.execute();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView)
            {

            }
        });

    }

    public String getName(int value) {
        return names[value];
    }

    public int getImage(int value) {
        return images[value];
    }

    public void setHeatMap(int x, int y) {
        /*heatMap.setAlpha(1.0f);

        constraintLayout = (ConstraintLayout) findViewById(R.id.Re);

        constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout); */
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int)event.getX();
        int y = (int)event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                Rect imageRect = locateView(image);
                if (imageRect.contains(x,y)) {
                    setHeatMap(x, y);
                }

                break;
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
        }
        return false;
    }

    public Rect locateView(View view) {
        Rect loc = new Rect();
        int[] location = new int[2];
        if (view == null) {
            return loc;
        }
        view.getLocationOnScreen(location);

        loc.left = location[0];
        loc.top = location[1];
        loc.right = loc.left + view.getWidth();
        loc.bottom = loc.top + view.getHeight();
        return loc;
    }


    public void setLoading(final boolean load){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (load) {
                        BodyPartActivity.api_loading2.setVisibility(View.VISIBLE);
                    } else {
                        BodyPartActivity.api_loading2.setVisibility(View.INVISIBLE);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
