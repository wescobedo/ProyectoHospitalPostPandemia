package cl.praxis.ProyectoHospitalPostPandemia.controller;


import cl.praxis.ProyectoHospitalPostPandemia.ProyectoHospitalPostPandemiaApplication;
import cl.praxis.ProyectoHospitalPostPandemia.model.dto.Paciente;
import cl.praxis.ProyectoHospitalPostPandemia.model.service.PacienteService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    private static final Logger logger = LoggerFactory.getLogger(ProyectoHospitalPostPandemiaApplication.class);
    PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @GetMapping()
    public String findAll(Model model){
        logger.info("Ejecutando findAll() de PacienteController");
        model.addAttribute("pacientes", service.findAll());
        return "pacienteList";
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable("id") int id, Model model){
        model.addAttribute("book", service.findOne(id));

        return "bookEdit";
    }

    @PostMapping
    public String update(@ModelAttribute Paciente paciente){
        boolean result = service.update(paciente);

        if (result){
            logger.info("Paciente actualizado correctamente");
        } else {
            logger.error("Error al actualizar libro");
        }

        return "redirect:/books";
    }
    @GetMapping("/new")
    public ModelAndView create(){
        return new ModelAndView("bookNew");
    }

    @PostMapping("/new")
    public String save(@ModelAttribute Paciente paciente){
        boolean result = service.create(paciente);

        if (result){
            logger.info("Libro creado correctamente");
        } else {
            logger.error("Error al crear libro");
        }
        return "redirect:/books";
    }

    @GetMapping("/del/{id}")
    public String delete(@PathVariable("id") int id){
        boolean result = service.delete(id);

        if (result){
            logger.info("Libro eliminado correctamente");
        } else {
            logger.error("Error al eliminar el libro");
        }
        return "redirect:/books";
    }



}
