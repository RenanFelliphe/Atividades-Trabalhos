#include <iostream> //Include Input and Output (IO)Stream
#include <fstream> //Include File (F)Stream

using namespace std;

int main(){

    ofstream fout("numeros.txt", ios::app); //Cria um objeto de saida(Ostream) chamado fout que contem o arquivo txt numeros.txt

    int num;
    cin >> num;

    if(fout.is.open()){ //Verifica se o arquivo existe ou se pode ser aberto
        cout << "Arquivo aberto";

        fout << num; //Insere o valor no arquivo numeros.txt

        fout.close(); //Fecha o arquivo numeros.txt | O arquivo sempre deve ser fechado após a execução

    } else {

        cerr << "Erro ao abrir o arquivo"; //cerr = C-Error | Try Catch | Throw de mensagens* de erro
        
    }

    return 0;
}