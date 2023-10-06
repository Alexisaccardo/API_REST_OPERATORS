package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class Controlador {
    @PostMapping("/register_users")
    public Users register_users(@RequestBody Users users) throws SQLException, ClassNotFoundException {

        String code = users.getCode();
        String name = users.getName();
        String operator = users.getOperator();
        String city = users.getCiy();
        String address = users.getAddress();
        String cellphone = users.getCellphone();

        if (code == null || code.equals("") || code.length() < 0 || name == null || name.equals("") || name.length() < 0 ||
                operator == null || operator.equals("") || operator.length() < 0 || city == null || city.equals("") ||
                city.length() < 0 || address == null || address.equals("") || address.length() < 0 ||
                cellphone == null || cellphone.equals("") || cellphone.length() < 0) {

            return new Users(null, null, null, null, null, null);
        } else {
            BD bd = new BD();
            String validate = bd.Select_operators(operator);
            if (validate.equals("")) {
                return new Users(null, null, "Operador no existe", null, null, null);

            } else {
                users = bd.Register(code, name, operator, city, address, cellphone);
            }
        }
        return users;
    }

    @PostMapping("/edit_")
    public Users edit(@RequestBody Users users) throws SQLException, ClassNotFoundException {

        String code = users.getCode();
        String operator = users.getOperator();

        if (code == null || code.equals("") || code.length() < 0 || operator == null || operator.equals("") || operator.length() < 0) {

            return new Users(null, null, null, null, null, null);

        } else {
            BD bd = new BD();
            String validate = bd.Select_operators(operator);
            if (validate.equals("")) {
                return new Users(null, null, "Operador no existe", null, null, null);

            } else {
                users = bd.Edit(code, operator);
            }
        }
        return users;
    }

    @GetMapping("/search")
    public List<Users> search() throws SQLException, ClassNotFoundException {
        BD bd = new BD();
        List<Users> list = bd.Search_all();

        return list;
    }

    @GetMapping("/search_user/{code}")
    public Users search_use(@PathVariable String code) throws SQLException, ClassNotFoundException {

        Users users;

        if (code == null || code.equals("") || code.length() < 0) {

            return new Users("No se encuentra un empleado con el codigo ingresado", null, null, null, null, null);

        } else {
            BD bd = new BD();
            users = BD.Select_user(code);
        }


        return users;
    }
}
