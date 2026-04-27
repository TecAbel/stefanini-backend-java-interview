package dev.abelardo_aqui_arroyo.back_end_interview.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dev.abelardo_aqui_arroyo.back_end_interview.dtos.CreatePetRequestDTO;
import dev.abelardo_aqui_arroyo.back_end_interview.dtos.CreatePetResponseDTO;
import dev.abelardo_aqui_arroyo.back_end_interview.dtos.PetResponseDTO;
import dev.abelardo_aqui_arroyo.back_end_interview.fetching_provider.PetStore;
import dev.abelardo_aqui_arroyo.back_end_interview.fetching_provider.dtos.CreatePetFetchingDto;
import dev.abelardo_aqui_arroyo.back_end_interview.fetching_provider.dtos.PetFetchResponseDTO;

@Service
public class PetsService {
  @Autowired
  private PetStore petStore;

  private final Logger logger = LoggerFactory.getLogger(PetsService.class);
  private final ObjectMapper objectMapper = new ObjectMapper();

  public PetResponseDTO getPetById(Long petId) {
    ResponseEntity<PetFetchResponseDTO> response = this.petStore.get("pet/" + petId, PetFetchResponseDTO.class);
    if (response.getStatusCode() != HttpStatus.OK) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This pet does not exist");
    }
    PetFetchResponseDTO fetchResponseDTO = response.getBody();
    PetResponseDTO responseDto = new PetResponseDTO();
    responseDto.setId(fetchResponseDTO.getId());
    responseDto.setStatus(fetchResponseDTO.getStatus());
    responseDto.setName(fetchResponseDTO.getName());
    logger.info(responseDto.toString());
    return responseDto;
  }

  public CreatePetResponseDTO createpet(CreatePetRequestDTO request) {
    System.out.println("reqeust" + request.toString());
    var fetchReq = new CreatePetFetchingDto();
    fetchReq.setId(request.getId());
    fetchReq.setName(request.getName());
    fetchReq.setStatus(request.getStatus());
    fetchReq.setPhotoUrls(List.of());
    System.out.println(fetchReq.toString());
    ResponseEntity<?> responseEntity = this.petStore.post("pet", fetchReq, Object.class);
    System.out.println(responseEntity.toString());
    if (responseEntity.getStatusCode() != HttpStatus.OK) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Verify ddata and try again");
    }

    CreatePetResponseDTO res = new CreatePetResponseDTO();
    res.setName(request.getName());
    res.setStatus(true);
    res.setDateCreated(LocalDate.now());
    res.setTransactionId(UUID.randomUUID());

    return res;
  }

}
