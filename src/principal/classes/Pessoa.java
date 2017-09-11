/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.classes;

/**
 *
 * @author Mateus
 */
public class Pessoa {
    private int id;
    private String nome;
    private String idade;
    
    
    public Pessoa(){
       
    }
    
    public int getId(){
        return id;
    }


    public void setId(int id){
        this.id =id;
    } 
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getIdade(){
        return idade;
    }
    public void setIdade(String idade){
        this.idade = idade;
    }
    
    
        @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", idade=" + idade + '}';
    }
}//fim classe
