
package Exemplo_Fila;

import java.util.Scanner;
/**
 *
 * @author Msv Wangley
 */
public class MenuPrincipal {
    public static void main(String[] args) {
        
        Scanner leitor = new Scanner(System.in);
        
        Fila.FILA inicio = null;
        Fila.FILA fim = null;
        Fila.FILA aux;
        int opcao;
        do{
            System.out.println("------------------------------------");
            System.out.println("O P C O E S ");
            System.out.println("1 - Inserir na fila");
            System.out.println("2 - Consultar toda a fila");
            System.out.println("3 - Consultar um elemento na fila");
            System.out.println("4 - Remover da fila");
            System.out.println("5 - Esvaziar a fila");
            System.out.println("6 - Alterar um elemento da fila");
            System.out.println("7 - Sair");
            System.out.println("------------------------------------");
            System.out.print("Informe a opcao: ");
            opcao = leitor.nextInt();
            
            int esseNumero, novoNumero;
            switch(opcao){
                case 1://inserir um elemento na fila
                    Fila.FILA novaFila = new Fila.FILA();
                    
                    System.out.print("Informe o valor os elementos: ");
                    novaFila.numero = leitor.nextInt();
                    novaFila.proximo = null;
                    
                    //Atualizar inicio e fim
                    //situacao 1 - Fila vazia eh o 10 e o ultimo
                    if(inicio == null){
                        inicio = novaFila;
                        fim = novaFila;
                    }
                    else{
                        fim.proximo = novaFila;
                        fim = novaFila;
                    }
                    System.out.println("Numero inserido!");
                    break;
                    
                case 2:
                    if(inicio == null){
                        System.out.println("Fila vazia");
                    }
                    else{
                        System.out.println("Consultando a fila");
                        aux = inicio;
                        while(aux != null){
                            System.out.println("Numero: "+aux.numero);
                            aux = aux.proximo;
                        }
                    }
                    break;
                    
                case 3://consultar um elemento na fila, pela senha
                    if(inicio == null){
                        System.out.println("Fila vazia");
                    }
                    else{
                        System.out.print("Digite um numero a pesquisar: ");
                        esseNumero = leitor.nextInt();
                        
                        aux = inicio;
                        while(aux != null && esseNumero != aux.numero){
                            aux = aux.proximo;
                        }
                        if(aux == null){//acabou a fila e nao foi encontrado o elemento
                            System.out.println("Numero nao encontrado!");
                        }
                        else{//numero encontrado
                            System.out.println("Numero encontrado!");
                        }
                    }
                    break;
                    
                case 4://remocao
                    if(inicio == null){
                        System.out.println("Fila vazia");
                    }
                    else{
                        System.out.println("Numero "+inicio.numero+" removido");
                        inicio = inicio.proximo;
                        System.out.println("Elemento removido com sucesso!");
                    }
                    break;
                    
                case 5://esvaziar a fila
                    if(inicio == null){
                        System.out.println("Fila vazia");
                    }
                    else{
                        inicio = null;
                    }
                    break;
                    
                case 6://alterar um elemento 
                    if(inicio == null){
                        System.out.println("Fila vazia");
                    }
                    else{
                        System.out.print("Informe o numero a alterar: ");
                        esseNumero = leitor.nextInt();
                        System.out.print("Digite o novo numero: ");
                        novoNumero = leitor.nextInt();
                        
                        aux = inicio;
                        while(aux != null && esseNumero != aux.numero){
                            aux = aux.proximo;
                        }
                        if(aux == null){
                            System.out.println("Numero nao encontrado");
                        }
                        else{
                            aux.numero = novoNumero;
                            System.out.println("Numero alterado");
                        }
                    }
                    break;
                    
                case 7:
                    System.out.println("Saindo...");
                    break;
                    
                default:
                    System.out.println("Opcao Invalida!");
                    break;
            }
        }
        while(opcao != 7);
    }
}
