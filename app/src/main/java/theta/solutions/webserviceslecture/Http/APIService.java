package theta.solutions.webserviceslecture.Http;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import theta.solutions.webserviceslecture.Model.CountryList;
import theta.solutions.webserviceslecture.Model.Student;

/**
 * Created by SALAHUDIN` on 3/28/2018.
 */

public interface APIService{
    //Apis Urls
    @GET("/rest/v2/all")
    Call<List<CountryList>> GetCountries();

    @GET("/rest/v2/name/{name}")
    Call<List<CountryList>> GetCountryByName(@Path("name") String Name);


    //Server Urls
    @POST("/Api/SaveData")
    @FormUrlEncoded
    Call<String> saveStudent(@Field("name") String Name,@Field("password") String Password,@Field("email") String Email);

    @GET("/Api/GetAllStudent")
    Call<List<Student>> GetAllStudents();

    @GET("/Api/GetStudentById/{id}")
    Call<Student> GetStudentByID(@Path("id") int ID);
}
