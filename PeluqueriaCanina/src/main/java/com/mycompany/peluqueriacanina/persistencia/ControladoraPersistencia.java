package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.logica.Mascota;
import com.mycompany.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {

    MascotaJpaController mascoJpa = new MascotaJpaController();
    DuenioJpaController duenioJpa = new DuenioJpaController();

    public void guardar(Duenio duenio, Mascota masco) {
        //crear en DB el dueño
        duenioJpa.create(duenio);

        //crear en la db la mascota
        mascoJpa.create(masco);
    }

    public List<Mascota> traerMascotas() {
        //busca todos los registro de la tabla mascota y los asigna, en nuestro caso los va a retornar 
        return mascoJpa.findMascotaEntities();
    }

    public void borrarDatos(int num_cliente) {
        try {
            mascoJpa.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Mascota traerDatos(int num_cliente) {
        return mascoJpa.findMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco) {

        try {
            mascoJpa.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public Duenio traerDuenio(int id_duenio) {
    
        return duenioJpa.findDuenio(id_duenio);
        
    }

    public void modificarDuenio(Duenio busDuenio) {
        
        try {
            duenioJpa.edit(busDuenio);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
