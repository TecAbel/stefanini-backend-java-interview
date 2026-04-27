
package dev.abelardo_aqui_arroyo.back_end_interview.dtos;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatePetResponseDTO {
  private UUID transactionId;
  private LocalDate dateCreated;
  private Boolean status;
  private String name;

}
