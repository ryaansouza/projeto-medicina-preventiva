package edu.medicina.preventiva.gerenciador_veterinario.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.medicina.preventiva.gerenciador_veterinario.dtos.MedicamentoDTO;
import edu.medicina.preventiva.gerenciador_veterinario.exceptions.RegraNegocioException;
import edu.medicina.preventiva.gerenciador_veterinario.models.Medicamento;
import edu.medicina.preventiva.gerenciador_veterinario.repositories.MedicamentoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicamentoServiceImpl implements MedicamentoService{

    private final MedicamentoRepository medicamentoRepository;

    @Override
    @Transactional
    public Medicamento salvar(MedicamentoDTO medicamentoDTO) {
        Medicamento medicamento = new Medicamento();
        medicamento.setNomeMed(medicamentoDTO.getNomeMed());
        medicamento.setValidadeMinimaMed(medicamentoDTO.getValidadeMinimaMed());
        medicamento.setValorMed(medicamentoDTO.getValorMed());
        return medicamentoRepository.save(medicamento);
    }

    @Override
    @Transactional
    public void alterar(Integer id, MedicamentoDTO medicamentoDTO) {
        Medicamento medicamento = medicamentoRepository.findById(id).orElseThrow(() ->
                                    new RegraNegocioException("Medicamento não encontrado!"));
        medicamento.setNomeMed(medicamentoDTO.getNomeMed());
        medicamento.setValidadeMinimaMed(medicamentoDTO.getValidadeMinimaMed());
        medicamento.setValorMed(medicamentoDTO.getValorMed());
    }

    @Override
    @Transactional
    public void deletar(int codigo) {
        medicamentoRepository.deleteById(codigo);
    }

    @Override
    public List<MedicamentoDTO> consultarTodos() {
        List<MedicamentoDTO> medicamentoDTOs= new ArrayList<MedicamentoDTO>();
        for (Medicamento medicamento : medicamentoRepository.findAll()) {
            MedicamentoDTO medicamentoDTO = new MedicamentoDTO();
            medicamentoDTO.setCodigoMed(medicamento.getCodigoMed());
            medicamentoDTO.setNomeMed(medicamento.getNomeMed());
            medicamentoDTO.setValidadeMinimaMed(medicamento.getValidadeMinimaMed());
            medicamentoDTO.setValorMed(medicamento.getValorMed());
            medicamentoDTOs.add(medicamentoDTO);
        }
        return medicamentoDTOs;
    }

    @Override
    public MedicamentoDTO consultarPorCodigo(Integer codigo) {
        Medicamento medicamento = medicamentoRepository.findById(codigo).orElseThrow(() ->
                                    new RegraNegocioException("Medicamento nao encontrado!"));
        MedicamentoDTO medicamentoDTO = new MedicamentoDTO();
        medicamentoDTO.setCodigoMed(medicamento.getCodigoMed());
        medicamentoDTO.setNomeMed(medicamento.getNomeMed());
        medicamentoDTO.setValidadeMinimaMed(medicamento.getValidadeMinimaMed());
        medicamentoDTO.setValorMed(medicamento.getValorMed());
        return medicamentoDTO;
    }

    @Override
    public List<MedicamentoDTO> consultarPorNome(String nome) {
        List<MedicamentoDTO> medicamentoDTOs= new ArrayList<MedicamentoDTO>();
        for (Medicamento medicamento : medicamentoRepository.findByNomeMedContaining(nome)) {
            MedicamentoDTO medicamentoDTO = new MedicamentoDTO();
            medicamentoDTO.setCodigoMed(medicamento.getCodigoMed());
            medicamentoDTO.setNomeMed(medicamento.getNomeMed());
            medicamentoDTO.setValidadeMinimaMed(medicamento.getValidadeMinimaMed());
            medicamentoDTO.setValorMed(medicamento.getValorMed());
            medicamentoDTOs.add(medicamentoDTO);
        }
        return medicamentoDTOs;
    }

    @Override
    public List<MedicamentoDTO> consultarPorDataValidade(LocalDate dataValidade) {
        List<MedicamentoDTO> medicamentoDTOs = new ArrayList<MedicamentoDTO>();
        for (Medicamento medicamento : medicamentoRepository.findByValidadeMinimaMed(dataValidade)) {
            MedicamentoDTO medicamentoDTO = new MedicamentoDTO();
            medicamentoDTO.setCodigoMed(medicamento.getCodigoMed());
            medicamentoDTO.setNomeMed(medicamento.getNomeMed());
            medicamentoDTO.setValidadeMinimaMed(medicamento.getValidadeMinimaMed());
            medicamentoDTO.setValorMed(medicamento.getValorMed());
            medicamentoDTOs.add(medicamentoDTO);
        }
        return medicamentoDTOs;
    }
    
}
