package com.example.kalq;

import android.annotation.SuppressLint;
import android.inputmethodservice.InputMethodService;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Timer;

@SuppressLint("ClickableViewAccessibility")
public class MyInputMethodService extends InputMethodService {

    private ConstraintLayout kalqLayout;
    public static boolean flag = false;
    Button delete;
    Timer timer = new Timer();

    @Override
    public void onInitializeInterface() {
        super.onInitializeInterface();
    }

    @Override
    public View onCreateInputView() {
        kalqLayout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.kalq_keyboard_view, null);
        Button delete = kalqLayout.findViewById(R.id.del);

        delete.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                InputConnection ic = getCurrentInputConnection();
                long time;

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        flag = true;
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                long time = 800;
                                while (flag) {

                                    CharSequence selectedText = ic.getSelectedText(0);
                                    if (TextUtils.isEmpty(selectedText)) {
                                        ic.deleteSurroundingText(1, 0);
                                    } else {
                                        ic.commitText("", 1);
                                    }

                                    if (time > 50){ time -= 100;
                                    } else { time = 50; }

                                    try {
                                        Thread.sleep(time);

                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }).start();
                        break;
                    case MotionEvent.ACTION_UP:
                        flag = false;
                        break;
                }

                return false;
            }
        });

        return kalqLayout;
    }

    public void space(View v){
        flag = false;
        InputConnection ic = getCurrentInputConnection();
        ic.commitText(" ",1);
    }

    public void enter(View v) {
        flag = false;
        InputConnection ic = getCurrentInputConnection();
        ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
    }


    public void letter(View v){
        flag = false;
        Button b = v.findViewById(v.getId());
        CharSequence text = b.getText();

        InputConnection ic = getCurrentInputConnection();
        ic.commitText(text.toString(), 1);
    }

}
