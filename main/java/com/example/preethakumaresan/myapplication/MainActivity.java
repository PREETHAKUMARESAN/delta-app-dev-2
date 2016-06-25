package com.example.preethakumaresan.myapplication;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int SPEECH_REQUEST_CODE = 0;
    String command,defshape,defsize;

    MyView myview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myview = new MyView(MainActivity.this);
        setContentView(myview);
        defshape="circle";
        defsize="medium";

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setMessage("Click the menu button to talk!    " + "    Default shape is a circle which is of medium size.    " +
                "    PLEASE TELL THE FOLLOWING CAPITALIZED WORDS LOUDLY  -     " + "    1. UP for moving up     " +
                "" + "    2.DOWN for moving down    " + "" + "   3.RIGHT for moving right     " +
                "" + "   4.LEFT for moving left    " + "" + "    5.SQUARE for chainging into a square    " +
                "" + "  6.SMALL for a small size     " + "" + " 7.MEDIUM for a medium or defualt size    " +
                "" + "  8.LARGE for a large size     " + "" + " 9.CIRCLE for changing back to default size    ");
        alertDialogBuilder.setCancelable(false).setPositiveButton("READY", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu. This adds options to the actionbar if it is present
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id=item.getItemId();
        if(id==R.id.talk)
                displaySpeechRecognizer();
        return super.onOptionsItemSelected(item);
    }

    private void displaySpeechRecognizer() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        // Start the activity, the intent will be populated with the speech text

        try {
            startActivityForResult(intent, SPEECH_REQUEST_CODE);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(MainActivity.this, "I cudnt hear that! REPEAT that BOSS!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            String spokenText = results.get(0);
            command = spokenText;
        }

        movecircle();
        super.onActivityResult(requestCode, resultCode, data);
    }
    public void movecircle() {
        switch (command) {
            case "up":
                myview.changeposition(0, -25);
                break;
            case "down":
                myview.changeposition(0, 25);
                break;
            case "left":
                myview.changeposition(-25, 0);
                break;
            case "right":
                myview.changeposition(25, 0);
                break;
            case "small":
                defsize = "small";
                myview.changesize(defshape,defsize);
                break;
            case "medium":
                defsize = "medium";
                myview.changesize(defshape,defsize);
                break;
            case "large":
                defsize = "large";
                myview.changesize(defshape,defsize);
                break;
            case "square":
                defshape = "square";
                myview.changesize(defshape,defsize);
                break;
            case "circle":
                defshape = "circle";
                myview.changesize(defshape,defsize);
                break;
            default:
                Toast.makeText(MainActivity.this, "sorry", Toast.LENGTH_SHORT).show();
        }

    }
}
