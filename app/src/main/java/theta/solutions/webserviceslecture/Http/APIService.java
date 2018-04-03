package theta.solutions.webserviceslecture.Http;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import theta.solutions.webserviceslecture.Model.CountryList;

/**
 * Created by SALAHUDIN` on 3/28/2018.
 */

public interface APIService{
    @GET("/rest/v2/all")
    Call<List<CountryList>> GetCountries();

    @GET("/rest/v2/name/{name}")
    Call<List<CountryList>> GetCountryByName(@Path("name") String Name);
}
