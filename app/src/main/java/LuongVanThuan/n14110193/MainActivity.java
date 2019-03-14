/**
 * Luong Van Thuan- 14110193
 * March 2019
 */


package LuongVanThuan.n14110193;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // declare widgets variables
    Button btnSin, btnCos, btnTan, btnFactorial, btnPow;
    Button btnClear, btnDel, btnOpen, btnClose, btnRootSquare;
    Button btn7, btn8, btn9, btnDiv;
    Button btn4, btn5, btn6, btnMulti;
    Button btn1, btn2, btn3, btnSubstract, btnAdd, btnResult;
    Button btn0, btnDot, btnPi;

    TextView screenAns, screenMath;

    StringBuilder textMath = new StringBuilder("");
    StringBuilder textAns = new StringBuilder("0");
    StringBuilder screenTextMath = new StringBuilder("");
    double num1 = 0, num2 = 0, ans = 0;
    //char mask = ' ';
    int checkSubmit = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();


    }

    public void mapping() {
        //Control
        screenAns = (TextView) findViewById(R.id.tv_result);
        screenMath = (TextView) findViewById(R.id.tv_math);

        btn0 = (Button) findViewById(R.id.btn_0);
        btn0.setOnClickListener(this);

        btn1 = (Button) findViewById(R.id.btn_1);
        btn1.setOnClickListener(this);

        btn2 = (Button) findViewById(R.id.btn_2);
        btn2.setOnClickListener(this);

        btn3 = (Button) findViewById(R.id.btn_3);
        btn3.setOnClickListener(this);

        btn4 = (Button) findViewById(R.id.btn_4);
        btn4.setOnClickListener(this);

        btn5 = (Button) findViewById(R.id.btn_5);
        btn5.setOnClickListener(this);


        btn6 = (Button) findViewById(R.id.btn_6);
        btn6.setOnClickListener(this);

        btn7 = (Button) findViewById(R.id.btn_7);
        btn7.setOnClickListener(this);

        btn8 = (Button) findViewById(R.id.btn_8);
        btn8.setOnClickListener(this);

        btn9 = (Button) findViewById(R.id.btn_9);
        btn9.setOnClickListener(this);

        btnSin = (Button) findViewById(R.id.btn_sin);
        btnSin.setOnClickListener(this);

        btnCos = (Button) findViewById(R.id.btn_cos);
        btnCos.setOnClickListener(this);


        btnTan = (Button) findViewById(R.id.btn_tan);
        btnTan.setOnClickListener(this);

        btnFactorial = (Button) findViewById(R.id.btn_factorial);
        btnFactorial.setOnClickListener(this);

        btnPow = (Button) findViewById(R.id.btn_pow);
        btnPow.setOnClickListener(this);


        btnClear = (Button) findViewById(R.id.btn_clear);
        btnClear.setOnClickListener(this);


        btnDel = (Button) findViewById(R.id.btn_del);
        btnDel.setOnClickListener(this);

        btnClose = (Button) findViewById(R.id.btn_close);
        btnClose.setOnClickListener(this);

        btnOpen = (Button) findViewById(R.id.btn_open);
        btnOpen.setOnClickListener(this);

        btnRootSquare = (Button) findViewById(R.id.btn_root_square);
        btnRootSquare.setOnClickListener(this);

        btnDot = (Button) findViewById(R.id.btn_dot);
        btnDot.setOnClickListener(this);

        btnPi = (Button) findViewById(R.id.btn_pi);
        btnPi.setOnClickListener(this);


        btnDiv = (Button) findViewById(R.id.btn_div);
        btnDiv.setOnClickListener(this);


        btnMulti = (Button) findViewById(R.id.btn_mul);
        btnMulti.setOnClickListener(this);


        btnSubstract = (Button) findViewById(R.id.btn_sub);
        btnSubstract.setOnClickListener(this);


        btnAdd = (Button) findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(this);


        btnResult = (Button) findViewById(R.id.btn_result);
        btnResult.setOnClickListener(this);
    }

    public void error() {
        screenAns.setText("Math Error !");
        textAns = textMath = screenTextMath = new StringBuilder("");
    }

    public void submit(String[] elementMath) {
        InfixToPostfix ITP = new InfixToPostfix();
        if (textMath.length() > 0) {
            try {
                if (!ITP.check_error)
                    elementMath = ITP.processString(textMath.toString());        //	split expression to element
                if (!ITP.check_error)
                    elementMath = ITP.postfix(elementMath);        // 	format elements to postfix
                if (!ITP.check_error)
                    textAns = new StringBuilder(ITP.valueMath(elementMath));        // get result
                screenAns.setText(textAns);

                screenTextMath = new StringBuilder();
                textMath = new StringBuilder();
                checkSubmit = 1;

            } catch (Exception e) {
                error();
            }
            if (ITP.check_error) error();
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        String elementMath[] = null;


        if (id == R.id.btn_0) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("0");
                screenTextMath.append("0");
            }
            screenMath.setText(screenTextMath);
        } else if (id == R.id.btn_1) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("1");
                screenTextMath.append("1");
            }
            screenMath.setText(screenTextMath);
        } else if (id == R.id.btn_2) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("2");
                screenTextMath.append("2");
            }
            screenMath.setText(screenTextMath);
        } else if (id == R.id.btn_3) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("3");
                screenTextMath.append("3");
            }

            screenMath.setText(screenTextMath);
        } else if (id == R.id.btn_4) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("4");
                screenTextMath.append("4");
            }
            screenMath.setText(screenTextMath);
        } else if (id == R.id.btn_5) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("5");
                screenTextMath.append("5");
            }
            screenMath.setText(screenTextMath.toString());
        } else if (id == R.id.btn_6) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("6");
                screenTextMath.append("6");
            }
            screenMath.setText(screenTextMath);
        } else if (id == R.id.btn_7) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("7");
                screenTextMath.append("7");
            }
            screenMath.setText(screenTextMath);
        } else if (id == R.id.btn_8) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("8");
                screenTextMath.append("8");
            }
            screenMath.setText(screenTextMath);
        } else if (id == R.id.btn_9) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("9");
                screenTextMath.append("9");
            }
            screenMath.setText(screenTextMath);
        } else if (id == R.id.btn_dot) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append(".");
                screenTextMath.append(".");
            }
            screenMath.setText(screenTextMath);
        } else if (id == R.id.btn_pi) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("π");
                screenTextMath.append("π");
            }
            screenMath.setText(screenTextMath);
        } else if (id == R.id.btn_add) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("+");
                screenTextMath.append("+");
            }
            screenMath.setText(screenTextMath);
        } else if (id == R.id.btn_sub) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("-");
                screenTextMath.append("-");
            }
            screenMath.setText(screenTextMath);
        } else if (id == R.id.btn_mul) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("*");
                screenTextMath.append("*");
            }
            screenMath.setText(screenTextMath);
        } else if (id == R.id.btn_div) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("/");
                screenTextMath.append("/");
            }
            screenMath.setText(screenTextMath);
        } else if (id == R.id.btn_pow) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("^(");
                screenTextMath.append("^(");
            }
            screenMath.setText(screenTextMath);
        } else if (id == R.id.btn_root_square) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("@");
                screenTextMath.append("√");
            }
            screenMath.setText(screenTextMath);
        } else if (id == R.id.btn_sin) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("s(");
                screenTextMath.append("Sin(");
            }
            screenMath.setText(screenTextMath);
        } else if (id == R.id.btn_cos) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("c(");
                screenTextMath.append("Cos(");
            }
            screenMath.setText(screenTextMath);
        } else if (id == R.id.btn_tan) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("t(");
                screenTextMath.append("Tan(");
            }
            screenMath.setText(screenTextMath);
        } else if (id == R.id.btn_open) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append("(");
                screenTextMath.append("(");
            }
            screenMath.setText(screenTextMath);
        } else if (id == R.id.btn_close) {
            if (screenTextMath.length() < 48) {    //if length < 48
                if (checkSubmit == 1) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = 0;
                }
                textMath.append(")");
                screenTextMath.append(")");
            }
            screenMath.setText(screenTextMath);
        } else if (id == R.id.btn_result) {
            submit(elementMath);
        } else if (id == R.id.btn_clear) {
            textMath = new StringBuilder("");
            screenTextMath = new StringBuilder("");
            textAns = new StringBuilder("0");
            screenAns.setText(textAns);
            screenMath.setText("|");
        } else if (id == R.id.btn_del) {
            if (screenMath.length() > 0) {
                char c = textMath.charAt(textMath.length() - 1);
                if (textMath.length() > 1 && c == '(' && textMath.charAt(textMath.length() - 2) == '^') {
                    screenTextMath = new StringBuilder(screenTextMath.substring(0, screenTextMath.length() - 2));
                    textMath = new StringBuilder(textMath.substring(0, textMath.length() - 2));
                } else if (textMath.length() > 1 && c == '(' && (textMath.charAt(textMath.length() - 2) == 's' || textMath.charAt(textMath.length() - 2) == 'c' || textMath.charAt(textMath.length() - 2) == 't')) {
                    textMath = new StringBuilder(textMath.substring(0, textMath.length() - 2));
                    screenTextMath = new StringBuilder(screenTextMath.substring(0, screenTextMath.length() - 4));
                } else {
                    textMath = new StringBuilder(textMath.substring(0, textMath.length() - 1));
                    screenTextMath = new StringBuilder(screenTextMath.substring(0, screenTextMath.length() - 1));
                }
                screenMath.setText(screenTextMath);
            }

        }
    }
}

