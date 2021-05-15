package LookBook.network;

import LookBook.currentData.CurrentWeatherData;
import LookBook.data.WeatherData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ServiceApi {

    @GET("getVilageFcst?ServiceKey=9wUoUxoImWRYe4RFFo3lpwP4SAn22KwTngckq%2BmPvb54aDIbTVXS8GmpB8kroAXK7svNMQi3%2Bjjw2TXVWQSBiA%3D%3D")
    Call<WeatherData> getWeather(
            @Query("pageNo") String pageNum,
            @Query("numOfRows") String numOfRows,
            @Query("dataType") String type,
            @Query("base_date") String baseDate,
            @Query("base_time") String baseTime,
            @Query("nx") String s_nx,
            @Query("ny") String s_ny
    );

    @GET("getUltraSrtNcst?serviceKey=9wUoUxoImWRYe4RFFo3lpwP4SAn22KwTngckq%2BmPvb54aDIbTVXS8GmpB8kroAXK7svNMQi3%2Bjjw2TXVWQSBiA%3D%3D")
    Call<CurrentWeatherData> getCurrentWeather(
            @Query("pageNo") String pageNum,
            @Query("numOfRows") String numOfRows,
            @Query("dataType") String type,
            @Query("base_date") String baseDate,
            @Query("base_time") String baseTime,
            @Query("nx") String s_nx,
            @Query("ny") String s_ny
    );

}
