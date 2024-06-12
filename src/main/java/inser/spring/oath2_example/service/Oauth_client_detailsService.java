package inser.spring.oath2_example.service;

import innui.modelos.configurations.ResourceBundles;
import innui.modelos.errors.Oks;
import innui.modelos.internacionalization.Tr;
import inser.spring.oath2_example.dto.Oauth_client_detailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import inser.spring.oath2_example.entity.Oauth_client_detailsEntity;
import static inser.spring.oath2_example.entity.Role.k_role_admin;
import inser.spring.oath2_example.repository.Oauth_client_detailsRepository;
import java.io.File;
import java.util.ResourceBundle;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@Transactional
public class Oauth_client_detailsService {
    // Properties file for translactions
    public static String k_in_route;
    static {
        String paquete_tex = Oauth_client_detailsService.class.getPackage().getName();
        paquete_tex = paquete_tex.replace(".", File.separator);
        k_in_route = "in/" + paquete_tex + "/in";
    }
    // Authorized user details
    @Autowired
    private Oauth_userDetailsService oauth_userDetailsService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public Oauth_client_detailsRepository Oauth_client_detailsRepository;

    public boolean check_permits(String role_name, Oks ok, Object ... extras_array) throws Exception {
        ResourceBundle in;
        in = ResourceBundles.getBundle(k_in_route);
        try {
            if (oauth_userDetailsService.oauth_userDetail.isAccountNonExpired() == false) {
                ok.setTxt(Tr.in(in, "Account expired."));
                return false;
            }
            if (oauth_userDetailsService.oauth_userDetail.isAccountNonLocked() == false) {
                ok.setTxt(Tr.in(in, "Account locked."));
                return false;
            }
            boolean is_found = false;
            String lowercase = role_name.toLowerCase();
            for (var role: oauth_userDetailsService.oauth_userDetail.getRoles()) {
                if (role.getName().toLowerCase().equals(lowercase)) {
                    is_found = true;
                    break;
                }
            }
            if (is_found == false) {
                ok.setTxt(Tr.in(in, "User does not have the role required."));
            }
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return ok.is;
    }

    /**
     * 
     * @param ouath_client_detailsDTO
     * @param ok
     * @param extras_array
     * @return
     * @throws Exception 
     */
    public String createOrUpdate(Oauth_client_detailsDTO ouath_client_detailsDTO, Oks ok, Object ... extras_array) throws Exception {
        String retorno = null;
        ResourceBundle in;
        in = ResourceBundles.getBundle(k_in_route);
        try {
            Oauth_client_detailsEntity oauth_client_detailsEntity = null;
            if (check_permits(k_role_admin, ok)) {
                try {
                    oauth_client_detailsEntity = copyOauth_client_detailsDtoToEntity(ouath_client_detailsDTO, ok);
                } catch (DataIntegrityViolationException ex) {
                    ok.setTxt(ex);
                }
                if (ok.is == false) { return null; }
                Oauth_client_detailsRepository.save(oauth_client_detailsEntity);
                retorno = oauth_client_detailsEntity.getClient_id() + Tr.in(in, " saved");
            }
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return retorno;
    }
    /**
     * 
     * @param id
     * @param ok
     * @param extras_array
     * @return
     * @throws Exception 
     */
    public String deleteById(String id, Oks ok, Object ... extras_array) throws Exception {
        String retorno = null;
        ResourceBundle in;
        in = ResourceBundles.getBundle(k_in_route);
        try {
            if (check_permits(k_role_admin, ok)) {
                if (Oauth_client_detailsRepository.existsById(id)) {
                    Oauth_client_detailsRepository.deleteById(id);
                    retorno = id + Tr.in(in, " deleted");
                } else {
                    ok.setTxt(Tr.in(in, "Record not found ") + id);
                }
            }
        } catch (Exception e) {
            ok.setTxt(e);
        }
        return retorno;
    }
    /**
     * 
     * @param oauth_client_detailsDTO
     * @param ok
     * @param extras_array
     * @return 
     */
    private Oauth_client_detailsEntity copyOauth_client_detailsDtoToEntity(Oauth_client_detailsDTO oauth_client_detailsDTO, Oks ok, Object ... extras_array) {
        Oauth_client_detailsEntity oauth_client_detailsEntity = new Oauth_client_detailsEntity();
        BeanUtils.copyProperties(oauth_client_detailsDTO, oauth_client_detailsEntity);
        String client_secret = passwordEncoder.encode(oauth_client_detailsDTO.password);
        oauth_client_detailsEntity.setClient_secret(client_secret);
        return oauth_client_detailsEntity;
    }
}
