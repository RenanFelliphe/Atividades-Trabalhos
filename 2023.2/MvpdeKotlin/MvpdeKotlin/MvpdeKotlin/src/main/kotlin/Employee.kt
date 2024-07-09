import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Employee {
    private var nome: String = "Indefinido"
    private var cargo: String = "Indefinido"
    private var salario: Double = 0.0
    private var cod: Int = 1
    private var email: String = "Indefinido"
    private var idade: Int = 0
    private var dataNascimento: LocalDate? = null
    val regex = Regex("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")
    private val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    val bold = "\u001B[1m"
    val red = "\u001B[31m"
    val cyan = "\u001B[36m"
    val reset = "\u001B[0m"
    val green = "\u001B[32m"

    fun registrarFuncionario() {
        println("\n$reset$bold          [ —$cyan REGISTRAR$reset FUNCIONÁRIO — ]")
        println("$green$bold— >$reset Digite o$green$bold NOME$reset do funcionário")
        nome = readln()
        println("$green$bold— >$reset Digite o$green$bold CARGO$reset do funcionário")
        cargo = readln().lowercase()
        println("$green$bold— >$reset Digite o$green$bold SALARIO$reset do funcionário")
        salario = readln().toDouble()

        println("$green$bold— >$reset Deseja registrar o$green$bold EMAIL$reset do funcionário?")
        println("               $cyan[1]$reset SIM   $red[2] NÃO$reset")

        when (readln().toIntOrNull()) {
            1 -> {
                do {
                    println("$green$bold— >$reset Digite o$green$bold EMAIL$reset do funcionário")
                    val emailInserido = readln()
                    if (emailInserido.let { regex.matches(it) }) {
                        email = emailInserido
                        break
                    } else {
                        println("\n$reset$bold      [ — O EMAIL DIGITADO EMAIL NÃO É$red VÁLIDO$reset$bold — ]\n")
                        println("$green— > D I C A :$reset Um email DEVE conter os caracteres $green\"$reset@$green\"$reset e $green\"$reset.$green\"$reset!")
                        println("   $green      — >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
                    }
                } while (true)
            }
            2 -> {

            }
            else -> {
                println("\n$reset$bold [ — OPÇÃO$red INVÁLIDA$reset$bold — ]\n")
                println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n"); readln()
            }
        }

        while (dataNascimento == null) {
            println("\n$green$bold— >$reset Digite$green$bold DATA DE NASCIMENTO$reset do funcionário? (Formato: DD/MM/AAAA)")
            val dataRecebida = readln()

            dataNascimento = try {
                LocalDate.parse(dataRecebida, formatter)
            } catch (e: Exception) {
                null
            }

            if (dataNascimento != null) {
                idade = LocalDate.now().year - dataNascimento!!.year
                if (dataNascimento!!.monthValue > 12 || dataNascimento!!.dayOfMonth < 1 ||
                    dataNascimento!!.year > LocalDate.now().year || idade > 120
                ) {
                    println("\n$reset$bold [ — DATA DE NASCIMENTO$red INVÁLIDA$reset$bold — ]\n")
                    when {
                        dataNascimento!!.monthValue > 12 || dataNascimento!!.monthValue < 1 -> {
                            println("\n$reset$bold [ — DATA DE NASCIMENTO$red INVÁLIDA$reset$bold — ]\n")
                            println("   $green— >$reset O $red MÊS DE NASCIMENTO$reset não pode ser menor que$red 1$reset ou maior que$red 12 MESES$reset")
                        }
                        dataNascimento!!.dayOfMonth < 1 -> {
                            println("\n$reset$bold [ — DATA DE NASCIMENTO$red INVÁLIDA$reset$bold — ]\n")
                            println("   $green— >$reset O $red DIA DE NASCIMENTO$reset não pode ser menor que$red 1 DIA$reset")
                        }
                        dataNascimento!!.year > LocalDate.now().year -> {
                            println("\n$reset$bold [ — DATA DE NASCIMENTO$red INVÁLIDA$reset$bold — ]\n")
                            println("   $green— >$reset O $red ANO DE NASCIMENTO$reset não pode ser maior que $reset${LocalDate.now().year} ANOS $reset")
                        }
                        else -> {
                            println("\n$reset$bold [ — DATA DE NASCIMENTO$red INVÁLIDA$reset$bold — ]\n")
                            println("   $green— >$reset A $red IDADE$reset não pode ser maior que$red 120 ANOS$reset")
                    }}
                    println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n"); readln()
                    readln()
                    dataNascimento = null
                }
            } else {
                println("\n$reset$bold [ — DATA DE NASCIMENTO$red INVÁLIDA$reset$bold — ]\n")
                println("   $green— > D I C A :$reset Aperte$green$bold ENTER$reset para continuar!\n")
                println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n"); readln()
            }
        }

        cod = employeeList.lastOrNull()?.cod?.plus(1) ?: 1

        val dataNascimentoFormatada = dataNascimento!!.format(formatter)
        println(
            """
            |
            |
            |[CONFIRMAR REGISTRO]
            |CÓDIGO — $cod
            |NOME — $nome
            |CARGO — $cargo
            |SALÁRIO — R$$salario
            |EMAIL — $email
            |IDADE — $idade ($dataNascimentoFormatada)
            |
            |[1] Sim       Não [2]
            """.trimMargin("|"))

        when (readln().toIntOrNull() ?: 2) {
            1 -> {
                employeeFile.appendText("| $cod | $nome |  $cargo |  $salario |  $email |  $idade |\n")
                employeeList.add(employeeObject)
                println("\n$reset$bold [ — OPERAÇÃO$cyan REALIZADA$reset$bold COM SUCESSO — ]\n")
                println("$reset$bold [ — QUANTIDADE DE FUNCIONÁRIOS$green REGISTRADOS$reset$bold = $green" + employeeList.size.plus(1) + "$reset$bold]\n")
                println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n\n"); readln()
            }
            else -> {
                println("\n$reset$bold [ — OPERAÇÃO$red CANCELADA$reset$bold — ]\n")
                println("   $green— >$reset Aperte$green$bold ENTER$reset para continuar!\n"); readln()
                abrirMenu(employeeFile)
            }
        }
    }

    fun getNome(): String {
        return nome
    }

    fun setNome(nome: String) {
        this.nome = nome
    }

    fun getCargo(): String {
        return cargo
    }

    fun setCargo(cargo: String) {
        this.cargo = cargo
    }

    fun getSalario(): Double {
        return salario
    }

    fun setSalario(salario: Double) {
        this.salario = salario
    }

    fun getCod(): Int {
        return cod
    }

    fun getEmail(): String {
        return email
    }

    fun setEmail(email: String) {
        this.email = email
    }

    fun getIdade(): Int {
        return idade
    }

    fun getDataNascimento(): LocalDate? {
        return dataNascimento
    }
}
