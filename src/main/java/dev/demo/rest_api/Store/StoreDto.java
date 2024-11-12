package dev.demo.rest_api.Store;

import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class StoreDto {

  public StoreDto() {}

  public StoreDto(String name) {
    this.name = name;
  }

  public StoreDto(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  @Valid @Nullable private Integer id;

  @NotNull(message = "Name cannot be null")
  @NotBlank(message = "Name cannot be empty")
  @Length(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
  private String name;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
