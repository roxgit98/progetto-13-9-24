package davidegiliberti.progetto_13_9_24.services;

import davidegiliberti.progetto_13_9_24.entities.Dipendente;
import davidegiliberti.progetto_13_9_24.exceptions.NotFoundEx;
import davidegiliberti.progetto_13_9_24.payloads.DipendenteDTO;
import davidegiliberti.progetto_13_9_24.repositories.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DipendenteService {
    @Autowired
    private DipendenteRepository dipendenteRepository;

    public Dipendente saveDipendente(DipendenteDTO body) {
        Dipendente dipendente = new Dipendente(body.username(), body.nome(), body.cognome(), body.email(), body.avatar());
        return this.dipendenteRepository.save(dipendente);
    }

    public Dipendente findById(long dipendeteId) {
        return this.dipendenteRepository.findById(dipendeteId).orElseThrow(() -> new NotFoundEx(dipendeteId));
    }

    public Dipendente findByIdAndUpdate(long dipendenteId, DipendenteDTO dipendenteUpdate) {
        Dipendente found = findById(dipendenteId);
        found.setUsername(dipendenteUpdate.username());
        found.setNome(dipendenteUpdate.nome());
        found.setCognome(dipendenteUpdate.cognome());
        found.setEmail(dipendenteUpdate.email());
        return this.dipendenteRepository.save(found);
    }

    public void findByIdAndDelete(long dipendenteId) {
        this.dipendenteRepository.delete(this.findById(dipendenteId));
    }


}
