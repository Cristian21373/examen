package com.examen.cristian.Interface;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.examen.cristian.models.user;

@Repository
public interface IUser extends CrudRepository<user, String> {
    @Query("SELECT us FROM user us WHERE "
            + "us.Title LIKE %?1%")
    List<user> filtroUser(String filtro);

    // @Query ("SELECT t FROM Task t WHERE t.status = 'pendiente' AND (t.dueDate = :fiveDaysBefore OR t.dueDate = :oneDayBefore)")
    List<user> cerca_vencimiento();
}
