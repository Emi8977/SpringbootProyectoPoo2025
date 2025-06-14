package com.example.ProyectoFinal.services;

import com.example.ProyectoFinal.models.Cliente;
import com.example.ProyectoFinal.models.Pago;
import com.example.ProyectoFinal.repositories.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoServiceImpl implements PagoService{
    private final PagoRepository pagoRepository;

    @Autowired
    public PagoServiceImpl(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }


    @Override
    public List<Pago> getAllPago() {
        return pagoRepository.findAll();
    }

    @Override
    public Pago getPagoById(Long id) {
        return pagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));
    }

    @Override
    public Pago createPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    @Override
    public Pago updatePago(Long id, Pago pagoDetails) {
        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        if ( pagoDetails.getMonto() != 0.0) {
            pagoDetails.setMonto(pagoDetails.getMonto());
        }
        if (pagoDetails.getTipo() != null) {
            pago.setTipo(pagoDetails.getTipo());
        }
        return pagoRepository.save(pago);
    }

    @Override
    public void deletePago(Long id) {
        if (!pagoRepository.existsById(id)) {
            throw new RuntimeException("Pago no encontrado");
        }
        pagoRepository.deleteById(id);
    }

}
