package com.example.awadeshkumar.reviewapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.awadeshkumar.reviewapp.helpers.HttpRequest;
import com.example.awadeshkumar.reviewapp.models.SignUp;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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

    private class LongOperation extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            SignUp signUp = new SignUp();
            signUp.setConfirmPassword("awadesh");
            signUp.setEmailId("awadesh22kumar@gmail.com");
            signUp.setFirstName("Awadesh");
            signUp.setLastName("Yadav");
            signUp.setMobileNo("1234567891");
            signUp.setPassword("awadesh");
            Gson gson = new Gson();
            String postdata = gson.toJson(signUp);
            String response = HttpRequest.POST("http://myyfirstelasticbeans-env.ap-south-1.elasticbeanstalk.com/users", postdata);


            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {


//            TextView txt = (TextView) findViewById(R.id.output);
//            txt.setText("Executed"); // txt.setText(result);
            // might want to change "executed" for the returned string passed
            // into onPostExecute() but that is upto you
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }
    }

}
