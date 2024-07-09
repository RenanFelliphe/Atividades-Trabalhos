import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException


const val bold = "\u001B[1m"
const val red = "\u001B[31m"
const val cyan = "\u001B[36m"
const val green = "\u001B[32m"
const val yellow = "\u001B[93m"
const val reset = "\u001B[0m"
var employeeFile = File("Lista de Funcionários.txt")
var employeeObject = Employee()
var employeeList = mutableListOf(employeeObject)
lateinit var leitorDedocumento: BufferedReader
var linhaDodocumento: String? = null




class Encerrar: Exception()


fun main() {
    try {
        abrirMenu(employeeFile)
    } catch (ex: Encerrar) {
        println("""$bold$red
           [ — O PROGRAMA FOI ENCERRADO COM SUCESSO — ]
           """)
    }}
fun abrirMenu(employeeFile: File) {
    while (true) {
        println("\n$reset$bold  [ —$cyan MENU$reset INICIAL — ]")
        println("$cyan[1]$reset Registrar funcionário")
        println("$cyan[2]$reset Acessar todos registros")
        println("$red$bold[0]$reset Sair")


        when (readln().toIntOrNull() ?: continue) {
            1 -> registrarFuncionario()
            2 -> listarFuncionarios(employeeFile)
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
    val employee = Employee()
    employee.registrarFuncionario()
}
fun listarFuncionarios(employeeFile: File){
    /*Lista está vazia*/
    if(employeeList.isEmpty()){
        println("\n$reset$bold [ — NÃO HÁ $red NENHUM $reset$bold FUNCIONÁRIO REGISTRADO — ]\n")
        println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
        abrirMenu(employeeFile)
    }
    /*Lista possui conteúdo*/
    else {
        while(true){
            println("\n$reset$bold       [ —$cyan REGISTROS$reset DE FUNCIONÁRIOS — ]")
            /*Imprimido com sucesso*/
            try {
                FileReader(employeeFile).use { fileReader ->
                    leitorDedocumento = BufferedReader(fileReader)
                    linhaDodocumento = leitorDedocumento.readLine()
                    while (linhaDodocumento != null) {
                        println(linhaDodocumento)
                        linhaDodocumento = leitorDedocumento.readLine()
                    }
                }
            }
            /*Falha na impressão*/
            catch (e: IOException) {
                    println("\n$reset$bold [ — $red ERRO$reset$bold AO EXIBIR OS REGISTROS — ] ${e.message}\n")
                    println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                    abrirMenu(employeeFile)
            }


            println("\n   $green— >$reset Aperte$green$bold ENTER$reset para continuar!"); readln()


            println("$cyan[1]$reset Registrar um funcionário $reset")
            println("$cyan[2]$reset Selecionar um funcionário $reset")
            println("$cyan[3]$reset Contabilizar funcionários registrados $reset")
            println("$red$bold[0]$reset Voltar $reset")


            when(readln().toIntOrNull() ?: continue) {
                1 -> registrarFuncionario()
                2 -> selecionarFuncionario(employeeFile)
                3 -> contabilizarRegistros(employeeFile)
                0 -> abrirMenu(employeeFile)
                else -> {
                    println("\n$reset$bold [ — OPÇÃO$red INVÁLIDA$reset$bold — ]\n")
                    println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                }
            }}
    }
}
fun contabilizarRegistros(employeeFile: File){
    /*Lista está vazia*/
    if(employeeList.isEmpty()){
        println("\n$reset$bold [ — NÃO HÁ $red NENHUM $reset$bold FUNCIONÁRIO REGISTRADO — ]\n")
        println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
        abrirMenu(employeeFile)
    }
    /*Lista possui conteúdo*/
    else{
        while(true){
            println("\n$reset$bold[ —$cyan QUANTIDADE$reset DE FUNCIONÁRIOS REGISTRADOS — ]")
            println(" >>>>>>>>>>>>>>>>>>>> $cyan" + employeeList.size +" $reset<<<<<<<<<<<<<<<<<<<<")
            println("\n   $green— >$reset Aperte$green$bold ENTER$reset para continuar!"); readln()
            println("$cyan[1]$reset Registrar um funcionário")
            println("$cyan[2]$reset Selecionar um funcionário")
            println("$cyan[3]$reset Listar todos funcionários")
            println("$cyan[4]$reset Deletar todos registros")
            println("$red$bold[0]$reset Voltar ao menu")


            when(readln().toIntOrNull() ?: continue) {
                1 -> registrarFuncionario()
                2 -> selecionarFuncionario(employeeFile)
                3 -> listarFuncionarios(employeeFile)
                4 -> limparLista(employeeFile)
                0 -> abrirMenu(employeeFile)
                else -> println("Opção inválida")
            }}
    }
}
fun selecionarFuncionario(employeeFile: File){
    /*Lista está vazia*/
    if(employeeList.isEmpty()){
        employeeList.clear()
        println("\n$reset$bold [ — NÃO HÁ $red NENHUM $reset$bold FUNCIONÁRIO REGISTRADO — ]\n")
        println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
        abrirMenu(employeeFile)
    }
    /*Lista possui conteúdo*/
    else {
        while(true){
            println("\n$reset$bold          [ —$cyan SELECIONAR$reset FUNCIONÁRIO — ]")
            println("Voltar ao menu $red$bold[0]$reset      $cyan$bold[1]$reset Listar todos funcionários")
            println("\n$green       — >$reset Digite o$green NOME$reset do funcionário")
            var nomePesquisado = readln()

            when(nomePesquisado) {
                "0" -> abrirMenu(employeeFile)
                "1" -> listarFuncionarios(employeeFile)
                /*Busca funcionário*/
                else -> {
                    val funcionarioEncontrado = employeeList.find{it.getNome() == nomePesquisado}
                    /*Funcionário encontrado*/
                    if (funcionarioEncontrado != null){
                        println("\n$reset$bold [ — O funcionário(a) $green\"$nomePesquisado\"$reset$bold foi selecionado com$green SUCESSO$reset$bold — ]\n")
                        println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!"); readln()

                        while(true){
                            println("|$cyan$bold CÓDIGO — $reset\"" + funcionarioEncontrado.getCod() +
                                    "|$cyan$bold NOME — $reset" + funcionarioEncontrado.getNome() +
                                    "|$cyan$bold CARGO — $reset" + funcionarioEncontrado.getCargo() +
                                    "|$cyan$bold SALÁRIO — $reset" + funcionarioEncontrado.getSalario() +
                                    "|$cyan$bold EMAIL — $reset" + funcionarioEncontrado.getEmail() +
                                    "|$cyan$bold IDADE — $reset" + funcionarioEncontrado.getIdade() + "$cyan($reset" + funcionarioEncontrado.getDataNascimento()+ "$cyan)$reset" +
                                    " |\n")


                            println("$cyan[1]$reset Corrigir 1 dado de \"$nomePesquisado\"")
                            println("$cyan[2]$reset Alterar todos os dados de \"$nomePesquisado\"")
                            println("$cyan[3]$reset Deletar \"$nomePesquisado\"")
                            println("$red$bold[0]$reset Voltar ao menu")

                            /*Opção selecionado*/
                            when(readln().toIntOrNull() ?: continue) {
                                /*Corrigir 1 atributo*/
                                1 -> {


                                    println("\n$reset$bold  [ —$cyan CORRIGIR$reset FUNCIONÁRIOS — ]")
                                    println("|$cyan$bold CÓDIGO — $reset\"" + funcionarioEncontrado.getCod() +
                                            "|$cyan$bold NOME — $reset" + funcionarioEncontrado.getNome() +
                                            "|$cyan$bold CARGO — $reset" + funcionarioEncontrado.getCargo() +
                                            "|$cyan$bold SALÁRIO — $reset" + funcionarioEncontrado.getSalario() +
                                            "|$cyan$bold EMAIL — $reset" + funcionarioEncontrado.getEmail() +
                                            "|$cyan$bold IDADE — $reset" + funcionarioEncontrado.getIdade() + "$cyan($reset" + funcionarioEncontrado.getDataNascimento()+ "$cyan)$reset" +
                                            " |\n")

                                    println("$green— >$reset Informe o dado que deseja alterar")


                                    when(readln().lowercase()){
                                        "nome" -> {
                                            println("$green— >$reset Digite o novo$green NOME$reset de \"" + funcionarioEncontrado.getNome() + "\"")
                                            val novoNome = readln()
                                            val nomeAntigo = funcionarioEncontrado.getNome()
                                            funcionarioEncontrado.setNome(novoNome)
                                            /*Nome válido*/
                                            while(true){
                                                println("\n$reset$bold         [ —$cyan CONFIRMAR$reset ALTERAÇÕES — ]")
                                                println("$green— >$reset Tem certeza que deseja mudar o$green NOME$reset de:")
                                                println("$green NOME$reset:  \"$red" + nomeAntigo + "$reset\"$green — — > $reset\"$cyan" + funcionarioEncontrado.getNome() + "$reset\"")
                                                println("      $cyan[1]$reset Sim   $yellow[2]$reset Corrigir    Não$red[3]$reset")

                                                /*Confirmar edição*/
                                                when(readln().toIntOrNull() ?: continue) {
                                                    /*Confirmar edição*/
                                                    1 -> {
                                                        funcionarioEncontrado.setNome(novoNome)
                                                        nomePesquisado = novoNome
                                                        println("\n$reset$bold [ — OPERAÇÃO$cyan REALIZADA$reset$bold COM SUCESSO — ]\n")
                                                        println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                                                        break
                                                    }
                                                    /*Corrigir edição*/
                                                    2 -> {
                                                        funcionarioEncontrado.setNome(nomeAntigo)
                                                        break
                                                    }
                                                    /*Cancelar edição*/
                                                    3 -> {
                                                        funcionarioEncontrado.setNome(nomeAntigo)
                                                        println("\n$reset$bold [ — OPERAÇÃO$red CANCELADA$reset$bold COM SUCESSO — ]\n")
                                                        println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                                                        return
                                                    }
                                                    /*Opção inválida*/
                                                    else -> {
                                                        funcionarioEncontrado.setNome(nomeAntigo)
                                                        println("\n$reset$bold [ — OPÇÃO$red INVÁLIDA$reset$bold — ]\n")
                                                        println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                                                        listarFuncionarios(employeeFile)
                                                        break
                                                    }
                                                }
                                            }
                                        }
                                        "cargo" -> {
                                            println("$green— >$reset Digite o novo$green CARGO$reset de \"" + funcionarioEncontrado.getNome() + "\"")
                                            val novoCargo = readln().lowercase()
                                            val cargoAntigo = funcionarioEncontrado.getCargo()
                                            funcionarioEncontrado.setCargo(novoCargo)
                                            /*Cargo válido*/
                                            while(true){
                                                println("\n$reset$bold         [ —$cyan CONFIRMAR$reset ALTERAÇÕES — ]")
                                                println("$green— >$reset Tem certeza que deseja mudar o$green CARGO$reset de:")
                                                println("$green CARGO$reset:  \"$red" + cargoAntigo + "$reset\"$green — — > $reset\"$cyan" + funcionarioEncontrado.getCargo() + "$reset\"")
                                                println("      $cyan[1]$reset Sim   $yellow[2]$reset Corrigir    Não$red[3]$reset")

                                                /*Confirmar edição*/
                                                when(readln().toIntOrNull() ?: continue) {
                                                    /*Confirmar edição*/
                                                    1 -> {
                                                        funcionarioEncontrado.setCargo(novoCargo)
                                                        println("\n$reset$bold [ — OPERAÇÃO$cyan REALIZADA$reset$bold COM SUCESSO — ]\n")
                                                        println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                                                        break
                                                    }
                                                    /*Corrigir edição*/
                                                    2 -> {
                                                        funcionarioEncontrado.setCargo(cargoAntigo)
                                                        break
                                                    }
                                                    /*Cancelar edição*/
                                                    3 -> {
                                                        funcionarioEncontrado.setCargo(cargoAntigo)
                                                        println("\n$reset$bold [ — OPERAÇÃO$red CANCELADA$reset$bold COM SUCESSO — ]\n")
                                                        println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                                                        return
                                                    }
                                                    /*Opção inválida*/
                                                    else -> {
                                                        funcionarioEncontrado.setCargo(cargoAntigo)
                                                        println("\n$reset$bold [ — OPÇÃO$red INVÁLIDA$reset$bold — ]\n")
                                                        println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                                                        listarFuncionarios(employeeFile)
                                                        break
                                                    }
                                                }
                                            }
                                        }
                                    }}
                                /*Corrigir todos atributos*/
                                2 -> {
                                    while (true) {
                                        println("\n$reset$bold              [ —$cyan REESTABELECER $reset DADOS — ]")
                                        println("$green   — >$reset Deseja reestabelecer$green TODOS$reset os seguintes dados?")
                                        println("|$cyan$bold NOME — $reset${funcionarioEncontrado.getNome()}" +
                                                "|$cyan$bold CARGO — $reset${funcionarioEncontrado.getCargo()}" +
                                                "|$cyan$bold SALÁRIO — $reset${funcionarioEncontrado.getSalario()}" +
                                                "|$cyan$bold EMAIL — $reset${funcionarioEncontrado.getEmail()} |")
                                        println("                 Sim$cyan[1]$reset       $red[2]$reset Não")

                                        when (readln().toIntOrNull() ?: continue) {
                                            /*Confirmar edição*/
                                            1 -> {
                                                /*Nome*/
                                                println("$green— >$reset Digite o novo$green NOME$reset de \"${funcionarioEncontrado.getNome()}\"")
                                                val novoNome = readln()
                                                val nomeAntigo = funcionarioEncontrado.getNome()
                                                funcionarioEncontrado.setNome(novoNome)

                                                /*Cargo*/
                                                println("$green— >$reset Digite o novo$green CARGO$reset de \"${funcionarioEncontrado.getNome()}\"")
                                                val novoCargo = readln()
                                                val cargoAntigo = funcionarioEncontrado.getCargo()
                                                funcionarioEncontrado.setCargo(novoCargo)

                                                /*Salario*/
                                                println("$green— >$reset Digite o novo$green SALÁRIO$reset de \"${funcionarioEncontrado.getNome()}\"")
                                                val novoSalario = readln().toDoubleOrNull()
                                                val salarioAntigo = funcionarioEncontrado.getSalario()
                                                if (novoSalario != null) {
                                                    funcionarioEncontrado.setSalario(novoSalario)
                                                }

                                                /*Email*/
                                                var novoEmail: String
                                                val emailAntigo = funcionarioEncontrado.getEmail()
                                                do {
                                                    println("$green— >$reset Digite o novo$green EMAIL$reset de \"${funcionarioEncontrado.getNome()}\"")
                                                    novoEmail = readln()
                                                    /*Email válido*/
                                                    if (funcionarioEncontrado.regex.matches(novoEmail)) {
                                                        funcionarioEncontrado.setEmail(novoEmail)
                                                        break
                                                    }
                                                    /*Opção inválida*/
                                                    else {
                                                        println("\n$reset$bold [ — O EMAIL DIGITADO EMAIL NÃO É$red INVÁLIDO$reset$bold — ]\n")
                                                        println("$green— > D I C A :$reset Um email deve conter os caracteres \"@\" e \".\"!")
                                                        println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n")
                                                        readln()
                                                    }
                                                } while (true)

                                                /*Confirmar alterações*/
                                                while (true) {
                                                    println("\n$reset$bold         [ —$cyan CONFIRMAR$reset ALTERAÇÕES — ]")
                                                    println("$green— >$reset Tem certeza que deseja mudar o$green TODOS$reset os dados de:")
                                                    println("         \"$red$nomeAntigo$reset\"$green — — > $reset\"$cyan${funcionarioEncontrado.getNome()}$reset\"")
                                                    println("         \"$red$cargoAntigo$reset\"$green — — > $reset\"$cyan${funcionarioEncontrado.getCargo()}$reset\"")
                                                    println("         \"$red$salarioAntigo$reset\"$green — — > $reset\"$cyan${funcionarioEncontrado.getSalario()}$reset\"")
                                                    println("         \"$red$emailAntigo$reset\"$green — — > $reset\"$cyan${funcionarioEncontrado.getEmail()}$reset\"")
                                                    println("      $cyan[1]$reset Sim      Não$red[2]$reset")

                                                    when (readln().toIntOrNull() ?: continue) {
                                                        /*Confirmar edição*/
                                                        1 -> {
                                                            println("\n$reset$bold [ — OPERAÇÃO REALIZADA$green COM SUCESSO — ]$reset\n")
                                                            println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n")
                                                            readln()
                                                            listarFuncionarios(employeeFile)
                                                        }
                                                        /*Cancelar edição*/
                                                        2 -> {
                                                            funcionarioEncontrado.setNome(nomeAntigo)
                                                            funcionarioEncontrado.setCargo(cargoAntigo)
                                                            funcionarioEncontrado.setSalario(salarioAntigo)
                                                            funcionarioEncontrado.setEmail(emailAntigo)
                                                            println("\n$reset$bold [ — OPERAÇÃO$red CANCELADA$reset$bold COM SUCESSO — ]\n")
                                                            println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n")
                                                            readln()
                                                            return
                                                        }
                                                        /*Opção inválida*/
                                                        else -> {
                                                            println("\n$reset$bold [ — OPÇÃO$red INVÁLIDA$reset$bold — ]\n")
                                                            println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n")
                                                            readln()
                                                            listarFuncionarios(employeeFile)
                                                        }
                                                    }
                                                }
                                            }
                                            /*Cancelar edição*/
                                            2 -> {
                                                println("\n$reset$bold [ — OPERAÇÃO$red CANCELADA$reset$bold COM SUCESSO — ]\n")
                                                println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n")
                                                readln()
                                                return
                                            }
                                            /*Opção inválida*/
                                            else -> {
                                                println("\n$reset$bold [ — OPÇÃO$red INVÁLIDA$reset$bold — ]\n")
                                                println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n")
                                                readln()
                                            }
                                        }
                                    }
                                }
                                /*Deletar o funcionário*/
                                3 -> {
                                    while(true){
                                        println("\n$reset$bold                [ —$cyan DELETAR $reset FUNCIONÁRIO — ]")
                                        println("$green   — >$reset Tem certeza que deseja$red DELETAR PERMANENTEMENTE $reset esse registro?")
                                        println("$cyan  | Nome — $reset" + funcionarioEncontrado.getNome() + "$cyan | Cargo — $reset" + funcionarioEncontrado.getCargo() + "$cyan | Salário — $reset" + funcionarioEncontrado.getSalario() + " |")
                                        println("                    Sim$cyan[1]$reset       $red[2]$reset Não")

                                        when (readln().toIntOrNull() ?: continue) {
                                            /*Deleta funcionário*/
                                            1 -> {
                                                val nomeAntigo = funcionarioEncontrado.getNome()
                                                employeeList.remove(funcionarioEncontrado)
                                                println("\n$reset$bold [ — O FUNCIONÁRIO \"$nomeAntigo\"$red FOI DELETADO$reset$bold COM SUCESSO! — ]")
                                                println("$reset$bold [ — QUANTIDADE DE FUNCIONÁRIOS$green REGISTRADOS$reset$bold = $green${employeeList.size}$reset$bold]\n")
                                                println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n")
                                                readln()
                                                listarFuncionarios(employeeFile)
                                            }
                                            /*Cancelar operação*/
                                            2 -> {
                                                println("\n$reset$bold [ — OPERAÇÃO$red CANCELADA$reset$bold COM SUCESSO — ]\n")
                                                println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n")
                                                readln()
                                                return
                                            }
                                            /*Opção inválida*/
                                            else -> {
                                                println("\n$reset$bold [ — OPÇÃO$red INVÁLIDA$reset$bold — ]\n")
                                                println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n")
                                                readln()
                                            }
                                        }}}
                                /*Voltar pro menu*/
                                0 -> {
                                    abrirMenu(employeeFile)
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
                        selecionarFuncionario(employeeFile)
                    }
                }
            }}
    }}
fun limparLista(employeeFile: File){
    /*Lista está vazia*/
    if(employeeList.isEmpty()){
        println("\n$reset$bold [ — NÃO HÁ $red NENHUM $reset$bold FUNCIONÁRIO REGISTRADO — ]\n")
        println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
        abrirMenu(employeeFile)
    }
    /*Lista possui conteúdo*/
    else {
        while(true){
            println("\n$reset$bold              [ —$cyan APAGAR$reset REGISTROS — ]")
            println("$green— >$reset Tem certeza que deseja apagar$red TODOS$reset os registros?")
            println("                $cyan[1]$reset Sim     Não$red[2]$reset")


            when(readln().toIntOrNull() ?: continue) {
                /*Confirmar deleção*/
                1 -> {
                    println("\n$reset$bold [ — QUANTIDADE DE REGISTROS A SEREM$green APAGADOS$reset$bold = $green" + employeeList.size + "$reset$bold]")
                    println("           $cyan[1]$reset Confirmar    Cancelar$red[2]$reset")
                    when(readln().toIntOrNull() ?: continue) {
                        /*Confirmar deleção*/
                        1-> {
                            employeeList.clear()
                            employeeFile.writeText("")
                            println("\n$reset$bold[ — TODOS OS REGISTROS FORAM$red APAGADOS$reset$bold COM$green SUCESSO$reset$bold — ]")
                            println("\n   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                            abrirMenu(employeeFile)
                        }
                        /*Cancelar deleção*/
                        2 -> {
                            println("\n$reset$bold [ — OPERAÇÃO$red CANCELADA$reset$bold COM SUCESSO — ]\n")
                            println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                            abrirMenu(employeeFile)
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
                    abrirMenu(employeeFile)
                }
                /*Opção inválida*/
                else -> {
                    println("\n$reset$bold [ — OPÇÃO$red INVÁLIDA$reset$bold — ]\n")
                    println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                }
            }}
    }
}



