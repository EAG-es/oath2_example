package inser.spring.oath2_example.controller;

import innui.modelos.errors.Oks;
import inser.spring.oath2_example.dto.Oauth_client_detailsDTO;
import inser.spring.oath2_example.service.Oauth_client_detailsService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author emilio
 */
@Validated
@RestController
@RequestMapping("/oath_admin")
public class Oauth_client_detailsController {

    @Autowired
    private Oauth_client_detailsService oauth_client_details;
    
    /**
     * Example of usage:
     * POST /oath_admin/add HTTP/1.1
     * Host: localhost:8082
     * Content-Type: application/json
     * Authorization: ••••••
     * Content-Length: 376
     * 
     * {
     *     "client_id": "client_id",
     *     "web_server_redirect_uri": "http://localhost:8080/code",
     *     "scope": "READ,WRITE",
     *     "access_token_validity": 3600,
     *     "refresh_token_validity": 10000,
     *     "resource_ids": "microservice",
     *     "authorized_grant_types": "authorization_code,password,refresh_token,implicit",
     *     "additional_information": "{}",
     *     "password": "password"
     * }
     * @param oauth_client_detailsDTO
     * @return
     * @throws Exception 
     */
    @PostMapping(value = { "/add", "/update" })
    public ResponseEntity<String> createOrUpdate(@Valid @RequestBody Oauth_client_detailsDTO oauth_client_detailsDTO) throws Exception {
        ResponseEntity<String> retorno = null;
        Oks ok = new Oks();
//        ResourceBundle in;
//        in = ResourceBundles.getBundle(k_in_route);
        do {
            try {
                String response = oauth_client_details.createOrUpdate(oauth_client_detailsDTO, ok);
                if (ok.is == false) { break; }
                retorno = new ResponseEntity<>(response, HttpStatus.CREATED);
            } catch (Exception e) {
                ok.setTxt(e);
            }
        } while (false);
        if (ok.is == false) {
            retorno = new ResponseEntity<>(ok.getTxt(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return retorno;
    }
    /**
     * Example of usage:
     * GET /oath_admin/delete?id=prueba HTTP/1.1
     * Host: localhost:8082
     * Authorization: Bearer gKsk5pP11RggGdaBpiuY3yeWzn8
     * Cookie: JSESSIONID=4B628E7710D814D59106007BD1C844E6
     * @param id
     * @return
     * @throws Exception 
     */
    @GetMapping(value = "/delete")
    public ResponseEntity<String> deleteById(@RequestParam("id") String id) throws Exception {
        ResponseEntity<String> retorno = null;
        Oks ok = new Oks();
//        ResourceBundle in;
//        in = ResourceBundles.getBundle(k_in_route);
        do {
            try {
                String response = oauth_client_details.deleteById(id, ok);
                retorno = new ResponseEntity<>(response, HttpStatus.OK);
            } catch (Exception e) {
                ok.setTxt(e);
            }
        } while (false);
        if (ok.is == false) {
            retorno = new ResponseEntity<>(ok.getTxt(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return retorno;
    }
    
}
