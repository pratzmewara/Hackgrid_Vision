package com.example.prateek.bottom_navigation.stories;

/*import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.kartikbhardwaj.bottom_navigation.R;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class NewsData extends AppCompatActivity {

    String url = "https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=f6bddf738e64468280f0a7173b265b41";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newsdata); //ForTesting ShouldBeRemovedAfterwards

        textView=findViewById(R.id.jsonarraylist);  //ForTesting ShouldBeRemovedAfterwards

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>()

                {
                    @Override
                    public void onResponse(JSONObject response)
                    {
                        //try
                        //{
                          // if (!(response.getJSONObject("status").equals("ok"))) { }
                          // else
                               // {
                                    try
                                    {
                                        String headers[]={"title","description","url","urlToImage","publishedAt"};

                                        List<List<String>> array = new ArrayList<List<String>>();

                                        for(int i=0;i<response.getJSONArray("articles").length();i++)
                                        {
                                            array.add(new ArrayList<String>());
                                            for (int j=0;j<headers.length;j++)
                                            {
                                                array.get(i).add((response.getJSONArray("articles").getJSONObject(i).getJSONObject(headers[j])).toString());
                                                textView.setText(array.get(i).get(j)); //ForTesting ShouldBeRemovedAfterwards
                                                //Toast.makeText(NewsData.this, "ResponseSuccesful", Toast.LENGTH_LONG).show();

                                            }
                                        }
                                        Toast.makeText(NewsData.this, "ResponseSuccesful", Toast.LENGTH_LONG).show();
                                     }
                                     catch (JSONException e)
                                     {
                                        e.printStackTrace();
                                        Toast.makeText(NewsData.this, "ResponseUnsuccesful", Toast.LENGTH_LONG).show();
                                     }
                                //}
                        //}
                        /*catch (JSONException e)
                        {
                            e.printStackTrace();
                            Toast.makeText(NewsData.this, "ResponseUnsuccesful", Toast.LENGTH_LONG).show();
                        }//idharthaasterikaurslash
                    }
                },
                        new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                    }
                });

// Access the RequestQueue through your singleton class.
        NewsDataSingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }
}*/


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;
import com.example.kartikbhardwaj.bottom_navigation.R;

public class NewsData extends AppCompatActivity {
    private TextView mTextViewResult;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newsdata);

        mTextViewResult = findViewById(R.id.text_view_result);
        Button buttonParse = findViewById(R.id.button_parse);

        mQueue = Volley.newRequestQueue(this);

        buttonParse.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                jsonParse();
            }
        });
    }

    private void jsonParse() {

        String url = "https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=f6bddf738e64468280f0a7173b265b41";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("articles");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject articles = jsonArray.getJSONObject(i);

                                String title = articles.getString("title");

                                mTextViewResult.append(title);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }
}
