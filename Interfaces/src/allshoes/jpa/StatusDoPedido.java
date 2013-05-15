
package allshoes.jpa;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StatusDoPedido implements Serializable {
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idStatus;
     private boolean status;

    public int getIdStatus() {
        return idStatus;
    }

    public boolean isStatus() {
        return status;
    }
    private static final Logger LOG = Logger.getLogger(StatusDoPedido.class.getName());
     
     
}
