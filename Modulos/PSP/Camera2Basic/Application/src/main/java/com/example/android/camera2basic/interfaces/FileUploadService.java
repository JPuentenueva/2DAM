package com.example.android.camera2basic.interfaces;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by jmpgallego on 13/01/2017.
 */

public interface FileUploadService {

    String ENDPOINT = "http://www.salesianos-triana.com/dam/xml/upload/";

    @Multipart
    @POST("upload.php")
    Call<ResponseBody> upload(@Part MultipartBody.Part file);

}
