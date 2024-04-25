import com.google.gson.Gson;
import file.ConversionHistory;
import model.CoinCurrency;
import model.CoinType;
import model.ConversionCoin;
import service.ApiConsumer;
import service.Convert;
import util.JsonConvert;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem vindo ao conversor de Moedas!");
        System.out.println("Escolha abaixo o número correspondente a moeda que deseja fazer conversão: ");
        CoinType baseCurrency = menu(sc);

        System.out.println("Para qual moeda devo converter?");
        CoinType targetCurrency = menu(sc);

        ApiConsumer consumer = new ApiConsumer();
        String json = consumer.Consumer(String.valueOf(baseCurrency), String.valueOf(targetCurrency));

        Gson gson = new JsonConvert().jsonConvert();
        CoinCurrency coinCurrency = gson.fromJson(json, CoinCurrency.class);

        System.out.println("Quanto da moeda " + coinCurrency.baseCode() + " deseja converter para " + coinCurrency.targetCode() + "?");
        double value = sc.nextDouble();


        double conversion = Convert.covert(value, coinCurrency.conversionRate());
        System.out.printf("O valor final é: %.2f \n", conversion);

        ConversionHistory.save(value, baseCurrency.name(), conversion, targetCurrency.name());

    }

    private static CoinType menu(Scanner sc) {
        while (true) {
            System.out.println("***********************************************");
            System.out.println("""
                    1 -> European Euro
                    2 -> Brazilian Real
                    3 -> United States Dollar
                    4 -> Japanese Yen
                    5 -> South Korean Won
                    0 -> Sair""");
            System.out.println("***********************************************");

            String option = sc.nextLine();
            switch (option) {
                case "1":
                    return CoinType.showDescription("Euro");
                case "2":
                    return CoinType.showDescription("Brazilian Real");
                case "3":
                    return CoinType.showDescription("United States Dollar");
                case "4":
                    return CoinType.showDescription("Japanese Yen");
                case "5":
                    return CoinType.showDescription("South Korean Won");
                case "0":
                    System.out.println("Finalizando programa...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}