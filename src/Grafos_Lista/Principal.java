package Grafos_Lista;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        String local;
        Scanner entrada = new Scanner(System.in);
        Leitura leitura = new Leitura();
        //TiposBuscas tb = new TiposBuscas();
        
        System.out.println("Opçoes de arquivos \n"
                + "\tHDGraph20_20.txt "
                + "\n");
        
        System.out.println("Nome do Arquivo: ");
        local = entrada.nextLine();
        
        leitura.leituraArquivo("HDGraph20_20.txt");
        //tb.iniciaBuscas();
        

        System.out.println("");

    }

}
