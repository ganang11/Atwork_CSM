package com.example.app.atworkcsm.Utils;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Mu'adz on 3/21/2018.
 */

public interface AuthService {
    @POST("/signin/{uid}")
    Call<ResponseBody> testloginPost(@Path("uid") String postfix);

}
