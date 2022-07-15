package com.professorquincozes.restapiclient.interactor;

import com.professorquincozes.restapiclient.entity.Usuario;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RetrofitClient {

        private static RetrofitClient instance = null;
        private UsuarioInteractor.Api myApi;

        private RetrofitClient() {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(UsuarioInteractor.Api.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            myApi = retrofit.create(UsuarioInteractor.Api.class);
        }


        public static synchronized RetrofitClient getInstance() {
            if (instance == null) {
                instance = new RetrofitClient();
            }
            return instance;
        }

        public UsuarioInteractor.Api getMyApi() {
            return myApi;
        }
    }