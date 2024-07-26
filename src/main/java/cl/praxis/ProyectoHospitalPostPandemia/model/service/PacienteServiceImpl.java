package cl.praxis.ProyectoHospitalPostPandemia.model.service;

import org.springframework.stereotype.Service;


import cl.praxis.ProyectoHospitalPostPandemia.ProyectoHospitalPostPandemiaApplication;
import cl.praxis.ProyectoHospitalPostPandemia.model.dto.Paciente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


@Service
public class PacienteServiceImpl implements PacienteService {

    private List<Paciente> pacienteList;
    private static final Logger logger = LoggerFactory.getLogger(ProyectoHospitalPostPandemiaApplication.class);



    public PacienteServiceImpl() {

        pacienteList = new ArrayList<>();

        pacienteList.add(new Paciente(1, "Waldo", "Escobedo", "1234", 1,0 ));
        pacienteList.add(new Paciente(2, "Clorinda", "Meza", "1122", 2,1 ));
        pacienteList.add(new Paciente(3, "Alexis", "Sanchez", "3344", 3,1 ));
    }

    public PacienteServiceImpl(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }

    @Override
    public List<Paciente> findAll() {

        logger.info("Ejecutando findAll de pacienteServiceImpl");

        return pacienteList;
    }

    @Override
    public Paciente findOne(int id) {
        return pacienteList.stream()
                .filter(paciente -> paciente.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean create(Paciente b) {
        pacienteList.add(b);
        return true;
    }

    @Override
    public boolean update(Paciente b) {
             return true;
    }

    @Override
    public boolean delete(int id) {

        Paciente b = findOne(id);
        if (b != null){
            pacienteList.remove(b);
            return true;
        }

        return false;
    }

}
