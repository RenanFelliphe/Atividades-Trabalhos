import java.io.File

const val bold = "\u001B[1m"
const val red = "\u001B[31m"
const val cyan = "\u001B[36m"
const val green = "\u001B[32m"
const val yellow = "\u001B[93m"
const val reset = "\u001B[0m"
var arquivo = File("Lista de Funcionários.txt")
var employee = Funcionario()
var list = mutableListOf(employee)

class Encerrar: Exception()

fun main() {
    try {
        abrirMenu(arquivo)
    } catch (ex: Encerrar) {
        println("""$bold$red 
            [ — O PROGRAMA FOI ENCERRADO COM SUCESSO — ]
            """)
    }}
fun abrirMenu(arquivo: File) {
    while (true) {
        println("\n$reset$bold  [ —$cyan MENU$reset INICIAL — ]")
        println("$cyan[1]$reset Registrar funcionário")
        println("$cyan[2]$reset Acessar todos registros")
        println("$red$bold[0]$reset Sair")

        when (readln().toIntOrNull() ?: continue) {
            1 -> registrarFuncionario()
            2 -> listarFuncionarios(arquivo)
            0 -> throw Encerrar()
            /*Opção inválida*/
            else -> {
                println("\n$reset$bold [ — $red INVÁLIDA$reset$bold — ]\n")
                println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
            }
        }
    }
}
fun registrarFuncionario(){
    val employee = Funcionario()
    employee.registrarFuncionario()
    list.add(employee)
}
fun listarFuncionarios(arquivo: File){
    /*Lista está vazia*/
    if(list.isEmpty()){
        println("\n$reset$bold [ — NÃO HÁ $red NENHUM $reset$bold FUNCIONÁRIO REGISTRADO — ]\n")
        println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
        abrirMenu(arquivo)
    }
    else {
    while(true){
        println("\n$reset$bold       [ —$cyan REGISTROS$reset DE FUNCIONÁRIOS — ]")
        /*Imprime todos funcionários registrados*/
        list.forEach {
            println("|$cyan$bold CÓDIGO — $reset${it.cod}" +
                    "|$cyan$bold NOME — $reset${it.nome} " +
                    "|$cyan$bold CARGO — $reset${it.cargo} " +
                    "|$cyan$bold SALÁRIO — $reset${it.salario}" +
                    "|$cyan$bold EMAIL — $reset${it.email}" +
                    "|$cyan$bold IDADE — $reset${it.idade}$cyan($reset${it.dataNascimento}$cyan)$reset")
        }

        println("\n   $green— >$reset Aperte$green$bold ENTER$reset para continuar!"); readln()

        println("$cyan[1]$reset Registrar um funcionário $reset")
        println("$cyan[2]$reset Selecionar um funcionário $reset")
        println("$cyan[3]$reset Contabilizar funcionários registrados $reset")
        println("$red$bold[0]$reset Voltar $reset")

        when(readln().toIntOrNull() ?: continue) {
            1 -> registrarFuncionario()
            2 -> selecionarFuncionario(arquivo)
            3 -> contabilizarRegistros(arquivo)
            0 -> abrirMenu(arquivo)
            else -> println("Opção inválida")
        }}
}
}
fun contabilizarRegistros(arquivo: File){
    /*Lista está vazia*/
    if(list.isEmpty()){
        println("\n$reset$bold [ — NÃO HÁ $red NENHUM $reset$bold FUNCIONÁRIO REGISTRADO — ]\n")
        println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
        abrirMenu(arquivo)
    }
    /*Lista possui conteúdo*/
    else{
        while(true){
            println("\n$reset$bold[ —$cyan QUANTIDADE$reset DE FUNCIONÁRIOS REGISTRADOS — ]")
            println(" >>>>>>>>>>>>>>>>>>>> $cyan" + list.size +" $reset<<<<<<<<<<<<<<<<<<<<")
            println("\n   $green— >$reset Aperte$green$bold ENTER$reset para continuar!"); readln()
            println("$cyan[1]$reset Registrar um funcionário")
            println("$cyan[2]$reset Selecionar um funcionário")
            println("$cyan[3]$reset Listar todos funcionários")
            println("$cyan[4]$reset Deletar todos registros")
            println("$red$bold[0]$reset Voltar ao menu")

            when(readln().toIntOrNull() ?: continue) {
                1 -> registrarFuncionario()
                2 -> selecionarFuncionario(arquivo)
                3 -> listarFuncionarios(arquivo)
                4 -> limparLista(arquivo)
                0 -> abrirMenu(arquivo)
                else -> println("Opção inválida")
            }}
    }
}
fun selecionarFuncionario(arquivo: File){
    /*Lista está vazia*/
    if(list.isEmpty()){
        println("\n$reset$bold [ — NÃO HÁ $red NENHUM $reset$bold FUNCIONÁRIO REGISTRADO — ]\n")
        println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
        abrirMenu(arquivo)
    }
    else {
    while(true){
        println("\n$reset$bold          [ —$cyan SELECIONAR$reset FUNCIONÁRIO — ]")
        println("Voltar ao menu $red$bold[0]$reset      $cyan$bold[1]$reset Listar todos funcionários")
        println("\n$green       — >$reset Digite o$green NOME$reset do funcionário")
        var nomePesquisado = readln()

        when(nomePesquisado) {
            "0" -> abrirMenu(arquivo)
            "1" -> listarFuncionarios(arquivo)
            /*Busca funcionário*/
            else -> {
                val funcionarioEncontrado = list.find{it.nome == nomePesquisado}
                /*Funcionário encontrado*/
                if (funcionarioEncontrado != null){
                    println("\n$reset$bold [ — O funcionário(a) $green\"$nomePesquisado\"$reset$bold foi selecionado com$green SUCESSO$reset$bold — ]\n")
                    println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!"); readln()

                    while(true){
                        println("|$cyan$bold CÓDIGO — $reset\"" + funcionarioEncontrado.cod +
                                "|$cyan$bold NOME — $reset" + funcionarioEncontrado.nome +
                                "|$cyan$bold CARGO — $reset" + funcionarioEncontrado.cargo +
                                "|$cyan$bold SALÁRIO — $reset" + funcionarioEncontrado.salario +
                                "|$cyan$bold EMAIL — $reset" + funcionarioEncontrado.email +
                                "|$cyan$bold IDADE — $reset" + funcionarioEncontrado.idade + "$cyan($reset" + funcionarioEncontrado.dataNascimento+ "$cyan)$reset" +
                                " |\n")

                        println("$cyan[1]$reset Corrigir 1 dado de \"$nomePesquisado\"")
                        println("$cyan[2]$reset Alterar todos os dados de \"$nomePesquisado\"")
                        println("$cyan[3]$reset Deletar \"$nomePesquisado\"")
                        println("$red$bold[0]$reset Voltar ao menu")

                        val opcaoMenu = readln().toIntOrNull() ?: continue

                        /*Opção selecionado*/
                        when(opcaoMenu) {
                            /*Corrigir 1 atributo*/
                            1 -> {

                                println("\n$reset$bold  [ —$cyan CORRIGIR$reset FUNCIONÁRIOS — ]")
                                println("|$cyan$bold CÓDIGO — $reset" + funcionarioEncontrado.cod +
                                        "|$cyan$bold NOME — $reset" + funcionarioEncontrado.nome +
                                        "|$cyan$bold CARGO — $reset" + funcionarioEncontrado.cargo +
                                        "|$cyan$bold SALÁRIO — $reset" + funcionarioEncontrado.salario +
                                        "|$cyan$bold EMAIL — $reset" + funcionarioEncontrado.email +
                                        "|$cyan$bold IDADE — $reset" + funcionarioEncontrado.idade + "$cyan($reset" + funcionarioEncontrado.dataNascimento+ "$cyan)$reset")


                                println("$green— >$reset Informe o dado que deseja alterar")

                                when(readln().lowercase()){
                                    "nome" ->  {
                                        println("$green— >$reset Digite o novo$green NOME$reset de \"" + funcionarioEncontrado.nome + "\"")
                                        val novoNome = readln()
                                        val nomeAntigo = funcionarioEncontrado.nome
                                        funcionarioEncontrado.nome = novoNome
                                        /*Nome válido*/
                                        while(true){
                                            println("\n$reset$bold         [ —$cyan CONFIRMAR$reset ALTERAÇÕES — ]")
                                            println("$green— >$reset Tem certeza que deseja mudar o$green NOME$reset de:")
                                            println("$green NOME$reset:  \"$red" + nomeAntigo + "$reset\"$green — — > $reset\"$cyan" + funcionarioEncontrado.nome + "$reset\"")
                                            println("      $cyan[1]$reset Sim   $yellow[2]$reset Corrigir    Não$red[3]$reset")

                                            /*Confirmar edição*/
                                            when(readln().toIntOrNull() ?: continue) {
                                                /*Confirmar edição*/
                                                1 -> {
                                                    funcionarioEncontrado.nome = novoNome
                                                    nomePesquisado = novoNome
                                                    println("\n$reset$bold [ — OPERAÇÃO$cyan REALIZADA$reset$bold COM SUCESSO — ]\n")
                                                    println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                                                    break
                                                }
                                                /*Corrigir edição*/
                                                2 -> {
                                                    funcionarioEncontrado.nome = nomeAntigo
                                                    break
                                                }
                                                /*Cancelar edição*/
                                                3 -> {
                                                    funcionarioEncontrado.nome = nomeAntigo
                                                    println("\n$reset$bold [ — OPERAÇÃO$red CANCELADA$reset$bold COM SUCESSO — ]\n")
                                                    println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                                                    return
                                                }
                                                /*Opção inválida*/
                                                else -> {
                                                    funcionarioEncontrado.nome = nomeAntigo
                                                    println("\n$reset$bold [ — OPÇÃO$red INVÁLIDA$reset$bold — ]\n")
                                                    println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                                                    listarFuncionarios(arquivo)
                                                    break
                                                }

                                            }
                                        }

                                    }
                                    "cargo" ->  {
                                        println("$green— >$reset Digite o novo$green CARGO$reset de \"" + funcionarioEncontrado.nome + "\"")
                                        val novoCargo = readln().lowercase()
                                        val cargoAntigo = funcionarioEncontrado.cargo
                                        funcionarioEncontrado.cargo = novoCargo
                                        /*Cargo válido*/
                                        while(true){
                                            println("\n$reset$bold         [ —$cyan CONFIRMAR$reset ALTERAÇÕES — ]")
                                            println("$green— >$reset Tem certeza que deseja mudar o$green CARGO$reset de:")
                                            println("$green CARGO$reset:  \"$red" + cargoAntigo + "$reset\"$green — — > $reset\"$cyan" + funcionarioEncontrado.cargo + "$reset\"")
                                            println("      $cyan[1]$reset Sim   $yellow[2]$reset Corrigir    Não$red[3]$reset")

                                            /*Confirmar edição*/
                                            when(readln().toIntOrNull() ?: continue) {
                                                /*Confirmar edição*/
                                                1 -> {
                                                    funcionarioEncontrado.cargo = novoCargo
                                                    println("\n$reset$bold [ — OPERAÇÃO$cyan REALIZADA$reset$bold COM SUCESSO — ]\n")
                                                    println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                                                    break
                                                }
                                                /*Corrigir edição*/
                                                2 -> {
                                                    funcionarioEncontrado.cargo = cargoAntigo
                                                    break
                                                }
                                                /*Cancelar edição*/
                                                3 -> {
                                                    funcionarioEncontrado.cargo = cargoAntigo
                                                    println("\n$reset$bold [ — OPERAÇÃO$red CANCELADA$reset$bold COM SUCESSO — ]\n")
                                                    println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                                                    return
                                                }
                                                /*Opção inválida*/
                                                else -> {
                                                    funcionarioEncontrado.cargo = cargoAntigo
                                                    println("\n$reset$bold [ — OPÇÃO$red INVÁLIDA$reset$bold — ]\n")
                                                    println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                                                    listarFuncionarios(arquivo)
                                                    break
                                                }
                                            }}
                                    }
                                    "salario" -> {
                                        println("$green— >$reset Digite o novo$green SALÁRIO$reset de \"" + funcionarioEncontrado.nome + "\"")
                                        val novoSalario = readln().toDoubleOrNull()
                                        /*Email válido*/
                                        if (novoSalario != null) {
                                            val salarioAntigo = funcionarioEncontrado.salario
                                            funcionarioEncontrado.salario = novoSalario

                                            /*Salário válido*/
                                            while(true){
                                                println("\n$reset$bold         [ —$cyan CONFIRMAR$reset ALTERAÇÕES — ]")
                                                println("$green— >$reset Tem certeza que deseja mudar o$green SALÁRIO$reset de:")
                                                println("$green SALÁRIO$reset:        \"$red" + salarioAntigo + "$reset\"$green — — > $reset\"$cyan" + funcionarioEncontrado.salario + "$reset\"")
                                                println("      $cyan[1]$reset Sim   $yellow[2]$reset Corrigir    Não$red[3]$reset")

                                                /*Confirmar edição*/
                                                when(readln().toIntOrNull() ?: continue) {
                                                    /*Confirmar edição*/
                                                    1 -> {
                                                        funcionarioEncontrado.salario = novoSalario
                                                        println("\n$reset$bold [ — OPERAÇÃO$cyan REALIZADA$reset$bold COM SUCESSO — ]\n")
                                                        println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                                                        break
                                                    }
                                                    /*Corrigir edição*/
                                                    2 -> {
                                                        funcionarioEncontrado.salario = salarioAntigo
                                                        break
                                                    }
                                                    /*Cancelar edição*/
                                                    3 -> {
                                                        funcionarioEncontrado.salario = salarioAntigo
                                                        println("\n$reset$bold [ — OPERAÇÃO$red CANCELADA$reset$bold COM SUCESSO — ]\n")
                                                        println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                                                        return
                                                    }
                                                    /*Opção inválida*/
                                                    else -> {
                                                        funcionarioEncontrado.salario = salarioAntigo
                                                        println("\n$reset$bold [ — OPÇÃO$red INVÁLIDA$reset$bold — ]\n")
                                                        println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                                                        listarFuncionarios(arquivo)
                                                        break
                                                    }

                                                }}}
                                        /*Opção inválida*/
                                        else {
                                            println("\n$reset$bold [ — VALOR$red INVÁLIDO$reset$bold — ]\n")
                                            println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                                        }
                                    }
                                    "email" ->{
                                        val emailAntigo = funcionarioEncontrado.email
                                        var novoEmail: String
                                        /*Verificação de validade do email*/
                                        do {
                                            println("$green— >$reset Digite o novo$green EMAIL$reset de \"" + funcionarioEncontrado.nome + "\"")
                                            novoEmail = readln()
                                            /*Email válido*/
                                            if(funcionarioEncontrado.regex.matches(novoEmail)){
                                                funcionarioEncontrado.email = novoEmail
                                                break
                                            /*Email inválido*/
                                            }
                                            else {
                                                println("\n$reset$bold [ — O EMAIL DIGITADO EMAIL NÃO É$red INVÁLIDO$reset$bold — ]\n")
                                                println("$green— > D I C A :$reset Um email deve conter os caracteres \"@\" e \".\"!")
                                                println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                                            }
                                        } while (true)
                                        /*Confirmar edição*/
                                        while(true){
                                            println("\n$reset$bold         [ —$cyan CONFIRMAR$reset ALTERAÇÕES — ]")
                                            println("$green— >$reset Tem certeza que deseja mudar o$green EMAIL$reset de:")
                                            println("$green EMAIL$reset:  \"$red" + emailAntigo + "$reset\"$green — — > $reset\"$cyan" + funcionarioEncontrado.email + "$reset\"")
                                            println("      $cyan[1]$reset Sim   $yellow[2]$reset Corrigir    Não$red[3]$reset")

                                            when(readln().toIntOrNull() ?: continue) {
                                                /*Confirmar edição*/
                                                1 -> {
                                                    funcionarioEncontrado.email = novoEmail
                                                    println("\n$reset$bold [ — OPERAÇÃO$cyan REALIZADA$reset$bold COM SUCESSO — ]\n")
                                                    println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                                                    break
                                                }
                                                /*Corrigir edição*/
                                                2 -> {
                                                    funcionarioEncontrado.email = emailAntigo
                                                    break
                                                }
                                                /*Cancelar edição*/
                                                3 -> {
                                                    funcionarioEncontrado.email = emailAntigo
                                                    println("\n$reset$bold [ — OPERAÇÃO$red CANCELADA$reset$bold COM SUCESSO — ]\n")
                                                    println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                                                    return
                                                }
                                                /*Opção inválida*/
                                                else -> {
                                                    funcionarioEncontrado.nome = emailAntigo
                                                    println("\n$reset$bold [ — OPÇÃO$red INVÁLIDA$reset$bold — ]\n")
                                                    println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                                                    listarFuncionarios(arquivo)
                                                    break
                                                }

                                            }}
                                    }
                                    "idade" -> {
                                        println("\n$reset$bold [ — A IDADE DE UM FUNCIONÁRIO$red NÃO PODE$reset$bold SER ALTERADA — ]\n")
                                        println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!"); readln()
                                    }
                                        "codigo" -> {
                                        println("\n$reset$bold [ — O CÓDIGO DE UM FUNCIONÁRIO$red NÃO PODE$reset$bold SER ALTERADO — ]\n")
                                        println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!"); readln()
                                    }
                                        "código" -> {
                                        println("\n$reset$bold [ — O CÓDIGO DE UM FUNCIONÁRIO$red NÃO PODE$reset$bold SER ALTERADO — ]\n")
                                        println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!"); readln()
                                    }
                                    else -> {
                                        println("\n$reset$bold [ — ATRIBUTO$red NÃO$reset$bold ENCONTRADO — ]\n")
                                        println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!"); readln()
                                    }
                                }}
                            /*Corrigir todos atributos*/
                            2 -> {
                                while(true){
                                    println("\n$reset$bold              [ —$cyan REESTABELECER $reset DADOS — ]")
                                    println("$green   — >$reset Deseja reestabelecer$green TODOS$reset os seguintes dados?")
                                    println("|$cyan$bold NOME — $reset" + funcionarioEncontrado.nome +
                                            "|$cyan$bold CARGO — $reset" + funcionarioEncontrado.cargo +
                                            "|$cyan$bold SALÁRIO — $reset" + funcionarioEncontrado.salario +
                                            "|$cyan$bold EMAIL — $reset" + funcionarioEncontrado.email + " |")
                                    println("                 Sim$cyan[1]$reset       $red[2]$reset Não")

                                    when(readln().toIntOrNull() ?: continue) {
                                        /*Confirmar edição*/
                                        1 -> {
                                            /*Nome*/
                                            println("$green— >$reset Digite o novo$green NOME$reset de \"" + funcionarioEncontrado.nome + "\"")
                                            val novoNome = readln()
                                            val nomeAntigo = funcionarioEncontrado.nome
                                            funcionarioEncontrado.nome = novoNome

                                            /*Cargo*/
                                            println("$green— >$reset Digite o novo$green CARGO$reset de \"" + funcionarioEncontrado.nome + "\"")
                                            val novoCargo = readln()
                                            val cargoAntigo = funcionarioEncontrado.cargo
                                            funcionarioEncontrado.cargo = novoCargo

                                            /*Salario*/
                                            println("$green— >$reset Digite o novo$green SALÁRIO$reset de \"" + funcionarioEncontrado.nome + "\"")
                                            val novoSalario = readln().toDoubleOrNull()
                                            val salarioAntigo = funcionarioEncontrado.salario
                                            funcionarioEncontrado.salario = novoSalario

                                            /*Email*/
                                            var novoEmail: String
                                            val emailAntigo = funcionarioEncontrado.email
                                            do {
                                                println("$green— >$reset Digite o novo$green EMAIL$reset de \"" + funcionarioEncontrado.nome + "\"")
                                                novoEmail = readln()
                                                /*Email válido*/
                                                if(funcionarioEncontrado.regex.matches(novoEmail)){
                                                    funcionarioEncontrado.email = novoEmail
                                                    break
                                                }
                                                /*Opção inválida*/
                                                else {
                                                    println("\n$reset$bold [ — O EMAIL DIGITADO EMAIL NÃO É$red INVÁLIDO$reset$bold — ]\n")
                                                    println("$green— > D I C A :$reset Um email deve conter os caracteres \"@\" e \".\"!")
                                                    println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                                                }
                                            } while (true)

                                            /*Confirmar alterações*/
                                            while(true){
                                                println("\n$reset$bold         [ —$cyan CONFIRMAR$reset ALTERAÇÕES — ]")
                                                println("$green— >$reset Tem certeza que deseja mudar o$green TODOS$reset os dados de:")
                                                println("         \"$red" + nomeAntigo + "$reset\"$green — — > $reset\"$cyan" + funcionarioEncontrado.nome + "$reset\"")
                                                println("         \"$red" + cargoAntigo + "$reset\"$green — — > $reset\"$cyan" + funcionarioEncontrado.cargo + "$reset\"")
                                                println("         \"$red" + salarioAntigo + "$reset\"$green — — > $reset\"$cyan" + funcionarioEncontrado.salario + "$reset\"")
                                                println("         \"$red" + emailAntigo + "$reset\"$green — — > $reset\"$cyan" + funcionarioEncontrado.email + "$reset\"")
                                                println("      $cyan[1]$reset Sim      Não$red[2]$reset")

                                                when(readln().toIntOrNull() ?: continue) {
                                                    /*Confirmar edição*/
                                                    1 -> {
                                                        println("\n$reset$bold [ — OPERAÇÃO REALIZADA$green COM SUCESSO — ]$reset\n")
                                                        println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                                                        listarFuncionarios(arquivo)
                                                    }
                                                    /*Cancelar edição*/
                                                    2 -> {
                                                        funcionarioEncontrado.nome = nomeAntigo
                                                        funcionarioEncontrado.cargo = cargoAntigo
                                                        funcionarioEncontrado.salario = salarioAntigo
                                                        funcionarioEncontrado.email = emailAntigo
                                                        println("\n$reset$bold [ — OPERAÇÃO$red CANCELADA$reset$bold COM SUCESSO — ]\n")
                                                        println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                                                        return
                                                    }
                                                    /*Opção inválida*/
                                                    else -> {
                                                        println("\n$reset$bold [ — OPÇÃO$red INVÁLIDA$reset$bold — ]\n")
                                                        println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                                                        listarFuncionarios(arquivo)
                                                    }
                                                }}
                                        }
                                        /*Cancelar edição*/
                                        2 -> {
                                            println("\n$reset$bold [ — OPERAÇÃO$red CANCELADA$reset$bold COM SUCESSO — ]\n")
                                            println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                                            return
                                        }
                                        /*Opção inválida*/
                                        else -> {
                                            println("\n$reset$bold [ — OPÇÃO$red INVÁLIDA$reset$bold — ]\n")
                                            println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                                        }
                                    }}}
                            /*Deletar o funcionário*/
                            3 -> {
                                while(true){
                                    println("\n$reset$bold                [ —$cyan DELETAR $reset FUNCIONÁRIO — ]")
                                    println("$green   — >$reset Tem certeza que deseja$red DELETAR PERMANENTEMENTE $reset esse registro?")
                                    println("$cyan  | Nome — $reset" + funcionarioEncontrado.nome + "$cyan | Cargo — $reset" + funcionarioEncontrado.cargo + "$cyan | Salário — $reset" + funcionarioEncontrado.salario + " |")
                                    println("                    Sim$cyan[1]$reset       $red[2]$reset Não")


                                    when(readln().toIntOrNull() ?: continue) {
                                        /*Deleta funcionário*/
                                        1 -> {
                                            val nomeAntigo = funcionarioEncontrado.nome
                                            list.remove(funcionarioEncontrado)
                                            println("\n$reset$bold [ — O FUNCIONÁRIO \"$nomeAntigo\"$red FOI DELETADO$reset$bold COM SUCESSO! — ]")
                                            println("$reset$bold [ — QUANTIDADE DE FUNCIONÁRIOS$green REGISTRADOS$reset$bold = $green" + list.size + "$reset$bold]\n")
                                            println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                                            listarFuncionarios(arquivo)
                                        }
                                        /*Cancelar operação*/
                                        2 -> {
                                            println("\n$reset$bold [ — OPERAÇÃO$red CANCELADA$reset$bold COM SUCESSO — ]\n")
                                            println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                                            return
                                        }
                                        /*Opção inválida*/
                                        else -> {
                                            println("\n$reset$bold [ — OPÇÃO$red INVÁLIDA$reset$bold — ]\n")
                                            println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                                        }
                                    }}}
                            /*Voltar pro menu*/
                            0 -> {
                                abrirMenu(arquivo)
                            }
                            /*Opção inválida*/
                            else -> {
                                println("\n$reset$bold [ — OPÇÃO$red INVÁLIDA$reset$bold — ]\n")
                                println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                            }
                        }
                    }
                }
                /*Funcionário não encontrado*/
                else {
                    println("\n$reset$bold [ — O funcionário(a) \"$nomePesquisado\"$red NÃO$reset$bold foi encontrado! — ]\n")
                    println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!"); readln()
                    selecionarFuncionario(arquivo)
                }
            }
        }}
}}
fun limparLista(arquivo: File){
    /*Lista está vazia*/
    if(list.isEmpty()){
        println("\n$reset$bold [ — NÃO HÁ $red NENHUM $reset$bold FUNCIONÁRIO REGISTRADO — ]\n")
        println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
        abrirMenu(arquivo)
    } else {
    while(true){
        println("\n$reset$bold              [ —$cyan APAGAR$reset REGISTROS — ]")
        println("$green— >$reset Tem certeza que deseja apagar$red TODOS$reset os registros?")
        println("                $cyan[1]$reset Sim     Não$red[2]$reset")

        val opcaoMenu = readln().toIntOrNull() ?: continue

        when(opcaoMenu) {
            /*Confirmar deleção*/
            1 -> {
                println("\n$reset$bold [ — QUANTIDADE DE REGISTROS A SEREM$green APAGADOS$reset$bold = $green" + list.size + "$reset$bold]")
                println("           $cyan[1]$reset Confirmar    Cancelar$red[2]$reset")
                when(readln().toIntOrNull() ?: continue) {
                    /*Confirmar deleção*/
                    1-> {
                        list.clear()
                        println("\n$reset$bold [ — TODOS OS REGISTROS FORAM$red APAGADOS$reset$bold COM$green SUCESSO$reset$bold — ]")
                        println("\n   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                        abrirMenu(arquivo)
                    }
                    /*Cancelar deleção*/
                    2 -> {
                            println("\n$reset$bold [ — OPERAÇÃO$red CANCELADA$reset$bold COM SUCESSO — ]\n")
                            println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                            abrirMenu(arquivo)
                        }
                    /*Opção inválida*/
                    else -> {
                        println("\n$reset$bold [ — OPÇÃO$red INVÁLIDA$reset$bold — ]\n")
                        println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                    }
                }
            }
            /*Cancelar deleção*/
            2 -> {
                println("\n$reset$bold [ — OPERAÇÃO$red CANCELADA$reset$bold COM SUCESSO — ]\n")
                println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                abrirMenu(arquivo)
            }
            /*Opção inválida*/
            else -> {
                println("\n$reset$bold [ — OPÇÃO$red INVÁLIDA$reset$bold — ]\n")
                println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
            }
        }}
}
}