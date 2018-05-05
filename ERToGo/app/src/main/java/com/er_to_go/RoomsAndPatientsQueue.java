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
import java.util.List;


public class RoomsAndPatientsQueue extends AppCompatActivity {
    private TextView head;

    private LinearLayout waiting_list;

    private String[] sampleText = {
            "Bleeding Leg",
            "Fractured back",
            "Cracked skull",
            "Dislocated Shoulder",
            "Bleeding skull",


    };

    private String[] sampleVerb = {
            "Bruising", "Burning", "Bleeding", "Dislocated", "Fractured", "Other"
    };

    private String[] sampleBody = {
            "Head", "Chest", "Stomach", "Arm", "Leg", "Leg"
    };

    private int room_ids[] = {R.id.ROOM1, R.id.ROOM2, R.id.ROOM3, R.id.ROOM4, R.id.ROOM5};

    private ArrayList<View> rooms = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms_and_patients_queue);
        //head = findViewById(R.id.textView5);
        //head.setAlpha(0.99f);

        waiting_list = (LinearLayout) findViewById(R.id.waiting_list);


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 10, 0, 10);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == j) {
                    break;
                }

                TextView tv = new TextView(getApplicationContext());
                tv.setText(sampleVerb[i] + sampleBody[j]);
                tv.setAlpha(0.99f);
                tv.setOnLongClickListener(longClickListener);
                tv.setBackgroundResource(R.color.colorPrimaryDark);
                tv.setPadding(12, 6, 12, 6);
                tv.setLayoutParams(params);
                waiting_list.addView(tv);
            }

        }


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
            v.startDrag(data,shadowBuilder,v,0);

            return false;
        }
    };
   View.OnDragListener onDragListener = new View.OnDragListener() {
       @Override
       public boolean onDrag(View v, DragEvent event) {
           int dragEvent = event.getAction();

           switch (dragEvent){
               case DragEvent.ACTION_DRAG_ENTERED:
                       break;
               case DragEvent.ACTION_DRAG_EXITED:
                   break;
               case DragEvent.ACTION_DROP:

                   final View view = (View) event.getLocalState();

                   System.out.println("id: " + view.getId() + " alpha: " + view.getAlpha() + " " + ((TextView) view).getText().toString());

                   if(view.getAlpha() != 1.0) {
                       ((ViewManager)view.getParent()).removeView(view);
                       v.setBackgroundResource(R.color.red);
                   }

                   break;

       }
           return true;

       }
};
}