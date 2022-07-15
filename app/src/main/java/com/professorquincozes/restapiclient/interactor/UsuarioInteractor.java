package com.professorquincozes.restapiclient.interactor;

import com.professorquincozes.restapiclient.Contratos;
import com.professorquincozes.restapiclient.entity.Usuario;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class UsuarioInteractor implements Contratos.Interactor {

    private final Contratos.Presenter presenter;

    public UsuarioInteractor(Contratos.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void downloadDados(int id) {
        Call<Usuario> call = RetrofitClient.getInstance().getMyApi().getUsuario(id);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Usuario usuario = response.body();
                presenter.disponibilizarDados(usuario);
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                t.printStackTrace();
                presenter.reportarErro("Erro." + t.getLocalizedMessage());
            }

        });
    }

    public interface Api {
        String BASE_URL = "http://10.79.197.68:8080/api/";
        @GET("usuario?")
        Call<Usuario> getUsuario(@Query("id") int id);
    }


}
