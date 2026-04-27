package dev.abelardo_aqui_arroyo.back_end_interview.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreatePetRequestDTO {
  @NotNull
  private Long id;
  @NotBlank
  private String status;
  @NotBlank
  private String name;
}
