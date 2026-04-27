package dev.abelardo_aqui_arroyo.back_end_interview.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.abelardo_aqui_arroyo.back_end_interview.dtos.CreatePetRequestDTO;
import dev.abelardo_aqui_arroyo.back_end_interview.dtos.CreatePetResponseDTO;
import dev.abelardo_aqui_arroyo.back_end_interview.dtos.PetResponseDTO;
import dev.abelardo_aqui_arroyo.back_end_interview.services.PetsService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

@RestController()
@RequestMapping("api/pet")
public class PetsController {
  @Autowired
  private PetsService petsService;

  @GetMapping("/{petId}")
  public PetResponseDTO getPetById(@Valid @PathVariable Long petId) {
    return this.petsService.getPetById(petId);
  }

  @PostMapping()
  public CreatePetResponseDTO createPet(@Valid @RequestBody CreatePetRequestDTO request) {
    return this.petsService.createpet(request);
  }

}
