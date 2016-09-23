/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.videoaula.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author noebezerra
 */
// para conectar com o banco de dados, transforma em uma entidade
@Entity
@Table(name="eventos")
public class Pessoas implements Serializable{
    // atributos
    @Id  // indentifida o id
    @GeneratedValue(strategy = GenerationType.AUTO) // gera automaticamente o valor do id
    private int id;
    // @Column(name="data_cadastro") para padronizar no banco de dados
    private String evento;
    private String endereco;
    private String uf;
    private String cidade;
    private String datai;
    private String dataf;
    private String email;
    private String telefone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDatai() {
        return datai;
    }

    public void setDatai(String datai) {
        this.datai = datai;
    }

    public String getDataf() {
        return dataf;
    }

    public void setDataf(String dataf) {
        this.dataf = dataf;
    }
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String eamil) {
        this.email = eamil;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoas other = (Pessoas) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
    
}
