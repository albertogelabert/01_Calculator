package com.androiddevsteam.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private static final char OP_ADD = '+';
    private static final char OP_SUB = '-';
    private static final char OP_MULT = 'x';
    private static final char OP_DIV = '/';

    // Data variables
    private String mFirstNumber;
    private char mOperation;
    private String mCurrentNumber;


    // Android Views
    private TextView mTextViewInput; // user input (to build the operation)
    private TextView mTextViewAns; // answer of the operation

    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;
    private Button mButton8;
    private Button mButton9;

    private Button mButtonAdd;
    private Button mButtonEq;
    // TODO: buttons Sub, Mult, Div
    // TODO: buttons 0 1 2 3


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTextViewAns = (TextView) findViewById(R.id.tv_ans);
        mTextViewInput = (TextView) findViewById(R.id.tv_input);

        // Let Android which Java Button is which Button defined in the XML
        mButton4 = (Button) findViewById(R.id.b4);
        mButton5 = (Button) findViewById(R.id.b5);
        mButton6 = (Button) findViewById(R.id.b6);
        mButton7 = (Button) findViewById(R.id.b7);
        mButton8 = (Button) findViewById(R.id.b8);
        mButton9 = (Button) findViewById(R.id.b9);
        // TODO: buttons 0 1 2 3

        mButtonAdd = (Button) findViewById(R.id.badd);
        mButtonEq = (Button) findViewById(R.id.beq);
        // TODO: buttons Sub, Mult, Div


        // What to do when we click on a button?
        // We MUST set the onclicklistener for each button,
        // so Android knows what funcion to call when a button is clicked
        mButton4.setOnClickListener(mNumberOnClickListener);
        mButton5.setOnClickListener(mNumberOnClickListener);
        mButton6.setOnClickListener(mNumberOnClickListener);
        mButton7.setOnClickListener(mNumberOnClickListener);
        mButton8.setOnClickListener(mNumberOnClickListener);
        mButton9.setOnClickListener(mNumberOnClickListener);

        // Same for operatiosn, but we use a different listener
        mButtonAdd.setOnClickListener(mOperationOnClickListener);
        // TODO buttons sub, mult, div

        mButtonEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });
    }

    private final View.OnClickListener mNumberOnClickListener = new View.OnClickListener() {

        // This method gets called whenever a view with this onclicklistener is clicked
        @Override
        public void onClick(View v) {
            // id is the R.id.bX of the view, as defined in the XML
            int id = v.getId();
            int num = buttonIdToInt(id);

            if (mCurrentNumber == null) mCurrentNumber = "";
            mCurrentNumber += String.valueOf(num);
            updateUI();
        }
    };

    /**
     * Converts a resId (R.id.xx) to an int
     *
     * @param id The id of the digit button
     * @return The value of the button
     */
    private int buttonIdToInt(int id) {
        switch (id) {
            // TODO: Add 0 1 2 3
            case R.id.b4:
                return 4;
            case R.id.b5:
                return 5;
            case R.id.b6:
                return 6;
            case R.id.b7:
                return 7;
            case R.id.b8:
                return 8;
            case R.id.b9:
                return 9;
            default:
                throw new RuntimeException("Invalid button id");
        }
    }

    private final View.OnClickListener mOperationOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (mFirstNumber != null && mCurrentNumber != null) {
                // we've already started the second number
                return;
            }

            mOperation = buttonIdToOperation(id);
            mFirstNumber = mCurrentNumber;
            mCurrentNumber = ""; // make it empty again, we're using it for the second number
            updateUI();
        }
    };

    /**
     * @see #buttonIdToInt(int)
     */
    private char buttonIdToOperation(int id) {
        switch (id) {
            case R.id.badd:
                return OP_ADD;
            // TODO you know what's missing by now

            default:
                throw new RuntimeException("Invalid operation");
        }
    }

    private void updateUI() {
        String input = null;
        if (mFirstNumber == null) {
            input = mCurrentNumber + " " + mOperation;
        } else {
            input = mFirstNumber + " " + mOperation + " " + mCurrentNumber;
        }
        mTextViewInput.setText(input);
    }

    private void calculateResult() {
        if (mFirstNumber == null || mCurrentNumber == null || mOperation == 0) {
            // We don't throw an exception here because we don't want to crash the app
            // We just ignore the equals if the user hasn't entered enough info yet
            return;
        }
        double x = Double.parseDouble(mFirstNumber);
        double y = Double.parseDouble(mCurrentNumber);

        double result = Double.NaN;
        switch (mOperation) {
            case OP_ADD:
                result = x + y;
                break;
            // TODO add sub, mult
            case OP_DIV:
                if (y == 0) {
                    result = Double.POSITIVE_INFINITY;
                } else {
                    result = x / y;
                }
            default:
                throw new RuntimeException("No operation");
        }

        mTextViewAns.setText(String.valueOf(result));
        prepareForNextCalculation();
    }

    /**
     * Prepare the variables for the next calculation
     */
    private void prepareForNextCalculation() {
        mCurrentNumber = null;
        mFirstNumber = null;
        mOperation = 0;
    }
}
