package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Button bt0,bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,btp; //數字部分
    private Button btEqu,btPlus,btMinus,btMul,btDiv,btDel;//按鈕部分

    private TextView textShow,textAns,textOp;

    private int pre_Operator = 0;
    private int operator = 0;
    private double sum1 = 0;
    Boolean isTypenumber = false;
//    private String s = ""; //用來判斷+-*//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt0 = (Button) findViewById(R.id.btn_0);
        bt1=(Button)findViewById(R.id.btn_1);
        bt2=(Button)findViewById(R.id.btn_2);
        bt3=(Button)findViewById(R.id.btn_3);
        bt4=(Button)findViewById(R.id.btn_4);
        bt5=(Button)findViewById(R.id.btn_5);
        bt6=(Button)findViewById(R.id.btn_6);
        bt7=(Button)findViewById(R.id.btn_7);
        bt8=(Button)findViewById(R.id.btn_8);
        bt9=(Button)findViewById(R.id.btn_9);
        btp=(Button)findViewById(R.id.btn_p);
        btEqu=(Button)findViewById(R.id.btn_equal);
        btPlus=(Button)findViewById(R.id.btn_plus);
        btMinus=(Button)findViewById(R.id.btn_minus);
        btMul=(Button)findViewById(R.id.btn_mul);
        btDiv=(Button)findViewById(R.id.btn_divide);
        btDel=(Button)findViewById(R.id.btn_del);

        textShow=(TextView) findViewById(R.id.txt_display);
        textAns=(TextView) findViewById(R.id.txt_preView);
        textOp = (TextView)findViewById(R.id.txt_Operator);
        textShow.setText("0");

        bt0.setOnClickListener(myListener);
        bt1.setOnClickListener(myListener);
        bt2.setOnClickListener(myListener);
        bt3.setOnClickListener(myListener);
        bt4.setOnClickListener(myListener);
        bt5.setOnClickListener(myListener);
        bt6.setOnClickListener(myListener);
        bt7.setOnClickListener(myListener);
        bt8.setOnClickListener(myListener);
        bt9.setOnClickListener(myListener);
        btp.setOnClickListener(myListener);
        btPlus.setOnClickListener(myListener);
        btMinus.setOnClickListener(myListener);
        btMul.setOnClickListener(myListener);
        btDiv.setOnClickListener(myListener);
        btDel.setOnClickListener(myListener);
        //btC.setOnClickListener(myListener);
        //btEqu.setOnClickListener(myListener);


        btEqu.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(textShow.getText().toString() == ""){
                    textShow.setText(subZeroAndDot(String.valueOf(sum1)));
                    textAns.setText("");
                    return;
                }
                switch (operator) {
                    case 1://除
                        if(sum1 == 0){
                            textShow.setText("0");
                            sum1 = 0;
                            operator = 0;
                            pre_Operator = 0;
                            isTypenumber = false;
                            break;
                        }
                        else if(Integer.parseInt(textShow.getText().toString()) == 0 ){  //  防呆0
                            Toast.makeText(getApplicationContext(),"錯誤! 不能除以0",Toast.LENGTH_LONG).show();
                            //textShow.setText("ERROR");
                            textShow.setText("0");
                            sum1 = 0;
                            operator = 0;
                            pre_Operator = 0;
                            isTypenumber = false;
                            break;
                        }
                        else{
                            sum1 /=Double.parseDouble(textShow.getText().toString());
                        }
                        textShow.setText(subZeroAndDot(String.valueOf(sum1)));
                        textAns.setText("0");
                        isTypenumber = false;
                        break;
                    case 2://乘
                        sum1 *= Double.parseDouble(textShow.getText().toString());
                        textShow.setText(subZeroAndDot(String.valueOf(sum1)));
                        isTypenumber = false;
                        break;
                    case 3://減
                        sum1 -= Double.parseDouble(textShow.getText().toString());
                        textShow.setText(subZeroAndDot(String.valueOf(sum1)));
                        isTypenumber = false;
                        break;
                    case 4://加
                        sum1 += Double.parseDouble(textShow.getText().toString());
                        textShow.setText(subZeroAndDot(String.valueOf(sum1)));
                        isTypenumber = false;
                        break;
                    default:
                        break;
                }
                textAns.setText("");
                textOp.setText("");
                operator = 0;
            }
        });
    }

    private String st;
    private Button.OnClickListener myListener=new Button.OnClickListener(){
        
        public void onClick(View v){
            Button btnTemp=(Button)findViewById(v.getId());
            String keyin = textShow.getText().toString();
            if(keyin == "0"){
                keyin="";
            }
            switch(v.getId()){
                case R.id.btn_0:
                {
                    if (isTypenumber == false) {
                        isTypenumber = true;
                        if(operator != 0){ //判斷是否按下operator
                            keyin ="";
                            textShow.setText(keyin);
                        }
                    }
                    textShow.setText(keyin+"0");
                    break;
                }
                case R.id.btn_1:
                {
                    if (isTypenumber == false) {
                        isTypenumber = true;
                        if(operator != 0){ //判斷是否按下operator
                            keyin ="";
                            textShow.setText(keyin);
                        }
                    }
                    if(keyin.equals("0")){
                        keyin ="";
                    }
                    textShow.setText(keyin+"1");

                    break;
                }
                case R.id.btn_2:
                {
                    if (isTypenumber == false) {
                        isTypenumber = true;
                        if(operator != 0){ //判斷是否按下operator
                            keyin ="";
                            textShow.setText(keyin);
                        }
                    }
                    if(keyin.equals("0")){
                        keyin ="";
                    }
                    textShow.setText(keyin+"2");

                    break;
                }
                case R.id.btn_3:
                {
                    if (isTypenumber == false) {
                        isTypenumber = true;
                        if(operator != 0){ //判斷是否按下operator
                            keyin ="";
                            textShow.setText(keyin);
                        }
                    }
                    if(keyin.equals("0")){
                        keyin ="";
                    }
                    textShow.setText(keyin+"3");

                    break;
                }
                case R.id.btn_4:
                {
                    if (isTypenumber == false) {
                        isTypenumber = true;
                        if(operator != 0){ //判斷是否按下operator
                            keyin ="";
                            textShow.setText(keyin);
                        }
                    }
                    if(keyin.equals("0")){
                        keyin ="";
                    }
                    textShow.setText(keyin+"4");

                    break;
                }
                case R.id.btn_5:
                {
                    if (isTypenumber == false) {
                        isTypenumber = true;
                        if(operator != 0){ //判斷是否按下operator
                            keyin ="";
                            textShow.setText(keyin);
                        }
                    }
                    if(keyin.equals("0")){
                        keyin ="";
                    }
                    textShow.setText(keyin+"5");

                    break;
                }
                case R.id.btn_6:
                {
                    if (isTypenumber == false) {
                        isTypenumber = true;
                        if(operator != 0){ //判斷是否按下operator
                            keyin ="";
                            textShow.setText(keyin);
                        }
                    }
                    if(keyin.equals("0")){
                        keyin ="";
                    }
                    textShow.setText(keyin+"6");

                    break;
                }
                case R.id.btn_7:
                {
                    if (isTypenumber == false) {
                        isTypenumber = true;
                        if(operator != 0){ //判斷是否按下operator
                            keyin ="";
                            textShow.setText(keyin);
                        }
                    }
                    if(keyin.equals("0")){
                        keyin ="";
                    }
                    textShow.setText(keyin+"7");

                    break;
                }
                case R.id.btn_8:
                {
                    if (isTypenumber == false) {
                        isTypenumber = true;
                        if(operator != 0){ //判斷是否按下operator
                            keyin ="";
                            textShow.setText(keyin);
                        }
                    }
                    if(keyin.equals("0")){
                        keyin ="";
                    }
                    textShow.setText(keyin+"8");

                    break;
                }
                case R.id.btn_9:
                {
                    if (isTypenumber == false) {
                        isTypenumber = true;
                        if(operator != 0){ //判斷是否按下operator
                            keyin ="";
                            textShow.setText(keyin);
                        }
                    }
                    if(keyin.equals("0")){
                        keyin ="";
                    }
                    textShow.setText(keyin+"9");

                    break;
                }
                case R.id.btn_p:
                {
                    if (isTypenumber == false) {
                        isTypenumber = true;
                        if(operator != 0){ //判斷是否按下operator
                            keyin ="";
                            textShow.setText(keyin);
                        }
                    }
                    String tmp = textShow.getText().toString();
                    if(tmp.length() == 0 || tmp == "0"){//沒有數字 小數點會補0
                        keyin = "0.";
                    }
                    else{
                        if(tmp.indexOf(".") == -1){
                           keyin +=".";
                        }
                    }
                    textShow.setText(keyin);
                    break;
                }
                case R.id.btn_plus:
                {
                    textOp.setText("+");
                    if(pre_Operator == 0){
                        operator = 4;
                        pre_Operator = operator;
                    }
                    else{
                        pre_Operator = operator;
                        operator = 4;
                    }

                    if(isTypenumber == true) {
                        isTypenumber = false;
                        if (sum1 == 0) { //第一次
                            sum1 = Double.parseDouble(textShow.getText().toString());
                        } else {
                            if (pre_Operator != 0) {
                                sum1 = calculate(sum1, Double.parseDouble(textShow.getText().toString()), pre_Operator);//先算上一次的值
                                textShow.setText("");
                                textAns.setText(subZeroAndDot(String.valueOf(sum1)));
                            }
                        }
                    }
                    break;
                }
                case R.id.btn_minus:
                {
                    textOp.setText("-");
                    if(pre_Operator == 0){
                        operator = 3;
                        pre_Operator = operator;
                    }else{
                        pre_Operator = operator;
                        operator = 3;
                    }
                    if(isTypenumber == true) {
                        isTypenumber = false;
                        if (sum1 == 0) { //第一次
                            sum1 = Double.parseDouble(textShow.getText().toString());
                        } else {
                            if (pre_Operator != 0) {
                                sum1 = calculate(sum1, Double.parseDouble(textShow.getText().toString()), pre_Operator);//先算上一次的值
                                textAns.setText(subZeroAndDot(String.valueOf(sum1)));
                            }
                        }
                    }
                    break;
                }
                case R.id.btn_mul:
                {
                    textOp.setText("*");
                    if(pre_Operator == 0){
                        operator = 2;
                        pre_Operator = operator;
                    }else{
                        pre_Operator = operator;
                        operator = 2;
                    }
                    if(isTypenumber == true) {
                        isTypenumber = false;
                        if (sum1 == 0) { //第一次
                            sum1 = Double.parseDouble(textShow.getText().toString());
                        } else {
                            if (pre_Operator != 0) {
                                sum1 = calculate(sum1, Double.parseDouble(textShow.getText().toString()), pre_Operator);//先算上一次的值
                                textAns.setText(subZeroAndDot(String.valueOf(sum1)));
                            }
                        }
                    }
                    break;
                }
                case R.id.btn_divide:
                {
                    textOp.setText("/");
                    if(pre_Operator == 0){
                        operator = 1;
                        pre_Operator = operator;
                    }else{
                        pre_Operator = operator;
                        operator = 1;
                    }
                    if(isTypenumber == true) {
                        isTypenumber = false;
                        if (sum1 == 0) { //第一次
                            sum1 = Double.parseDouble(textShow.getText().toString());
                        } else {
                            if (pre_Operator != 0) {
                                sum1 = calculate(sum1, Double.parseDouble(textShow.getText().toString()), pre_Operator);//先算上一次的值

                                textAns.setText(subZeroAndDot(String.valueOf(sum1)));
                            }
                        }
                    }
                    break;
                }
                case R.id.btn_del:
                {
                    keyin = "0";
                    textShow.setText(keyin);
                    textAns.setText("");
                    textOp.setText("");
                    pre_Operator = 0;
                    operator = 0;
                    sum1 = 0;
                    isTypenumber = false;
                    break;
                }
            }

        }
    };
    /*case R.id.btn_equal:
                {
                    double total = sum1 + Double.parseDouble(textShow.getText().toString());
                    textShow.setText(String.valueOf(total));
                    textAns.setText("");
                    break;
                }*/
    private double calculate(double n1,double n2,int op){
        switch (op) {
            case 1://除
                if( n2 == 0){  //  防呆
                    //textShow.setText("ERROR");
                    Toast.makeText(getApplicationContext(),"錯誤! 不能除以0",Toast.LENGTH_LONG).show();
                    textShow.setText("0");
                }
                else{
                    n1 /= n2;
                }
                //textShow.setText(String.valueOf(n1));
                break;
            case 2://乘
                n1 *= n2;
                //textShow.setText(String.valueOf(n1));
                break;
            case 3://減
                n1 -= n2;
                //textShow.setText(String.valueOf(n1));
                break;
            case 4://加
                n1 += n2;
                //textShow.setText(String.valueOf(n1));
                break;
            default:
                break;
        }
        return n1;
    }
    //移除不需要.0
    public static String getPrettyNumber(String number) {
        return BigDecimal.valueOf(Double.parseDouble(number))
                .stripTrailingZeros().toPlainString();
    }

    public static String subZeroAndDot(String s){
        if(s.indexOf(".") > 0){
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }
}
