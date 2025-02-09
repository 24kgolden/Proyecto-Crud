package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guadar(String nombreMasco, String raza, String color, String nombreDuenio, String observacion, String celDuenio, String algercio, String atencionEsp) {
        //creamos el dueño y asiganamos sus valores
        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);
        //duenio.setId_duenio(0);

        //creamos la mascota y asiganamos sus valores
        Mascota masco = new Mascota();
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAlergico(algercio);
        masco.setAtencion_especial(atencionEsp);
        masco.setObservaciones(observacion);
        masco.setUnDuenio(duenio);

        //llama a la persistencia ---- guarda los datos en la base datos
        controlPersis.guardar(duenio, masco);
    }

    public List<Mascota> traerMascotas() {
        return controlPersis.traerMascotas();
    }

    public void borrarDatos(int num_cliente) {
        controlPersis.borrarDatos(num_cliente);
    }

    public Mascota traerDatos(int num_cliente) {
        return controlPersis.traerDatos(num_cliente);
    }

    public void modificarMascota(Mascota masco, String nombreMasco, String raza, String color, 
            String nombreDuenio, String observacion, String celDuenio, String algercio, String atencionEsp) {
    
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observacion);
        masco.setAtencion_especial(atencionEsp);
        masco.setAlergico(algercio);
        
        //modifico masocta
        controlPersis.modificarMascota(masco);
        
        //seteo nuevos valores del dueño
        //Duenio = datoDuenio = controlPersis.buscarDuenio();
        Duenio busDuenio = this.buscar(masco.getUnDuenio().getId_duenio());
        busDuenio.setNombre(nombreDuenio);
        busDuenio.setCelDuenio(celDuenio);
        
        //llamar al modificar dueño
        this.modificarDuenio(busDuenio);
        
    }

    private Duenio buscar(int id_duenio) {
        
        return controlPersis.traerDuenio(id_duenio);
        
    }

    private void modificarDuenio(Duenio busDuenio) {
        
        controlPersis.modificarDuenio(busDuenio);
        
    }



}
