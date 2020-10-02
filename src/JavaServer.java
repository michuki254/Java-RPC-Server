import org.apache.xmlrpc.WebServer;

import java.util.Random;

public class JavaServer {
    int CPU = 0, YOU = 0;
    String progress, winner;

    public static void main(String[] args) {
        try {
            System.out.println("Attempting to start XML-RPC Server...");

            WebServer server = new WebServer(2017);
            server.addHandler("sample", new JavaServer());
            server.start();

            System.out.println("Started successfully.");
            System.out.println("Accepting requests. (Halt program to stop.)");
        } catch (Exception exception){
            System.err.println("JavaServer: " + exception);
        }
    }

    public String connection(){
        return "successful";
    }

    public String resetScore(){
        CPU = 0;
        YOU = 0;
        return "successfully";
    }

    public String RockPaperScissors(int user_input){
        String result[] = new String[3];
        try {
            Random random = new Random();
            int Low = 1;
            int High = 3;
            int cpu_output = random.nextInt(High-Low) + Low;

            if ((cpu_output == 1 && user_input ==1) || (cpu_output == 2 && user_input == 2) ||(cpu_output == 3 && user_input == 3)) {
                result[0] = ("It is a tie!");
                result[2] = "Try Again";
            }
            else if(cpu_output == 1 && user_input == 2) {
                YOU = YOU + 1;
                result[0] = ("CPU chose Rock, You chose Paper");
                result[2] = "You Win";
            }
            else if(cpu_output == 1 && user_input == 3){
                CPU = CPU + 1;
                result[0] = ("CPU chose Rock, You chose Scissors");
                result[2] = "CPU Wins";
            }
            else if(cpu_output == 2 && user_input == 1){
                CPU = CPU + 1;
                result[0] = ("CPU chose Paper, You chose Rock");
                result[2] = "CPU Wins";
            }
            else if(cpu_output == 2 && user_input == 3){
                YOU = YOU + 1;
                result[0] = ("CPU chose Paper, You chose Scissors");
                result[2] = "You Win";
            }
            else if(cpu_output == 3 && user_input == 1){
                YOU = YOU + 1;
                result[0] = ("CPU chose Scissors, You chose Rock");
                result[2] = "You Win";
            }
            else if(cpu_output == 3 && user_input == 2){
                CPU = CPU + 1;
                result[0] = ("CPU chose Scissors, You chose Paper");
                result[2] = "CPU Wins";
            }
        } catch (Exception exception){
            System.err.println("JavaServer: " + exception);
        }
        result[1] = "CPU: "+CPU+"\tYOU: "+YOU;

        String resultGenerated = result[0];
        String progress = result[1];
        String winner = result[2];

        return (resultGenerated+" so "+winner+"\n"+progress);
    }
}
