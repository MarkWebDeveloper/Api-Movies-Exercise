package dev.mark.apimovies.controllers;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.mark.apimovies.services.IGenericService;
import dev.mark.apimovies.services.MovieService;
import dev.mark.apimovies.messages.Message;
import dev.mark.apimovies.models.Movie;


// Annotación RestController se usa para marcar el controlador de tipo Rest.
@RestController
// RequestMapping nos sirve para especificar la ruta para nuestro endpoint. path = "${api-endpoint}/movies" usa la variable que tenemos en nuestro archivo application.properties.
@RequestMapping(path = "${api-endpoint}/movies")
public class MovieController {
    
// Aquí en vez de usar un servicio de MovieService usamos una interfaz IGenericService. Lo hacemos para la mayor facilidad de testeo. De esta manera nuestro controlador no depende de un servicio en concreto sino que puede funcionar con cualquier servicio que implemente esta interfaz genérica(en este caso es IGenericService).
    IGenericService<Movie> service;

    public MovieController(MovieService service) {
        this.service = service;
    }
// GetMapping, PostMapping, PutMapping y DeleteMapping son la anotaciones que marcan los métodos de CRUD correspondientes. (path = "") significa que para usar el método index() no tenemos que añadir nada más a nuestro endpoint de "${api-endpoint}/movies".
    @GetMapping(path = "")
// Como vemos el método index() (lo podemos llamar de cualquier manera) nos tiene que devolver una lista de objetos de tipo Movie. Este método index() implementa el método getAll de nuestro servicio.
    public List<Movie> index() {

        List<Movie> movies = service.getAll();
        return movies;

    }
// En este caso path = "/{id}" significa que a nuestro endpoint de ${api-endpoint}/movies se añade /{id}. Id es una variable que introducimos, por ejemplo, en Postman o en Vue para poder acceder a id de nuestra película. 

// Anotación @PathVariable linkea nuestra variable de la ruta con la variable que sigue y en nuestro caso es movieId. De esta manera conseguimos que la variable que introducimos a la ruta se pase como argumento al método getById de nuestro servicio.

// throws Exception significa que el método show puede lanzar una excepción. 

// return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(movie) significa que como resultado de nuestra peticion vamos a recibir un estatus 200 y el cuerpo del objeto encontrado.
    @GetMapping(path = "/{id}")
    public ResponseEntity<Movie> showById(@PathVariable("id") Long movieId) throws Exception {

        Movie movie = service.getById(movieId);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(movie);
    }
// @RequestBody significa que para hacer la solicitud necesitaríamos pasarle a la api a través de Postman o cualquier otro medio un objeto, en nuestro caso es de tipo Movie. 
    @PostMapping(path = "")
    public ResponseEntity<Movie> create(@RequestBody Movie movie) {

        Movie newMovie = service.save(movie);

        return ResponseEntity.status(201).body(newMovie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> update(@PathVariable("id") Long id, @RequestBody Movie movie) throws Exception {

        Movie updatedMovie = service.update(id, movie);

        return ResponseEntity.status(200).body(updatedMovie);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Message> remove(@PathVariable("id") Long id) throws Exception { 

        Message delete = service.delete(id);

        return ResponseEntity.status(200).body(delete);
    }
// En este caso tuve que añadir un paso adicional (/bytitle) a la ruta porque ya teníamos un GetMapping que esperaba una variable cuando hacíamos el método de showById que era responsable de buscar el objeto por su id. Si no podemos un paso adicional, entonces el sistema no va a saber cual de los dos métodos queremos usar y nos dará un error a la hora de hacer la petición en Postman.
    @GetMapping(path = "/bytitle/{title}")
    public ResponseEntity<Movie> showByTitle(@PathVariable("title") String title) throws Exception {

        Movie movie = service.getByTitle(title);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(movie);
    }

}