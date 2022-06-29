#java8

Algumas funcionalidades introduzidas no JAVA 8: 

1 - Primeiro vamos criar uma lista:

      List<String> lista = new ArrayList<String>(); 

2 - Agora adicionamos alguns elementos: 

      lista.add("Chocolate");
      lista.add("Queijo");
      lista.add("Strogonoff"); 
      lista.add("Ovo");

3 - Printando a lista modo tradicional: 

      for(String string: lista){
            System.out.println(string);
      }  

Resulta em:

Chocolate
Queijo
Strogonoff
Ovo

4 - Printando a lista com forEach + lambda: 

            lista.forEach(s -> System.out.println(s));

Resulta em:

Chocolate
Queijo
Strogonoff
Ovo

5 - Agora vamos ordenar a lista pelo tamanho da palavra do modo antigo, criando um Comparator e sobrescrevendo o metodo sort:
            
            lista.sort(new Comparator<String>() {
            @Override
            public int compare(String string1, String string2) {
                if(string1.length() > string2.length())
                    return 1;
                if(string1.length() < string2.length())
                    return -1;
                return 0;
           }
           });

Resultando em: [Ovo, Queijo, Chocolate, Strogonoff]

6 - Mas agora podemos fazer a mesma coisa de forma mais simples usando lambda:
            
            lista.sort((string1, string2) -> {
               if(string1.length() > string2.length())
                   return 1;
               if(string1.length() < string2.length())
                   return -1;
               return 0;
            });

Resultando a mesma coisa: [Ovo, Queijo, Chocolate, Strogonoff]

7 - Vamos melhorar usando o metodo compare() da classe Integer:

      lista.sort((string1, string2) -> {
           return Integer.compare(string1.length(), string2.length());
      });

8 - Como temos apenas 1 instrucao dentro da arrow function podemos melhorar ainda mais:

       lista.sort((string1, string2) -> Integer.compare(string1.length(), string2.length()));

9 - Para finalizar, podemos tirar o metodo compare:

       lista.sort((string1, string2) -> string1.length() - string2.length());
       //sim, isso funciona =)

Resultado: [Ovo, Queijo, Chocolate, Strogonoff]

10 - Outra forma de iterar uma lista fazendo comparacoes eh com a classe Comparator, metodo comparing():

       //comparando pelo tamanho das palavras [ s.length() dentro do lambda ]
       lista.sort(Comparator.comparing(s -> s.length()));

Resultado: [Ovo, Queijo, Chocolate, Strogonoff]

       //comparando pelas palavras [ s ] (ordem alfabetica)
       lista.sort(Comparator.comparing(s -> s));

Resultado: [Chocolate, Ovo, Queijo, Strogonoff]

11 - Outro recurso muito util eh as possibilidades de filtros da API Stream:

       //pego minha lista e filtro as palavras com tamanho > 6 [ s -> s.length() > 6 dentro do lambda ]
       lista.stream().filter(s -> s.length() > 6).forEach(s -> System.out.println(s));

Resultado: 
Chocolate
Strogonoff

Mas observe como ficou a lista apos o uso do filter

Resultado: [Chocolate, Ovo, Queijo, Strogonoff]

ATENÇÃO!

Percebeu? Isso nao altera a lista original, ele apenas itera a lista original para utiliza-la, caso deseje aplicar as alteracoes na lista original, pegue a referencia da lista e invoque o metodo .collect que retornara algum tipo de collection (por exemplo um List() com o metodo .collect(Collectors.toList());

       //lista recebe uma nova lista apenas com as palavras que possuem tamanho > 6
       lista  = lista.stream().filter(s -> s.length() > 6).collect(Collectors.toList());

Resultando na nova lista: [Chocolate, Strogonoff]

Process finished with exit code 0
