package com.example.prateek.bottom_navigation.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.ArrayMap;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.kartikbhardwaj.bottom_navigation.R;

import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class QuizRulesActivity extends AppCompatActivity {

    Button startQuizButton;
    Calendar startTime = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_rules);


        startQuizButton=findViewById(R.id.startQuizButton);
        SharedPreferences sharedPreferences = getSharedPreferences("AUTHENTICATION", 0);
        String token = sharedPreferences.getString("token", "Not found!");
        final Map<String, String> mHeaders = new ArrayMap<String, String>();
        mHeaders.put("token", token);
        try {
            RequestQueue requestQueue;
            requestQueue = Volley.newRequestQueue(this);
            String URL = "http://api.cyllide.com/api/client/quiz/get/latest";

            final StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    Log.e("RealityCheck",response);
                    Log.e("RealityCheck","Inside onResponse");

//My method
//                    byte[] msg = hex2byte(response.getBytes());
//                    String secretKeyString="##gdvhcbxkwjlei23**ukefdvhbxjscm";
//                    byte[] result = new byte[0];
//                    try {
//                        result = decrypt(secretKeyString, msg);
//                        Log.e("RealityCheck",result.toString());
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
                    //======================================================
//                    byte[] encryptionKey = "##gdvhcbxkwjlei23**ukefdvhbxjscm".getBytes(StandardCharsets.UTF_8);
//                    Log.e("RealityCheck", String.valueOf(encryptionKey.length));
//                    AdvancedEncryptionStandard advancedEncryptionStandard = new AdvancedEncryptionStandard(encryptionKey);
//                    try {
//                        byte[] decryptedText = advancedEncryptionStandard.decrypt(response.getBytes(StandardCharsets.UTF_8));
//                        Log.e("RealityCheck",new String(decryptedText));
//                    } catch (Exception e) {
//                        Log.e("RealityCheck","exception", e);
//
//                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("VOLLEY", error.toString());
                }
            })
            {
                @Override
                public Map<String, String> getHeaders() {
                    return mHeaders;
                }
            };

            requestQueue.add(stringRequest);
            Log.e("RealityCheck","Request sent");
        } catch (Exception e) {
            e.printStackTrace();
        }
        new CountDownTimer(startTime.getTimeInMillis()- Calendar.getInstance().getTimeInMillis(),1000){
            @Override
            public void onTick(long millisUntilFinished) {
                //converting millis to sec,min,hour
                String hour=String.valueOf(millisUntilFinished/(1000*3600));
                String minute=String.valueOf((millisUntilFinished/(1000*60))%60);
                String second=String.valueOf(((millisUntilFinished/1000)%60)%60);
                SimpleDateFormat df =new SimpleDateFormat("MM:SS");
                // formatted the time to string
                if(Integer.parseInt(hour)>24){
                    df = new SimpleDateFormat("DD:HH");
                }
                else if(Integer.parseInt(hour)<24 && Integer.parseInt(hour)>=1){
                    df = new SimpleDateFormat("HH:MM");
                }

                String time=df.format(millisUntilFinished);
                //timer.setText(hour+" :"+minute+" : "+second);
                startQuizButton.setText(time);
            }

            @Override
            public void onFinish() {
                startQuizButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {





                    }

//
// }
                });



            }
        }.start();
    }


    public static byte[] hex2byte(byte[] b) {
        if ((b.length % 2) != 0)
            throw new IllegalArgumentException("hello");
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length; n += 2) {
            String item = new String(b, n, 2);
            b2[n / 2] = (byte) Integer.parseInt(item, 16);
        }
        return b2;

    }
    public static byte[] decrypt(String secretKeyString, byte[] encryptedMsg)

            throws Exception {
        Key key = generateKey(secretKeyString);
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decValue = c.doFinal(encryptedMsg);
        return decValue;

    }

    private static Key generateKey(String secretKeyString) throws Exception {

        Key key = new SecretKeySpec(secretKeyString.getBytes(), "AES");

        return key;

    }

}


