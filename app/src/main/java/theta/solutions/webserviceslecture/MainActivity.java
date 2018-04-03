package theta.solutions.webserviceslecture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import theta.solutions.webserviceslecture.Helpers.Constants;
import theta.solutions.webserviceslecture.Http.ApiUtils;
import theta.solutions.webserviceslecture.Model.CountryList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //GetCountryList();
        //GetCountryByName("Pakistan");
        SaveStudentdata("Ali","1","IT");
    }

    private void SaveStudentdata(String Name,String RollNo,String StudentClass) {
        Call<String> oStudent= ApiUtils.getAPIService(Constants.SERVERBASEURL).saveStudent(Name,RollNo,StudentClass);
        oStudent.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String Message=response.body();
                Toast.makeText(MainActivity.this, Message+"", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage()+"", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void GetCountryByName(String Name) {

        Call<List<CountryList>> oListCountry= ApiUtils.getAPIService(Constants.BASEURL).GetCountryByName(Name);
        oListCountry.enqueue(new Callback<List<CountryList>>() {
            @Override
            public void onResponse(Call<List<CountryList>> call, Response<List<CountryList>> response) {
                List<CountryList> obj=response.body();
                Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<CountryList>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage()+"", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void GetCountryList() {

            Call<List<CountryList>> oListCountry= ApiUtils.getAPIService(Constants.BASEURL).GetCountries();

        oListCountry.enqueue(new Callback<List<CountryList>>() {
            @Override
            public void onResponse(Call<List<CountryList>> call, Response<List<CountryList>> response) {
                List<CountryList> obj=response.body();
                Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<CountryList>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage()+"", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
