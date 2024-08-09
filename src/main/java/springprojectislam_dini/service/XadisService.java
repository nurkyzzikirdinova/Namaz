package springprojectislam_dini.service;

import peaksoft.springprojectislam_dini.MyExeption.MyException;
import peaksoft.springprojectislam_dini.entity.Xadis;

import java.util.List;

public interface XadisService {
    void saveXadis(Xadis newXadis);

    List<Xadis>findAllXadis();

    Xadis findById(Long xadisId) throws MyException;

    void updateXadis(Long xadisId, Xadis newXadis);

    void deleteXadisById(Long xadisId);

    List<Xadis> XadisSearch(String word);
}
