package murder;

import java.util.Scanner;
import java.util.Random;

public class PROJETOFINALPI {

    static Scanner kb = new Scanner(System.in);
    static Random rnd = new Random();

    public static void main(String[] args) {
        controladora();
    }

//FUNÇÃO CONTROLADORA DO JOGO
    public static void controladora() {
        int linhaDasPistas = rnd.nextInt(3); //RANDOMIZA AS LINHAS DA MATRIZ COM AS PISTAS
        int[] vetorfinal = embaralha();

        System.out.println("---> Welcome to MURDER <---\n");
        System.out.print("Digite o seu nome detetive: ");
        String nomeDoJogador = kb.nextLine();
        System.out.println("Você foi identificado(a) detetive " + nomeDoJogador + " !\n"
                + "\nO que deseja fazer?");
        lerMainMenu(nomeDoJogador); //LER A OPÇÃO ESCOLHIDA PELO JOGADOR
        intro(); //INTRODUÇÃO TEXTUAL DO JOGO
        int desafio1 = rnd.nextInt(3); //RANDOMIZA OS DESAFIOS DO JOGO
        String[][] senhafinal = matriz();
        cozinha(desafio1, nomeDoJogador, vetorfinal, linhaDasPistas, senhafinal); 
        desafio1 = rnd.nextInt(3) + 3; //RANDOZIMA OS TRÊS PRIMEIROS DESAFIOS DO VETOR
        salaDeJantar(desafio1, nomeDoJogador, vetorfinal, linhaDasPistas, senhafinal); 
        desafio1 = rnd.nextInt(3) + 6; //RANDOZIMA OS TRÊS SEGUINTES DESAFIOS DO VETOR
        salaDeEstar(desafio1, nomeDoJogador, vetorfinal, linhaDasPistas, senhafinal);
        desafio1 = rnd.nextInt(3) + 9; //RANDOZIMA OS TRÊS SEGUINTES DESAFIOS DO VETOR
        enfermaria(desafio1, nomeDoJogador, vetorfinal, linhaDasPistas, senhafinal);
        desafio1 = rnd.nextInt(3) + 12; //RANDOZIMA OS TRÊS SEGUINTES DESAFIOS DO VETOR
        quartoZ(desafio1, nomeDoJogador, vetorfinal, linhaDasPistas, senhafinal);

        office(linhaDasPistas, senhafinal, nomeDoJogador);
    }

//MENU PRINCIPAL DO JOGO
    public static void mainMenu() {
        System.out.print("\n1 - Jogar"
                + "\n2 - Instruções"
                + "\n3 - Suspeitos"
                + "\n4 - Créditos"
                + "\n5 - Desistir\n"
                + "\nEscolha uma opção: ");
    }
    
//FUNÇÃO RESPONSÁVEL POR FAZER A LEITURA DO MENU PRINCIPAL    
    public static void lerMainMenu(String nomeDoJogador) {
        int opt = 0;
        do {
            mainMenu();
            opt = kb.nextInt();
            switch (opt){
                case 1:
                    break;
                    
                case 2:
                    instructions(nomeDoJogador);
                    break;
                
                case 3:
                    suspects();
                    break;
                    
                case 4:
                    credits();
                    break;

                case 5:
                    desistir();
                    break;
                    
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opt != 1);
    }
    
//FUNÇÃO DE PAUSA ENTRE OS TEXTOS 
    public static void pausa(){
        System.out.print("Digite OK para continuar: ");
        String pausa = kb.next();
    }
    
// INSTRUÇOES DO JOGO
    public static void instructions(String nomeDoJogador) {
        System.out.println("\n" + nomeDoJogador + ", você é membro do departamento de\n"
                + "polícia da cidade de Hidenville.\n"
                + "Sua função? Detetive de homicídios!\n"
                + "Poucas horas após um assassinato, você foi chamado para investigar o crime.\n"
                + "Seu dever é pesquisar o local do crime\n"
                + "e descobrir quem é o culpado pelo assassinato.\n"
                + "Você não pode entrevistar as testemunhas pois seu\n"
                + "superior já está fazendo esse serviço.\n"
                + "Você deve percorrer as seis salas que estão abertas e decifrar os\n"
                + "enigmas de cada computador para conseguir a senha que\n"
                + "dá acesso à câmera principal.\n");
    }

// LISTA DE SUSPEITOS DO ASSASSINATO
    public static void suspects() {

        System.out.println("\n---> SRA. JANE – Aposentada, apaixonada por insetos, remédios e seringas usadas.\n "
                + "Já foi investigada por adulteração nos medicamentos da empresa farmacêutica onde trabalhava.\n "
                + "Sempre está vestida com um colar de pérolas herdado da mãe.\n");
        System.out.println("---> ANNE ROSS – Especialista em Big Data, carrega diversos pendrives e fones de ouvido consigo.\n"
                + " É suspeita por ter invadido contas bancárias de pessoas que mantinham\n "
                + "vínculo com seu pai.\n");
        System.out.println("---> THOMAS WEELS – Cientista, foi professor da Universidade Hidenville mas\n"
                + "foi expulso depois de falsificar documentos sobre a morte de animais no laboratório\n"
                + "de Biologia. É um importante membro da Maçonaria.\n");
        System.out.println("---> DR. MCGALE – Médico legista, simpático ao governo ditatorial de Hidenville.\n"
                + " Foi capturado por liberais e teve uma fratura em uma de suas pernas.\n"
                + " Está sempre mancando e reclamando de sua pouca visão.\n");
        System.out.println("---> FÉLIX PURPLE – Dono de uma famosa galeria de Artes em Hidenville.\n"
                + "Já trabalhou como assistente administrativo de uma farmacêutica.\n"
                + "Foi preso por usar fotos intimas de membros do governo durante um de seus eventos.\n");
        System.out.println("---> OLIVER BANKS – Assistente de medicina legal, responsável pela limpeza\n"
                + "e conservação dos cadáveres. Estudante de química e por ser de uma família\n"
                + "conservadora, está sempre usando símbolos cristãos.\n");
    }

//CREDITOS DO JOGO
    public static void credits() {
        System.out.println("\n-- Emillyn Esteves--"
                + "\n-- Gabriel Max --"
                + "\n-- Isadora Beserra --"
                + "\n-- Matheus Makoto --"
                + "\n-- Raphaela Wagner --\n");
    }

// DESISTIR DO JOGO
    public static void desistir() {
        System.exit(0);
    }

// INTRODUÇÃO DO JOGO
    public static void intro() {
        System.out.println("\nSão 22:57 e a neblina noturna já dominou a cidade. O dia está um pouco frio, mas por conta das\n"
                + "últimas chuvas em Hidenville, tudo está úmido. Você está sozinho na sua sala da delegacia\n"
                + "arquivando alguns boletins de ocorrência ligados ao porte ilegal de armar tecnológicas...um café\n"
                + "deixaria você mais acordado mas a cafeteira não quer mais esquentar a água.... de repente o seu telefone toca:\n"
                + "\nTrimmmm!!!!!! Trimmm!!!!!! Trimmmm!!!!!!\n"
                + "\nVocê: Departamento de polícia de Hidenville, quem fala\n"
                + "\nDesconhecido:(ruídos) Eu.....é...(mais ruídos)...eu.....\n"
                + "\nVocê: Alô? Alô? \n"
                + "\nDesconhecido: Mataram! Mataram ela! (ruídos)... Antiga fábrica da !ASKFOODS.INC....Ajuda(ruídos)\n"
                + "\nO telefone desligou. Você está confuso e assustado, mas agora não precisa mais do café.\n"
                + "Você pegou as chaves do carro, equipou suas armas e partiu rumo à fábrica abandonada da !ASKFOODS.INC.\n");
        
        pausa(); //CHAMA A FUNÇÃO PARA PAUSAR OS TEXTOS
        
        System.out.println("\n---> VOCÊ CHEGOU AO LOCAL DO CRIME <---\n"
                + "\nVocê está dentro do prédio da !AKSFOODS.INC.\n"
                + "Apesar das luzes estarem ligadas...é bem difícil\n"
                + "enxergar as coisas por aqui. Somente se pode ver um longo corredor coberto por um carpete\n"
                + "que está muito sujo.Nas paredes estão algumas obras de arte e banners antigos da empresa,\n"
                + "o que dá uma sensação de abandono ao lugar...\n");
        
        pausa(); //CHAMA A FUNÇÃO PARA PAUSAR OS TEXTOS
    }
    
// AMBIENTE DA COZINHA 
    static void cozinha(int desafio1, String nomeDoJogador, int vetorfinal[], int linhaDasPistas, String senhafinal[][]) {
        System.out.println("\n\n---> VOCÊ  ENTROU NA COZINHA <---");
        System.out.println("\nA cozinha está completamente destruída\n"
                + "e ao que tudo indica, apenas o fogão está funcionando…\n"
                + "inclusive usaram o fogão recentemente... mas quem faria isso?\n"
                + "\"Um bilhete na geladeira diz: “Jack, o tel. da \n"
                + "recepção mudou de número. Anote-o se quiser falar com\n"
                + "a Amanda: 11423-98795”. Um machado com manchas de sangue \n"
                + "está próximo da janela. Chegando mais perto é possível ver\n"
                + "que o sangue ainda esta fresco… Um pequeno lenço de\n"
                + "bolso na cor rosa está jogado dentro de uma caixa.\n"
                + "A câmera de segurança da cozinha não para de piscar…e um\n"
                + "pequeno computador de bordo está conectado à ela.\n");
        String desafio = desafio(desafio1);
        System.out.println(desafio);
        String alternativas = alternativas(desafio1);
        System.out.print(alternativas(desafio1));
        int i = 1;
        int j = 2;
        boolean resposta1 = true;
        do {
            int resposta = kb.nextInt();
            int respostaCorreta = validaResposta(desafio1);
            if (resposta == respostaCorreta) {
                System.out.println("\nResposta correta!\n\nVoce abriu a porta para o próximo ambiente!");
                System.out.println("\nUMA PARTE DA SENHA DA FINAL ---> "+senhafinal[linhaDasPistas][vetorfinal[0]]+"\n\nMEMORIZE-A!");
                resposta1 = false;
                return;
            } else {
                System.out.println("\nResposta Errada! Cuidado, você possui mais " + j + " tentativas!\n");
                i++;
                j--;
                if (i > 3) {
                    gameOver(nomeDoJogador);
                }
            }
        } while (resposta1 = true);
    }
    
// AMBIENTE DA SALA DE JANTAR 
    static void salaDeJantar(int desafio1, String nomeDoJogador, int vetorfinal[], int linhaDasPistas, String senhafinal[][]) {
        System.out.println("\n\n---> VOCÊ ENTROU NA SALA DE JANTAR <---");
        System.out.println("\nDiversos jornais sobre a polícia de Hidenville estão\n"
                + "colados na parede da sala de jantar. Um ventilador parece\n"
                + "estar ligados à dias... e está com um barulho insuportável e em um\n"
                + "quadro antigo na parede está escrito: K1ll_H1M!\n"
                + "Alguns notebooks e computadores estão espalhados por pequenas\n"
                + "mesas de madeira… No monitor de um dos computadores aparece a\n"
                + "lista dos sorteados para o jantar e o nome Anne está sublinhado.\n"
                + "Um fone de ouvido novo está sobre a mesa de jantar...\n"
                + "Um notebook está aberto para acesso.\n");
        String desafio = desafio(desafio1);
        System.out.println(desafio);
        String alternativas = alternativas(desafio1);
        System.out.print(alternativas(desafio1));
        int i = 1;
        int j = 2;
        boolean resposta1 = true;
        do {
            int resposta = kb.nextInt();
            int respostaCorreta = validaResposta(desafio1);
            if (resposta == respostaCorreta) {
                System.out.println("\nResposta correta!\n\nVoce abriu a porta para o próximo ambiente!");
                System.out.println("\nUMA PARTE DA SENHA DA FINAL ---> "+senhafinal[linhaDasPistas][vetorfinal[1]]+"\n\nMEMORIZE-A!");
                resposta1 = false;
                return;
            } else {
                System.out.println("\nResposta Errada! Cuidado, você possui mais " + j + " tentativas!\n");
                i++;
                j--;
                if (i > 3) {
                    gameOver(nomeDoJogador);
                }
            }
        } while (resposta1 = true);
    }

// AMBIENTE DA SALA DE ESTAR 
    static void salaDeEstar(int desafio1, String nomeDoJogador, int vetorfinal[], int linhaDasPistas, String senhafinal[][]) {
        System.out.println("\n\n---> VOCÊ ENTROU NA SALA DE ESTAR <---");
        System.out.println("\nAlguns livros técnicos empoeirados e a disposição\n"
                + "dos móveis mostram que essa sala era a recepção da fábrica.\n"
                + "Entre as almofadas sujas do sofá, está jogado um pequeno colar\n"
                + "com um crucifixo quebrado. O sistema de exaustão da fábrica\n"
                + "ainda funciona e está exalando um cheiro de mofo muito estranho.\n"
                + "Algumas revistas com propagandas da !Ask Food Inc foram deixados\n"
                + "juntos à anotações de circuitos lógicos sobre um balcão.\n"
                + "Um computador está ligado e na tela parece ter um menu de acesso...\n");
        String desafio = desafio(desafio1);
        System.out.println(desafio);
        String alternativas = alternativas(desafio1);
        System.out.print(alternativas(desafio1));
        int i = 1;
        int j = 2;
        boolean resposta1 = true;
        do {
            int resposta = kb.nextInt();
            int respostaCorreta = validaResposta(desafio1);
            if (resposta == respostaCorreta) {
                System.out.println("\nResposta correta!\n\nVoce abriu a porta para o próximo ambiente!");
                System.out.println("\nUMA PARTE DA SENHA DA FINAL ---> "+senhafinal[linhaDasPistas][vetorfinal[2]]+"\n\nMEMORIZE-A!");
                resposta1 = false;
                return;
            } else {
                System.out.println("\nResposta Errada! Cuidado, você possui mais " + j + " tentativas!\n");
                i++;
                j--;
                if (i > 3) {
                    gameOver(nomeDoJogador);
                }
            }
        } while (resposta1 = true);
    }
    
// AMBIENTE DA ENFERMARIA 
    static void enfermaria(int desafio1, String nomeDoJogador, int vetorfinal[], int linhaDasPistas, String senhafinal[][]) {
        System.out.println("\n\n---> VOCÊ ENTROU NA ENFERMARIA <---");
        System.out.println("\nUm livro de bolso com os dizeres: On 11:38h.\n"
                + "Sobre uma mesa está um histórico de atendimentos ambulatoriais.\n"
                + "Um mapa com instruções de aplicação de vacina está queimado e\n"
                + "junto com os medicamentos está um estojo de lentes de contato.\n"
                + "O mapa encima da maca está marcando um ponto que parece\n"
                + "ser o Office do Gerente... O computador está ligado.\n");
        String desafio = desafio(desafio1);
        System.out.println(desafio);
        String alternativas = alternativas(desafio1);
        System.out.print(alternativas(desafio1));
        int i = 1;
        int j = 2;
        boolean resposta1 = true;
        do {
            int resposta = kb.nextInt();
            int respostaCorreta = validaResposta(desafio1);
            if (resposta == respostaCorreta) {
                System.out.println("\nResposta correta!\n\nVoce abriu a porta para o próximo ambiente!");
                System.out.println("\nUMA PARTE DA SENHA DA FINAL ---> "+senhafinal[linhaDasPistas][vetorfinal[3]]+"\n\nMEMORIZE-A!");
                resposta1 = false;
                return;
            } else {
                System.out.println("\nResposta Errada! Cuidado, você possui mais " + j + " tentativas!\n");
                i++;
                j--;
                if (i > 3) {
                    gameOver(nomeDoJogador);
                }
            }
        } while (resposta1 = true);
    }

// AMBIENTE DO QUARTO CABINE Z
    static void quartoZ(int desafio1, String nomeDoJogador, int vetorfinal[], int linhaDasPistas, String senhafinal[][]) {
        System.out.println("\n\n---> VOCÊ ENTROU NO QUARTO Z <---");
        System.out.println("\nA cabine de letra Z funcionava como local de\n"
                + "descanso para os funcionário de trabalho insalubre da empresa…\n"
                + "mas parece que foi convertida em um quarto de solteiro\n"
                + "depois do prédio ser invadido por hackers.\n"
                + "Entre alguns papéis está esquecido um pequeno símbolo religioso…\n"
                + "Alguns comprimidos de remédio vencido estão jogados próximos a\n"
                + "uma cama de solteiro. Em uma parede existem diversos computadores\n"
                + "que parecem receber as imagens da câmera de segurança do local.\n"
                + "O computador principal está funcionando…\n");
        String desafio = desafio(desafio1);
        System.out.println(desafio);
        String alternativas = alternativas(desafio1);
        System.out.print(alternativas(desafio1));
        int i = 0;
        int j = 2;
        boolean resposta1 = true;
        do {
            int resposta = kb.nextInt();
            int respostaCorreta = validaResposta(desafio1);
            if (resposta == respostaCorreta) {
                System.out.println("\nResposta correta!\n\nVoce abriu a porta para o próximo ambiente!");
                System.out.println("\nUMA PARTE DA SENHA DA FINAL ---> "+senhafinal[linhaDasPistas][vetorfinal[4]]+"\n\nMEMORIZE-A!");
                resposta1 = false;
                return;
            } else {
                System.out.println("\nResposta Errada! Cuidado, você possui mais " + j + " tentativas!\n");
                i++;
                j--;
                if (i > 3) {
                    gameOver(nomeDoJogador);
                }
            }
        } while (resposta1 = true);
    }

// AMBIENTE DO OFFICE DO GERENTE
    static void office(int linhaDasPistas, String[][] matriz, String nomeDoJogador) {
        System.out.println("\n\n---> VOCÊ ENTROU NO ESCRITÓRIO DO GERENTE <---");
        System.out.println("\nLivros de balanço da empresa estão organizados em uma\n"
                + "estante e documentos de contabilidade estão jogados em um canto.\n"
                + "Um mapa com circuitos diz como ativar o áudio da fábrica…\n"
                + "mas você não precisa disso! No cinzeiro tem um cigarro que foi\n"
                + "apagado a pouco tempo... muito estranho… Entre canetas e papéis\n"
                + " estão jogadas algumas pérolas... O computador da sala\n"
                + "tem acesso total às cameras. No monitor está escrito:\n"
                + "Solicitando código para acessar o histórico das câmeras...\n");

        System.out.println("\nDIGITE A SENHA PARA ACESSAR A CÂMERA DE SEGURANÇA: ");
        
        String fim = matriz[linhaDasPistas][5];

        int i = 0;
        int j = 2;
        boolean resposta1 = true;
        do {
            String senhainserida = kb.next().toUpperCase();
            
            if (senhainserida.equals(fim)) {
                murderer();
                exitGame(nomeDoJogador);
            } else {
                System.out.println("\nResposta Errada! Cuidado, você possui mais " + j + " tentativas!\n");
                i++;
                j--;
                if (i >= 2) {
                    gameOver(nomeDoJogador);
                }
            }
        } while (resposta1 == true);
    }

//VETOR DE DESAFIOS COM AS PERGUNTAS
    public static String desafio(int desafio1) {
        String[] desafio = new String[15];
        desafio[0] = "\n-----------------------DESAFIO--------------------------\n"
                + "Uma mensagem está aberta nesse computador e um funcionário de"
                + "\nnome Josh diz: “O que importa ao novo gerente comercial da "
                + "\n!ASKFOODS é a organização!” Segundo ele, sem metodologia uma "
                + "\nempresa não prospera. Ao tentar acessar a câmera aparece a "
                + "\nseguinte mensagem: Quais as consoantes do nome do criador da "
                + "\nteoria que Josh quer implantar?\n";
        desafio[1] = "\n-----------------------DESAFIO--------------------------\n"
                + "A tela apresenta um gráfico de vendas do cereal “Doolb” durante"
                + "\na campanha “Por dentro da !ASKFOODS.INC”. As vendas parecem "
                + "\nque cresceram bastante! Mas para sair dessa tela é preciso preencher"
                + "\no lucro líquido das vendas do dia de lançamento que foi de 3000"
                + "\ncereais. O preço de venda de uma caixa de cereal é de U$5,00. "
                + "\nO custo fixo para produzir uma caixa é de U$1,50 mais U$0,30 de "
                + "\nimpostos por unidade.\n";
        desafio[2] = "\n-----------------------DESAFIO--------------------------\n"
                + "Esse computador parece que foi modificado pelos hackers que"
                + "\ninvadiram o prédio da !ASKFOODS.INC  e está solicitando a"
                + "\nresolução da igualdade de 010xxx111 = x4x, sendo que o valor"
                + "\nfinal deve ser convertido para a base hexadecimal.\n";
        desafio[3] = "\n-----------------------DESAFIO--------------------------\n"
                + "Um email confidencial do diretor administrativo está aberto\n"
                + "\n nesse computador e diz que o acesso à câmera do ambiente é o "
                + "\nnovo modelo de gestão do setor de RH da !ASKFOODSINC."
                + "\nUm pequeno desenho mostra a sequência invertida de Maslow."
                + "\nÉ necessário preencher 5 espaços e em cada casa estão as "
                + "\niniciais R E S S F, respectivamente:\n";
        desafio[4] = "\n-----------------------DESAFIO--------------------------\n"
                + "Um bilhete ao lado do computador diz: "
                + "\n“Arnold, a nova senha de acesso é a Inicial do nome e sobrenome"
                + "\ndo diretor da !ASK FOOD.INC em binário: ALAN DANIEL FAITH\n";
        desafio[5] = "\n-----------------------DESAFIO--------------------------\n"
                + "A senha é o coeficiente linear da equação acrescido de 23."
                + "A equação é F(x)= 3x + 9\n";
        desafio[6] = "\n-----------------------DESAFIO--------------------------\n"
                + "Uma página de pesquisa está aberta e nela diz que a teoria"
                + "\nmotivacional de Frederick Herzberg defende a ideia de que "
                + "\nexistem dois fatores responsáveis pela satisfação de um "
                + "\nfuncionário no ambiente de trabalho. O primeiro seria os"
                + "\nmotivadores e o segundo está cortado por algum tipo de banner"
                + "\nbem estranho... A resposta parece ser a senha de acesso à "
                + "\ncâmera...\n";
        desafio[7] = "\n-----------------------DESAFIO--------------------------\n"
                + "Para acessar a câmera desse computador é preciso somar o "
                + "\nmódulo das seguintes funções: I -3 + (- 25) I e I 45 I\n";
        desafio[8] = "\n-----------------------DESAFIO--------------------------\n"
                + "Foi deixado um bilhete ao lado do computador e nele está "
                + "\nescrito: “Mandy, por questões de segurança, eu precisei mudar"
                + "\na senha da câmera dessa sala, mas não conte nada para o "
                + "\nsegurança novato! O novo código de acesso são as iniciais da "
                + "\nempresa em base octal.”\n";
        desafio[9] = "\n-----------------------DESAFIO--------------------------\n"
                + "O computador está com um programa do antigo departamento "
                + "\nfinanceiro aberto e para fechá-lo é preciso dizer quando a"
                + "\nfunção feita para o departamento financeiro corta o eixo Y."
                + "\nA função é F(x) = 4x + 9. Ao destravar o programa o acesso "
                + "\na câmera será liberado.\n";
        desafio[10] = "\n-----------------------DESAFIO--------------------------\n"
                + "Parece que já tentaram acessar essa câmera alguns minutos "
                + "\natrás mas o código foi alterado.... a nova pergunta de "
                + "\nacesso é: Qual a teoria criada por Elton Mayo?\n";
        desafio[11] = "\n-----------------------DESAFIO--------------------------\n"
                + "A funcionária responsável pelo setor de marketing precisou "
                + "\nusar esse computador para preencher um formulário de gastos"
                + "\npessoais. Ela pegou um táxi da sede atual da empresa para "
                + "esse prédio desativado e preferiu vir de táxi. A bandeirada"
                + "\natual em Hidenville está R$3,50 durante o dia e R$4,50 durante"
                + "\nà noite acrescidos de 70 centavos por quilômetro rodado."
                + "\nEla saiu da empresa às 18:47 e percorreu 18km. Qual o valor "
                + "\npago pela funcionária?\n";
        desafio[12] = "\n-----------------------DESAFIO--------------------------\n"
                + "Que estranho... o bloco de notas está aberto nesse computador"
                + "\ne diz: “ A senha de acesso às câmeras é a sequência das "
                + "\nletras do cereal “doolb” escritas ao contrário:\n";
        desafio[13] = "\n-----------------------DESAFIO--------------------------\n"
                + "Um recado enviado por email para o usuário desse computador"
                + "\ndiz: “Cara, hoje estive na inspeção e o novo lote de bolachas"
                + "\nsabor chocolate está com uma certa quantidade de material "
                + "\nradioativo. Solicitei ao funcionário do TI que modificasse o"
                + "\ncódigo das câmeras do setor de produção, mas por algum motivo,"
                + "\na senha dessa câmera mudou também. Então a nova senha são os "
                + "\nnúmeros 235 convertidos em binários e depois negados."
                + "\n Abraços, Clerman.”\n";
        desafio[14] = "\n-----------------------DESAFIO--------------------------\n"
                + "Um circuito da câmera de segurança está desligado."
                + "\nPara reativá-lo é necessário digitar a negação dos binários"
                + "\nobtidos através dos números ímpares do telefone da recepção "
                + "\nda empresa:\n";

        return desafio[desafio1];
    }
    
//VETOR COM A HISTÓRIA FINAL, O ASSASSINO E O MOTIVO DO ASSASSINATO
    public static void murderer() {
        int culpado = rnd.nextInt(6);

        String[] textoDosCulpados = new String[6];

        textoDosCulpados[0] = "\nSra.Jane.\n\n"
                + "Durante o apagão, Sra.Jane foi em busca de velas e acabou\n"
                + "cruzando com a funcionária responsável pelo evento e a mesma\n"
                + "começou a acusa-lá pelo desaparecimento de uma amiga e antiga\n"
                + "funcionária da empresa farmacêutica que Sra.Jane trabalhou,\n"
                + "dizendo que tinha provas sobre o desaparecimento e que dessa\n"
                + "vez, a justiça seria feita. E com isso, Sra.Jane tirou uma\n"
                + "seringa com um veneno letal que sempre carregava na bolsa\n"
                + "e aplicou na funcionária, causando sua morte instantânea.\n"
                + "\nEnfim... você descobriu quem era o resposável pelo Murder!\n";
        textoDosCulpados[1] = "\nAnne Ross\n\n"
                + "Se aproveitando da escuridão, Anne começou a andar pela\n"
                + "antiga fábrica, chegando em uma sala com um notebook e alguns\n"
                + "arquivos. Os arquivos contem apenas documentos antigos sobre\n"
                + "a !Ask Foods, já o notebook estava ligado com algumas\n"
                + "informações na tela como a lista de convidados para o jantar.\n"
                + "Ao começar a mexer, Anne descobriu que o notebook continha\n"
                + "mais do simples informações do evento como lista de clientes\n"
                + "e fornecedores, dados bancários, etc. Com isso Anne Ross\n"
                + "começou a roubar informações da empresa, até ser pega pela\n"
                + "funcionária que vinha passando pelo corredor, que ao reparar\n"
                + "o que estava acontecendo ameaçou chamar a polícia, como já\n"
                + "era suspeita de uma investigação policial, Anne não podia\n"
                + "deixar isso acontecer, optando por atacar a funcionária,que\n"
                + "acabou caindo e morrendo com o impacto.\n"
                + "\nEnfim... você descobriu quem era o resposável pelo Murder!\n";
        textoDosCulpados[2] = "\nThomas Weels\n\n"
                + "Durante a queda de energia, Thomas saiu em busca de um\n"
                + "banheiro e em um dos corredores esbarrou com a funcionária do\n"
                + "evento. O que Thomas não esperava era que a funcionária do\n"
                + "evento fosse ex-funcionária da universidade de Hidenville,\n"
                + "onde Thomas dava aula antes de ser expulso. E a principal\n"
                + "responsável por sua expulsão foi a funcionária que ao achar\n"
                + "documentos falsos sobre a morte de animais no laboratório,\n"
                + "foi falar direto com a diretoria da universidade, fazendo\n"
                + "com que Thomas perca seu emprego. Tomado pela raiva de ver a\n"
                + "mulher em sua frente, Thomas aproveitando-se da falta de\n"
                + "iluminação, atacou a funcionária, tendo sua vingança, por\n"
                + "ter sua carreira arruinada.\n"
                + "\nEnfim... você descobriu quem era o resposável pelo Murder!\n";
        textoDosCulpados[3] = "\nDr McGale.\n\n"
                + "Devido a sua pouca visão e o fato de estar tudo escuro,\n"
                + "Dr McGale estava perdido na fábrica. Ao continuar caminhando,\n"
                + "encontrou a funcionária do evento, e após pedir algumas\n"
                + "informações a ela, e ela ter respondido de forma grosseira,\n"
                + "Dr McGale, ajustou seus óculos, olhou melhor pra funcionária\n"
                + "e a reconheceu como parte do grupo de liberais pelo qual ele\n"
                + "foi capturado. Sem pensar duas vezes, tirou a arma da cinta\n"
                + "que sempre carregava, e atirou na funcionária, que morreu na\n"
                + "hora\n"
                + "\nEnfim... você descobriu quem era o resposável pelo Murder!\n";
        textoDosCulpados[4] = "\nFelix Purple.\n\n"
                + "Durante o apagão, Felix saiu a procura de lanternas e acabou\n"
                + "encontrando a funcionária em um dos corredores. Eles já se\n"
                + "conheciam pois Felix trabalhou em um projeto na área de moda\n"
                + "onde a funcionária participou como modelo. Mas o que Felix\n"
                + "Purple não sabia era que a funcionária guardava rancor dele\n"
                + "por conta da humilhação que o marido dela sofreu quando suas\n"
                + "fotos íntimas foram usadas em um de seus eventos. E com isso\n"
                + "a funcionária aproveitando a escuridão atacou Felix,que foi\n"
                + "capaz de se defender, atacando a mulher na cabeça diversas\n"
                + "vezes até ela estar morta.\n"
                + "\nEnfim... você descobriu quem era o resposável pelo Murder!\n";
        textoDosCulpados[5] = "\nOliver Banks.\n\n"
                + "Depois de se mudar para Hidenville, Oliver teve um relacionamento\n"
                + "amoroso com a funcionária responsável pelo evento. Porém, o\n"
                + "relacionamento durou pouco por conta de uma traição da parte dela.\n"
                + "Durante o apagão, a funcionária foi a procura de Oliver, pedindo\n"
                + "uma segunda chance e dizer que sentia muito. Mas Oliver, muito\n"
                + "recentido não aceitou e com isso eles começaram a discutir. Oliver\n"
                + "tomado pela raiva, atacou a ex-namorada e a asfixiou até a morte.\n"
                + "\nEnfim... você descobriu quem era o resposável pelo Murder!\n";

        System.out.println(textoDosCulpados[culpado]);
    }
//FUNÇÃO COMPOSTA POR UM VETOR COM AS OPÇÕES DE RESPOSTAS ENUMERADAS DE 1 A 4
    public static String alternativas(int desafio1) {

        String[] alternativas = new String[15];

        alternativas[0] = "1-XMBWR"
                + "\n2-XWBR"
                + "\n3-MXWBR"//RESPOSTA CORRETA
                + "\n4-MWBR"
                + "\nDigite a resposta: ";
        alternativas[1] = "1-R$14098,00"
                + "\n2-R$14099,00"
                + "\n3-R$13000,31"
                + "\n4-R$14098,50"//RESPOSTA CORRETA
                + "\nDigite a resposta: ";
        alternativas[2] = "1-367"//RESPOSTA CORRETA
                + "\n2-247"
                + "\n3-366"
                + "\n4-245"
                + "\nDigite a resposta: ";
        alternativas[3] = "1- Social, estima, fisiologica"
                + "\n2-Realizações , estima, segurança, social, fisiologica"
                + "\n3-Realizações , estima, social, segurança, fisiologica"//RESPOSTA CORRETA
                + "\n4-Estima , segurança , social,fisiologica"
                + "\nDigite a resposta: ";
        alternativas[4] = "1-101010001111"
                + "\n2-101110011111"
                + "\n3-101000100111"
                + "\n4-101010011111"//RESPOSTA CORRETA
                + "\nDigite a resposta: ";
        alternativas[5] = "1-31"
                + "\n2-32"//RESPOSTA CORRETA
                + "\n3-30"
                + "\n4-33"
                + "\nDigite a resposta: ";
        alternativas[6] = "1-Higienicos"//RESPOSTA CORRETA
                + "\n2-Motivacionais"
                + "\n3-Disposição"
                + "\n4-Condicionamento"
                + "\nDigite a resposta: ";
        alternativas[7] = "1-72"
                + "\n2-71"
                + "\n3-70"
                + "\n4-73"//RESPOSTA CORRETA
                + "\nDigite a resposta: ";
        alternativas[8] = "1-1218"
                + "\n2-1117"
                + "\n3-1216"
                + "\n4-1217"//RESPOSTA CORRETA
                + "\nDigite a resposta: ";
        alternativas[9] = "1- -9"//RESPOSTA CORRETA
                + "\n2- -8"
                + "\n3- -7"
                + "\n4- -10"
                + "\nDigite a resposta: ";
        alternativas[10] = "1-Teoria da administração classica"
                + "\n2-Teoria da administração cientifica"
                + "\n3-Teoria burocratica"
                + "\n4-Teoria das relações humanas"//RESPOSTA CORRETA
                + "\nDigite a resposta: ";
        alternativas[11] = "1-R$16,00"
                + "\n2-R$16,10"//RESPOSTA CORRETA
                + "\n3-R$16,05"
                + "\n4-R$17,00"
                + "\nDigite a resposta: ";
        alternativas[12] = "1-BLOOD"//RESPOSTA CORRETA
                + "\n2-DLOOB"
                + "\n3-DLOOD"
                + "\n4-BLOD"
                + "\nDigite a resposta: ";
        alternativas[13] = "1-0100011"
                + "\n2-1011101"
                + "\n3-1011111"
                + "\n4-0100010"//RESPOSTA CORRETA
                + "\nDigite a resposta: ";
        alternativas[14] = "1-111110011111001101"
                + "\n2-000001100000110010"//RESPOSTA CORRETA
                + "\n3-000001100011000010"
                + "\n4-000001100000110011"
                + "\nDigite a resposta: ";
        return alternativas[desafio1];
    }

//FUNÇÃO COM VETOR PREENCHIDO COM AS RESPOSTAS CORRETAS
    public static int validaResposta(int desafio1) {
        int[] validaResposta = new int[15];

        validaResposta[0] = 3;
        validaResposta[1] = 4;
        validaResposta[2] = 1;
        validaResposta[3] = 3;
        validaResposta[4] = 4;
        validaResposta[5] = 2;
        validaResposta[6] = 1;
        validaResposta[7] = 4;
        validaResposta[8] = 4;
        validaResposta[9] = 1;
        validaResposta[10] = 4;
        validaResposta[11] = 2;
        validaResposta[12] = 1;
        validaResposta[13] = 4;
        validaResposta[14] = 2;

        return validaResposta[desafio1];
    }

// FUNÇÃO COM AS POSSÍVEIS SENHAS PARA O ACESSO ÀS CAMERAS DE SEGURANÇA
    public static String[][] matriz() {

        String[][] senha = new String[3][6];
        senha[0][0] = "B";
        senha[0][1] = "L";
        senha[0][2] = "O";
        senha[0][3] = "O";
        senha[0][4] = "D";
        senha[0][5] = "BLOOD";

        senha[1][0] = "C";
        senha[1][1] = "O";
        senha[1][2] = "R";
        senha[1][3] = "P";
        senha[1][4] = "O";
        senha[1][5] = "CORPO";

        senha[2][0] = "M";
        senha[2][1] = "O";
        senha[2][2] = "R";
        senha[2][3] = "T";
        senha[2][4] = "E";
        senha[2][5] = "MORTE";

        return senha;
    }

    //FUNÇÃO DE FIM DE JOGO CASO O JOGADOR PERCA
    public static void gameOver(String nomeDoJogador) {
        System.out.println("A porta do ambiente abriu subitamente.\n"
                + "Um tiro foi disparado em direção a você!\n"
                + "Você foi morto pelo assassino, " + nomeDoJogador + " !");
        System.out.println("  ^\n"
                            + "         | |\n"
                            + "       @#####@\n"
                            + "     (###   ###)-.\n"
                            + "   .(###     ###) \\\n"
                            + "  /  (###   ###)   )\n"
                            + " (=-  .@#####@|_--\"\n"
                            + " /\\    \\_|l|_/ (\\\n"
                            + "(=-\\     |l|    /\n"
                            + " \\  \\.___|l|___/\n"
                            + " /\\      |_|   /\n"
                            + "(=-\\._________/\\\n"
                            + " \\             /\n"
                            + "   \\._________/\n"
                            + "     #  ----  #\n"
                            + "     #   __   #\n"
                            + "     \\########/\n");
        System.exit(0);
    }

    //FUNÇÃO QUE EMBARALHA AS COLUNAS DA SENHA DO ÚLTIMO AMBIENTE
    public static int[] embaralha() {
        int pista1 = rnd.nextInt(5);
        int pista2 = rnd.nextInt(5);
        if (pista2 == pista1) {
            do {
                pista2 = rnd.nextInt(5);
            } while (pista2 == pista1);
        }
        int pista3 = rnd.nextInt(5);
        if ((pista3 == pista1) || (pista3 == pista2)) {
            do {
                pista2 = rnd.nextInt(5);
            } while ((pista3 == pista1) || (pista3 == pista2));
        }
        int pista4 = rnd.nextInt(5);
        if ((pista4 == pista1) || (pista4 == pista2) || (pista4 == pista3)) {
            do {
                pista2 = rnd.nextInt(5);
            } while ((pista4 == pista1) || (pista4 == pista2) || (pista4 == pista3));
        }
        int pista5 = rnd.nextInt(5);
        if ((pista5 == pista1) || (pista5 == pista2) || (pista5 == pista3) || (pista5 == 4)) {
            do {
                pista2 = rnd.nextInt(5);
            } while ((pista5 == pista1) || (pista5 == pista2) || (pista5 == pista3) || (pista5 == 4));
        }
        int[] vetorEmbaralhado = new int[5];
        vetorEmbaralhado[0] = pista1;
        vetorEmbaralhado[1] = pista2;
        vetorEmbaralhado[2] = pista3;
        vetorEmbaralhado[3] = pista4;
        vetorEmbaralhado[4] = pista5;

        return vetorEmbaralhado;

    }
//VETOR COM OS ASSASSINOS POSSÍVEIS
    public static String murderer(int culpado) {
        String[] murder = new String[6];
        murder[0] = "sraJane";
        murder[1] = "anneRoss";
        murder[2] = "thomasWeels";
        murder[3] = "drMcgale";
        murder[4] = "felixPurple";
        murder[5] = "oliverBanks";

        return murder[culpado];
    }
    
//FUNÇÃO DE FIM DE JOGO CASO O JOGADOR PERCA
    public static void exitGame(String nomeDoJogador) {
        System.out.println("  ^\n"
                            + "         | |\n"
                            + "       @#####@\n"
                            + "     (###   ###)-.\n"
                            + "   .(###     ###) \\\n"
                            + "  /  (###   ###)   )\n"
                            + " (=-  .@#####@|_--\"\n"
                            + " /\\    \\_|l|_/ (\\\n"
                            + "(=-\\     |l|    /\n"
                            + " \\  \\.___|l|___/\n"
                            + " /\\      |_|   /\n"
                            + "(=-\\._________/\\\n"
                            + " \\             /\n"
                            + "   \\._________/\n"
                            + "     #  ----  #\n"
                            + "     #   __   #\n"
                            + "     \\########/\n");
        System.exit(0);
    }
}
