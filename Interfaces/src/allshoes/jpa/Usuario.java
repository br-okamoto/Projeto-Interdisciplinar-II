/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allshoes.jpa;

import antlr.ByteBuffer;
import java.io.Serializable;
import java.math.BigInteger;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario extends Pessoa implements Serializable, Cloneable {

    @Id
    @GeneratedValue
    private int idPessoa;
    private String login;
    @Column(name = "senha", length = 32, columnDefinition = "VARCHAR(32)")
    private char[] senha;
    private int idTipoUsuario;
    private String email;

    public Usuario() {
    }

    public Usuario (int idPessoa, String login, char[] senha, int idTipoUsuario, String email) {
        this.idPessoa = idPessoa;
        this.login = login;
        this.senha = hashPassword(senha);
        this.idTipoUsuario = idTipoUsuario;
        this.email = email;
    }
    
    public Usuario(int idPessoa, char[] senha){
        this.idPessoa = idPessoa;
        this.senha = hashPassword(senha);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public char[] getSenha() {
        return senha;
    }

    public void setSenha(char[] senha) {
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
    
    private char[] hashPassword(char[] password) {
        char[] encoded = null;
        try {
            java.nio.ByteBuffer passwdBuffer = 
              Charset.defaultCharset().encode(CharBuffer.wrap(password));
            byte[] passwdBytes = passwdBuffer.array();
            MessageDigest mdEnc = MessageDigest.getInstance("MD5");
            mdEnc.update(passwdBytes, 0, password.length);
            encoded = new BigInteger(1, mdEnc.digest()).toString(16).toCharArray();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return encoded;
    }
}
