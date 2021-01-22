package com.asap.crud.controller;

import com.assement.exception.InvalidException;
import com.assement.model.Apolice;
import com.assement.model.Cliente;
import com.assement.repository.ApoliceRepository;
import com.assement.repository.ClienteRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
public class Controller {

    private final ClienteRepository clienteRepository;

    private final ApoliceRepository apoliceRepository;

    @Autowired
    public Controller (ClienteRepository clienteRepository, ApoliceRepository apoliceRepository){
        this.apoliceRepository = apoliceRepository;
        this.clienteRepository = clienteRepository;
    }

    @PostMapping("/cliente")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Cliente createCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @PostMapping("/apolice")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Apolice createApolice(@RequestBody Apolice apolice){
        return apoliceRepository.save(apolice);
    }

    @PostMapping("/cliente/{clienteId}/{apoliceId}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Cliente createApolice(@PathVariable String clienteId,
                                 @PathVariable int apoliceId){
        Cliente cliente = getCliente(clienteId);
        cliente.addApolice(getApolice(apoliceId));
        return clienteRepository.save(cliente);
    }

    @GetMapping("/cliente/{clienteId}")
    @ResponseStatus(value = HttpStatus.OK)
    public Cliente getCliente(@PathVariable String clienteId){
        String erroCriar ="Nao foi possivel a encontrar" +
                " o cliente com id: "+clienteId;
        return clienteRepository.findById(clienteId).orElseThrow(
                () -> new InvalidException(erroCriar));
    }

    @GetMapping("/apolice/{apoliceId}")
    @ResponseStatus(value = HttpStatus.OK)
    public Apolice getApolice(@PathVariable int apoliceId){
        String erroCriar ="Nao foi possivel encontrar" +
                " a apolice com id: "+apoliceId;
        return apoliceRepository.findById(apoliceId).orElseThrow(
                () -> new InvalidException(erroCriar));
    }

    @PutMapping("/cliente/{clienteId}")
    @ResponseStatus(value = HttpStatus.OK)
    public Cliente updateCliente(@PathVariable String clienteId,
                                 @RequestBody Cliente updateCliente){
        String erroEditar ="Nao foi possivel realizar o update" +
                " do cliente com id: "+clienteId;
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(
                () -> new InvalidException(erroEditar));
        cliente.setNome(updateCliente.getNome());
        cliente.setCidade(updateCliente.getCidade());
        cliente.setUf(updateCliente.getUf());
        cliente.setApolices(updateCliente.getApolices());
        return clienteRepository.save(cliente);
    }

    @PutMapping("/apolice/{apoliceId}")
    @ResponseStatus(value = HttpStatus.OK)
    public Apolice updateApolice(@PathVariable int apoliceId,
                                 @RequestBody Apolice updateApolice){
        String erroEditar ="Nao foi possivel realizar o update" +
                " da apolice com id: "+apoliceId;
        Apolice apolice = apoliceRepository.findById(apoliceId).orElseThrow(
                () -> new InvalidException(erroEditar));
        apolice.setInicioVigencia(updateApolice.getInicioVigencia());
        apolice.setFimVigencia(updateApolice.getFimVigencia());
        apolice.setPlaca(updateApolice.getPlaca());
        apolice.setValor(updateApolice.getValor());
        return apoliceRepository.save(apolice);
    }

    @DeleteMapping("/cliente/{clienteId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteCliente(@PathVariable String clienteId){
         clienteRepository.deleteById(clienteId);
    }

    @DeleteMapping("/apolice/{clienteId}/{apoliceId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteApolice(@PathVariable String clienteId,
                              @PathVariable int apoliceId){
        Cliente cliente = getCliente(clienteId);
        if (!cliente.equals(null)) {
            cliente.removeApolice(getApolice(apoliceId));
            clienteRepository.save(cliente);
        }
        apoliceRepository.deleteById(apoliceId);
    }

}
