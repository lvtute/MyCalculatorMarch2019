/**
 * Luong Van Thuan- 14110193
 * March 2019
 */


package LuongVanThuan.n14110193;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // declare widgets variables
    Button btnSin, btnCos, btnTan, btnFactorial, btnPow;
    Button btnClear, btnDel, btnOpen, btnClose, btnRootSquare;
    Button btn7, btn8, btn9, btnDiv;
    Button btn4, btn5, btn6, btnMulti;
    Button btn1, btn2, btn3, btnSubstract, btnAdd, btnResult;
    Button btn0, btnDot, btnPi;
    Button btnNegative;

    TextView screenAns;
    EditText editText;

    private boolean isNumber = false;
    private boolean lastDot = false;
    private boolean stateError = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();

        // Hiding and disable keyboard
        editText.setRawInputType(InputType.TYPE_NULL);
        editText.addTextChangedListener(textWatcher);


    }

    public void mapping() {
        //Control
        screenAns = (TextView) findViewById(R.id.tv_result);
        editText = (EditText) findViewById(R.id.edt_input);

        btnNegative = findViewById(R.id.btn_negative);
        btnNegative.setOnClickListener(this);

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


    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.btn_0:
                append("0");
                isNumber = true;
                break;
            case R.id.btn_1:
                append("1");
                isNumber = true;
                break;
            case R.id.btn_2:
                append("2");
                isNumber = true;
                break;
            case R.id.btn_3:
                append("3");
                isNumber = true;
                break;
            case R.id.btn_4:
                append("4");
                isNumber = true;
                break;
            case R.id.btn_5:
                append("5");
                isNumber = true;
                break;
            case R.id.btn_6:
                append("6");
                isNumber = true;
                break;
            case R.id.btn_7:
                append("7");
                isNumber = true;
                break;
            case R.id.btn_8:
                append("8");
                isNumber = true;
                break;
            case R.id.btn_9:
                append("9");
                isNumber = true;
                break;
            case R.id.btn_add:
                if (!isEmpty()) {
                    if (endsWithOperatore())
                        replace("+");
                    else
                        append("+");
                    isNumber = false;
                    lastDot = false;
                    break;
                }
            case R.id.btn_mul:
                if (!isEmpty()) {
                    if (endsWithOperatore())
                        replace("*");
                    else
                        append("*");
                    isNumber = false;
                    lastDot = false;
                    break;
                }
            case R.id.btn_sub:
                if (!isEmpty()) {
                    if (endsWithOperatore())
                        replace("-");
                    else
                        append("-");
                    isNumber = false;
                    lastDot = false;
                    break;
                } else {
                    append("-");
                    Toast.makeText(this.getApplicationContext(), "hihi",
                            Toast.LENGTH_LONG).show();
                    break;
                }
            case R.id.btn_div:
                if (!isEmpty()) {
                    if (endsWithOperatore())
                        replace("/");
                    else
                        append("/");
                    isNumber = false;
                    lastDot = false;
                    break;
                }
            case R.id.btn_dot:
                if (isNumber && !stateError && !lastDot) {
                    append(".");
                    Toast.makeText(this.getApplicationContext(), "hihi",
                            Toast.LENGTH_LONG).show();
                    isNumber = false;
                    lastDot = true;
                } else if (isEmpty()) {
                    append("0.");
                    isNumber = false;
                    lastDot = true;
                }
                break;

            case R.id.btn_pow:
                if (!isEmpty()) {
                    if (endsWithOperatore())
                        replace("^");
                    else
                        append("^");
                    isNumber = false;
                    lastDot = false;
                    break;
                }
            case R.id.btn_root_square:
//                if (!isEmpty()) {
//                    if (endsWithOperatore())
//                        append("sqrt(");
//                    else
                append("√(");
                isNumber = false;
                lastDot = false;
                break;
//                }
            case R.id.btn_del:
                delete();
                break;
            case R.id.btn_clear:
                clear();
                break;
            case R.id.btn_open:
                bracket();
                break;
            case R.id.btn_result:
                calculate(true);
                break;

            case R.id.btn_pi:
                append("π");
                isNumber = true;
                break;
            case R.id.btn_factorial:
                append("!");

            case R.id.btn_sin:
                append("sin(");
            default:
                break;


        }
    }

    private void appendsing(String str, int index) {

        editText.getText().replace(index, index + 1, str);
    }

    private void calculate(boolean isequlclick) {

        String input = getinput();
        try {
            if (!isEmpty() && !endsWithOperatore()) {
//                if (input.contains("x")) {
//                    input = input.replaceAll("x", "*");
//                }

//                if(input.contains("\u00F7")){
//                    input=input.replaceAll("\u00F7","/");
//                }
//                if (input.contains("π")) {
//                    input = input.replaceAll("π", "pi");
//                }
                if (input.contains("√")) {
                    input = input.replaceAll("√", "sqrt");
                }
                Expression expression = new ExpressionBuilder(input)
                        .variables("π")
                        .build()
                        .setVariable("π", Math.PI);

                double result = expression.evaluate();


                if (isequlclick) {
                    editText.setText(standardizeDouble(result));
//                    editText.setText(String.valueOf(result));
                    screenAns.setText("");
                } else
                    screenAns.setText(standardizeDouble(result));
//                    screenAns.setText(String.valueOf(result));
            } else screenAns.setText("");
        } catch (Exception e) {
            stateError = true;
            isNumber = false;
        }

    }

    private void bracket() {
        if ((!stateError && !isEmpty() && !endsWithbracket() && isNumber) || isclosed()) {
            append("*(");
        } else if (isEmpty() || endsWithOperatore() || endsWithbracket()) {
            append("(");
        } else if (!isEmpty() && !endsWithbracket()) {
            append(")");
        }
    }

    private boolean isclosed() {
        return getinput().endsWith(")");
    }

    private boolean endsWithbracket() {
        return getinput().endsWith("(");
    }

    private void append(String str) {
        this.editText.getText().append(str);
    }


    private String getinput() {
        return this.editText.getText().toString();
    }

    private boolean isEmpty() {
        return getinput().isEmpty();
    }

    private boolean endsWithOperatore() {
        return getinput().endsWith("+") || getinput().endsWith("-") || getinput().endsWith("/") || getinput().endsWith("*");
    }

    private void replace(String str) {
        editText.getText().replace(getinput().length() - 1, getinput().length(), str);
    }

    private void clear() {
        lastDot = false;
        isNumber = false;
        stateError = false;
        editText.getText().clear();
    }

    private void delete() {
        if (!isEmpty()) {
            if (getinput().endsWith("sin(")||getinput().endsWith("cos(")
                    ||getinput().endsWith("tan(")){
                this.editText.getText().delete(getinput().length() - 4, getinput().length());
            }
            else{//default
                this.editText.getText().delete(getinput().length() - 1, getinput().length());
            }


        } else clear();
    }

    public String standardizeDouble(double num) {
        int a = (int) num;
        if (a == num)
            return Integer.toString(a);
        else return Double.toString(num);
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            calculate(false);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}

