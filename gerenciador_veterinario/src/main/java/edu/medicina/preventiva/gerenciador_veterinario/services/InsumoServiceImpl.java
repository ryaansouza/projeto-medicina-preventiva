package edu.medicina.preventiva.gerenciador_veterinario.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.medicina.preventiva.gerenciador_veterinario.dtos.InsumoDTO;
import edu.medicina.preventiva.gerenciador_veterinario.exceptions.RegraNegocioException;
import edu.medicina.preventiva.gerenciador_veterinario.models.Insumo;
import edu.medicina.preventiva.gerenciador_veterinario.repositories.InsumoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InsumoServiceImpl implements InsumoService {

    private final InsumoRepository insumoRepository;

    @Override
    @Transactional
    public Insumo salvar(InsumoDTO insumoDTO) {
        Insumo insumo = new Insumo();
        insumo.setNome(insumoDTO.getNome());
        insumo.setValor(insumoDTO.getValor());
        insumo.setDescricao(insumoDTO.getDescricao());
        return insumoRepository.save(insumo);
    }

    @Override
    @Transactional
    public void alterar(Integer id, InsumoDTO insumoDTO) {
        Insumo insumo = insumoRepository.findById(id).orElseThrow(() ->
                                    new RegraNegocioException("Insumo nao encontrado!"));
        insumo.setNome(insumoDTO.getNome());
        insumo.setValor(insumoDTO.getValor());
        insumo.setDescricao(insumoDTO.getDescricao());
    }

    @Override
    @Transactional
    public void deletar(int codigo) {
        insumoRepository.deleteById(codigo);
    }

    @Override
    public List<InsumoDTO> consultarTodos() {
        List<InsumoDTO> insumoDTOs= new ArrayList<InsumoDTO>();
        for (Insumo insumo : insumoRepository.findAll()) {
            InsumoDTO insumoDTO = new InsumoDTO();
            insumoDTO.setCodigo(insumo.getCodigo());
            insumoDTO.setNome(insumo.getNome());
            insumoDTO.setValor(insumo.getValor());
            insumoDTO.setDescricao(insumo.getDescricao());
            insumoDTOs.add(insumoDTO);
        }
        return insumoDTOs;
    }

    @Override
    public InsumoDTO consultarPorCodigo(Integer codigo) {
        Insumo insumo = insumoRepository.findById(codigo).orElseThrow(() ->
                                    new RegraNegocioException("Insumo nao encontrado!"));
        InsumoDTO insumoDTO = new InsumoDTO();
        insumoDTO.setCodigo(insumo.getCodigo());
        insumoDTO.setNome(insumo.getNome());
        insumoDTO.setValor(insumo.getValor());
        insumoDTO.setDescricao(insumo.getDescricao());
        return insumoDTO;
    }

    @Override
    public List<InsumoDTO> consultarPorNome(String nome) {
        List<InsumoDTO> insumoDTOs= new ArrayList<InsumoDTO>();
        for (Insumo insumo : insumoRepository.findByNomeContaining(nome)) {
            InsumoDTO insumoDTO = new InsumoDTO();
            insumoDTO.setCodigo(insumo.getCodigo());
            insumoDTO.setNome(insumo.getNome());
            insumoDTO.setValor(insumo.getValor());
            insumoDTO.setDescricao(insumo.getDescricao());
            insumoDTOs.add(insumoDTO);
        }
        return insumoDTOs;
    }
    
}