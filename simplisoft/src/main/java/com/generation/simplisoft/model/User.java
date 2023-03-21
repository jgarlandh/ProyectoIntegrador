package com.generation.simplisoft.model;

import javax.persistence.Entity;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Users") // Se usa para comunicarnos con la tabla que queremos, en este caso "Roles"

// Anotaciones para el uso de Lombok
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class User {
        
    /* ------- Esto para indicarle a la tabla que ID es autoincrementable ------ */
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        /* ----------------------------------------------------------------------------- */
        /*----- El atributo ID debe venir justo después de las sentencias de arriba ---- */
        /* ---------- Los atributos coinciden con las columnas de la tabla ------------- */
        /* ----------------------------------------------------------------------------- */
        private Integer id_user;
        private String rut;
        private String username;
        private String userPassword;
        private String email;
        private String address;
        private Boolean userStatus; // Usuario Activo o  Inactivo
        private String phone;
        private Integer fk_id_role;
}
