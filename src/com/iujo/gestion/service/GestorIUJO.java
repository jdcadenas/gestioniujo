package com.iujo.gestion.service;

import java.util.ArrayList;

public class GestorIUJO<T>{
    private ArrayList<T> lista = new ArrayList<>();

    public void agregar(T item){
        lista.add(item);
    }

    public ArrayList<T> obtenerTodos(){
        return lista;
    }
    public int contar(){
        return lista.size();
    }


}
