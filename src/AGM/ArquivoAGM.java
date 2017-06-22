
package AGM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArquivoAGM {

    public ArquivoAGM() {

    }

    public List TxtToString() throws FileNotFoundException {
        List<String> arquivo = new ArrayList<>();
        String local;
        Scanner entrada = new Scanner(System.in);
        
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
                + "\tLDGraph500_250.txt\n"
                + "\tMDGraph500_500.txt\n"
                + "\tMDGraph500_625.txt\n"        
                
                + "\n");
        
        System.out.println("Nome do Arquivo: ");
        local = entrada.nextLine();

        File arquivotxt = new File("./arquivos/"+local);
        InputStream in = new FileInputStream(arquivotxt);
        Scanner scan = new Scanner(in);

        while (scan.hasNext()) {
            arquivo.add(scan.nextLine());
        }

        return arquivo;
    }
}
