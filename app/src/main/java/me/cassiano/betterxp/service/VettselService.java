package me.cassiano.betterxp.service;


import me.cassiano.betterxp.model.PokemonOptimizationProblem;
import me.cassiano.betterxp.model.VettselSolutionResponse;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface VettselService {

    @POST("xp")
    Observable<VettselSolutionResponse> runSimplex(@Body PokemonOptimizationProblem problem);

}
