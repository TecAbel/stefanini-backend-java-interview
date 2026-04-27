package dev.abelardo_aqui_arroyo.back_end_interview.fetching_provider.dtos;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatePetFetchingDto {
  private Long id;
  private String status;
  private String name;
  private List<String> photoUrls;

}
