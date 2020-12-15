package com.example.fast;

        import com.google.gson.JsonObject;

        import retrofit2.Call;
        import retrofit2.http.Body;
        import retrofit2.http.POST;

public interface ApiService {
    @POST("posts")
Call<PostResponse> postData(
                @Body JsonObject body);
}