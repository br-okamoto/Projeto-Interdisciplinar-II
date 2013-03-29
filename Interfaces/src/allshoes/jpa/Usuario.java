/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allshoes.jpa;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario extends Pessoa implements Serializable, Cloneable {

    @Id
    @GeneratedValue
    private int idPessoa;
    private String login;
    private String senha;
    private int idTipoUsuario;
    private String email;

    public Usuario() {
    }

    public Usuario (int idPessoa, String login, String senha, int idTipoUsuario, String email) {
        this.idPessoa = idPessoa;
        this.login = login;
        this.senha = senha;
        this.idTipoUsuario = idTipoUsuario;
        this.email = email;
    }
    
    public Usuario(int idPessoa, String senha){
        this.idPessoa = idPessoa;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getItTipoUsuario() {
        return idTipoUsuario;
    }

    public void setItTipoUsuario(int itTipoUsuario) {
        this.idTipoUsuario = itTipoUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
