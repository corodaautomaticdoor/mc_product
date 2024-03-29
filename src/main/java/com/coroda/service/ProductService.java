package com.coroda.service;

import com.coroda.dto.request.ProductRequest;
import com.coroda.dto.response.ProductResponse;
import com.coroda.entity.OriginProduct;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.Map;

public interface ProductService {

    Completable save(ProductRequest model);
    Completable delete(Long id);
    Completable update(ProductRequest model);
    Single<ProductResponse> getById(Long id);
    Maybe<ProductResponse> getByModel(String model);
    Observable<ProductResponse> getByCategory(String category);

    Observable<ProductResponse> getData(Map<String, String> params);

}
