package com.example.productcardretrofitglide;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.Call;

public interface ProductService {
    @GET("products")
    Call<ProductResponse> getProductsCard();
}
