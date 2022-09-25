import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service
{

    static User usuario = new User();
    static List<Paciente> listPaciente = new ArrayList<>();

    static void mensagem()
    {
        System.out.println("#---------------------------------------------##---------------------------------------------#");
        System.out.println("Bem vindo a Clinca de Broxas");
        System.out.println("#---------------------------------------------##---------------------------------------------#");
    }

    static void loggin()
    {
        System.out.println("Bem vindo ao sistema de login da Clinaca BROXA");
        System.out.println("-------------------------------");
        System.out.println("Digite seu login: ");
        Scanner scannerlogin = new Scanner(System.in);
        String login = scannerlogin.nextLine();
        System.out.println("-------------------------------");
        System.out.println("Digite seu Senha: ");
        Scanner scannerSenha = new Scanner(System.in);
        String Senha = scannerSenha.nextLine();

        if (login.equals(usuario.login) && Senha.equals(usuario.Senha)) {
            System.out.println("Você entrou com sucesso: ");
            menu();
        } else {
            PARADO:
            while (true) {
                System.out.println("Usuario invalido,tente novamente ");
                System.out.println("-----------------------------------------------");
                System.out.println("Digite seu Loggin");
                login = scannerlogin.nextLine();
                System.out.println("-----------------------------------------------");
                System.out.println("Digite sua Senha");
                Senha = scannerSenha.nextLine();

                if (login.equals(usuario.login) && Senha.equals(usuario.Senha)) {
                    System.out.println("Você acessou com sucesso ");
                    menu();
                    break PARADO;
                }
            }
        }
    }

    static void menu()
    {

        menu:
        while (true) {
            System.out.println("#----------------------------------------------#");
            System.out.println("# Menu de Opções:                              #");
            System.out.println("# Digite (0) para sair do Sistema:             #");
            System.out.println("# Digite (1) para mostrar lista de espera:     #");
            System.out.println("# Digite (2) para adicionar paciente:          #");
            System.out.println("# Digite (3) para editar paciente:             #");
            System.out.println("# Digite (4) para remover paciente:            #");
            System.out.println("#----------------------------------------------#");
            Scanner scanSair = new Scanner(System.in);
            int resp = scanSair.nextInt();
            if (resp == 0)
            {
                System.out.println("Sainda do sistema, Até logo!!!!!");
                break menu;
            }
            else if (resp == 1)
            {
                mostar();
            }
            else if (resp == 2)
            {
                System.out.println("Adicionar paciente");
                adicionar();
                break;
            }
            else if (resp == 3)
            {
                editar();
                System.out.println("Digite (1) para editar novamente | Digite (0) para voltar ao menu");
                Scanner editMenu = new Scanner(System.in);
                int mudarEdiMu = editMenu.nextInt();
                while (mudarEdiMu != 1 && mudarEdiMu != 0)
                {
                    System.out.println("Resposta invalida, digite novamente:");
                    System.out.println("Digite (1) para editar novamente | Digite (0) para voltar ao menu");
                    mudarEdiMu = editMenu.nextInt();
                }
                if (mudarEdiMu == 1) {
                    editar();
                }
                if (mudarEdiMu == 0) {
                    menu();
                }
            }
            if (resp == 4){
                remover();
            }
        }

    }

    static void editar()
    {
        System.out.println("Editar paciente");
        System.out.println("Digite o número do CPF do Paciente que deseja editar:  ");
        Scanner scannerCpf = new Scanner(System.in);
        String CPF = scannerCpf.nextLine();
        System.out.println("O que deseja mudar? Digite: (1) para Nome | (2) para Idade | (3)para CPF | (4) para Plano de Rico");
        Scanner scannerEsco = new Scanner(System.in);
        int escoEdit = scannerEsco.nextInt();
        while (escoEdit != 1 && escoEdit != 2 && escoEdit != 3 && escoEdit != 4)
        {
            System.out.println("Resposta invalida digite novamente: ");
            System.out.println("O que deseja mudar? Digite: (1) para Nome | (2) para Idade | (3)para CPF | (4) para Plano de Rico");
            escoEdit = scannerEsco.nextInt();
        }
        for (int i = 0; i < listPaciente.size(); i++)
         {
            if (listPaciente.get(i).cpf.equals(CPF))
            {
                if (escoEdit == 1)
                {
                    System.out.println("Digite o nome do novo: ");
                    Scanner scannerNome = new Scanner(System.in);
                    String nomeNovo = scannerNome.nextLine();
                    listPaciente.get(i).nome = nomeNovo;
                    System.out.println("Novo nome atualizado com sucesso");
                }
                if (escoEdit == 2)
                {
                    System.out.println("Digite a nova idade: ");
                    Scanner scannerIdade = new Scanner(System.in);
                    String idadeNova = scannerIdade.nextLine();
                    listPaciente.get(i).idade = idadeNova;
                    System.out.println("Nova idade atualizada com sucesso");
                }
                if (escoEdit == 3)
                {
                    System.out.println("Digite o novo CPF: ");
                    Scanner scannerCPF = new Scanner(System.in);
                    String cpfNovo = scannerCPF.nextLine();
                    listPaciente.get(i).cpf = cpfNovo;
                    System.out.println("Novo cpf atualizado com sucesso");
                }
                if (escoEdit == 4)
                {
                    System.out.println("Digite para alteração de plano: ");
                    Scanner scannerPlano = new Scanner(System.in);
                    String planoSaudeNovo = scannerPlano.nextLine();
                    listPaciente.get(i).planoDeSaude = planoSaudeNovo;
                    System.out.println("Novo plano atualizado com sucesso");
                }
            }
         }
        menu();
    }

    static void adicionar()
    {
        PARADO2:
        while (true) {
            Paciente paci = new Paciente();
            System.out.println("#---------------------------------------------##---------------------------------------------#");
            System.out.println("Digite o nome: ");
            Scanner scanNome = new Scanner(System.in);
            paci.nome = scanNome.nextLine();
            System.out.println("#---------------------------------------------##---------------------------------------------#");
            System.out.println("Digite a idade: ");
            Scanner scanIdade = new Scanner(System.in);
            paci.idade = scanIdade.nextLine();
            System.out.println("#---------------------------------------------##---------------------------------------------#");
            System.out.println("Digite o cpf: ");
            Scanner scanCpf = new Scanner(System.in);
            paci.cpf = scanCpf.nextLine();
            System.out.println("#---------------------------------------------##---------------------------------------------#");
            System.out.println("Possui plano : (Sim) ou (Não) ");
            Scanner scanPlano = new Scanner(System.in);
            paci.planoDeSaude = scanPlano.nextLine();
            listPaciente.add(paci);
            System.out.println("Paciente Adicionado com sucesso: ");
            System.out.println("#---------------------------------------------##---------------------------------------------#");
            System.out.println("deseja adicionar outro paciente ? ou deseja volta para o menu ?");
            System.out.println("Digite 1 para adionar paciente: ou digite 0 para voltar ao menu: ");
            System.out.println("#---------------------------------------------##---------------------------------------------#");
            Scanner scanAdicionar = new Scanner(System.in);
            int respAdic = scanAdicionar.nextInt();
            while (respAdic != 1 && respAdic != 0) {
                System.out.println("Resposta invalida,Digite um número valido!!!");
                System.out.println("Digite (1) para adcionar outro cliente ou digite (0) para voltar ao menu: ");
                respAdic = scanAdicionar.nextInt();
            }
            if (respAdic == 0) {
                menu();
                break PARADO2;
            }


        }

    }

        static void remover ()
    {

            System.out.println("Remover paciente");
            System.out.println("Digite o CPF do Paciente: ");
            Scanner scanRemov = new Scanner(System.in);
            String remove = scanRemov.nextLine();
            for (int r = 0; r < listPaciente.size(); r++)
            {
                if (listPaciente.get(r).cpf.equals(remove))
                {
                    listPaciente.remove(r);
                } else {
                    System.out.println("Paciente não encontrado, Digite novamente uma das opções: ");
                }
                System.out.println("Paciente removido com sucesso!");
                menu();
            }
        }

    static void mostar()
    {

        System.out.println("Mostrar lista");
        for (Paciente a : listPaciente) {
            System.out.println("#----------------------------------------------#");
            System.out.println("Nome: " + a.nome);
            System.out.println("Idade: " + a.idade);
            System.out.println("CPF: " + a.cpf);
            System.out.println("Possui plano: " + a.planoDeSaude);
        }
    }
}


