package br.edu.ads.usj.lp2.crudempresa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepo extends CrudRepository<Produto,Long> {
 
    List<Produto> findAll();
    
}