package com.javanauta.usuario.business;

import com.javanauta.usuario.infrastructure.clients.ViaCepClient;
import com.javanauta.usuario.infrastructure.clients.ViaCepDTO;
import com.javanauta.usuario.infrastructure.exceptions.IllegalArgumentException;
import com.javanauta.usuario.infrastructure.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ViaCepService {
    private final ViaCepClient viaCepClient;


    public ViaCepDTO buscarDadosEndereco(String cep){

        ViaCepDTO viaCepDTO = viaCepClient.buscarDadosEndereco(processarCep(cep));

        if(viaCepDTO.getCep() == null || viaCepDTO.getCep().isEmpty()){
            throw new ResourceNotFoundException("O CEP não foi localizado");
        }

        return viaCepDTO;
    }

    private String processarCep(String cep){

        String cepFormat = cep.replace(" ", "").replace("-", "");

        if(!cepFormat.matches("\\d+") || !Objects.equals(cepFormat.length(), 8)){
            throw new IllegalArgumentException("O cep contém caracteres inválidos");
        }
        return cepFormat;
    }

}
