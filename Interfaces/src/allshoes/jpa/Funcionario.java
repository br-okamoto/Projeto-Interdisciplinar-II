package allshoes.jpa;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idPessoa")
public class Funcionario extends Usuario {
    
    private int registro;
    @Enumerated (EnumType.STRING)
    private LocalDeTrabalho localDeTrabalho;
    private String cargo;

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public LocalDeTrabalho getLocalDeTrabalho() {
        return localDeTrabalho;
    }

    public void setLocalDeTrabalho(LocalDeTrabalho localDeTrabalho) {
        this.localDeTrabalho = localDeTrabalho;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
}
