package com.example.fast;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class PostResponse{
    @SerializedName("guid")
    private String guid;
    @SerializedName("answer")
    private HashMap<Integer, String> answer;


    public void setGuid(String guid){
        this.guid = guid;
    }
    public String getGuid(){
        return guid;
    }
    public void setAnswer(HashMap<Integer, String> answer){
        this.answer = answer;
    }
    public HashMap<Integer, String> getAnswer(){
        return answer;
    }

}
