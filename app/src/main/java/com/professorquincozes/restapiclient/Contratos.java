package com.professorquincozes.restapiclient;

import com.professorquincozes.restapiclient.entity.Usuario;

public interface Contratos {
    interface View {
        void mostrarDados(Usuario usuario);

        void mostrarErro(String localizedMessage);
    }

    interface Presenter {
        void solicitarDados(int id);

        void disponibilizarDados(Usuario usuario);

        void reportarErro(String message);
    }

    interface Interactor {

        void downloadDados(int usuario);
    }
}
