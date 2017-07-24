package sourav.calculator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int opt;
    double num1;
    double num2;
    double mem;
    boolean isOptRunning = false;
    boolean isMemoryEmpty = true;
    TextView textView;
    TextView historyView;

    public void ButtonPressActions(View v){
        textView = (TextView) findViewById(R.id.display);
        historyView = (TextView) findViewById(R.id.history);
        Button membtn = (Button)findViewById(R.id.memory);
        String prevText;
        String displayText;

        switch (v.getId()){
            case R.id.one:
                prevText=textView.getText().toString();
                displayText=prevText+"1";
                textView.setText(displayText);
                break;
            case R.id.two:
                prevText=textView.getText().toString();
                displayText=prevText+"2";
                textView.setText(displayText);
                break;
            case R.id.three:
                prevText=textView.getText().toString();
                displayText=prevText+"3";
                textView.setText(displayText);
                break;
            case R.id.four:
                prevText=textView.getText().toString();
                displayText=prevText+"4";
                textView.setText(displayText);
                break;
            case R.id.five:
                prevText=textView.getText().toString();
                displayText=prevText+"5";
                textView.setText(displayText);
                break;
            case R.id.six:
                prevText=textView.getText().toString();
                displayText=prevText+"6";
                textView.setText(displayText);
                break;
            case R.id.seven:
                prevText=textView.getText().toString();
                displayText=prevText+"7";
                textView.setText(displayText);
                break;
            case R.id.eight:
                prevText=textView.getText().toString();
                displayText=prevText+"8";
                textView.setText(displayText);
                break;
            case R.id.nine:
                prevText=textView.getText().toString();
                displayText=prevText+"9";
                textView.setText(displayText);
                break;
            case R.id.zero:
                prevText=textView.getText().toString();
                displayText=prevText+"0";
                textView.setText(displayText);
                break;
            case R.id.dot:
                prevText=textView.getText().toString();
                displayText=prevText+".";
                textView.setText(displayText);
                break;
            case R.id.equals:
                try {
                    if (isOptRunning) {
                        num2 = Double.parseDouble(textView.getText().toString());
                        displayText = historyView.getText() + Double.toString(num2);
                        historyView.setText(displayText);
                        actions();
                        textView.setText(String.format(Locale.getDefault(), "%.2f", num1));
                        isOptRunning = false;
                    } else {
                        num2 = Double.parseDouble(textView.getText().toString());
                        displayText = historyView.getText() + Double.toString(num2);
                        historyView.setText(displayText);
                        actions();
                        textView.setText(String.format(Locale.getDefault(), "%.2f", num1));
                    }
                }catch (Exception e){
                    textView.setText(String.format(Locale.getDefault(), "%.2f", num1));
                }

                break;
            case R.id.delete:
                int length = textView.getText().length();
                int number = length-1;

                if (length>0){
                    StringBuilder dlt = new StringBuilder(textView.getText());
                    dlt.deleteCharAt(number);
                    displayText=dlt.toString();
                    textView.setText(displayText);
                }
                break;
            case R.id.clear:
                textView.setText("");
                historyView.setText("");
                isOptRunning=false;
                break;
            case R.id.add:
                if(isOptRunning){
                    num2=Double.parseDouble(textView.getText().toString());
                    actions();
                    displayText=historyView.getText()+Double.toString(num2)+"+";
                    historyView.setText(displayText);
                    textView.setText("");
                }else{
                    this.opt=1;
                    num1=Double.parseDouble(textView.getText().toString());
                    displayText= Double.toString(num1) + "+";
                    historyView.setText(displayText);
                    textView.setText("");
                    isOptRunning=true;
                }
                break;
            case R.id.subs:
                if(isOptRunning){
                    num2=Double.parseDouble(textView.getText().toString());
                    actions();
                    displayText=historyView.getText()+Double.toString(num2) + "-";
                    historyView.setText(displayText);
                    textView.setText("");
                }else{
                    this.opt=2;
                    num1=Double.parseDouble(textView.getText().toString());
                    displayText= Double.toString(num1) + "-";
                    historyView.setText(displayText);
                    textView.setText("");
                    isOptRunning=true;
                }
                break;
            case R.id.multiply:
                if(isOptRunning){
                    num2=Double.parseDouble(textView.getText().toString());
                    actions();
                    displayText=historyView.getText()+Double.toString(num2) + "×";
                    historyView.setText(displayText);
                    textView.setText("");
                }else{
                    this.opt=3;
                    num1=Double.parseDouble(textView.getText().toString());
                    displayText= Double.toString(num1) + "×";
                    historyView.setText(displayText);
                    textView.setText("");
                    isOptRunning=true;
                }
                break;
            case R.id.divide:
                if(isOptRunning){
                    num2=Double.parseDouble(textView.getText().toString());
                    actions();
                    displayText=historyView.getText()+Double.toString(num2) + "÷";
                    historyView.setText(displayText);
                    textView.setText("");
                }else{
                    this.opt=4;
                    num1=Double.parseDouble(textView.getText().toString());
                    displayText= Double.toString(num1) + "÷";
                    historyView.setText(displayText);
                    textView.setText("");
                    isOptRunning=true;
                }
                break;
            case R.id.memory:
                if(isMemoryEmpty){
                    mem = Double.parseDouble(textView.getText().toString());
                    membtn.setTextColor(Color.parseColor("#ff7043"));
                    isMemoryEmpty=false;
                }else{
                    displayText=Double.toString(mem);
                    textView.setText(displayText);
                    membtn.setTextColor(Color.parseColor("#ffffff"));
                    isMemoryEmpty=true;
                }
                break;
        }
    }

    public void actions(){
        switch (opt){
            case 1:
                num1+=num2;
                break;
            case 2:
                num1-=num2;
                break;
            case 3:
                num1*=num2;
                break;
            case 4:
                num1/=num2;
                break;

        }
    }
}
