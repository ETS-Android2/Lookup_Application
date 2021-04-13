package network;

//로그인, 회원가입 관련
import Login_Main.data.DupCheckData;
import Login_Main.data.DupCheckResponse;
import Login_Main.data.JoinResponse;
import Login_Main.data.JoinData;
import Login_Main.data.LoginData;
import Login_Main.data.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Multipart;
import retrofit2.http.Part;

public interface ServiceApi {
    //로그인 routes->login.js
    @POST("/user/login")
    Call<LoginResponse> userLogin(@Body LoginData data);

    //회원가입 routes->login.js
    @POST("/user/join")
    Call<JoinResponse> userJoin(@Body JoinData data);

    //회원가입 때 ID중복체크
    @POST("/user/dup")
    Call<DupCheckResponse> userCheckDup(@Body DupCheckData data);

    //사진 업로드(어떤 옷인지 파악하여 옷장에 저장) routes->upload.js
    @Multipart
    @POST("/upload/pic")
    Call<ResponseBody> postImage(@Part MultipartBody.Part image, @Part("upload") RequestBody name);

}