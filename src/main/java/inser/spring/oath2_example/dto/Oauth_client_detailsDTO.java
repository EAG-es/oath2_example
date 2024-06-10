package inser.spring.oath2_example.dto;

/**
 *
 * @author emilio
 */
public class Oauth_client_detailsDTO {
    public String client_id; //  varchar(255) not null,
    // public String client_secret; //  varchar(255) not null,
    public String web_server_redirect_uri; // varchar(2048) default null,
    public String scope; //  varchar(255) default null,
    public int access_token_validity; //  int(11) default null,
    public int refresh_token_validity; // int(11) default null,
    public String resource_ids; //  varchar(1024) default null,
    public String authorized_grant_types; //  varchar(1024) default null,
    // public String authorities; // varchar(1024) default null,
    public String additional_information; // varchar(4096) default null,
    // public String autoapprove; // varchar(255) default null,
    public String password; // varchar(4096) default null,

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
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

    public String getAdditional_information() {
        return additional_information;
    }

    public void setAdditional_information(String additional_information) {
        this.additional_information = additional_information;
    }
    
}
