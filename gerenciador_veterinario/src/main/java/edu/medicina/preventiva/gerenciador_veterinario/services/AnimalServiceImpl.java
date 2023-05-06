package edu.medicina.preventiva.gerenciador_veterinario.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.medicina.preventiva.gerenciador_veterinario.dtos.AnimalDTO;
import edu.medicina.preventiva.gerenciador_veterinario.exceptions.RegraNegocioException;
import edu.medicina.preventiva.gerenciador_veterinario.models.Animal;
import edu.medicina.preventiva.gerenciador_veterinario.repositories.AnimalRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService{
    
    private final AnimalRepository animalRepository;

    @Override
    @Transactional
    public Animal salvar(AnimalDTO animalDTO) {
        Animal animal = new Animal();
        animal.setNomeAnimal(animalDTO.getNomeAnimal());
        animal.setRacaAnimal(animalDTO.getRacaAnimal());
        animal.setIdadeAnimal(animalDTO.getIdadeAnimal());
        animal.setPesoAnimal(animalDTO.getPesoAnimal());
        animal.setPorteAnimal(animalDTO.getPorteAnimal());
        animal.setSexoAnimal(animalDTO.getSexoAnimal());
        animal.setCpfDonoAnimal(animalDTO.getCpfDonoAnimal());
        animal.setInfoAdicionaisAnimais(animalDTO.getInfoAdicionaisAnimais());

        return animalRepository.save(animal);
    }

    @Override
    @Transactional
    public void alterar(Integer id, AnimalDTO animalDTO) {
        Animal animal = animalRepository.findById(id).orElseThrow(() ->
                                    new RegraNegocioException("Animal nao encontrado!"));

        animal.setNomeAnimal(animalDTO.getNomeAnimal());
        animal.setRacaAnimal(animalDTO.getRacaAnimal());
        animal.setIdadeAnimal(animalDTO.getIdadeAnimal());
        animal.setPesoAnimal(animalDTO.getPesoAnimal());
        animal.setPorteAnimal(animalDTO.getPorteAnimal());
        animal.setSexoAnimal(animalDTO.getSexoAnimal());
        animal.setCpfDonoAnimal(animalDTO.getCpfDonoAnimal());
        animal.setInfoAdicionaisAnimais(animalDTO.getInfoAdicionaisAnimais());

    }

    @Override
    @Transactional
    public void deletar(int codigoAnimal) {
        animalRepository.deleteById(codigoAnimal);
    }

    @Override
    public List<AnimalDTO> consultarTodos() {
        List<AnimalDTO> animalDTOs = new ArrayList<AnimalDTO>();
        for (Animal animal : animalRepository.findAll()) {
            AnimalDTO animalDTO = new AnimalDTO();

            animalDTO.setCodigoAnimal(animal.getCodigoAnimal());
            animalDTO.setNomeAnimal(animal.getNomeAnimal());
            animalDTO.setRacaAnimal(animal.getRacaAnimal());
            animalDTO.setIdadeAnimal(animal.getIdadeAnimal());
            animalDTO.setPesoAnimal(animal.getPesoAnimal());
            animalDTO.setPorteAnimal(animal.getPorteAnimal());
            animalDTO.setSexoAnimal(animal.getSexoAnimal());
            animalDTO.setCpfDonoAnimal(animal.getCpfDonoAnimal());
            animalDTO.setInfoAdicionaisAnimais(animal.getInfoAdicionaisAnimais());
            animalDTOs.add(animalDTO);
        }
        return animalDTOs;
    }

    @Override
    public AnimalDTO consultarPorCodigo(Integer codigoAnimal) {
        Animal animal = animalRepository.findById(codigoAnimal).orElseThrow(() ->
                                    new RegraNegocioException("Animal nao encontrado!"));
        
        AnimalDTO animalDTO = new AnimalDTO();
        animalDTO.setCodigoAnimal(animal.getCodigoAnimal());
        animalDTO.setNomeAnimal(animal.getNomeAnimal());
        animalDTO.setRacaAnimal(animal.getRacaAnimal());
        animalDTO.setIdadeAnimal(animal.getIdadeAnimal());
        animalDTO.setPesoAnimal(animal.getPesoAnimal());
        animalDTO.setPorteAnimal(animal.getPorteAnimal());
        animalDTO.setSexoAnimal(animal.getSexoAnimal());
        animalDTO.setCpfDonoAnimal(animal.getCpfDonoAnimal());
        animalDTO.setInfoAdicionaisAnimais(animal.getInfoAdicionaisAnimais());

        return animalDTO;
    }

    @Override
    public List<AnimalDTO> consultarPorNome(String nomeAnimal) {
        List<AnimalDTO> animalDTOs = new ArrayList<AnimalDTO>();
        for (Animal animal : animalRepository.findByNomeAnimalContaining(nomeAnimal)) {
            AnimalDTO animalDTO = new AnimalDTO();

            animalDTO.setCodigoAnimal(animal.getCodigoAnimal());
            animalDTO.setNomeAnimal(animal.getNomeAnimal());
            animalDTO.setRacaAnimal(animal.getRacaAnimal());
            animalDTO.setIdadeAnimal(animal.getIdadeAnimal());
            animalDTO.setPesoAnimal(animal.getPesoAnimal());
            animalDTO.setPorteAnimal(animal.getPorteAnimal());
            animalDTO.setSexoAnimal(animal.getSexoAnimal());
            animalDTO.setCpfDonoAnimal(animal.getCpfDonoAnimal());
            animalDTO.setInfoAdicionaisAnimais(animal.getInfoAdicionaisAnimais());
            animalDTOs.add(animalDTO);
        }
        return animalDTOs;
    }

    @Override
    public List<AnimalDTO> consultarPorCpfDono(String cpfDonoAnimal) {

        List<AnimalDTO> animalDTOs = new ArrayList<AnimalDTO>();

        for (Animal animal : animalRepository.findByCpfDonoAnimal(cpfDonoAnimal)) {
            AnimalDTO animalDTO = new AnimalDTO();

            animalDTO.setCodigoAnimal(animal.getCodigoAnimal());
            animalDTO.setNomeAnimal(animal.getNomeAnimal());
            animalDTO.setRacaAnimal(animal.getRacaAnimal());
            animalDTO.setIdadeAnimal(animal.getIdadeAnimal());
            animalDTO.setPesoAnimal(animal.getPesoAnimal());
            animalDTO.setPorteAnimal(animal.getPorteAnimal());
            animalDTO.setSexoAnimal(animal.getSexoAnimal());
            animalDTO.setCpfDonoAnimal(animal.getCpfDonoAnimal());
            animalDTO.setInfoAdicionaisAnimais(animal.getInfoAdicionaisAnimais());
            
            animalDTOs.add(animalDTO);
        }
        return animalDTOs;
    }
    
}
