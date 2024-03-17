
<!--
    CREATE TABLE Usuario(
	nomeUsuario VARCHAR(50) NOT NULL,
    emailUsuario VARCHAR(100) NOT NULL,
    senhaUsuario VARCHAR(50) NOT NULL,
    
    CONSTRAINT PK_Usuario PRIMARY KEY(emailUsuario)
);
    SELECT * FROM usuario;
    DELETE FROM usuario;
-->

<?php
    $dbHost = 'LocalHost';
    $dbUsername = 'root';
    $dbPassword = 'MyRoot123456';
    $dbName = 'lsrc';

    $conexao = new mysqli($dbHost, $dbUsername, $dbPassword, $dbName);
    
    

    if(isset($_POST['registrar']) && !empty($_POST['name']) && !empty($_POST['email']) && !empty($_POST['password'])){
        $nomeUsuario = $_POST['name'];
        $emailUsuario = $_POST['email'];
        $senhaUsuario = $_POST['password'];

        $INSERT_INTO = mysqli_query($conexao, "INSERT INTO usuario VALUES ('$nomeUsuario','$emailUsuario','$senhaUsuario')");
    }

    if(isset($_POST['logar']) && !empty($_POST['email']) && !empty($_POST['password'])){
        $nomeUsuario = $_POST['name'];
        $emailUsuario = $_POST['email'];
        $senhaUsuario = $_POST['password'];

        $SELECT_USER_NAME = "SELECT * FROM usuario WHERE emailUsuario = '$emailUsuario' AND senhaUsuario = '$senhaUsuario'";

        $result = $conexao->query($SELECT_USER_NAME);

        if(mysqli_num_rows($result) < 1){
            echo "<span> Este usuario <strong> NÃO EXISTE </strong> </span>";
        } else {
            $row = $result->fetch_assoc();
            $nomeUsuario = $row['nomeUsuario'];
            echo "<span>Seja Bem Vindo(a): <strong>$nomeUsuario</strong></span>";        
        }
    }
?>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Formulário LSRC</title>
        <link rel="stylesheet" href="style.css">
        <style>
            @import url('https://fonts.googleapis.com/css?family=Fjalla+One&display=swap');
            * {
                margin: 0 AUTO;
                padding: 0;
            }

            span{
                font-weight: 500;
                font-family: var(--font-face);
                letter-spacing: 1px;
                background-color: var(--form-shadow);
                border: 2px solid black;
                padding: 0.4rem 1rem 0.4rem 1rem;
                border-bottom-left-radius: 0.9rem;
                border-bottom-right-radius: 0.9rem;
                font-size: 0.9rem;
            }

            span strong{
                color: black;
                text-decoration: underline;
            }

            :root {
                --bg: url("https://s3-us-west-2.amazonaws.com/s.cdpn.io/38816/image-from-rawpixel-id-2210775-jpeg.jpg");
                --form-bg: #f8f4e5;
                --form-shadow: #ffa580;
                --form-primary-highlight: #95a4ff;
                --form-secondary-highlight: #ffc8ff;
                --font-size: 14pt;
                --font-face: 'Fjalla One';
                --font-color: #2A293E;
            }

            body {
                background: var(--bg) center center no-repeat;
                background-size: cover;
                width: 100vw;
                height: 100vh;
                display: grid;
                align-items: center;
                justify-items: center;
            }

            form {
                text-align: center;
                background: var(--form-bg);
                height: 20.5rem;
                width: 16rem;
                padding: 50px 100px 70px 100px;
                border: 2px solid black;
                border-radius: 5px;
                box-shadow: 15px 15px 1px var(--form-shadow), 15px 15px 1px 2px black;
                position: absolute;
            }

            .title{
                font-size: calc(var(--font-size) + 1rem);
                font-weight: 700;
                font-family: var(--font-face);
                letter-spacing: 3px;
                margin-bottom: 0.7rem;
            }

            strong{
                color: var(--form-shadow);
            }

            input {
                display: block;
                width: 100%;
                font-size: var(--font-size);
                line-height: calc(var(--font-size) * 2);
                font-family: var(--font-face);
                margin-bottom: calc(var(--font-size) * 2);
                border: none;
                border-bottom: 5px solid black;
                background: var(--form-bg);
                min-width: 250px;
                padding-left: 5px;
                outline: none;
                color: black;
            }

            input:focus {
                border-bottom: 5px solid var(--form-shadow);
            }

            button {
                display: block;
                line-height: calc(var(--font-size) * 2);
                padding: 0 20px;
                background: var(--form-shadow);
                letter-spacing: 2px;
                transition: .2s all ease-in-out;
                outline: none;
                border: 1px solid black;
                border-radius: 2px;
                font-weight: 700;
                box-shadow: 3px 3px 1px 1px var(--form-primary-highlight), 3px 3px 1px 2px black;
                cursor: pointer;
            }

            button:hover {
                background: var(--form-primary-highlight);
                color: white;
                border: 1px solid black;
                box-shadow: 3px 3px 1px 1px var(--form-shadow), 3px 3px 1px 2px black;
            }

            ::selection {
                background: var(--form-secondary-highlight);
            }

            input:-webkit-autofill,
            input:-webkit-autofill:hover,
            input:-webkit-autofill:focus {
                border-bottom: 5px solid var(--form-primary-highlight);
                -webkit-text-fill-color: var(--font-color);
                -webkit-box-shadow: 0 0 0px 1000px var(--form-bg) inset;
                transition: background-color 5000s ease-in-out 0s;
            }

            p.sign-in,
            p.sign-out{
                text-align: center;
                margin: 1.5rem 0 0 0;
                font-family: 'Arial';
                font-size: calc(var(--font-size) - 0.5rem);
                cursor: pointer;
                font-weight: 600;
            }

            p.sign-out u{
                color: var(--form-primary-highlight);
            }

            p.sign-in u{
                color: var(--form-shadow);
            }

            .login.close{
                display: none;
            }

            .register.close{
                display: none;
            }
        </style>
    </head>

    <body>

        <form class="login" method="POST">
            <p class="title"><strong>-</strong> Login <strong>-</strong></p>
            <input class="NomeReveal" type="text" name="name" required="" disabled>
            <input placeholder="E-mail" type="email" name="email" required="">
            <input placeholder="Senha" type="password" name="password" required="">

            <button type="submit" name="logar" value="Entrar">ENTRAR</button>
            <p class="sign-out">Ainda não tem uma conta? <u>Registre-se</u></p>
        </form>

        <form class="register close" action="index.php" method="POST">
            <p class="title"><strong>~</strong> Registrar <strong>~</strong></p>
            <input placeholder="Nome" type="text" name="name" required="">
            <input placeholder="E-mail" type="email" name="email" required="">
            <input placeholder="Senha" type="password" name="password" required="">

            <button type="submit" name="registrar">REGISTRAR</button>
            <p class="sign-in">Já tem uma conta? <u>Entre</u></p>
        </form>

    </body>


<script>
  const login = document.querySelector('.login');
  const register = document.querySelector('.register');
  const signIn = document.querySelector('.sign-in');
  const signOut = document.querySelector('.sign-out');

  function toggleLoginRegister(){
      signIn.addEventListener('click', () => {
        register.classList.add('close');
        login.classList.remove('close');
      })

      signOut.addEventListener('click', () => {
        login.classList.add('close');
        register.classList.remove('close');
      })
  }

  toggleLoginRegister();
</script>
</html>
