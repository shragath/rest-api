package dev.demo.rest_api.Product;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

public class ProductDto {

  public ProductDto() {}

  public ProductDto(Integer id, String name, Double price, Integer quantity, Integer store) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
    this.storeId = store;
  }

  public ProductDto(String name, Double price, Integer quantity, Integer store) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
    this.storeId = store;
  }

  @Valid private Integer id;

  @NotNull(message = "Name cannot be null")
  @NotBlank(message = "Name cannot be empty")
  private String name;

  @NotNull(message = "Price cannot be null")
  private Double price;

  @NotNull(message = "Quantity cannot be null")
  private Integer quantity;

  @NotNull(message = "Store id cannot be null")
  @Range(min = 1, message = "Store id must be greater than 0")
  private Integer storeId;

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Double getPrice() {
    return price;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public Integer getStoreId() {
    return storeId;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public void setStore(Integer storeId) {
    this.storeId = storeId;
  }
}
