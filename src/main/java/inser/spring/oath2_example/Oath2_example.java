package inser.spring.oath2_example;

import innui.modelos.Modelos;
import innui.modelos.configurations.Initials;
import innui.modelos.errors.Oks;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Oath2_example extends Initials {

    public Oath2_example() throws Exception {
        Oks ok = new Oks();
        init(ok);
        if (ok.is == false) {
            throw new Exception(ok.getTxt());
        }
    }

    @Override
    protected void finalize() throws Exception, Throwable {
        Oks ok = new Oks();
        terminate(ok);
        if (ok.is == false) {
            throw new Exception(ok.getTxt());
        }
        super.finalize();
    }


    @Override
    public boolean run(Oks ok, Object ... extras_array) throws Exception {
        return ok.is;
    }
    
    @Override
    public boolean init(Oks ok, Object... extra_array) throws Exception {
        // Init models for the clases
        // Models: persistent properties (re), internationalization (in),...
        if (ok.is == false) { return ok.is; }
        _init_from_class(Modelos.class, ok);
        if (ok.is == false) { return ok.is; }
        _init_from_class(this.getClass(), ok);
        return ok.is;
    }
    
    @Override
    public boolean terminate(Oks ok, Object... extra_array) throws Exception {
        // Terminate models for the clases
        // Models: persistent properties (re), internationalization (in),...
        if (ok.is == false) { return ok.is; }
        _terminate_from_class(Modelos.class, ok);
        if (ok.is == false) { return ok.is; }
        _terminate_from_class(this.getClass(), ok);
        if (ok.is == false) { return ok.is; }
        return ok.is;
    }
    
    public static void main(String[] args) {
        SpringApplication.run(Oath2_example.class, args);
    }

}
