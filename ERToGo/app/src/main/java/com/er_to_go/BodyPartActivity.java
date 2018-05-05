package com.er_to_go;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class BodyPartActivity extends Activity {


    String[] names = {"Head", "Leg", "Arm", "Chest", "Stomach"};
    int[] images = {R.drawable.head2, R.drawable.leg2, R.drawable.arm2, R.drawable.chest2, R.drawable.stomach2};

    ImageView image;
    ImageView heatMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.self_diag_part);

        TextView name = findViewById(R.id.BODY_PART_NAME);
        image = findViewById(R.id.BODY_PART_IMAGE);
        heatMap = findViewById(R.id.BODY_PART_HEATMAP);

        Bundle b = getIntent().getExtras();
        int value = -1; // or other values
        if(b != null)
            value = b.getInt("key");
        else
            return;

        name.setText(getName(value));
        image.setImageResource(getImage(value));

    }

    public String getName(int value) {
        return names[value];
    }

    public int getImage(int value) {
        return images[value];
    }

    public void setHeatMap(int x, int y) {
        //heatMap.setAlpha(1.0f);
        heatMap.setX(x);
        heatMap.setY(y);

        ViewGroup.MarginLayoutParams marginParams = (ViewGroup.MarginLayoutParams) image.getLayoutParams();
        marginParams.setMargins((int)image.getX(), (int)image.getY(), 0, 0);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int)event.getX();
        int y = (int)event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                Rect imageRect = locateView(image);
                if (imageRect.contains(x,y)) {
                    System.out.println("Clicked image");
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

}
