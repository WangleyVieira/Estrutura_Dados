
package Exemplo_Pilha;

import java.util.Scanner;
/**
 *
 * @author Msv Wangley
 */
public class MenuPrincipal {
    public static void main(String[] args) {
        
        Scanner leitor = new Scanner(System.in);
        
        Pilha aux;
        Pilha topo = null; 
        
        int opcao;
        do{
            System.out.println("---- O P C O E S --------");
            System.out.println("1 - Inserir na pilha");
            System.out.println("2 - Calcular toda a pilha");
            System.out.println("3 - Remover da pilha");
            System.out.println("4 - Esvaziar a pilha");
            System.out.println("5 - Sair");
            System.out.println("------------------------");
            System.out.print("Opcao: ");
            opcao = leitor.nextInt();
            
            switch(opcao){
                case 1:
                    System.out.println("Digite o numero: ");
                    
                    Pilha novo = new Pilha(); //instanciamento da classe pilha, criando objeto pilha
                    
                    novo.numero = leitor.nextInt();//ira receber de entrada os valores de leitura
                    novo.proximo = topo;//proximo objeto que vai receber topo
                    topo = novo; //topo ira receber outro objeto
                    
                    System.out.println("Numero inserido");
                    break;
                    
                case 2:
                    if(topo == null){
                        System.out.println("Pilha vazia");
                    }
                    else{
                        System.out.println("Consulta da pilha");
                        aux = topo;//topo == null
                        while(aux != null){
                            System.out.println(aux.numero+" ");
                            aux = aux.proximo;
                        }
                    }
                    break;
                    
                case 3:
                    if(topo == null){
                        System.out.println("Pilha vazia");
                    }
                    else{
                        System.out.println("Numero "+topo.numero+" removido");
                        topo = topo.proximo;
                    }
                    break;
                    
                case 4:
                    if(topo == null){
                        System.out.println("Pilha vazia");
                    }
                    else{
                        topo = null;
                        System.out.println("Pilha esvaziada");
                    }
                    break;
                    
                case 5:
                    System.out.println("Encerrando...");
                    break;
                    
                default:
                    System.out.println("Opcao Invalida!");
                    break;
            }
        }
        
        while(opcao != 5);
        
        
    }
}
