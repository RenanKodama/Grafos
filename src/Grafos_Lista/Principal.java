package Grafos_Lista;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        String local;
        Scanner entrada = new Scanner(System.in);
        Leitura_AGM leitura = new Leitura_AGM();
        //TiposBuscas tb = new TiposBuscas();
        
        System.out.println("Opçoes de arquivos \n"
                + "\tHDGraph20_20.txt\n"
                + "\tHDGraph30_30.txt\n"
                + "\tHDGraph50_50.txt\n"
                + "\tLDGraph20_20.txt\n"
                + "\tLDGraph30_30.txt\n"
                + "\tLDGraph40_40.txt\n"
                + "\tLDGraph50_50.txt\n"
                + "\tMDGraph20_20.txt\n"
                + "\tMDGraph30_30.txt\n"
                + "\tMDGraph40_40.txt\n"
                + "\tMDGraph50_50.txt\n"
                
                + "\n");
        
        System.out.println("Nome do Arquivo: ");
        local = entrada.nextLine();
        
        try {
            leitura.leituraArquivo(local);
            //tb.iniciaBuscas();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }

}
