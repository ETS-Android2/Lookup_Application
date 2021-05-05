package network;

//로그인, 회원가입 관련
import java.util.List;

import Category.activity.CategoryActivity;
import Category.data.CategoryData;
import Category.data.CategoryResponse;
import Closet.data.ImageData;
import Closet.data.ImageResponse;
import Cutout.data.InfoData;
import Cutout.data.InfoResponse;
import Login_Main.data.DupCheckData;
import Login_Main.data.DupCheckResponse;
import Login_Main.data.JoinResponse;
import Login_Main.data.JoinData;
import Login_Main.data.LoginData;
import Login_Main.data.LoginResponse;

import Color.data.ColorData;
import Color.data.ColorResponse;
import Color.data.ToneData;
import Color.data.ToneResponse;


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

    //회원가입 때 ID중복체크 routes->login.js
    @POST("/user/dup")
    Call<DupCheckResponse> userCheckDup(@Body DupCheckData data);

    //이거 사용 안함!!!!!-사진 업로드 하기 위한 정보(ID, 파일 이름) 업로드 routes->upload.js
    @POST("/upload/info")
    Call<InfoResponse> postImageInfo(@Body InfoData data);

    //사진 업로드(어떤 옷인지 파악하여 옷장에 저장) routes->upload.js
    @Multipart
    @POST("/upload/pic")
    Call<ResponseBody> postImage(@Part MultipartBody.Part image, @Part("upload") RequestBody name);

    @POST("/category/model")
    Call<CategoryResponse> findCategory(@Body CategoryData data);
 
    //Closet에서 사진 url들 갖고올 때 사용
    @POST("/closet/image")
    Call<ImageResponse> getClosetImages(@Body ImageData data);
    //Call<List<ImageResponse>> getClosetImages(@Body ImageData data);

    @POST("/color/color")
    Call<ColorResponse> userCheckColor(@Body ColorData data);
   /* @POST("/color1/color1")
    Call<ColorResponse> userCheckColor1(@Body ColorData data);

    @POST("/color1/color2")
    Call<ColorResponse> userCheckColor2(@Body ColorData data);
*/

    @POST("/color1/color1")
    Call<ColorResponse> userCheckColor123(@Body ColorData data);

    @POST("/tone1/tone1")
    Call<ToneResponse> userCheckTone123(@Body ToneData data);

    @POST("/tone2/tone2")
    Call<ToneResponse> userCheckTone2(@Body ToneData data);

    @POST("/tone3/tone3")
    Call<ToneResponse> userCheckTone3(@Body ToneData data);
}