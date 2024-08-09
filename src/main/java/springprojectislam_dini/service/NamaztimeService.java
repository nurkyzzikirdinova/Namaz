package springprojectislam_dini.service;

import org.springframework.stereotype.Service;
import peaksoft.springprojectislam_dini.MyExeption.MyException;
import peaksoft.springprojectislam_dini.entity.NamazTime;

import java.util.List;

@Service
public interface NamaztimeService {

    void saveNamaxtime(NamazTime newNamazTime);

    List<NamazTime>findAllNamazTime();

    NamazTime findById(Long namazTimeId) throws MyException;

    void updateNamazTimeById(Long namaztimeId, NamazTime newNamazTime);

    void deleteNamazTimeId(Long namazTimeId);
}
