package inser.spring.oath2_example.repository;

import inser.spring.oath2_example.entity.Oauth_client_detailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Oauth_client_detailsRepository extends JpaRepository<Oauth_client_detailsEntity, String> {


}
