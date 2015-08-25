package com.android.nilima.stackviewer;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    EditText pushET;
    Button popBtn,pushBtn;
    TextView popView,resultView;

    StackUtils stack=new StackUtils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pushET=(EditText)findViewById(R.id.pushed_ET);
        popView=(TextView)findViewById(R.id.poped_View);
        resultView=(TextView)findViewById(R.id.result_view);

        pushBtn=(Button)findViewById(R.id.push_btn);
        popBtn=(Button)findViewById(R.id.pop_btn);


        pushBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputString=pushET.getText().toString();
                if(inputString.equals("")){
                    pushET.setError("Can't be empty");
                    return;
                }

                int number=Integer.parseInt(inputString);
                stack.pushNumber(number);
                Toast.makeText(MainActivity.this,"Pushed Integer "+number,Toast.LENGTH_SHORT).show();
                resultView.setText(stack.data.toString());

            }
        });

        popBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stack.isEmpty()){
                    resultView.setError("Stack is empty");
                    resultView.requestFocus();
                    Toast.makeText(MainActivity.this,"Stack is empty",Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    int popedNumber=stack.popNumber();
                    resultView.setText(stack.data.toString());
                    popView.setText("Poped Number is "+popedNumber);
                    Toast.makeText(MainActivity.this,"Poped Integer "+popedNumber,Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });


    }

        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
