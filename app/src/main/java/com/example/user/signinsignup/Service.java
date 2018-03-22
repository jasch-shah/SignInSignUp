package com.example.user.signinsignup;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by user on 15-02-2018.
 */

public interface Service {
    @FormUrlEncoded
    @POST("Retrofit/registerUser.php")
    Call<RegisterPojo> registerUser(@Field("name")String name, @Field("email")String email,
                                    @Field("password")String password, @Field("mobile")String mobile);

    @FormUrlEncoded
    @POST("Retrofit/loginUser.php")
    Call<LoginPojo> loginUser(@Field("email") String email,
                              @Field("password") String password);

    @FormUrlEncoded
    @POST("Retrofit/updateUser.php")
    Call<UpdatePojo> updateUser(@Field("name") String name,@Field("mobile") String mobile,@Field("email") String email,
                              @Field("password") String password);

    @FormUrlEncoded
    @POST("Retrofit/deleteUser.php")
    Call<DeletePojo> deleteUser(@Field("name") String name);


}
