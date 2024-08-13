package springprojectislam_dini.service;


import springprojectislam_dini.MyExeption.MyException;
import springprojectislam_dini.entity.Xadis;

import java.util.List;

public interface XadisService {
    void saveXadis(Xadis newXadis);

    List<Xadis> findAllXadis();

    Xadis findById(Long xadisId) throws MyException;

    void updateXadis(Long xadisId, Xadis newXadis);

    void deleteXadisById(Long xadisId);

    List<Xadis> XadisSearch(String word);
}
