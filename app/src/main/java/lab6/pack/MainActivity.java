package lab6.pack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private  Draw2D draw2D;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout layout = findViewById(R.id.layout);
        Button button = findViewById(R.id.ButtonDraw);
        button.setOnClickListener((view)-> {
            if (draw2D!=null){
                layout.removeView(draw2D);
            }
            draw2D= new Draw2D(this,null);
            layout.addView(draw2D, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        });
    }
}
