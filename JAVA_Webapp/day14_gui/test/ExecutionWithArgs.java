import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ExecutionWithArgs {
 public static void main(String[] args) {
  String command = "netsh firewall add portopening UDP 10024 voip";
  for (int i = 0; i < args.length; i++) {
   command += " " + args[i];
  }
  System.out.println("Command: " + command);

  try {
   Process p = Runtime.getRuntime().exec(command);
   BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
   String line = null;
   while ((line = br.readLine()) != null) {
    System.out.println(line);
   }
  } catch (IOException e) {
   System.err.println(e);
  }
 }
}