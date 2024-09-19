package com.examen.cristian.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.cristian.Interface.IUser;
import com.examen.cristian.models.user;
import com.examen.cristian.service.emailService;




@RestController
@RequestMapping("/api/v1/user")
public class userController {

    @Autowired
	private IUser userService;

    @Autowired
	private emailService emailService;

    @PostMapping("/task/")
    public ResponseEntity<Object> save(@RequestBody user user) {
        
        if (user.getTitle().equals("")) {

            return new ResponseEntity<>("El titulo es obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (user.getDue_date().equals("")) {

            return new ResponseEntity<>("La fecha es obligatoria", HttpStatus.BAD_REQUEST);
        }
        if (user.getAssigned_to().equals("")) {

            return new ResponseEntity<>("El correo electronico es obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (user.getStatus().equals("")) {

            return new ResponseEntity<>("El Status del usuario es obligatorio", HttpStatus.BAD_REQUEST);
        }

        userService.save(user);
        emailService.enviarCorreoRegistro(user.getAssigned_to());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @GetMapping("/task/")
    public ResponseEntity<Object> findAll(){
        var ListUser =userService.findAll();
        return new ResponseEntity<>(ListUser, HttpStatus.OK);
    }

    @GetMapping("/busquedafiltro/{filtro}")
    public ResponseEntity<Object>findFiltro(@PathVariable String filtro){
        var ListUser = userService.filtroUser(filtro);
        return new ResponseEntity<>(ListUser, HttpStatus.OK);
    }
	
	@GetMapping("/task/{id}")
    public ResponseEntity<Object> findOne(@PathVariable("id") String id){
        userService.findById(id);
        return new ResponseEntity<>("Tarea no encontrada", HttpStatus.OK);
    }
	
	@DeleteMapping("/task/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id){
        userService.deleteById(id);
        return new ResponseEntity<>("Registro Eliminado", HttpStatus.OK);
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") String id, @RequestBody user userUpdate){
	    var user = userService.findById(id).orElse(null);
	    if (user != null) {
	        user.setTitle(userUpdate.getTitle());
	        user.setDue_date(userUpdate.getDue_date());
	        user.setAssigned_to(userUpdate.getAssigned_to());
	        user.setStatus(userUpdate.getStatus());

	        
	        userService.save(user);
	        return new ResponseEntity<>("Guardado", HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("Error: user no encontrado", HttpStatus.BAD_REQUEST);
	    }
	}
}
