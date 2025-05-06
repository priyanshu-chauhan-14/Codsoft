// Currency Selection: Allow the user to choose the base currency and the target
//  currency.
//  Currency Rates: Fetch real-time exchange rates from a reliable API.
//  Amount Input: Take input from the user for the amount they want to convert.
//  Currency Conversion: Convert the input amount from the base currency to the
//  target currency using the fetched exchange rate.
//  Display Result: Show the converted amount and the target currency symbol
//  to the user
import java.util.InputMismatchException;
import java.util.Scanner;
public class _04_CurrencyConvertor {

    // Function to get exchange rate based on base and target currency
    public static float getExchangeRate(String base, String target) {
        // Simple hardcoded rates relative to USD
        float usdToInr = 83.0f;
        float usdToEur = 0.85f;
        float usdToGbp = 0.75f;
        float usdToJpy = 110.0f;

        // Convert base to USD first
        float baseToUsd = 1.0f;
        if (base.equals("INR")) baseToUsd = 1 / usdToInr;
        else if (base.equals("EUR")) baseToUsd = 1 / usdToEur;
        else if (base.equals("GBP")) baseToUsd = 1 / usdToGbp;
        else if (base.equals("JPY")) baseToUsd = 1 / usdToJpy;

        // Now convert USD to target
        float usdToTarget = 1.0f;
        if (target.equals("INR")) usdToTarget = usdToInr;
        else if (target.equals("EUR")) usdToTarget = usdToEur;
        else if (target.equals("GBP")) usdToTarget = usdToGbp;
        else if (target.equals("JPY")) usdToTarget = usdToJpy;

        return baseToUsd * usdToTarget;
    }

    public static void main(String[] args) {
       try( Scanner scanner = new Scanner(System.in)){
        float amount = 0.0f;
        String baseCurrency = "none";
        String targetCurrency = "none";

        System.out.println("Welcome to the Simple Currency Converter!");
        System.out.println("Available currencies: USD, INR, EUR, GBP, JPY");

        System.out.print("Enter your base currency (e.g., USD): ");
        try{
            baseCurrency = scanner.next().toUpperCase();
        }
        catch(InputMismatchException e){
            System.out.println("Invalid input : "+e);
        }

        System.out.print("Enter your target currency (e.g., INR): ");
        try{
            targetCurrency = scanner.next().toUpperCase();
        }
        catch(InputMismatchException e){
            System.out.println("Invalid input : "+e);
        }
        System.out.print("Enter amount to convert: ");
        try{
        amount = scanner.nextFloat();
        }
        catch(InputMismatchException e){
            System.out.println("Invalid input : "+e);
        }

        float rate = getExchangeRate(baseCurrency, targetCurrency);
        float convertedAmount = amount * rate;

        System.out.printf("Converted amount: %.2f %s\n", convertedAmount, targetCurrency);
        scanner.close();
    }
    }
}
