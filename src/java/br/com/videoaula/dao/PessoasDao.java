/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.videoaula.dao;

import br.com.videoaula.entity.Pessoas;
import br.com.videoaula.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author noebezerra
 */
public class PessoasDao {
    private Session sessao; // a sessao e o transaction será o hibernate
    private Transaction trans;
    private List<Pessoas> list;

    public List<Pessoas> getList() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Pessoas.class);
        this.list = cri.list();
        
        return list;
    }
    
    public void addPessoa(Pessoas p){
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            Pessoas pessoa = new Pessoas();
            pessoa.setEvento(p.getEvento());
            pessoa.setEndereco(p.getEndereco());
            pessoa.setUf(p.getUf());
            pessoa.setCidade(p.getCidade());
            pessoa.setDatai(p.getDatai());
            pessoa.setDataf(p.getDataf());
            pessoa.setEmail(p.getEmail());
            pessoa.setTelefone(p.getTelefone());

            sessao.save(pessoa);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }
    
    public void removePessoa(Pessoas p){
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            sessao.delete(p);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }
    
    public void updatePessoa(Pessoas p){
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            sessao.update(p);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }
}
