package pmdm.androidfirebase.interfaces;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by jmpuentenueva on 13/01/2017.
 */

public interface HostingerApiInterface {
    @FormUrlEncoded
    @POST("RegisterDevice.php")
    Call<ResponseRegister> registerDevice(
            @Field("email") String email,
            @Field("token") String token
    );
}
