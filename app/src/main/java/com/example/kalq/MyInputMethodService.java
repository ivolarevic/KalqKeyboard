package com.example.kalq;

import android.annotation.SuppressLint;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.TableLayout;

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

        initRightSide();
        initLeftSide();

        return kalqLayout;
    }

    private void initRightSide(){
        Button g = (Button) kalqLayout.findViewById(R.id.g); g.setOnClickListener(this);
        Button t = (Button) kalqLayout.findViewById(R.id.t); t.setOnClickListener(this);
        Button o = (Button) kalqLayout.findViewById(R.id.o); o.setOnClickListener(this);
        Button j = (Button) kalqLayout.findViewById(R.id.j); j.setOnClickListener(this);
        Button i = (Button) kalqLayout.findViewById(R.id.i); i.setOnClickListener(this);
        Button e = (Button) kalqLayout.findViewById(R.id.e); e.setOnClickListener(this);
        Button u = (Button) kalqLayout.findViewById(R.id.u); u.setOnClickListener(this);
        Button k = (Button) kalqLayout.findViewById(R.id.k); k.setOnClickListener(this);
        Button a = (Button) kalqLayout.findViewById(R.id.a); a.setOnClickListener(this);
        Button l = (Button) kalqLayout.findViewById(R.id.l); l.setOnClickListener(this);
        Button q = (Button) kalqLayout.findViewById(R.id.q); q.setOnClickListener(this);
    }

    private void initLeftSide(){
        Button m = (Button) kalqLayout.findViewById(R.id.m); m.setOnClickListener(this);
        Button b = (Button) kalqLayout.findViewById(R.id.b); b.setOnClickListener(this);
        Button w = (Button) kalqLayout.findViewById(R.id.w); w.setOnClickListener(this);
        Button h = (Button) kalqLayout.findViewById(R.id.h); h.setOnClickListener(this);
        Button p = (Button) kalqLayout.findViewById(R.id.p); p.setOnClickListener(this);
        Button x = (Button) kalqLayout.findViewById(R.id.x); x.setOnClickListener(this);
        Button c = (Button) kalqLayout.findViewById(R.id.c); c.setOnClickListener(this);
        Button r = (Button) kalqLayout.findViewById(R.id.r); r.setOnClickListener(this);
        Button y = (Button) kalqLayout.findViewById(R.id.y); y.setOnClickListener(this);
        Button s = (Button) kalqLayout.findViewById(R.id.s); s.setOnClickListener(this);
        Button z = (Button) kalqLayout.findViewById(R.id.z); z.setOnClickListener(this);
        Button d = (Button) kalqLayout.findViewById(R.id.d); d.setOnClickListener(this);
        Button n = (Button) kalqLayout.findViewById(R.id.n); n.setOnClickListener(this);
        Button f = (Button) kalqLayout.findViewById(R.id.f); f.setOnClickListener(this);
        Button vv = (Button) kalqLayout.findViewById(R.id.v); vv.setOnClickListener(this);
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

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        InputConnection ic = getCurrentInputConnection();
        String letter = "";
        switch (v.getId()) {
            // Right
            case R.id.j: letter = "j"; break;
            case R.id.t: letter = "t"; break;
            case R.id.o: letter = "o"; break;
            case R.id.g: letter = "g"; break;
            case R.id.i: letter = "i"; break;
            case R.id.e: letter = "e"; break;
            case R.id.u: letter = "u"; break;
            case R.id.k: letter = "k"; break;
            case R.id.a: letter = "a"; break;
            case R.id.l: letter = "l"; break;
            case R.id.q: letter = "q"; break;

            // Left
            case R.id.m: letter = "m"; break;
            case R.id.b: letter = "b"; break;
            case R.id.w: letter = "w"; break;
            case R.id.p: letter = "p"; break;
            case R.id.h: letter = "h"; break;
            case R.id.x: letter = "x"; break;
            case R.id.c: letter = "c"; break;
            case R.id.r: letter = "r"; break;
            case R.id.y: letter = "y"; break;
            case R.id.s: letter = "s"; break;
            case R.id.z: letter = "z"; break;
            case R.id.d: letter = "d"; break;
            case R.id.n: letter = "n"; break;
            case R.id.f: letter = "f"; break;
            case R.id.v: letter = "v"; break;

            default:
                letter = "";
        }
        ic.commitText(letter, 1);
    }
}
