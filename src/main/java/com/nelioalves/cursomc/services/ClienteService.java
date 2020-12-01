package com.nelioalves.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.repositories.ClienteRepository;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente>cliente = clienteRepository.findById(id);
		return cliente.orElseThrow(() ->  new ObjectNotFoundException("Objeto nao encontrado id: " + id + " , tipo: " + cliente.getClass().getName()));
	}

}
