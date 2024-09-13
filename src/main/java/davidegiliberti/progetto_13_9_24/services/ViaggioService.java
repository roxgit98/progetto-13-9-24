package davidegiliberti.progetto_13_9_24.services;

import davidegiliberti.progetto_13_9_24.entities.Viaggio;
import davidegiliberti.progetto_13_9_24.exceptions.NotFoundEx;
import davidegiliberti.progetto_13_9_24.payloads.ViaggioDTO;
import davidegiliberti.progetto_13_9_24.repositories.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViaggioService {
    @Autowired
    private ViaggioRepository viaggioRepository;

    public Viaggio saveViaggio(ViaggioDTO body) {
        Viaggio viaggio = new Viaggio(body.destinazione(), body.data(), body.statoViaggio());
        return this.viaggioRepository.save(viaggio);
    }

    public Viaggio findById(long viaggioId) {
        return this.viaggioRepository.findById(viaggioId).orElseThrow(() -> new NotFoundEx(viaggioId));
    }

    public void findByIdAndDelete(long viaggioId) {
        this.viaggioRepository.delete(this.findById(viaggioId));
    }
}
