package com.example.android.mycalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
/* 初始化 number1对应toNum1,number2对应toNum2
* change作为存数的转换标记，默认为存入number1.一旦change值为true,接下来输入的数会存入number2
* sign为最后传入等号(equal)方法的符号
* num1HasTrans确认number1已转换为double类的toNum1*/
public class MainActivity extends AppCompatActivity  {

    private String number1 = "";
    private String number2 = "";
    private double toNum1 = 0;
    private double toNum2 = 0;
    private boolean change = false;
    private String sign = "";
    private boolean num1HasTrans = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
/*创建选项菜单*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    /*菜单内容*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        switch (id) {
            case R.id.action_help:
                Toast.makeText(this, "曾华哲写的十分脆弱的计算器。。", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_exit:
                Toast.makeText(this, "退出程序", Toast.LENGTH_SHORT).show();
                MainActivity.this.finish();
                break;
        }


        return super.onOptionsItemSelected(item);
    }
    /*0-9的数字按钮默认输入的数存入number1，当change为true,输入的数存入number2*/
    public void zero (View view)
    {
        EditText display = (EditText)findViewById(R.id.display);
        if(!change)
        {
            display.setText(number1+=0);
        }
        else
        {
            display.setText(number2+=0);
        }

    }

    public void one (View view)
    {
        EditText display = (EditText)findViewById(R.id.display);
        if(!change)
        {
            display.setText(number1+=1);
        }
        else
        {
            display.setText(number2+=1);
        }

    }
    public void two (View view)
    {
        EditText display = (EditText)findViewById(R.id.display);
        if(!change)
        {
            display.setText(number1+=2);
        }
        else
        {
            display.setText(number2+=2);
        }
    }
    public void three (View view)
    {
        EditText display = (EditText)findViewById(R.id.display);
        if(!change)
        {
            display.setText(number1+=3);
        }
        else
        {
            display.setText(number2+=3);
        }
    }
    public void four (View view)
    {
        EditText display = (EditText)findViewById(R.id.display);
        if(!change)
        {
            display.setText(number1+=4);
        }
        else
        {
            display.setText(number2+=4);
        }
    }
    public void five (View view)
    {
        EditText display = (EditText)findViewById(R.id.display);
        if(!change)
        {
            display.setText(number1+=5);
        }
        else
        {
            display.setText(number2+=5);
        }
    }
    public void six (View view)
    {
        EditText display = (EditText)findViewById(R.id.display);
        if(!change)
        {
            display.setText(number1+=6);
        }
        else
        {
            display.setText(number2+=6);
        }
    }
    public void seven (View view)
    {
        EditText display = (EditText)findViewById(R.id.display);
        if(!change)
        {
            display.setText(number1+=7);
        }
        else
        {
            display.setText(number2+=7);
        }
    }
    public void eight (View view)
    {
        EditText display = (EditText)findViewById(R.id.display);
        if(!change)
        {
            display.setText(number1+=8);
        }
        else
        {
            display.setText(number2+=8);
        }
    }
    public void nine (View view)
    {
        EditText display = (EditText)findViewById(R.id.display);
        if(!change)
        {
            display.setText(number1+=9);
        }
        else
        {
            display.setText(number2+=9);
        }
    }
    /*加减法的实现，将number1和2类型转换，传入符号到等于方法
    * 如果是连加连减，则将和或差存入number1，清空number并接受接下来的输入*/
    public void plus(View view)
    {
        EditText display = (EditText)findViewById(R.id.display);
        if(number1.equals(""))
        {
            return;
        }
        if (!num1HasTrans)
        {
            toNum1 = Double.parseDouble(number1);
            num1HasTrans = true;
        }
        change = true;
        sign = "+";
        if(!number2.equals(""))
        {
                toNum2 = Double.parseDouble(number2);
                toNum1 = toNum1 + toNum2;
                display.setText(toNum1+"");
                number2="";
        }
    }
    public void minus(View view)
    {
        EditText display = (EditText)findViewById(R.id.display);
        if(number1.equals(""))
        {
            return;
        }
        if (!num1HasTrans)
        {
            toNum1 = Double.parseDouble(number1);
            num1HasTrans = true;
        }
        change = true;
        sign = "-";
        if(!number2.equals(""))
        {
            toNum2 = Double.parseDouble(number2);
            toNum1 = toNum1 - toNum2;
            display.setText(toNum1+"");
            number2="";
        }
    }
    public void multiply(View view)
    {
        EditText display = (EditText)findViewById(R.id.display);
        if(number1.equals(""))
        {
            return;
        }
        if (!num1HasTrans)
        {
            toNum1 = Double.parseDouble(number1);
            num1HasTrans = true;
        }
        change = true;
        sign = "*";
        if(!number2.equals(""))
        {
            toNum2 = Double.parseDouble(number2);
            toNum1 = toNum1 * toNum2;
            display.setText(toNum1+"");
            number2="";
        }
    }
    /*原理基本相同，不同的是接收number2后会先判断除数是否为0，若是则输出error并将所有变量初始化*/
    public void divide(View view)
    {
        EditText display = (EditText)findViewById(R.id.display);
        if(number1.equals(""))
        {
            return;
        }
        if (!num1HasTrans)
        {
            toNum1 = Double.parseDouble(number1);
            num1HasTrans = true;
        }
        change = true;
        sign = "/";

        if(!number2.equals(""))
        {
            toNum2 = Double.parseDouble(number2);
            if(toNum2!=0)
            {
                toNum1 = toNum1 / toNum2;
                display.setText(toNum1+"");
                number2="";
            }
            else
            {
                display.setText("ERROR");
                number1 = "";
                number2 = "";
                change = false;
                num1HasTrans = false;
            }
        }
    }
/*这里需要将number1和2转换为Int*/
    public void mod(View view)
    {
        EditText display = (EditText)findViewById(R.id.display);
        if(number1.equals(""))
        {
            return;
        }

        if (!num1HasTrans)
        {
            toNum1 = Double.parseDouble(number1);
            num1HasTrans = true;
        }
        change = true;
        sign = "%";
        if(!number2.equals(""))
        {
            toNum2 = Double.parseDouble(number2);
            toNum1 = (int)toNum1 % (int)toNum2;
            display.setText(toNum1+"");
            number2="";
        }
    }
    public void clear(View view)
    {
        EditText display = (EditText)findViewById(R.id.display);
        number1 = "";
        number2 = "";
        change = false;
        num1HasTrans = false;
        display.setText("");
    }
/*删除操作，若number1或2不为空，通过substring实现*/
    public void delete (View view)
    {
        EditText display = (EditText)findViewById(R.id.display);
        if(change)
        {
            if(!number2.equals(""))
            {
                number2 = number2.substring(0,number2.length()-1);
                display.setText(number2);
            }
            else
            {
                return;
            }
        }
        else
        {
            if(!number1.equals(""))
            {
                number1 = number1.substring(0,number1.length()-1);
                display.setText(number1);
            }
           else{
                return;
            }
        }
    }
    /*正负号操作*/
    public  void nOrP(View view)
    {
        EditText display = (EditText)findViewById(R.id.display);
        if(change)
        {
            toNum2 = Double.parseDouble(number2);
            toNum2 = -toNum2;
            number2 = toNum2 + "";
            display.setText(number2);
        }
        else
        {
            toNum1 = Double.parseDouble(number1);
            toNum1 = -toNum1;
            number1 = toNum1 + "";
            display.setText(number1);
        }
    }
    /*添加小数点，在没有数值的情况下直接按小数点按钮或重复添加小数点无效*/
    public void point(View view)
    {
        if(number1.equals(""))
        {
            return;
        }
        EditText display = (EditText)findViewById(R.id.display);
        if(change)
        {
            if (number2.substring(number2.length()-1,number2.length()).equals("."))
            {
                return;
            }
            display.setText(number2+=".");
        }
        else
        {
            if (number1.substring(number1.length()-1,number1.length()).equals("."))
            {
                return;
            }
            display.setText(number1+=".");
        }
    }

