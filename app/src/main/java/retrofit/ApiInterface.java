package retrofit;


import java.util.List;

import model.CountryModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Devanshi on 28-02-2018.
 */

public interface ApiInterface
{
    @GET("/rest/v2/all")
    Call<List<CountryModel>> getpost();


}
