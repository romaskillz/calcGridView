package com.example.romas.calculatorgrid;

import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    float aVariable = 0;
    float bVariable = 0;
    float result = 0;
    String action = "";

    private TextView textViewResult;

    private GridAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initGridViewAdapter();
        initViews();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        textViewResult.setText("");
    }

    void initGridViewAdapter() {
        final GridView g = (GridView) findViewById(R.id.gridViewNumbers);
        mAdapter = new GridAdapter(getApplicationContext(), android.R.layout.simple_list_item_single_choice);
        g.setAdapter(mAdapter);
        g.setOnItemSelectedListener(this);
        g.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                textViewResult.append(mAdapter.getItem(position));
            }
        });

    }

    void initViews() {

        textViewResult = (TextView) findViewById(R.id.tvResult);


        findViewById(R.id.buttonAdd).setOnClickListener(clickListener);
        findViewById(R.id.buttonMin).setOnClickListener(clickListener);
        findViewById(R.id.buttonMul).setOnClickListener(clickListener);
        findViewById(R.id.buttonDiv).setOnClickListener(clickListener);

        findViewById(R.id.buttonRes).setOnClickListener(clickListener);
        findViewById(R.id.buttonClear).setOnClickListener(clickListener);


    }

    View.OnClickListener clickListener = new View.OnClickListener() {


        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonAdd:
                    aVariable = Float.valueOf(textViewResult.getText().toString());
                    action = "+";
                    textViewResult.setText("");
                    break;


                case R.id.buttonMin:
                    aVariable = Float.valueOf(textViewResult.getText().toString());
                    action = "-";
                    textViewResult.setText("");
                    break;

                case R.id.buttonMul:
                    aVariable = Float.valueOf(textViewResult.getText().toString());
                    action = "*";
                    textViewResult.setText("");
                    break;

                case R.id.buttonDiv:
                    aVariable = Float.valueOf(textViewResult.getText().toString());
                    action = "/";
                    textViewResult.setText("");
                    break;

                case R.id.buttonRes:
                    bVariable = Float.valueOf(textViewResult.getText().toString());
                    textViewResult.setText(String.valueOf(Calculate(bVariable, action)));
                    break;

                case R.id.buttonClear:
                    aVariable = 0;
                    bVariable = 0;
                    result = 0;
                    action = "";
                    textViewResult.setText("");
                    break;
            }
        }
    };

    public float Calculate(float bVariable, String action) {
        if (action == "+") {
            result = aVariable + bVariable;
        } else if (action == "-") {
            result = aVariable - bVariable;
        } else if (action == "*") {
            result = aVariable * bVariable;
        } else if (action == "/") {
            result = aVariable / bVariable;
        }
        return result;
    }
}