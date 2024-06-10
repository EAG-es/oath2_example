package inser.spring.oath2_example.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author emilio
 */
@Entity
@Table(name = "oauth_client_details")
public class Oauth_client_detailsEntity implements Serializable {
// client_id – to store the id of newly registered clients
// client_secret – to store the password of clients
// access_token_validity – which indicates if client is still valid (seconds)
// refresh_token_validity – when the access token expires, the refresh token enables you to seamlessly get a new access token to continue the API session, without asking the user to re-authenticate. (seconds)
// authorities – to indicate what roles are permitted with particular client
// scope – allowed actions, for example writing statuses on Facebook etc.
// authorized_grant_types, which provides information how users can login to the particular client

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "client_id", nullable = false, unique = true)
    String client_id; //  varchar(255) not null,
    
    @Column(name = "client_secret")
    String client_secret; //  varchar(255) not null,
    
    @Column(name = "web_server_redirect_uri", length = 2048)
    String web_server_redirect_uri; // varchar(2048) default null,
    
    @Column(name = "scope")
    String scope; //  varchar(255) default null,
    
    @Column(name = "access_token_validity")
    int access_token_validity; //  int(11) default null,
    
    @Column(name = "refresh_token_validity")
    int refresh_token_validity; // int(11) default null,
    
    @Column(name = "resource_ids", length = 1024)
    String resource_ids; //  varchar(1024) default null,
  
    @Column(name = "authorized_grant_types", length = 1024)
    String authorized_grant_types; //  varchar(1024) default null,
    
    @Column(name = "authorities", length = 1024)
    String authorities; // varchar(1024) default null,
    
    @Column(name = "additional_information", length = 4096)
    String additional_information; // varchar(4096) default null,
    
    @Column(name = "autoapprove")
    String autoapprove; // varchar(255) default null,

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getWeb_server_redirect_uri() {
        return web_server_redirect_uri;
    }

    public void setWeb_server_redirect_uri(String web_server_redirect_uri) {
        this.web_server_redirect_uri = web_server_redirect_uri;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public int getAccess_token_validity() {
        return access_token_validity;
    }

    public void setAccess_token_validity(int access_token_validity) {
        this.access_token_validity = access_token_validity;
    }

    public int getRefresh_token_validity() {
        return refresh_token_validity;
    }

    public void setRefresh_token_validity(int refresh_token_validity) {
        this.refresh_token_validity = refresh_token_validity;
    }

    public String getResource_ids() {
        return resource_ids;
    }

    public void setResource_ids(String resource_ids) {
        this.resource_ids = resource_ids;
    }

    public String getAuthorized_grant_types() {
        return authorized_grant_types;
    }

    public void setAuthorized_grant_types(String authorized_grant_types) {
        this.authorized_grant_types = authorized_grant_types;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public String getAdditional_information() {
        return additional_information;
    }

    public void setAdditional_information(String additional_information) {
        this.additional_information = additional_information;
    }

    public String getAutoapprove() {
        return autoapprove;
    }

    public void setAutoapprove(String autoapprove) {
        this.autoapprove = autoapprove;
    }

    
}
