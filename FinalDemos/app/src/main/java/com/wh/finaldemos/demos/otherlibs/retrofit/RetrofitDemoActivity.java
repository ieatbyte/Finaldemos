package com.wh.finaldemos.demos.otherlibs.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wh.finaldemos.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class RetrofitDemoActivity extends AppCompatActivity {

    public interface GitHubService {
        @GET("users/{user}/repos")
        Call<List<Repo>> listRepos(@Path("user") String user);
    }

    public static class Repo {
        public long id;
        public String name;
        public String full_name;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_demo);

        testRetrofitOnly();
    }

    private void testRetrofitOnly() {
        Log.e("testRetrofitOnly", "testRetrofitOnly");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);

        Call<List<Repo>> repos = service.listRepos("ieatbyte");
        repos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                Log.e("testRetrofitOnly", "onResponse");
                List<Repo> result = response.body();
                if (result != null) {
                    for (Repo e : result) {
                        Log.e("testRetrofitOnly", e.full_name);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Log.e("testRetrofitOnly", "onFailure");
            }
        });
    }
}
