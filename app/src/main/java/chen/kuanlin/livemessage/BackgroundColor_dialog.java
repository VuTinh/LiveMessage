package chen.kuanlin.livemessage;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

/**
 * Created by kuanlin on 2017/10/12.
 */

public class BackgroundColor_dialog {

    private Context context;
    private PaintView paintView;

    MySharedPreference mySharedPreference;

    public BackgroundColor_dialog(Context context, PaintView paintView){
        this.context = context;
        this.paintView = paintView;
        mySharedPreference = new MySharedPreference(context);
    }

    public void showBackgroundColorDialog(){
        ColorPickerDialogBuilder
                .with(context)
                .setTitle(R.string.dialog_select_bg_color)
                .initialColor(mySharedPreference.getUserBackground())
                .wheelType(ColorPickerView.WHEEL_TYPE.CIRCLE)
                .density(6)
                .showLightnessSlider(true)
                .showAlphaSlider(false)
                .setOnColorSelectedListener(new OnColorSelectedListener() {
                    @Override
                    public void onColorSelected(int selectedColor) {

                    }
                })
                .setPositiveButton(R.string.word_confirm, new ColorPickerClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {
                        paintView.setCanvasBackground(selectedColor);
                        mySharedPreference.saveUserBackground(selectedColor);
                    }
                })
                .build()
                .show();
    }
}
