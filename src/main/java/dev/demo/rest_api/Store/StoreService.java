package dev.demo.rest_api.Store;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoreService {
  private final StoreRepository storeRepository;

  public StoreService(StoreRepository storeRepository) {
    this.storeRepository = storeRepository;
  }

  public ResponseEntity<List<Store>> getStores() {
    List<Store> stores = storeRepository.findAll();
    return ResponseEntity.ok(stores);
  }

  @Transactional
  public ResponseEntity<String> addStore(StoreDto newStore) {
    try {
      Store store = new Store(newStore.getName());
      storeRepository.save(store);
      return ResponseEntity.ok().body("Store added successfully");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(null);
    }
  }
}
