package Modelo;

import com.fazecast.jSerialComm.*;
import java.io.IOException;
import java.io.InputStream;

public class Serial implements Runnable
{
    // Classe Serial, que foi preparada pelo orientador do projeto, que é responsável pela comunicação do circuito com o código

    @Override
    public void run()
    {
        executar();
    }
    
    public void executar()
    {
        String leitura = "";
        String[] valores = new String[3];
        SerialPort comPort = SerialPort.getCommPort("COM3");
        comPort.openPort();
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        InputStream in = comPort.getInputStream();
        
        try
        {
            while (Estaticos.coletaSerial)
            {
                leitura += (char) in.read();
                if (leitura.charAt(leitura.length()-1) == '\n')
                {
                    valores = leitura.split(",");
                    System.out.print("Vetor:" + valores[0] + " - " + valores [1] + " - " + valores[2]);
                    Estaticos.umidade = valores[0];
                    Estaticos.temperatura = valores[1];
                    Estaticos.precipitacao = valores[2];
                    
                    System.out.print("Estáticos: " + Estaticos.umidade + " - " + Estaticos.temperatura + " - " + Estaticos.precipitacao);
                    leitura = "";
                }
//                System.out.println(leitura);
            }
        }
        catch (IOException e)
        {
        }
        comPort.closePort();
    }

}