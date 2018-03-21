package com.example.app.atworkcsm.Utils;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Mu'adz on 3/21/2018.
 */

public interface AuthService {
    @POST("/login/{u}/{p}")
    Call<ResponseBody> loginData(@Path("u") String uname, @Path("p") String pass);

    @POST("/absen/{u}")
    Call<ResponseBody> userData(@Path("u") String uname);

}