    /*转换为二进制，只对number1操作，且可将计算结果继续作为十进制运算*/
    public void binary(View view)
    {
        EditText display = (EditText)findViewById(R.id.display);
        if(number1.equals(""))
        {
            return;
        }
         int intNum = Integer.parseInt(number1);
        display.setText(Integer.toBinaryString(intNum));
    }
    public  void square(View view)
    {
        EditText display = (EditText)findViewById(R.id.display);
        if(number1.equals(""))
        {
            return;
        }
        toNum1 = Double.parseDouble(number1);
        double sqrNum = toNum1*toNum1;
        display.setText(sqrNum+"");
        number1 = sqrNum + "";
    }

    public void sin (View view)
    {
        if(number1.equals(""))
        {
            return;
        }
        EditText display = (EditText)findViewById(R.id.display);
        toNum1 = Double.parseDouble(number1);
        double sinNum = Math.sin(toNum1);
        display.setText(sinNum+"");
        number1 = sinNum + "";
    }
    public void cos (View view)
    {
        if(number1.equals(""))
        {
            return;
        }
        EditText display = (EditText)findViewById(R.id.display);
        toNum1 = Double.parseDouble(number1);
        double cosNum = Math.cos(toNum1);
        display.setText(cosNum+"");
        number1 = cosNum + "";
    }

    public void rad (View view)
    {
        if(number1.equals(""))
        {
            return;
        }
        EditText display = (EditText)findViewById(R.id.display);
        toNum1 = Double.parseDouble(number1);
        double radNum = Math.toRadians(toNum1);
        display.setText(radNum+"");
        number1 = radNum + "";

    }
    /*等号操作，用一个临时变量temporary记录Number2的值并清空number2的值便于等号出现结果后的进一步操作
    * switch-case语句接收运算符并执行相应运算*/
    public void equal (View view)
    {
        EditText display = (EditText)findViewById(R.id.display);
        if(sign == "")
        {
            return;
        }
        double temporary = Double.parseDouble(number2);
        number2 = "";
        switch (sign)
        {
            case("+"):
            {
                toNum1+=temporary;
                display.setText(toNum1+"");
                break;
            }
            case("-"):{
                toNum1-=temporary;
                display.setText(toNum1+"");
                break;
            }
            case("*"):{
                toNum1*=temporary;
                display.setText(toNum1+"");
                break;
            }
            case("/"):{
                if(temporary!=0)
                {
                    toNum1/=temporary;
                    display.setText(toNum1+"");
                }
                else
                {
                    display.setText("ERROR");
                    number1 = "";
                    number2 = "";
                    change = false;
                    num1HasTrans = false;
                   return;
                }
                break;
            }
            case("%"):{
                toNum1=(int)toNum1%(int)temporary;
                display.setText(toNum1+"");
                break;
            }
        }
    }
}
