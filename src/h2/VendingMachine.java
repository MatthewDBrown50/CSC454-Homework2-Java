package h2;

public class VendingMachine {
    private int quarters, nickels, dimes;
    private double totalValue;
    private boolean changePressed;

    public VendingMachine(){
        quarters = 10;
        nickels = 10;
        dimes = 10;
        totalValue = 0.0;
        changePressed = false;
    }

    public String lambda(){
        if(totalValue >= 1.0){
            return "coffee ".repeat(Math.max(0, (int) Math.floor(totalValue)));
        }
        else if(changePressed){
            double tempValue = totalValue;
            int numQuarters = 0;
            int numDimes = 0;
            int numNickels = 0;

            while(tempValue > 0){
                if(quarters > 0){
                    numQuarters += 1;
                    tempValue -= 0.25;
                }
                else if(dimes > 0){
                    numDimes += 1;
                    tempValue -= 0.10;
                }
                else if(nickels > 0){
                    numNickels += 1;
                    tempValue -= 0.05;
                }
            }

            return "q ".repeat(Math.max(0, numQuarters)) +
                    "d ".repeat(Math.max(0, numDimes)) +
                    "n ".repeat(Math.max(0, numNickels));
        }

        return "nothing";
    }

    public void delta(String inputTokens){
        while(totalValue >= 1.0){
            double tempValue = 0.0;

            while (tempValue < 1.0){
                if(quarters > 0 && (tempValue + 0.25) <= 1){
                    quarters -= 1;
                    tempValue += 0.25;
                }
                else if(dimes > 0 && (tempValue + 0.10) <= 1){
                    dimes -= 1;
                    tempValue -= 0.10;
                }
                else if(nickels > 0 && (tempValue + 0.05) <= 1){
                    nickels -= 1;
                    tempValue -= 0.05;
                }
            }

            totalValue -= tempValue;
        }

        if(changePressed){
            while(totalValue > 0){
                if(quarters > 0){
                    quarters -= 1;
                    totalValue -= 0.25;
                }
                else if(dimes > 0){
                    dimes -= 1;
                    totalValue -= 0.10;
                }
                else if(nickels > 0){
                    nickels -= 1;
                    totalValue -= 0.05;
                }
            }
        }

        changePressed = false;

        for (char c : inputTokens.toCharArray()) {
            switch (c){
                case 'q':
                    quarters += 1;
                    totalValue += 0.25;
                    break;
                case 'd':
                    dimes += 1;
                    totalValue += 0.10;
                    break;
                case 'n':
                    nickels += 1;
                    totalValue += 0.05;
                    break;
                case 'c':
                    changePressed = true;
                    break;
            }
        }
    }
}
