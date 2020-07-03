package br.edu.ads.usj.lp2.crudempresa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProdutoControle {

    @Autowired
    ProdutoRepo prodRepository;

    @GetMapping(value = "/indexprod")
    public ModelAndView getTodos() {
        List<Produto> listaprod = prodRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("indexprod");
        modelAndView.addObject("listaprod", listaprod);
        return modelAndView;
    }

    @GetMapping(value = "/mostrarprod/{id}")
    public ModelAndView getMostrarprod(@PathVariable Long id) {
        Produto produto = prodRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("mostrarprod");
        modelAndView.addObject("produto", produto);
        return modelAndView;
    }

    @GetMapping(value = "/cadastrarprod")
    public ModelAndView getCadastrarprod() {
        Produto produto = new Produto();
        ModelAndView modelAndView = new ModelAndView("cadastrarprod");
        modelAndView.addObject("produto", produto);
        return modelAndView;
    }

    @PostMapping(value = "/cadastrarprod")
    public ModelAndView postCadastrarprod(Produto produto) {
        // grava o formulario no banco
        prodRepository.save(produto);
        ModelAndView modelAndView = new ModelAndView("mostrarprod");
        modelAndView.addObject("produto", produto);
        return modelAndView;
    }
    

    @GetMapping(value = "/deletarprod/{id}")
    public ModelAndView getDeletarprod(@PathVariable final Long id) {
        prodRepository.deleteById(id);
        List<Produto> listaprod = prodRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("indexprod");
        modelAndView.addObject("listaprod", listaprod);
        return modelAndView;
    }

    @GetMapping(value = "/editarprod/{id}")
    public ModelAndView getEditarprod(@PathVariable final Long id) {
        Produto produto = prodRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("cadastrarprod");
        modelAndView.addObject("produto", produto);
        return modelAndView;
    }

    
}