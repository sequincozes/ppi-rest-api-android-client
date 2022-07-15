package com.professorquincozes.restapiclient.presenter;

import com.professorquincozes.restapiclient.Contratos;
import com.professorquincozes.restapiclient.MainActivity;
import com.professorquincozes.restapiclient.entity.Usuario;
import com.professorquincozes.restapiclient.interactor.UsuarioInteractor;

public class UsuarioPresenter implements Contratos.Presenter {


    private final Contratos.View view;
    private final Contratos.Interactor interactor;

    public UsuarioPresenter(Contratos.View view) {
        this.view = view;
        this.interactor = new UsuarioInteractor(this);
    }

    @Override
    public void solicitarDados(int id) {
        interactor.downloadDados(id);
    }

    @Override
    public void disponibilizarDados(Usuario usuario) {
        view.mostrarDados(usuario);
    }

    @Override
    public void reportarErro(String message) {
        view.mostrarErro(message);
    }
}
