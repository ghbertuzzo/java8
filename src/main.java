import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class main {

    public static void main(String[] args) {
        System.out.println("\n\nAlgumas funcionalidades introduzidas no JAVA 8: \n\n1 - Primeiro vamos criar uma lista:" +
                "\n\nList<String> lista = new ArrayList<String>(); \n\n2 - Agora adicionamos alguns elementos: \n\nlista.add(\"Chocolate\");\nlista.add(\"Queijo\");\nlista.add(\"Strogonoff\"); \nlista.add(\"Ovo\");");

        List<String> lista = new ArrayList<String>();
        lista.add("Chocolate");
        lista.add("Queijo");
        lista.add("Strogonoff");
        lista.add("Ovo");

        System.out.println("\n3 - Printando a lista modo tradicional: \n\n" +
                "   for(String string: lista){\n" +
                "       System.out.println(string);\n" +
                "   }  \n\nResulta em: ");

        for(String string: lista){
            System.out.println(string);
        }


        System.out.println("\n4 - Printando a lista com forEach + lambda: \n\n[ lista.forEach(s -> System.out.println(s)); ] \n\nResulta em: ");
        lista.forEach(s -> System.out.println(s));


        System.out.println("\n5 - Agora vamos ordenar a lista pelo tamanho da palavra do modo antigo, criando um Comparator e sobrescrevendo o metodo sort:");
        System.out.println("" +
                "            \n" +
                "            lista.sort(new Comparator<String>() {\n" +
                "            @Override\n" +
                "            public int compare(String string1, String string2) {\n" +
                "                if(string1.length() > string2.length())\n" +
                "                    return 1;\n" +
                "                if(string1.length() < string2.length())\n" +
                "                    return -1;\n" +
                "                return 0;\n" +
                "           }\n" +
                "           });");
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
        System.out.println("\nResultando em: "+lista);

        System.out.println("\n6 - Mas agora podemos fazer a mesma coisa de forma mais simples usando lambda:");
        System.out.println("" +
                "            \n" +
                "            lista.sort((string1, string2) -> {\n" +
                "               if(string1.length() > string2.length())\n" +
                "                   return 1;\n" +
                "               if(string1.length() < string2.length())\n" +
                "                   return -1;\n" +
                "               return 0;\n" +
                "            });");

        lista.sort((string1, string2) -> {
            if(string1.length() > string2.length())
                return 1;
            if(string1.length() < string2.length())
                return -1;
            return 0;
        });

        System.out.println("\nResultando a mesma coisa: "+lista);

        System.out.println("\n7 - Vamos melhorar usando o metodo compare() da classe Integer:");
        System.out.println("" +
                "\n" +
                        "      lista.sort((string1, string2) -> {\n" +
                        "           return Integer.compare(string1.length(), string2.length());\n" +
                        "      });");

        lista.sort((string1, string2) -> {
            return Integer.compare(string1.length(), string2.length());
        });

        System.out.println("\n8 - Como temos apenas 1 instrucao dentro da arrow function podemos melhorar ainda mais:");
        System.out.println("" +
                "\n" +
                "       lista.sort((string1, string2) -> Integer.compare(string1.length(), string2.length()));");
        lista.sort((string1, string2) -> Integer.compare(string1.length(), string2.length()));

        System.out.println("\n9 - Para finalizar, podemos tirar o metodo compare:");
        System.out.println("\n" +
                "       lista.sort((string1, string2) -> string1.length() - string2.length());" +
                "\n" +
                "       //sim, isso funciona =)"  );

        lista.sort((string1, string2) -> string1.length() - string2.length());

        System.out.println("\nResultado: "+lista);

        System.out.println("\n10 - Outra forma de iterar uma lista fazendo comparacoes eh com a classe Comparator, metodo comparing():");
        System.out.println("" +
                "\n" +
                "       //comparando pelo tamanho das palavras [ s.length() dentro do lambda ]\n"+
                "       lista.sort(Comparator.comparing(s -> s.length()));"  );
        lista.sort(Comparator.comparing(s -> s.length()));
        System.out.println("\nResultado: "+lista);

        System.out.println("" +
                "\n" +
                "       //comparando pelas palavras [ s ] (ordem alfabetica)\n"+
                "       lista.sort(Comparator.comparing(s -> s));"  );

        lista.sort(Comparator.comparing(s -> s));
        System.out.println("\nResultado: "+lista);

        System.out.println("\n11 - Outro recurso muito util eh as possibilidades de filtros da API Stream:");
        System.out.println("" +
                "\n" +
                "       //pego minha lista e filtro as palavras com tamanho > 6 [ s -> s.length() > 6 dentro do lambda ]\n"+
                "       lista.stream().filter(s -> s.length() > 6).forEach(s -> System.out.println(s));"  );

        System.out.println("\nResultado: ");
        lista.stream().filter(s -> s.length() > 6).forEach(s -> System.out.println(s));

        System.out.println("\nMas observe como ficou a lista apos o uso do filter: "+lista);

        System.out.println("\nATENCAO!");
        System.out.println("\nPercebeu? Isso nao altera a lista original, ele apenas itera a lista original para utiliza-la, caso deseje aplicar as alteracoes na lista original, pegue a referencia da lista e invoque o metodo .collect que retornara algum tipo de collection (por exemplo um List() com o metodo .collect(Collectors.toList());");
        lista  = lista.stream().filter(s -> s.length() > 6).collect(Collectors.toList());
        System.out.println("" +
                "\n" +
                "       //lista recebe uma nova lista apenas com as palavras que possuem tamanho > 6\n"+
                "       lista  = lista.stream().filter(s -> s.length() > 6).collect(Collectors.toList());"  );
        System.out.println("\nResultando na nova lista: "+lista);

    }

}