package photo.wx.com.wxphotoprogress.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;

import photo.wx.com.wxphotoprogress.R;

/**
 * Created by Administrator on 2017/3/11.
 */
public class CircleBackgroundTextView extends TextView {
    private static final int DEFAULT_STROKE_WIDTH = 2;

    private Paint paint;

    private RectF rectF = new RectF();
    private Context context;
    public CircleBackgroundTextView(Context context) {
        this(context, null);
    }

    public CircleBackgroundTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public CircleBackgroundTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        setGravity(Gravity.CENTER);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(this.context.getResources().getColor(R.color.jacinth));
        paint.setStrokeWidth(DEFAULT_STROKE_WIDTH);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        rectF.set(DEFAULT_STROKE_WIDTH / 2f, DEFAULT_STROKE_WIDTH / 2f, canvas.getWidth() - DEFAULT_STROKE_WIDTH / 2f, canvas.getHeight() - DEFAULT_STROKE_WIDTH / 2f);
        canvas.drawOval(rectF, paint);
    }
}
