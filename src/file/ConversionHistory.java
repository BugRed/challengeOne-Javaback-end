package file;

import model.ConversionCoin;

import java.io.FileWriter;
import java.io.IOException;

public class ConversionHistory {
    public static void save(double baseValue, String baseCurrency, double convertedValue, String finalCurrency) {
        String fileName = "HistoryFile.txt";
        ConversionCoin item = new ConversionCoin(baseValue, baseCurrency, convertedValue, finalCurrency);

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName, true);
            String itemSave = item.toString();

            fileWriter.write(itemSave);
            fileWriter.write("\n");
            System.out.println("Dados foram adicionados ao arquivo " + fileName + " com sucesso!");
        } catch (IOException e) {
            System.out.println("Dados da conversão não puderam ser adicionados ao arquivo " + fileName + "!");
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("FileWriter pode ser finalizado.");
                }
            }
        }
    }
}
