package com.lazday.tugaskeduaolshop.data.Retrofit;




import com.lazday.tugaskeduaolshop.data.Model.productTugas;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
//Route::get('/users','Api\UserController@users');
//Route::get('user/{id}','Api\UserController@user');
//Route::get('logout/{id}','Api\UserController@logout');
//
//Route::post('auth/login','Api\UserController@login');
//Route::post('auth/register','Api\UserController@register');
//Route::post('auth/update/{iduser}','Api\UserController@updateUser');
//
//Route::get('/products','Api\ProductsController@products');
//Route::get('/product/{id}','Api\ProductsController@product');
//
//Route::post('/transaction','Api\TransactionController@store');
//Route::get('/transaction-user/{userId}/{status?}','Api\TransactionController@user');
//Route::get('/transaction/{code}','Api\TransactionController@byCode');
//
//Route::post('/upload/{code}','Api\TransactionController@upload');


    @GET("catalog?android=kotlin")
    Call<productTugas> getResultsKotlin();

    @GET("catalog?android=java")
    Call<productTugas> getResultsJava();


    @GET("catalog")
    Call<productTugas> getResults();
}
