package ph.edu.dlsu.primenumbergame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private int number = 0;
    private int score = 0;


    public void onClickPrime(View view){

        if(isPrime(number)){
            Toast.makeText(this, "Congratulations! You are correct!", Toast.LENGTH_SHORT).show();
            score++;
        }
        else{
            Toast.makeText(this, "You are wrong!", Toast.LENGTH_SHORT).show();
            score -= 5;
            Toast.makeText(this, "Last number was " + number, Toast.LENGTH_SHORT).show();
        }

        start();
    }

    public void onClickComposite(View view){

        if(!isPrime(number)){
            Toast.makeText(this, "Congratulations! You are correct!", Toast.LENGTH_SHORT).show();
            score++;
        }
        else{
            Toast.makeText(this, "You are wrong!", Toast.LENGTH_SHORT).show();
            score -= 5;
            Toast.makeText(this, "Last number was " + number, Toast.LENGTH_SHORT).show();
        }

        start();

    }

    private boolean isPrime(int value){
        for (int divisor = 2; divisor < value; divisor++) {
            if (value % divisor == 0) {
                return false;
            }
        }
        return true;
    }


    private void displayRandomNumber(){
        Random random = new Random();
        number = 2 + random.nextInt(999);
        TextView tnum = (TextView) findViewById(R.id.number);
        tnum.setText("" + number);
    }

    private void displayScore(){
        TextView nscore = (TextView) findViewById(R.id.score);
        nscore.setText("Score: " + score);
    }
    private void start(){
        displayScore();
        displayRandomNumber();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
