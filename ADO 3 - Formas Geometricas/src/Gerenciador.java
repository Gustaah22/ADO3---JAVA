import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Gerenciador {
    //Criação da Lista
    //ps. Entendi o final!
    private final static ArrayList<Formas> lista = new ArrayList<>();

    public static void add(Formas forma) {
        lista.add(forma);
    }

    //Utilização da areatotal
    public static double AreaTotal() {
        double soma = 0.0;

        //foreach
        for (Formas f : lista) {
            soma += f.Area();
        }
        return soma;
    }

    public static String listar() {
        StringBuilder message = new StringBuilder();

        for (Formas f : lista) {
            message.append(f.imprimir()).append(", \n");
        }

        return message.toString();
    }

    //Tela inicial da interface, deixando o usuario escolher
    public static void telaInicial() {
        JFrame app = new JFrame("Entrada");
        JLabel cabecalho = new JLabel("===== Menu - Formas Geometricas =====");
        JLabel primeiraOpcao = new JLabel("1 - Cadastrar");
        JLabel segundaOpcao = new JLabel("2 - Calcular Área Total");
        JLabel terceiraOpcao = new JLabel("3 - Listar");
        JLabel quartaOpcao = new JLabel("4 - Sair");
        JTextField areaDeTexto = new JTextField(25);
        JButton botaoOk = new JButton("Ok");
        JButton botaoCancelar = new JButton("cancelar");


        //Recebe um inteiro para que nesse caso servirá para fechar o frame/app
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setLayout(null);
        Dimension tamanho = new Dimension(500, 300);
        app.setPreferredSize(tamanho);

        //switch de escolhas a partir do numero informado pelo usuario na text area
        botaoOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int opcoes = Integer.parseInt(areaDeTexto.getText());
                switch (opcoes) {
                    case 1 -> Gerenciador.telaOpcoes();
                    case 2 -> JOptionPane.showMessageDialog(null, Gerenciador.AreaTotal());
                    case 3 -> JOptionPane.showMessageDialog(null, Gerenciador.listar());
                    case 4 -> System.exit(0);
                    default -> JOptionPane.showMessageDialog(null, "Valor não aceito");
                }
            }
        });

        botaoCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //Configuração de posição dos labels, textsAreas e buttons do frame
        cabecalho.setBounds(120, 15, 300, 25);
        primeiraOpcao.setBounds(65, 40, 200, 25);
        segundaOpcao.setBounds(65, 65, 200, 25);
        terceiraOpcao.setBounds(65, 90, 200, 25);
        quartaOpcao.setBounds(65, 115, 200, 25);
        areaDeTexto.setBounds(65, 140, 200, 25);
        botaoCancelar.setBounds(140, 170, 100, 25);
        botaoOk.setBounds(250, 170, 100, 25);

        //Chamando as "funções" para que apareçam no frame. Caso alguma dessas linhas de .add seja comentada ou apagada alguma parte das labels não irá aparecer na interface
        app.add(cabecalho);
        app.add(primeiraOpcao);
        app.add(segundaOpcao);
        app.add(terceiraOpcao);
        app.add(quartaOpcao);
        app.add(areaDeTexto);
        app.add(new JLabel());
        app.add(botaoCancelar);
        app.add(botaoOk);
        app.pack();
        app.setLocationRelativeTo(null);
        app.setVisible(true);
    }

    //Tela de opções após selecionar o cadastro de formas, segue basicamente a mesma forma da tela inicial mudando as funções do swtich para cada opção
    public static void telaOpcoes() {

        JFrame app = new JFrame("Entrada");
        JLabel cabecalho = new JLabel(" Formas ");
        JLabel primeiraOpcao = new JLabel("1 - Quadrado");
        JLabel segundaOpcao = new JLabel("2 - Circulo");
        JLabel terceiraOpcao = new JLabel("3 - Losango");
        JLabel quartaOpcao = new JLabel("4 - Voltar");
        JTextField areaDeTexto = new JTextField(25);
        JButton botaoOk = new JButton("Ok");
        JButton botaoCancelar = new JButton("Cancelar");

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setLayout(null);
        Dimension tamanho = new Dimension(500, 300);
        app.setPreferredSize(tamanho);

        cabecalho.setBounds(210, 15, 300, 25);
        primeiraOpcao.setBounds(65, 40, 200, 25);
        segundaOpcao.setBounds(65, 65, 200, 25);
        terceiraOpcao.setBounds(65, 90, 200, 25);
        quartaOpcao.setBounds(65, 115, 200, 25);
        areaDeTexto.setBounds(65, 140, 200, 25);
        botaoCancelar.setBounds(140, 170, 100, 25);
        botaoOk.setBounds(250, 170, 100, 25);

        app.add(cabecalho);
        app.add(primeiraOpcao);
        app.add(segundaOpcao);
        app.add(terceiraOpcao);
        app.add(quartaOpcao);
        app.add(areaDeTexto);
        app.add(new JLabel());
        app.add(botaoCancelar);
        app.add(botaoOk);
        app.pack();
        app.setLocationRelativeTo(null);
        app.setVisible(true);

        //Seleção de opções de valores na tela após selecionar a opção de cadastro
        botaoOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int opcoes = Integer.parseInt(areaDeTexto.getText());
                switch (opcoes) {
                    case 1 -> {
                        Quadrado q = new Quadrado();
                        Gerenciador.telaValores(q);
                    }
                    case 2 -> {
                        Circulo c = new Circulo();
                        Gerenciador.telaValores(c);
                    }
                    case 3 -> {
                        Losango l = new Losango();
                        Gerenciador.telaValores(l);
                    }
                    case 4 -> app.dispose();
                    default -> JOptionPane.showMessageDialog(null, "Valor não aceito");
                }
                //fecha a janela após a seleção da forma (diferente de system.exit)
                app.dispose();
            }
        });

        botaoCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                app.dispose();
            }
        });
    }

    //tela dos valores da forma selecionada
    public static void telaValores(final Formas f) {
        JFrame app = new JFrame("Entrada");
        JLabel primeiroValor = null;
        JLabel segundoValor = new JLabel("Diagonal Maior");
        JLabel cabecalho = null;
        JTextField areaDeTexto1 = new JTextField(25);
        JTextField areaDeTexto2 = new JTextField(25);
        areaDeTexto2.setVisible(false);

        //unica diferença dentro do if é que quando for selecionado o losango a area de texto que estava setada com visibilidade (false) virará true por conta das 2 medidas necessarias no losango
        if (f instanceof Quadrado) {
            cabecalho = new JLabel("===== Quadrado =====");
            primeiroValor = new JLabel("Lado do Quadrado");
            segundoValor.setVisible(false);
        } else if (f instanceof Circulo) {
            cabecalho = new JLabel("===== Circulo =====");
            primeiroValor = new JLabel("Raio");
            segundoValor.setVisible(false);
        } else if (f instanceof Losango) {
            cabecalho = new JLabel("===== Losango =====");
            primeiroValor = new JLabel("Diagonal Menor");
            areaDeTexto2.setVisible(true);
        }

        JButton botaoOk = new JButton("Ok");
        JButton botaoCancelar = new JButton("Cancelar");

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setLayout(null);
        Dimension tamanho = new Dimension(500, 300);
        app.setPreferredSize(tamanho);

        cabecalho.setBounds(70, 10, 300, 25);
        primeiroValor.setBounds(50, 80, 200, 25);
        areaDeTexto1.setBounds(250, 80, 200, 25);
        segundoValor.setBounds(50, 120, 200, 25);
        areaDeTexto2.setBounds(250, 120, 200, 25);
        botaoCancelar.setBounds(140, 170, 100, 25);
        botaoOk.setBounds(250, 170, 100, 25);

        app.add(cabecalho);
        app.add(primeiroValor);
        app.add(areaDeTexto1);
        app.add(segundoValor);
        app.add(areaDeTexto2);
        app.add(botaoCancelar);
        app.add(botaoOk);
        app.pack();
        app.setLocationRelativeTo(null);
        app.setVisible(true);

        botaoOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double primeiroValor = Double.parseDouble(areaDeTexto1.getText());
                //utiliza do ternario para o valor da areadetexto2 caso não haja valor o numero é convertido em zero, caso tenha valor o texto é convertido em decimal(double)
                double segundoValor = areaDeTexto2.getText().equals("") ? 0.0 : Double.parseDouble(areaDeTexto2.getText());

                //checando se os objetos são instancias de alguma classe
                if (f instanceof Quadrado){
                    ((Quadrado) f).setLado(primeiroValor);
                    f.setNome("Quadrado - ");
                }else if (f instanceof Circulo){
                    ((Circulo) f).setRaio(primeiroValor);
                    f.setNome("Circulo - ");
                }else if(f instanceof Losango){
                    if (segundoValor > primeiroValor){
                        ((Losango) f).setDiagonalMe(primeiroValor);
                        ((Losango) f).setDiagonalMa(segundoValor);
                    }else if(primeiroValor >= segundoValor){
                        ((Losango) f).setDiagonalMe(segundoValor);
                        ((Losango) f).setDiagonalMa(primeiroValor);
                    }

                    f.setNome("Losango - ");
                }
                Gerenciador.add(f);
                app.dispose();
            }
        });

        botaoCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                app.dispose();
            }
        });

    }
}