# cidenet_hulk_store_backend
hola, 
para tener encuenta: 

1. El proyecto esta basado en una arquitectura de microservicios.
2. Para iniciar el proyecto se debe tener encuenta lo siguiente:
 a. Tener una instancia del servidor de base de datos MySql, la configuracion se encuentra en la siguiente url:
  -> https://github.com/JoseFelix88/hulk-store-config-server.git, es un repositorio publico por tanto podra editarlo.
 b. Al iniciar los proyectos, se debe iniciar primero el hulk-store-configuration-server porque es el que carga la configuracion 
   inicial de la BD a la  que se conectan los demas servicios.
   Seguido del servidor de registro Eureka, continuando con cada servicio(cliente, proveedor, etc) y por ultimo el gateway-zuul-server.
 
 
 
Espero cumpla con parte del requerimiento seria bueno tener sus comentarios, para seguir mejorando.

Gracias, hasta pronto..!
