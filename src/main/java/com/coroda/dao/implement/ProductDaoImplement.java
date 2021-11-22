package com.coroda.dao.implement;

import com.coroda.dao.ProductDao;
import com.coroda.dto.request.ProductRequest;
import com.coroda.dto.response.ProductResponse;
import com.coroda.entity.OriginProduct;
import com.coroda.entity.Product;
import com.coroda.repository.ProductRepository;
import io.reactivex.*;
import io.reactivex.schedulers.Schedulers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.ws.rs.BadRequestException;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Repository
@Slf4j
@Data
public class ProductDaoImplement implements ProductDao {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Completable save(ProductRequest model) {
        log.info("Guardando datos del producto");
        return Single.fromCallable(() -> setProduct(model))
                .map(productRepository::save)
                .toCompletable();
    }

    private Product setProduct(ProductRequest model) {
        log.info("seteo de datos del producto del metodo save");
        Product p = new Product();
        p.setId(model.getId());
        p.setCategory(model.getCategory());
        p.setSubCategory(model.getSubCategory());
        p.setModel(model.getModel());
        p.setBrand(model.getBrand());
        p.setDescription(model.getDescription());
        p.setOrigin(model.getOrigin());
        p.setMaterial(model.getMaterial());
        p.setDimensions(model.getDimensions());
        p.setColor(model.getColor());
        p.setPriceUnit(model.getPriceUnit());
        p.setImage(model.getImage());
        return p;
    }
    @Override
    public Completable delete(Long id) {
        return maybeProduct(id)
                .flatMapCompletable(Product ->
                {
                    productRepository.deleteById(id);
                    return CompletableObserver::onComplete;
                });
    }

    private Maybe<Product> maybeProduct(Long id) {
        log.info("buscando por id y obteniendo los campos");
        return Maybe.just(
                productRepository.findById(id)
                        .<BadRequestException>orElseThrow(BadRequestException::new))
                .switchIfEmpty(Maybe.empty());
    }

    @Override
    public Completable update(ProductRequest model) {
        log.info("actualizando y guardando los campos");
        return maybeProduct(model.getId())
                .flatMapCompletable(product -> save(model));
    }

    @Override
    public Single<ProductResponse> getById(Long id) {
        return maybeProduct(id)
                .map(Product -> getProduct(Product))
                .toSingle();
    }

    private ProductResponse getProduct(Product model) {
        ProductResponse p = new ProductResponse();
        p.setId(model.getId());
        p.setCategory(model.getCategory());
        p.setSubCategory(model.getSubCategory());
        p.setModel(model.getModel());
        p.setBrand(model.getBrand());
        p.setDescription(model.getDescription());
        p.setOrigin(model.getOrigin());
        p.setMaterial(model.getMaterial());
        p.setDimensions(model.getDimensions());
        p.setColor(model.getColor());
        p.setPriceUnit(model.getPriceUnit());
        p.setImage(model.getImage());
        return p;
    }



    @Override
    public Observable<ProductResponse> findAll() {
        log.info("seteo de todos los datos registrados");
        return Observable.fromIterable(productRepository.findAll())
                .map(product -> getProduct(product))
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<ProductResponse> searchOrigin(OriginProduct originProduct) {
        log.info("Extrayendo reistros acorde al tipo de Operacion");
        return Observable.fromIterable(productRepository.searchOrigin(originProduct))
                .filter(obj -> obj.getOrigin().equals(originProduct))
                .map(product -> getProduct(product))
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<ProductResponse> searchModelProduct(String modelProduct) {
        log.info("Extrayendo reistros del Producto  acorde al modelo");
        return Observable.fromIterable(productRepository.searchModelProduct(modelProduct))
                .filter(obj -> obj.getModel().equals(modelProduct))
                .map(product -> getProduct(product))
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<ProductResponse> searchCategoryProduct(String categoryProduct) {
        log.info("Extrayendo reistros del Producto  acorde al modelo");
        return Observable.fromIterable(productRepository.searchCategory(categoryProduct))
                .filter(obj -> obj.getCategory().equals(categoryProduct))
                .map(product -> getProduct(product))
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<ProductResponse> getData(OriginProduct originProduct, String modelProduct) {
        log.info("Extrayendo reistros del origen del Producto acorde al modelo");
        return Observable.fromIterable(productRepository.getData(originProduct,modelProduct))
                .map(product -> getProduct(product))
                .subscribeOn(Schedulers.io());
    }
}
