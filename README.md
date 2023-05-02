# jwtimpldemo_SP2.7

Este es un proyecto de ejemplo de como implementar JWT y Spring Security sin SecurityWebConfigurer

* Es funcional, pero aún faltan algunos detalles, así que debes adaptarlo.

## Comenzar

* git clone https://github.com/montexbjeliseo/jwtimpldemo_SP2.7.git

* Crea la base de datos vacía "jwtimpldemo"

* Crear/loguear un usuario usando postman:
    - Crear: /auth/register
    - Login: /auth/login
    > '''json:
    {
      "username": "usuario",
      "password": "clave"
    }
    
