package com.cibertec.movil_modelo_proyecto_2022_2.service;

import com.cibertec.movil_modelo_proyecto_2022_2.entity.Editorial;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ServiceEditorial {

    @POST("editorial")
    public abstract Call<Editorial> RegistrarEditorial(@Body Editorial objEditorial);
    @GET("editorial")
    public abstract Call<List<Editorial>> ListarEditorial();
}
