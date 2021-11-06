package com.example.thirdtask;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.xpath.XPathExpression;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnplus, btnminus, btniDvide, btnMultiply,
            btnclear, btnEqual, btnDot, btnbackspace,btnPi,btnsin,btncos;
    EditText editTextMainscreen;
    TextView tvHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        buttonListner();
        editTextMainscreen.setShowSoftInputOnFocus(false);

    }

    @SuppressLint("CutPasteId")
    public void init() {
        btn0 = findViewById(R.id.btnzero);
        btn1 = findViewById(R.id.btnone);
        btn2 = findViewById(R.id.btntwo);
        btn3 = findViewById(R.id.btnthree);
        btn4 = findViewById(R.id.btnfour);
        btn5 = findViewById(R.id.btnFive);
        btn6 = findViewById(R.id.btnsix);
        btn7 = findViewById(R.id.btnseven);
        btn8 = findViewById(R.id.btnEight);
        btn9 = findViewById(R.id.btnnine);
        btnplus = findViewById(R.id.btnplus);
        btnminus = findViewById(R.id.btnminus);
        btnMultiply = findViewById(R.id.btnmultiply);
        btniDvide = findViewById(R.id.btnDivide);
        btnDot = findViewById(R.id.btndot);
        btnclear = findViewById(R.id.btnClear);
        btnEqual = findViewById(R.id.btnequal);
        btnbackspace = findViewById(R.id.btnback);
        btnPi = findViewById(R.id.btnpi);
        btnsin = findViewById(R.id.btnsin);
        btncos = findViewById(R.id.btncos);
        editTextMainscreen = findViewById(R.id.edtext_main);
        tvHistory = findViewById(R.id.tv1);
    }

    public void buttonListner() {
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnplus.setOnClickListener(this);
        btnminus.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btniDvide.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnclear.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        editTextMainscreen.setOnClickListener(this);
        tvHistory.setOnClickListener(this);
        btnbackspace.setOnClickListener(this);
        btnPi.setOnClickListener(this);
        btnsin.setOnClickListener(this);
        btncos.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnzero:
                updateText("0");
                break;
            case R.id.btnone:
                updateText("1");
                break;
            case R.id.btntwo:
                updateText("2");
                break;
            case R.id.btnthree:
                updateText("3");
                break;
            case R.id.btnfour:
                updateText("4");
                break;
            case R.id.btnFive:
                updateText("5");
                break;
            case R.id.btnsix:
                updateText("6");
                break;
            case R.id.btnseven:
                updateText("7");
                break;
            case R.id.btnEight:
                updateText("8");
                break;
            case R.id.btnnine:
                updateText("9");
                break;
            case R.id.btnplus:
                 updateText("+");
                break;
            case R.id.btnminus:
                updateText("-");
                break;
            case R.id.btnDivide:
                updateText("÷");
                break;
            case R.id.btnmultiply:
                updateText("×");
                break;
            case R.id.btnClear:
                editTextMainscreen.setText("");
                tvHistory.setText("");
                break;
            case R.id.btnback:
                setBtnbackspace();
                break;
            case R.id.btndot:
                updateText(".");
                break;
            case R.id.btnequal:
                setBtnEqual();
                break;
            case R.id.btnpi:
                setBtnPi();
                break;
            case R.id.btnsin:
                setBtnSin();
                break;
            case R.id.btncos:
                setBtnCos();
                break;

        }
    }

    void setBtnSin(){
        try {
            Double sin = Math.sin(Math.toRadians(Double.parseDouble(editTextMainscreen.getText().toString())));
            editTextMainscreen.setText("");
            tvHistory.setText(Math.floor(sin)+"");
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    void setBtnCos(){
        try {
            Double cos = Math.cos(Math.toRadians(Double.parseDouble(editTextMainscreen.getText().toString())));
            editTextMainscreen.setText("");
            tvHistory.setText(Math.floor(cos)+"");
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public  void  setBtnPi()
    {
        double pi= Math.PI;
        tvHistory.setText(pi+"");
        editTextMainscreen.setText("");
    }
    public void setBtnEqual() {

        String str = editTextMainscreen.getText().toString();
        if (str.split("\\+").length == 2) {
            String number[] = str.split("\\+");
            try {
                str = "";

                double sum = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                str += sum;
                editTextMainscreen.setText("");

                tvHistory.setText(number[0]+"+"+number[1]+"= "+str);
                updateText(str + "");

                Toast.makeText(this, "result" + str, Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (str.split("\\-").length == 2) {
            String number[] = str.split("\\-");
            try {
                str = "";

                double sum = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                str += sum;
                editTextMainscreen.setText("");
                tvHistory.setText(sum + "");
                updateText(str + "");

                Toast.makeText(this, "result" + str, Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (str.split("\\×").length == 2) {
            String number[] = str.split("\\×");
            try {
                str = "";
                double sum = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                str += sum;
                editTextMainscreen.setText("");
                tvHistory.setText(sum + "");
                updateText(str + "");

                Toast.makeText(this, "result" + str, Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (str.split("\\÷").length == 2) {
            String number[] = str.split("\\÷");
            try {
                str = "";
                double sum = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                str += sum;
                editTextMainscreen.setText("");
                tvHistory.setText(sum + "");
                updateText(str + "");

                Toast.makeText(this, "result" + str, Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    public void updateText(String str) {
        String oldString = editTextMainscreen.getText().toString();
        int cursorPos = editTextMainscreen.getSelectionStart();

        String leftstring = oldString.substring(0, cursorPos);
        String rightstring = oldString.substring(cursorPos);
        editTextMainscreen.setText(String.format("%s%s%s", rightstring, str, leftstring));
        editTextMainscreen.setSelection(cursorPos + 0);
//        if (editTextMainscreen.getText().length() >= 15) {
//            Toast.makeText(this, "Maximum number of digits(13) exceeded.", Toast.LENGTH_SHORT).show();
//        }
    }

    public void setBtnbackspace() {
        int cursorPostion = editTextMainscreen.getSelectionStart();
        int textLength = editTextMainscreen.getText().length();
        if (cursorPostion != 0 && textLength != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) editTextMainscreen.getText();
            selection.replace(cursorPostion - 1, cursorPostion, "");
            editTextMainscreen.setText(selection);
            editTextMainscreen.setSelection(cursorPostion - 1);

        }
    }

}