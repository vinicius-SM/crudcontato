package br.edu.ads.usj.lp2.crudempresa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ContatoRepo extends CrudRepository<Contato,Long> {

    List<Contato> findAll();
    
}