import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Funcionario() {

    var nome: String? = "Indefinido"
    var cargo: String? = "Indefinido"
    var salario: Double? = 0.0
    var cod: Int? = 1
    var email: String? = "Indefinido"
    val regex = Regex("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")
    var registrado: Boolean? = false
    var idade: Int? = 0
    var dataNascimento: LocalDate? = null
    val formatter: DateTimeFormatter? = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    val bold = "\u001B[1m"
    val red = "\u001B[31m"
    val cyan = "\u001B[36m"
    val reset = "\u001B[0m"
    val green = "\u001B[32m"

    fun registrarFuncionario() {
        println("\n$reset$bold  [ —$cyan REGISTRAR$reset FUNCIONÁRIOS — ]")
        println("$green— >$reset Digite o$green NOME$reset do funcionário")
        nome = readln()
        println("\n$green— >$reset Digite o$green CARGO$reset do funcionário")
        cargo = readln().lowercase()
        /*Digite o salário do funcionário*/
        println("\n$green— >$reset Digite o$green SALÁRIO$reset do funcionário")
        salario = readln().toDouble()
        /*Digite o email do funcionário*/
        do {
            println("\n$green— >$reset Digite o$green EMAIL$reset do funcionário")
            val emailInserido = readln()
            if (regex.matches(emailInserido)) {
                email = emailInserido
                break
            }
            else {
                println("\n$reset$bold      [ — O EMAIL DIGITADO EMAIL NÃO É$red INVÁLIDO$reset$bold — ]\n")
                println("$green— > D I C A :$reset Um email DEVE conter os caracteres $green\"$reset@$green\"$reset e $green\"$reset.$green\"$reset!")
                println("   $green      — >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
            }

        } while (true)
        /*Calcular idade do usuário com base na data de nascimento*/
        do {
            println("\n$green—>$reset Digite a$green DATA DE NASCIMENTO$reset do funcionário $green(Formato: DD/MM/AAAA)$reset")
            val dataRecebida = readln()
            dataNascimento = try {
                LocalDate.parse(dataRecebida, formatter)
            } catch (e: Exception) {
                null
            }

            idade = LocalDate.now().year - dataNascimento!!.year //Calcula a idade com base na data fornecida e na data atual

            /*Verifica se a data de nascimento é maior que a data atual*/
            if (dataNascimento != null && dataNascimento!!.year > LocalDate.now().year) {
                println("\n$reset$bold          [ — DATA DE NASCIMENTO $red INVÁLIDA$reset$bold — ]\n")
                println("$green— > D I C A :$reset O ano de nascimento$red$bold NÃO PODE$reset ser maior do que $bold$red${LocalDate.now().year}$reset")
                println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n"); readln()
                dataNascimento = null
            }
            if (dataNascimento != null && dataNascimento!!.year < (LocalDate.now().year - 100)) {
                println("\n$reset$bold          [ — DATA DE NASCIMENTO $red INVÁLIDA$reset$bold — ]\n")
                println("$green— > D I C A :$reset Sua idade$red$bold NÃO PODE$reset ser maior do que$red 120 anos$reset")
                println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n"); readln()
                dataNascimento = null
            }
        } while (dataNascimento == null)

        /*Calcular Id se a lista não for vazia*/
        cod = if (list.isNotEmpty()) {
            list.last().cod?.plus(1)
        }
        /*Calcular Id se a lista for vazia*/
        else{
            1
        }
        /*Menu de confirmação de registro*/
        while (true) {
            /*Impressão da confirmação*/
            println("""
                    |
                    |
                    |$reset$bold[ —$cyan CONFIRMAR$reset REGISTRO — ]
                    |$cyan | CÓDIGO — $reset$cod
                    |$cyan | NOME — $reset$nome
                    |$cyan | CARGO — $reset$cargo
                    |$cyan | SALÁRIO — $reset R${'$'}$salario
                    |$cyan | EMAIL — $reset$email         
                    |$cyan | IDADE — $reset$idade$cyan ($reset$dataNascimento$cyan)$reset
                    |
                    |$cyan[1]$reset Sim       Não$red[2]$reset
                    """.trimMargin("|"))

            when (readln().toIntOrNull() ?: continue) {
                /*Confirmar operação*/
                1 -> {
                    arquivo.appendText("| $cod | $nome |  $cargo |  $salario |  $email |  $idade |\n")

                    println("\n$reset$bold [ — FUNCIONÁRIO REGISTRADO COM$green SUCESSO$reset$bold — ]")
                    println("$reset$bold [ — QUANTIDADE DE FUNCIONÁRIOS$green REGISTRADOS$reset$bold = $green" + list.size.plus(1) + "$reset$bold]\n")
                    println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                        registrado = true
                    break
                }
                /*Cancelar operação*/
                else -> {
                    println("\n$reset$bold [ — OPERAÇÃO$red CANCELADA$reset$bold COM SUCESSO — ]\n")
                    println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n"); readln()
                    abrirMenu(arquivo)
                }
            }
        }

    }

    }
