
package ListaAlunos;

import java.util.Arrays;


public class Vetor {
    //Declarando e Inicializando um array de Aluno com capacidade 100
    private Aluno[] alunos = new Aluno[5]; //100
    
    //primeira posicao vazia no Array, da direita para a esquerda
    private int totalDeAlunos = 0;//guarda a quantidade de alunos armazenados no Array
    //[aluno1,aluno2,aluno3, 0 , , ... ]
    // primeira posicao vazia e o indice 3 (depois do aluno3)
    // quantidade de elementos = indice da primeira posicao vazia
    
    /* Com estrutura de repeticao seria ineficaz neste caso
    public void adiciona(Aluno aluno){
        for (int i = 0; i < this.alunos.length; i++) {
            if(this.alunos[i] ==  null){
                this.alunos[i] = aluno;
                break;
            }
        }
    }
    */
    public void adiciona(Aluno aluno){
        this.alunos[this.totalDeAlunos] = aluno;
        this.totalDeAlunos++;//proxima posicao do array
    }
    
    //Adicionar um aluno em uma determinada posicao
    public void adicionaAlunoPosicao(int posicao, Aluno aluno){
        if(!posicaoValida(posicao)){
            //System.out.println("Posicao nao encontrada!");
            throw new IllegalArgumentException("Posicao Invalida!");
        }
        
        for (int i = this.totalDeAlunos - 1; i >= posicao; i--) {
            this.alunos[i + 1] = this.alunos[i];
        }
        
        this.alunos[posicao] = aluno;
        this.totalDeAlunos++;
    }
    
    public Aluno pega(int posicao){
        if(!this.posicaoOcupada(posicao)){ //Se a posicao informada nao for encontrada exibe a mensagem
            //"Posicao Invalida"
            //System.out.println("Posicao nao encontrada!");
            throw new IllegalArgumentException("Posicao Invalida!");
        }
        return this.alunos[posicao];
    }
    
    private boolean posicaoOcupada(int posicao){//nao deve usado fora desta classe Vetor
        if(posicao >= 0 && posicao < this.totalDeAlunos){
            return true;
        }
        return false;
    }
    
    public boolean posicaoValida(int posicao){
        if(posicao >= 0 && posicao < this.totalDeAlunos){
            return true;
        }
        return false;
        //ou utilizar outra maneira sem o if
        // return posicao >= 0 && posicao < this.totalDeAlunos
    }
    
    public void remove(int posicao){
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posicao Invalida!");
        }
        
        for (int i = posicao; i < this.totalDeAlunos - 1; i++) {
            this.alunos[i] = this.alunos[i+1];
        }
        
        this.totalDeAlunos--;
    }
    /*
    public boolean contem(Aluno aluno){
        for (int i = 0; i < this.alunos.length; i++) {
            if(aluno == this.alunos[i]){
                return true;
            }
        }
        return false;
    }
    */
    /*
        Neste método, se o aluno procurado for encontrado então o valor true é devolvido. Se a array acabar e o aluno
    não for encontrado, signifca que ele não está armazenado logo o método deve devolver falso. A capacidade
    do array é obtida pelo atributo length.
        O nosso método é inefciente quando a Lista tem poucos elementos. Perceba que ele sempre percorre o
    array todo. Não é necessário percorrer o array inteiro basta percorrer as posições ocupadas, ou seja, o laço
    tem que ir até a última posição ocupada. Nós podemos obter a última posição ocupada através do atributo
    totalDeAlunos.
    */
    public boolean contem(Aluno aluno){
        for (int i = 0; i < this.totalDeAlunos; i++) {
            if(aluno.equals(this.alunos[i])){
                return true;
            }
        }
        return false;
    }
    
    public int tamanho(){
        return this.totalDeAlunos;
    }
    
    public String toString(){
        if(this.totalDeAlunos == 0){
            return "[]";
        }
        
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        
        for (int i = 0; i < this.totalDeAlunos - 1; i++) {
            builder.append(this.alunos[i]);
            builder.append(", ");
        }
        
        builder.append(this.alunos[this.totalDeAlunos - 1]);
        builder.append("]");
        return builder.toString();
    }

}
