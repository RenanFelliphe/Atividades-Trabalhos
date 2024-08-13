#include <iostream> //Include Input and Output (IO)Stream
#include <fstream> //Include File (F)Stream

using namespace std;

int main(){

    ifstream fin("numeros.txt"); //Cria um objeto de entrada(Istream) chamado fin que contem o arquivo txt numeros.txt


    /*if(fin.is.open()){ //Lê todos os caracteres do arquivo com mudança de linha
        cout << "Arquivo aberto";

        string linha;

        while(getline(fin, linha)){
            cout << linha << " "; //Imprime os caracteres lidos com as quebras de linhas existentes
            cout << endln;
        }
        
        fin.close(); //Fecha o arquivo numeros.txt | O arquivo sempre deve ser fechado após a execução

    } else {
        cerr << "Erro ao abrir o arquivo"; //cerr = C-Error | Try Catch | Throw de mensagens* de erro
    }*/

    /*if(fin.is.open()){ //Imprime um caractere (O primeiro)
        cout << "Arquivo aberto";

        int num;

        fin >> num; //Le o primeiro caractere dentro no arquivo numeros.txt e armazena na variável num

        cout << num << endl; //Imprime o caractere lido

        fin.close(); //Fecha o arquivo numeros.txt | O arquivo sempre deve ser fechado após a execução

    } else {
        cerr << "Erro ao abrir o arquivo"; //cerr = C-Error | Try Catch | Throw de mensagens* de erro
    }*/

    /*if(fin.is.open()){ //Lê todos os caracteres do arquivo
        cout << "Arquivo aberto";
        
        int num;

        while(fin >> num){
            cout << num << " "; //Imprime os caracteres lidos
            cout << endln;
        }
        
        fin.close(); //Fecha o arquivo numeros.txt | O arquivo sempre deve ser fechado após a execução

    } else {
        cerr << "Erro ao abrir o arquivo"; //cerr = C-Error | Try Catch | Throw de mensagens* de erro
    }*/

    return 0;
}