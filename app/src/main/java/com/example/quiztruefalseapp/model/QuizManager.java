package com.example.quiztruefalseapp.model;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.quiztruefalseapp.R;
import com.example.quiztruefalseapp.VolleySingleton;
import com.example.quiztruefalseapp.controller.CardStackAdapter;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class QuizManager {

    Context mContext;
    private RequestQueue mRequestQueue;
    private String url;

    public QuizManager(Context context) {
        mContext = context;
        mRequestQueue = VolleySingleton.getInstance().getRequestQueue();
        url = "https://opentdb.com/api.php?amount=10&category=23&type=boolean";
    }

    public void getQuizQuestions(Activity activity) {

        List<QuizQuestion> quizQuestions = new ArrayList<QuizQuestion>();

        JsonObjectRequest historyJsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.i("HISTORY",response + "");

                try {
                    JSONArray results = response.getJSONArray("results");

                    int len = response.length();

                    for (int i = 0; i < results.length(); i++) {
                        JSONObject questionJsonObj = results.getJSONObject(i);
                        String questionText = questionJsonObj.getString("question");
                        boolean questionAnswer = questionJsonObj.getBoolean("correct_answer");
                        QuizQuestion myQuestion = new QuizQuestion(questionText, questionAnswer);
                        quizQuestions.add(myQuestion);
                    }

                    CardStackView mCardStackView = activity.findViewById(R.id.myCardStackView);
                    mCardStackView.setLayoutManager(new CardStackLayoutManager(mContext));
                    mCardStackView.setAdapter(new CardStackAdapter(mContext, quizQuestions));
                } catch (JSONException e) {
                    Log.i("XXXXXXXX",response + "");
                    e.printStackTrace();
                    Log.i("xxxxxxxx",response + "");
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("RRRRR",error + "");

            }
        });
        mRequestQueue.add(historyJsonObjectRequest);
    }
}
