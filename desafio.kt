enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel)
{

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) 
    {
        inscritos.add(usuario)
    }
    
    fun printListaInscritos()
    {
        for(i in inscritos)
        {
            println(i.nome)
        }
    }
    
    fun printFormacao()
    {
        for(i in conteudos)
        {
            print("${i.nome} ** ${i.duracao} ")
        }
    }
}

fun main()
{
    //Definindo Cursos
    val cursoJavaScript = ConteudoEducacional("Curso de JavaScript", 120)
    val cursoJava = ConteudoEducacional("Curso de Java", 130)
    val cursoKotlin = ConteudoEducacional("Curso de Kotlin", 40)
    val cursoAngular = ConteudoEducacional("Curso de Angular", 60)
    
    //Adicionando Cursos a lista
    val listaConteudos = mutableListOf<ConteudoEducacional>()
    listaConteudos.add(cursoJavaScript)
    listaConteudos.add(cursoJava)
    listaConteudos.add(cursoKotlin)
    listaConteudos.add(cursoAngular)
    
    //Formação de Curso
    val formacaoA = Formacao("Formação em Multiplataforma", listaConteudos, Nivel.AVANCADO)
    val formacaoB = Formacao("Formação em Android", listaConteudos, Nivel.INTERMEDIARIO)
    
    //Criando Usuarios
   	var carlos = Usuario("Carlos", "carlos@dio.com.br")
    var andrei = Usuario("Andrei", "andrei@dio.com.br")
    var felipe = Usuario("Felipe", "felipe@dio.com.br")
    var fernando = Usuario("Fernando", "fernando@dio.com.br")
    
    //Registrando Usuarios nas formações
    formacaoA.matricular(carlos)
    formacaoB.matricular(andrei)
    formacaoA.matricular(felipe)
    formacaoB.matricular(fernando)
    
    //Prints
    println("*======================================*")
    println("Dados das formações")
    println("${formacaoA.nome} - ${formacaoA.nivel}")
    println("${formacaoB.nome} - ${formacaoB.nivel}")
    println("Grade formação A")
    println(formacaoA.printFormacao())
    println("=======================================")
    println("Grade formação B")
    println(formacaoB.printFormacao())
    println("=======================================")
    println("Lista de inscritos da formação A")
    println(formacaoA.printListaInscritos())
	println("Lista de inscritos da formação B")
    println(formacaoB.printListaInscritos())    
}