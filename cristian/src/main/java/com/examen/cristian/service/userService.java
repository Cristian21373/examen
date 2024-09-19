package com.examen.cristian.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.cristian.Interface.IUser;
import com.examen.cristian.interfaceService.IUserService;
import com.examen.cristian.models.user;

@Service
public class userService implements IUserService {

    @Autowired
	private IUser data;

    @Override
    public String save(user user) {
        data.save(user);
        return user.getId();
    }

    @Override
    public int delete(String id) {
        data.deleteById(id);
		return 1;
    }

    @Override
    public List<user> findAll() {
        List<user> ListUser=(List<user>) data.findAll();
		return ListUser;
    }

    @Override
    public List<user> filtroUser(String filtro) {
        List <user> listUser=data.filtroUser(filtro);
        return listUser;
    }

    @Override
    public Optional<user> findOne(String id) {
        Optional<user> user=data.findById(id);
		return user;
    }

    @Override
    public List<user> cerca_vencimiento() {
        List<user> ListUser = data.cerca_vencimiento();
        return ListUser;
    } 

}
