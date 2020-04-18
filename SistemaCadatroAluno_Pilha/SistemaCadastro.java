
package SistemaCadatroAluno_Pilha;

import java.util.Scanner;

/**
 *
 * @author Msv Wangley
 */
public class SistemaCadastro {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        Aluno.Pessoa aux;
        Aluno.Pessoa topo = null;
        
        boolean terminar = false;
        do{
            System.out.println("---------------------------------------------");
            System.out.println("1 - Cadastrar aluno (somente codigo)");
            System.out.println("2 - Cadastrar nota (para alunos ja cadastrados)");
            System.out.println("3 - Calcular media das notas dos alunos");
            System.out.println("4 - Exibir todos os aluno e respectivas notas");
            System.out.println("5 - Consultar se um aluno esta cadastrado");
            System.out.println("6 - Excluir aluno");
            System.out.println("7 - Sair");
            System.out.println("---------------------------------------------");
            System.out.print("Informe a opcao: ");
            int opcao = leitor.nextInt();
            
            Aluno.Pessoa novo = new Aluno.Pessoa();
            
            String codigoInformado;
            double somaNotas = 0, mediaNotas = 0;
            int qtdNotas = 0;
            
            //aux = topo;
            switch(opcao){
                case 1:
                    System.out.print("Informe o codigo do aluno: ");
                    novo.codigoAluno = leitor.next();
                    
                    novo.proximo = topo;
                    topo = novo;
                    
                    System.out.println("Aluno inserido\n");
                    break;
                    
                case 2:
                    System.out.print("Informe o codigo do aluno: ");
                    codigoInformado = leitor.next();

                    aux = topo;
                    if(codigoInformado.equals(aux.codigoAluno)){
                        System.out.println("Aluno valido");
                        while(aux != null){
                        if(codigoInformado.equals(aux.codigoAluno)){
                            System.out.print("Informe a nota do aluno: ");
                            double notaAluno = leitor.nextDouble();
                            aux.notaAluno = notaAluno;
                            System.out.println("Nota cadastrado!");
                        }
                        aux = aux.proximo;//proximo objeto do tipo Pessoa
                    }
                    }
                    else{
                        System.out.println("Aluno nao cadastrado");
                    }
                    break;
                    
                case 3:
                    aux = topo;
                    while(aux != null){
                        qtdNotas++;
                        somaNotas += aux.notaAluno;//esta acessando outro objeto notaAluno
                        aux = aux.proximo;
                    }
                    mediaNotas = (double) somaNotas / qtdNotas;
                    System.out.println("Quantidade de notas: "+qtdNotas);
                    System.out.println("Soma das notas: "+somaNotas);
                    System.out.println("Media das notas: "+mediaNotas);
                    break;
                    
                case 4:
                    if(topo == null){
                        System.out.println("Sem nada");
                    }
                    else{
                        System.out.println("Exibindo os alunos e suas notas");
                        aux = topo;
                        System.out.printf("Codigo Aluno | nota   \n");
                        while(aux != null){
                            System.out.printf("%s %15.2f \n", aux.codigoAluno, aux.notaAluno);
                            aux = aux.proximo;
                        }
                    }
                    break;
                    
                case 5:
                    aux = topo;
                    System.out.print("Informe o codigo do aluno: ");
                    codigoInformado = leitor.next();
                    if(codigoInformado.equals(aux.codigoAluno)){
                        System.out.println("Aluno cadastrado!");
                    }
                    else{
                        System.out.println("Aluno nao cadastrado");
                    }
                    break;
                    
                case 6:
                    if(topo == null){
                        System.out.println("Nenhum aluno cadastrado!");
                    }
                    else{
                        System.out.println("Aluno "+topo.codigoAluno+" deletado");
                        topo = topo.proximo;
                    }
                    break;
                    
                case 7:
                    System.out.println("Encerrando...");
                    terminar = true;
                    break;
                    
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        }
        while(!terminar);
    }
}
