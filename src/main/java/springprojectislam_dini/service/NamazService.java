package springprojectislam_dini.service;

import peaksoft.springprojectislam_dini.entity.Namaz;

import java.util.List;

public interface NamazService {

    void saveNamaz(Namaz newNAmaz);

    List<Namaz>findAllNamaz();

    Namaz findAllById(Long namazId);

    void updateNamaz(Long namazId, Namaz newNamaz);

    void deleteById(Long namazId);

    List<Namaz> NamazSearch(String word);

}
