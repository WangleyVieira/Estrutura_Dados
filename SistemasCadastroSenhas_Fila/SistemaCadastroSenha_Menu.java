
package SistemasCadastroSenhas_Fila;

import java.util.Scanner;

/**
 *
 * @author Msv Wangley
 */
public class SistemaCadastroSenha_Menu {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        Cadastro.Fila inicioFila = null; //inicio da fila
        Cadastro.Fila fimFila = null; //fim da fila
        Cadastro.Fila aux;
        
        boolean terminar = false;
        int opcao;
        String senhaConsultada, nomeConsultado;

        do{
            System.out.println("----------------------------------------------------");
            System.out.println("1 - Inserir Senha");
            System.out.println("2 - Exibir todas as senhas na fila");
            System.out.println("3 - Consultar se uma senha estah na fila de senhas");
            System.out.println("4 - Consultar se uma pessoa está na fila de senhas");
            System.out.println("5 - Registrar atendimento");
            System.out.println("6 - Cancelar todas as senhas");
            System.out.println("7 - Sair");
            System.out.println("----------------------------------------------------");
            System.out.println("");
            System.out.print("=> ");
            opcao = leitor.nextInt();
            
            switch(opcao){
                case 1: //Inserir senha, cadastrar codigo e nome do usuario
                    Cadastro.Fila novaFila = new Cadastro.Fila();//objeto novaFila
                    System.out.print("Cadastrar codigo: ");
                    novaFila.codigo = leitor.next();
                    System.out.print("Cadastrar nome: ");
                    novaFila.nome = leitor.next();
                    
                    novaFila.proxFila = null; //proxima elemento a ser inserido na fila
                    
                    //Atualizando inicio e fim da fila
                    if(inicioFila == null){ //o primeiro elemento ira no comeco da fila
                        inicioFila = novaFila; //o elemento vai no inicio da fila
                        fimFila = novaFila; //e ele tambem sera o fim da fila, por enquanto
                        System.out.println("");
                    }
                    else{
                        fimFila.proxFila = novaFila;
                        fimFila = novaFila;
                        System.out.println("");
                    }
                    System.out.println("Senha cadastrada com sucesso!\n");
                    break;
                    
                case 2: //exibir todas as senhas da fila
                    if(inicioFila == null){
                        System.out.println("Nenhuma senha cadastrada ate o presente momento");
                    }
                    else{
                        System.out.println("******************************");
                        System.out.println("Exibindo senhas cadastradas");
                        System.out.println("------------------------------");
                        aux = inicioFila;//auxiliar esta recebendo inicio, ambos sao objetos
                        while(aux != null){
                            System.out.println("Codigo - "+aux.codigo);//ira a posi
                            System.out.println("Nome - "+aux.nome);
                            System.out.println("");
                            aux = aux.proxFila;//proxima posicao da memoria auxiliar
                        }
                        System.out.println("******************************");
                    }
                    break;
                    
                case 3: //consultar se uma senha esta na fila de senhas
                    if(inicioFila == null){
                        System.out.println("Nenhuma senha cadastrada ate o presente momento");
                    }
                    else{
                        System.out.print("Informe a senha a ser consultada: ");
                        senhaConsultada = leitor.next();
                        
                        aux = inicioFila;
                        while(aux != null && senhaConsultada.equalsIgnoreCase(aux.codigo)){
                            aux = aux.proxFila;
                        }
                        if(aux == null){
                            System.out.println("Senha nao encontrada!");
                        }
                        else{
                            System.out.println("Senha encontrada!");
                        }
                    }
                    break;
                    
                case 4://consultar se uma pessoa, pelo nome, se esta na fila
                    if(inicioFila == null){
                        System.out.println("Nenhuma senha cadastrada ate o presente momento");
                    }
                    else{
                        System.out.print("Informe o nome da pessoa a ser pesquisado(a): ");
                        nomeConsultado = leitor.next();
                        
                        aux = inicioFila;
                        while(aux != null && nomeConsultado.equalsIgnoreCase(aux.nome)){
                            aux = aux.proxFila;
                        }
                        if(aux == null){
                            System.out.println("Nome nao encontrada!");
                        }
                        else{
                            System.out.println("Nome encontrada!");
                        }
                    }
                    break;
                    
                case 5: //Registar atendimento, excluir uma senha
                    if(inicioFila == null){
                        System.out.println("Nenhuma senha cadastrada ate o presente momento");
                    }
                    else{
                        System.out.println("Senha a ser atendido "+inicioFila.codigo);
                        inicioFila = inicioFila.proxFila;
                        System.out.println("Atendimento registrado com sucesso!");
                    }
                    break;
                    
                case 6://cancelar todas as senhas
                    if(inicioFila == null){
                        System.out.println("Nenhuma senha cadastrada ate o presente momento");
                    }
                    else{
                        System.out.println("Todas senhas excluidas!");
                        inicioFila = null; //esvazia toda a fila, do inicio ao fim da fila
                    }
                    
                case 7: //sair do sistema
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
