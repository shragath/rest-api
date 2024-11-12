package dev.demo.rest_api.Product;

import dev.demo.rest_api.Store.Store;
import dev.demo.rest_api.Store.StoreRepository;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
  private final ProductRepository productRepository;

  private final StoreRepository storeRepository;

  public ProductService(ProductRepository productRepository, StoreRepository storeRepository) {
    this.productRepository = productRepository;
    this.storeRepository = storeRepository;
  }

  public ResponseEntity<List<Product>> getProducts() {
    List<Product> products = productRepository.findAll();
    return ResponseEntity.ok(products);
  }

  @Transactional
  public ResponseEntity<List<Product>> addProduct(ProductDto newProduct) {
    try {
      Product product =
          new Product(
              null, newProduct.getName(), newProduct.getPrice(), newProduct.getQuantity(), null);
      if (storeRepository.existsById(newProduct.getStoreId())) {
        return ResponseEntity.badRequest().body(null);
      }
      Store store =
          storeRepository
              .findById(newProduct.getStoreId())
              .orElseThrow(() -> new Exception("Store not found"));
      product.setStore(store);
      productRepository.save(product);
      List<Product> products = productRepository.findAll();
      return ResponseEntity.ok(products);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(null);
    }
  }
}
