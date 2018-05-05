package com.er_to_go;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;


public class RoomsAndPatientsQueue extends AppCompatActivity {
private TextView head, chest, stomache, hand, leg, foot, room;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms_and_patients_queue);
        head = (TextView) findViewById(R.id.textView5);
        room = (TextView) findViewById(R.id.textView6);
        head.setOnLongClickListener(longClickListener);
        room.setOnDragListener(onDragListener);

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
                   final View view = (View) event.getLocalState();
                   if(view.getId() == R.id.textView5){
                       room.setBackgroundResource(R.color.red);
                   }
                       break;
               case DragEvent.ACTION_DRAG_EXITED:
                   break;
               case DragEvent.ACTION_DROP:
                   break;

       }
           return true;

       }
};
}