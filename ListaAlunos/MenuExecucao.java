/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaAlunos;


public class MenuExecucao {
    public static void main(String[] args) {
        
        Vetor lista = new Vetor();
        Aluno aluno1 = new Aluno();
        
        aluno1.setNome("Wangley Vieira");
        //inserindo uma String
        lista.adiciona(aluno1);
        
        System.out.println(lista.toString());
        
    }
}
