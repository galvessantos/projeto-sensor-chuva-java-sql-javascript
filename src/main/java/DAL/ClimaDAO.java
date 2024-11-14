package DAL;

import org.hibernate.Session;
import org.hibernate.Transaction;
import Modelo.Clima;

public class ClimaDAO
{
    // classe DAO, que exerce os comandos SQL
    
    // declaração de váriaveis: String p/ dar retorno do sucesso de cadastro no output, e session configurado pela classe HibernateUtil
    public String mensagem;
    Session session = HibernateUtil.getSessionFactory().openSession();
    
    // método que cadastra e recebe um objeto da classe de persistência Clima
    public void cadastrarClima(Clima clima)
    {
        this.mensagem = "";
        clima.setId(null);
        // try-catch para tratar possíveis erros de comunicação entre dois softwares diferentes
        try
        {
            // sequência de comandos que ligam o NetBeans com o banco de dados no SQL Server
            // aqui inicia-se a conexão, ou transação como sugere o nome da classe, ou seja, é o que inicia a comunicação
            Transaction transaction = session.beginTransaction();
            // persist é o comando que realiza o 'INSERT INTO' no SQL, ou seja, cadastra uma nova linha na tabela
            session.persist(clima);
            // commit é a desconexão, finalizando as operações SQL
            transaction.commit();
            
            // dá um retorno no output se foi cadastrado, ou se deu errado caso caia no catch
            this.mensagem = "Clima cadastrado !!!!!!";
            System.out.print(mensagem);
        }
        catch (Exception e)
        {
            this.mensagem = "Erro no cadastro " + HibernateUtil.mensagem + e.getMessage();
        }
    }
    
}
