package mobile.example.valeria.completecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void acao(View v){
        msg = (TextView) findViewById(R.id.text);
        String m = msg.getText().toString();
        String tag = v.getTag().toString();
        if(m.isEmpty()){
            if(!tag.equals("back")&&!tag.equals("clean"))
                msg.setText(tag);
        }
        else if(tag.equals("0")||tag.equals("1")||tag.equals("2")||tag.equals("3")||tag.equals("4")||tag.equals("5")
                ||tag.equals("6")||tag.equals("7")||tag.equals("8")||tag.equals("9")||tag.equals("+")
                ||tag.equals("-")||tag.equals("x")||tag.equals("/")||tag.equals(".")) {
            msg.setText(m + tag);
        }
        else if(tag.equals("back")){
            int len = m.length() - 1;
                msg.setText(m.substring(0, len));
        }
        else if(tag.equals("clean")){
            msg.setText("");
        }
        else{
            String[] vet = m.split("\\+|\\-|x|\\/");
            double n1, n2;
            double r;
            n1 = Double.parseDouble(vet[0]);
            n2 = Double.parseDouble(vet[1]);
            int len = vet[0].length();

            if(m.substring(len,len+1).equals("+")){
                r = n1 + n2;
            }
            else if(m.substring(len,len+1).equals("-")){
                r = n1 - n2;
            }
            else if(m.substring(len,len+1).equals("x")){
                r = n1 * n2;
            }
            else{
                r = n1 / n2;
            }
            msg.setText(Double.toString(r));
        }
    }
}