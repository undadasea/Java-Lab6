package lab6.pack;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class Draw2D extends View{

    private Random mRandom = new Random();
    public static Canvas mCanvas;
    public Button buttonDrawNewPic;

    public Draw2D(Context context, AttributeSet attr) {
        super(context, attr);
        buttonDrawNewPic = new Button(context, attr);
    }

    private int getColor(){
        int R = mRandom.nextInt(255);
        int G = mRandom.nextInt(255);
        int B = mRandom.nextInt(255);
        return Color.rgb(R, G, B);
    }

    private Rect getRect(Canvas canvas){
        int side = mRandom.nextInt(canvas.getWidth());
        int topLeftX = mRandom.nextInt(canvas.getWidth()-side);
        int topLeftY = mRandom.nextInt(canvas.getHeight()-side);
        Rect rect = new Rect(topLeftX, topLeftY, topLeftX+side, topLeftY+side);
        return rect;
    }



    public void drawPic(){
        Rect rect = getRect(mCanvas);

        Paint paintRect = new Paint();
        paintRect.setColor(getColor());
        mCanvas.drawRect(rect, paintRect);

        Paint paintCircle = new Paint();
        paintCircle.setColor(getColor());
        mCanvas.drawCircle(rect.centerX(), rect.centerY(),rect.width()/2, paintCircle);

        mCanvas.drawCircle(rect.centerX(), rect.centerY(),rect.width()/2-15, paintRect);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        Paint mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.WHITE);
        canvas.drawPaint(mPaint);
        mCanvas = canvas;

        drawPic();
    }
}
