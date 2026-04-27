package dev.abelardo_aqui_arroyo.back_end_interview.fetching_provider.dtos;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PetFetchResponseDTO {
  private Long id;
  private Category category;
  private String name;
  private List<String> photoUrls;
  private List<Tag> tags;
  private String status;

  @Data
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Category {
    private Integer id;
    private String name;
  }

  @Data
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Tag {
    private Integer id;
    private String name;
  }
}
