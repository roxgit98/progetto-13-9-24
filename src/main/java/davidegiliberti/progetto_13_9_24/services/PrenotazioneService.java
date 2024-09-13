package davidegiliberti.progetto_13_9_24.services;

import davidegiliberti.progetto_13_9_24.entities.Dipendente;
import davidegiliberti.progetto_13_9_24.entities.Prenotazione;
import davidegiliberti.progetto_13_9_24.entities.Viaggio;
import davidegiliberti.progetto_13_9_24.exceptions.NotFoundEx;
import davidegiliberti.progetto_13_9_24.payloads.PrenotazioneDTO;
import davidegiliberti.progetto_13_9_24.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    @Autowired
    private DipendenteService dipendenteService;
    @Autowired
    private ViaggioService viaggioService;

    public Prenotazione savePrenotazione(PrenotazioneDTO body) {
        Viaggio viaggio = viaggioService.findById(body.dipendenteId());
        Dipendente dipendente = dipendenteService.findById(body.dipendenteId());
        Prenotazione prenotazione = new Prenotazione(body.date(), body.preferenze(), viaggio, dipendente);
        return this.prenotazioneRepository.save(prenotazione);
    }

    public Prenotazione findById(long prenotazioneId) {
        return this.prenotazioneRepository.findById(prenotazioneId).orElseThrow(() -> new NotFoundEx(prenotazioneId));
    }

    public Prenotazione findByIdAndUpdate(long prenotazioneId, PrenotazioneDTO prenotazioneUpdate) {
        Prenotazione found = findById(prenotazioneId);
        found.setDate(prenotazioneUpdate.date());
        found.setPreferenze(prenotazioneUpdate.preferenze());
        Viaggio viaggio = viaggioService.findById(prenotazioneUpdate.viaggioId());
        Dipendente dipendente = dipendenteService.findById(prenotazioneUpdate.dipendenteId());
        found.setViaggio(viaggio);
        found.setDipendente(dipendente);
        return this.prenotazioneRepository.save(found);
    }

    public void findByIdAndDelete(long prenotazioneId) {
        this.prenotazioneRepository.delete(this.findById(prenotazioneId));
    }

}
