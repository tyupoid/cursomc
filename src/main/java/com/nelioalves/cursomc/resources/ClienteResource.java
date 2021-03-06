package com.nelioalves.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	@Autowired
	ClienteService clienteService;
	
	@RequestMapping(value = "/{id}")
	public ResponseEntity<Cliente> listarPorId(@PathVariable Integer id){
		Cliente cliente = clienteService.buscar(id);
		return ResponseEntity.ok(cliente);
	
}

}
