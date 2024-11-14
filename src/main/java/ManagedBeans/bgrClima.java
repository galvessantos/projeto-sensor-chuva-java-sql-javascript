package ManagedBeans;

import Modelo.Estaticos;
import Modelo.Serial;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Named(value = "bgrClima")
@SessionScoped
public class bgrClima implements Serializable
{
    // classe de bean gerenciável, é construído com intuito de definir funções dos botões do index
    
    // declaração de variáveis
    
    //variáveis das grandezas de medidas meteorológicas
    private String temperatura;
    private String umidade;
    private String precipitacao;
    // string que define o texto do botão
    private String mensagem = Estaticos.mensagem;
    
    
    public bgrClima()
    {
    }
    
    // método que define as variáveis locais com mesmo valor dos estáticos
    public void atualizarClima()
    {
        this.temperatura = Estaticos.temperatura;
        this.umidade = Estaticos.umidade;
        this.precipitacao = Estaticos.precipitacao;
    }
    
    // método para cadastrar clima
    public void cadastrar()
    {
        // Instância de objetos das classes Controle, do pacote Modelo, e da Classe List para a construção de uma lista que recebe itens String
        Modelo.Controle controle = new Modelo.Controle();
        List<String> dadosClima = new ArrayList<>();
        // adiciona na lista os valores das medidas, assim a lista se assemelha com um objeto da classe Clima
        dadosClima.add("0");
        dadosClima.add(temperatura);
        dadosClima.add(umidade);
        dadosClima.add(precipitacao);
        // chama o método para cadastrar o clima da classe Controle, enviando a lista como parâmetro, que passará por todos os processos até concluir um cadastro no banco de dados
        controle.cadastrarClima(dadosClima);
    }

    // método que inicia a classe Serial, e assim o circuito Arduino começa a trabalhar e enviar os dados para a aplicação
    public void iniciar()
    {
        // se a coletaSerial, que é de tipo booleano, for verdadeiro, então se torna falsa e interrompe os registros no banco de dados
          if (Estaticos.coletaSerial)
        {
            Estaticos.coletaSerial = false;
            mensagem = "Registrar medidas";
        }
        // se for falso, que é o padrão, inicia a classe Serial e Thread para iniciar os trabalhos, e muda o texto do botão, além de iniciar o método loop
        else
        {
            Estaticos.coletaSerial = true;
            Serial serial = new Serial();
            Thread s1 = new Thread(serial);
            s1.start();
            mensagem = "Interromper registros";
            loop();
        }
    }
    
    // método que chama o método cadastrar a cada determinados segundos
    public void loop()
    {
        // instância da classe Timer para criar um temporizador
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask()
        {
            // a cada tanto tempo confere se a coletaSerial é verdadeira, pois se está verdadeira é pq o circuito está trabalhando e assim chama o método cadastrar
            @Override
            public void run()
            {
                if(Estaticos.coletaSerial)
                {
                    cadastrar();
                }
                else
                {
                    this.cancel();
                }
            }
        }, 5000, 5000);
    }

    // Getters e Setters
    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getUmidade() {
        return umidade;
    }

    public void setUmidade(String umidade) {
        this.umidade = umidade;
    }

    public String getPrecipitacao() {
        return precipitacao;
    }

    public void setPrecipitacao(String precipitacao) {
        this.precipitacao = precipitacao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
