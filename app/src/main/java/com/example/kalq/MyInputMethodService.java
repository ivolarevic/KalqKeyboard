package com.example.kalq;

import android.inputmethodservice.InputMethodService;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;

import androidx.constraintlayout.widget.ConstraintLayout;

public class MyInputMethodService extends InputMethodService implements View.OnClickListener {

    private ConstraintLayout kalqLayout;

    @Override
    public void onInitializeInterface() {
        super.onInitializeInterface();
    }

    @Override
    public View onCreateInputView() {
        kalqLayout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.kalq_keyboard_view, null);

        return kalqLayout;
    }

    public void space(View v){
        InputConnection ic = getCurrentInputConnection();
        ic.commitText(" ",1);
    }

    public void enter(View v) {
        InputConnection ic = getCurrentInputConnection();
        ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
    }

    public void delete(View v){
        InputConnection ic = getCurrentInputConnection();
        ic.deleteSurroundingText(1, 0);
    }

    public void letter(View v){
        Button b = v.findViewById(v.getId());
        CharSequence text = b.getText();

        InputConnection ic = getCurrentInputConnection();
        ic.commitText(text.toString(), 1);
    }

    @Override
    public void onClick(View v) {

    }
}
