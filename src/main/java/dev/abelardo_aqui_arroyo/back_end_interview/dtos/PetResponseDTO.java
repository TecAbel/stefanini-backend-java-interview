package dev.abelardo_aqui_arroyo.back_end_interview.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PetResponseDTO {
  private Long id;
  private String status;
  private String name;

}
