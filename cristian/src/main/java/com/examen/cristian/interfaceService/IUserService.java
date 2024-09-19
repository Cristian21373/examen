package com.examen.cristian.interfaceService;

import java.util.List;
import java.util.Optional;

import com.examen.cristian.models.user;

public interface IUserService {
    public String save(user user);    
    public List<user> findAll();
    public List<user> filtroUser(String filtro);
    public Optional<user> findOne(String id);
    public int delete(String id);
    public List<user> cerca_vencimiento();
}
