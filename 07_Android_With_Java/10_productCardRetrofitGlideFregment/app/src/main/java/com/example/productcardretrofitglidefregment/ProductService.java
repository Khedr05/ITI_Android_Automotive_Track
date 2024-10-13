package com.example.productcardretrofitglidefregment;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductService {
    @GET("products")
    Call<ProductResponse> getProductsCard();
}
