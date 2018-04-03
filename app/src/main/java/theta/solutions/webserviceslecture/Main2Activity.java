package theta.solutions.webserviceslecture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import theta.solutions.webserviceslecture.Helpers.Constants;
import theta.solutions.webserviceslecture.Http.ApiUtils;
import theta.solutions.webserviceslecture.Model.Student;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
EditText mName,mEmail,mPassword;
Button mbtnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mName=(EditText)findViewById(R.id.etname);
        mEmail=(EditText)findViewById(R.id.etemail);
        mPassword=(EditText)findViewById(R.id.etpassword);
        mbtnSignUp=(Button) findViewById(R.id.btSignUp);
        mbtnSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
savedata();
GetAllStudents();
GetStudentById();
    }

    private void GetStudentById() {
        Call<Student> oStudent= ApiUtils.getAPIService(Constants.SERVERBASEURL).GetStudentByID(1);
        oStudent.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                Student ostd=response.body();
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {

            }
        });
    }

    private void GetAllStudents() {
        Call<List<Student>> oListStudent= ApiUtils.getAPIService(Constants.SERVERBASEURL).GetAllStudents();
        oListStudent.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                List<Student> oLISTStd=response.body();
                Toast.makeText(Main2Activity.this, "Get All Students", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {

            }
        });

    }

    private void savedata() {
        Call<String> ResponseMessage= ApiUtils.getAPIService(Constants.SERVERBASEURL).saveStudent(mName.getText().toString(),mPassword.getText().toString(),mEmail.getText().toString());

        ResponseMessage.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String Message=response.body();
                Toast.makeText(Main2Activity.this, Message+"", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(Main2Activity.this, t.getLocalizedMessage()+"", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
