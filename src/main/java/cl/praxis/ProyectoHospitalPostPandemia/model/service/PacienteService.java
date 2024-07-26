package cl.praxis.ProyectoHospitalPostPandemia.model.service;

import cl.praxis.ProyectoHospitalPostPandemia.model.dto.Paciente;


import java.util.List;

public interface PacienteService {
    List<Paciente> findAll();
    Paciente findOne(int id);
    boolean create(Paciente p);
    boolean update(Paciente p);
    boolean delete(int id);

}
