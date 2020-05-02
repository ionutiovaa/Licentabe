package be.dao;

import be.entity.Client;
import be.entity.Departament;
import be.entity.Proiect;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProiectDao extends CrudRepository<Proiect, Integer> {

    Proiect findProiectByNume(String nume);

    Proiect findProiectByClient(Client client);

    Proiect findProiectByDepartament(Departament departament);

    Proiect findAllByID(Integer id);

    Proiect findProiectByID(Integer id);

    List<Proiect> findAll();

    void deleteProiectByNume(String nume);

    void deleteProiectByClient(Client client);

    void deleteProiectByDepartament(Departament departament);

    @Transactional
    @Modifying
    @Query("UPDATE Proiect p " +
            "SET nume = :newNume " +
            "WHERE ID = :proiectID")
    int changeNumeProiect(@Param("proiectID") Integer proiectID,
                              @Param("newNume") String newNume);

    @Transactional
    @Modifying
    @Query("UPDATE Proiect p " +
            "SET id_client = :newId " +
            "WHERE ID = :proiectID")
    int updateClientProiect(@Param("proiectID") Integer proiectID,
                                     @Param("newId") Integer newId);

    @Transactional
    @Modifying
    @Query("UPDATE Proiect p " +
            "SET id_departament = :newId " +
            "WHERE ID = :proiectID")
    int updateDepartamentProiect(@Param("proiectID") Integer proiectID,
                            @Param("newId") Integer newId);

}
