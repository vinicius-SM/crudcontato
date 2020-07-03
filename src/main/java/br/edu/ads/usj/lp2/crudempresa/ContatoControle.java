package br.edu.ads.usj.lp2.crudempresa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContatoControle {

    @Autowired
    ContatoRepo contatoRepository;

    @GetMapping(value = "/indexcli")
    public ModelAndView getTodos() {
        List<Contato> listacli = contatoRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("indexcli");
        modelAndView.addObject("listacli", listacli);
        return modelAndView;
    }

    @GetMapping(value = "/mostrarcli/{id}")
    public ModelAndView getMostrarcli(@PathVariable Long id) {
        Contato contato = contatoRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("mostrarcli");
        modelAndView.addObject("contato", contato);
        return modelAndView;
    }

    @GetMapping(value = "/cadastrarcli")
    public ModelAndView getCadastrarcli() {
        Contato contato = new Contato();
        ModelAndView modelAndView = new ModelAndView("cadastrarcli");
        modelAndView.addObject("contato", contato);
        return modelAndView;
    }

    @PostMapping(value = "/cadastrarcli")
    public ModelAndView postCadastrarcli(Contato contato) {
        contatoRepository.save(contato);
        ModelAndView modelAndView = new ModelAndView("mostrarcli");
        modelAndView.addObject("contato", contato);
        return modelAndView;
    }
    

    @GetMapping(value = "/deletarcli/{id}")
    public ModelAndView getDeletarcli(@PathVariable final Long id) {
        contatoRepository.deleteById(id);
        List<Contato> listacli = contatoRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("indexcli");
        modelAndView.addObject("listacli", listacli);
        return modelAndView;
    }

    @GetMapping(value = "/editarcli/{id}")
    public ModelAndView getEditarcli(@PathVariable final Long id) {
        Contato contato = contatoRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("cadastrarcli");
        modelAndView.addObject("contato", contato);
        return modelAndView;
    }
    
    @GetMapping(value = "/contato")
    public ModelAndView getContato() {
        ModelAndView modelAndView = new ModelAndView("contato");
        return modelAndView;
    }

}