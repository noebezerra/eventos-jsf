/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.videoaula.bean;

import br.com.videoaula.dao.PessoasDao;
import br.com.videoaula.entity.Pessoas;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Faz comunicação com interface e banco de dados
 * @author noebezerra
 */
@ManagedBean
@SessionScoped
public class PessoasBean {

    /**
     * Creates a new instance of PessoasBean
     */
    private Pessoas pessoa = new Pessoas();
    private PessoasDao pessoaDao = new PessoasDao();
    private List<Pessoas> listaPessoas;
    
    
    public PessoasBean() {
    }
    // limpar dados
    public String limpaDados(){
        pessoa.setId(0);
        pessoa.setEvento(null);
        pessoa.setEndereco(null);
        pessoa.setUf(null);
        pessoa.setCidade(null);
        pessoa.setDatai(null);
        pessoa.setDataf(null);
        pessoa.setEmail(null);
        pessoa.setTelefone(null);
        
        return "";
    }
    // pegar dados
    public String pegarIngresso(Pessoas p){
        pessoa = p;
        return "ingresso";
    }
    // adiciona a pessoa
    public String adicionarPessoa(){
        pessoaDao.addPessoa(pessoa);
        pessoa.setEvento(null);
        pessoa.setEndereco(null);
        pessoa.setUf(null);
        pessoa.setCidade(null);
        pessoa.setDatai(null);
        pessoa.setDataf(null);
        pessoa.setEmail(null);
        pessoa.setTelefone(null);
        return "index";
    }
    // remove a pessoa
    public String removerPessoa(Pessoas p){
        this.pessoa = p;
        pessoaDao.removePessoa(this.pessoa);
        this.pessoa.setEvento(null);
        this.pessoa.setEndereco(null);
        this.pessoa.setUf(null);
        this.pessoa.setCidade(null);
        this.pessoa.setDatai(null);
        this.pessoa.setDataf(null);
        this.pessoa.setEmail(null);
        this.pessoa.setTelefone(null);
        return "index";
    }    

    public List listarPessoas(){
        listaPessoas = pessoaDao.getList();
        return this.listaPessoas;
    }
    
    public String carregarPessoa(Pessoas p){
        pessoa = p;
        return "editar";
    }
    
    public String atualizarPessoas(){
        pessoaDao.updatePessoa(pessoa);
        pessoa.setId(0);
        pessoa.setEvento(null);
        pessoa.setEndereco(null);
        pessoa.setUf(null);
        pessoa.setCidade(null);
        pessoa.setDatai(null);
        pessoa.setDataf(null);
        pessoa.setEmail(null);
        pessoa.setTelefone(null);
        
        return "index";
    }
    
    public Pessoas getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoas pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.pessoa);
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
        final PessoasBean other = (PessoasBean) obj;
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        return true;
    }
    
    
}
