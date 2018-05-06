package com.er_to_go;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RoomsAndPatientsQueue extends AppCompatActivity {

    public TextView waiting_count;

    public LinearLayout waiting_list;

    public static String[] sampleVerb = {
            "Bruising", "Burning", "Bleeding", "Dislocated", "Fractured", "Other"
    };

    public static String[] sampleBody = {
            "Head", "Chest", "Stomach", "Arm", "Leg", "Leg"
    };

    private int room_ids[] = {R.id.ROOM1, R.id.ROOM2, R.id.ROOM3, R.id.ROOM4, R.id.ROOM5};

    private ArrayList<View> rooms = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms_and_patients_queue);
        waiting_count = findViewById(R.id.waiting_count);

        waiting_list = (LinearLayout) findViewById(R.id.waiting_list);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                500,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 15, 0, 15);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == j) {
                    break;
                }

                int rand = (int) (Math.random() * 100);

                TextView tv = new TextView(getApplicationContext());
                tv.setText(rand + " | " + sampleVerb[i] + " " + sampleBody[j]);
                tv.setAlpha(0.99f);
                tv.setOnLongClickListener(longClickListener);

                if (rand > 66) {
                    tv.setBackgroundResource(R.color.Important);
                } else if (rand > 33) {
                    tv.setBackgroundResource(R.color.Medium);
                } else {
                    tv.setBackgroundResource(R.color.Low);
                }

                tv.setPadding(80, 20, 80, 20);
                tv.setLayoutParams(params);
                waiting_list.addView(tv);
            }

        }

        waiting_count.setText(waiting_list.getChildCount() + "");

        for (int i = 0; i < room_ids.length; i++) {
            rooms.add(findViewById(room_ids[i]));
        }

        for (View room : rooms) {
            room.setOnDragListener(onDragListener);
        }


    }

    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.setBackgroundColor(getResources().getColor(R.color.grey));
            v.startDrag(data,shadowBuilder,v,0);
            v.setAlpha(0.0f);

            return false;
        }
    };
   View.OnDragListener onDragListener = new View.OnDragListener() {
       @Override
       public boolean onDrag(View v, DragEvent event) {
           int dragEvent = event.getAction();

           switch (dragEvent){
               case DragEvent.ACTION_DRAG_ENTERED:


                   final View view = (View) event.getLocalState();

                   System.out.println("id: " + view.getId() + " alpha: " + view.getAlpha() + " " + ((TextView) view).getText().toString());

                   if(view.getAlpha() != 1.0) {
                       ((ViewManager)view.getParent()).removeView(view);
                       v.setBackgroundResource(R.color.red);
                       waiting_count.setText(waiting_list.getChildCount() + "");
                   }

                   break;

       }
           return true;

       }
};
}