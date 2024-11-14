package Modelo;

import DAL.ClimaDAO;
import java.util.List;

public class Controle
{
    // Classe controle, o centro do pacote Modelo, e comunicadora com o pacote DAL
    
    // método cadastrar, que recebe uma lista que armazena Strings
    public void cadastrarClima(List<String> listaDadosClima)
    {
        // Instância de um objeto da classe de persistência
        Clima clima = new Clima();
        
        // define os atributos da classe de persistência com os valores recebidos da lista
        clima.setId(0);
        clima.setTemperatura(listaDadosClima.get(1));
        clima.setUmidade(listaDadosClima.get(2));
        clima.setPrecipitacao(listaDadosClima.get(3));

        // instância de um objeto e chamada do método cadastrar da classe DAO enviando o objeto da classe de persistência como parâmetro
        ClimaDAO climaDAO = new ClimaDAO();
        climaDAO.cadastrarClima(clima);

    }
}
