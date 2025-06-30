import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Formulario extends JFrame { 
    //declarar elemento da barra
    private JMenuItem saveItem;
    private JMenuItem exitItem;
    private JMenu sendSub;
    private JMenuItem sendMail;
    private JMenuItem sendPrinter;
    private JMenuItem copyItem;
    private JMenuItem pasteItem;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu editMenu;
    //paineis
    private JPanel mainPanel;
    private JPanel personalPanel;
    private JPanel cvPanel;
    private JPanel areaPanel;
    private JPanel buttonPanel;

    private JPanel txtFieldTop(String label, JComponent component) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.add(new JLabel(label), BorderLayout.WEST);
        panel.add(component, BorderLayout.CENTER);
        //"anulador de responsividade"
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, panel.getPreferredSize().height));
        return panel;
    }

    private static JPanel subPanelMaker() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(null);
        panel.setMaximumSize(null);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        return panel;
    }
    
    public Formulario() {
        //Cria a janela
        JFrame frame = new JFrame();
        this.setTitle("Ficha de Cadastro");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 700);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        //Instancia da barra
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");
        sendSub = new JMenu("Send");
        sendMail = new JMenuItem("Email");
        sendPrinter = new JMenuItem("Print");
        copyItem = new JMenuItem("Copy");
        pasteItem = new JMenuItem("Paste");
        //hierarquia de menu
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        fileMenu.add(saveItem);
        fileMenu.add(sendSub);
        sendSub.add(sendMail);
        sendSub.add(sendPrinter);
        fileMenu.add(exitItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        setJMenuBar(menuBar);

        //instancia dos paineis
        mainPanel = new JPanel();
        personalPanel = subPanelMaker();
        cvPanel = subPanelMaker();
        areaPanel = subPanelMaker();
        buttonPanel = subPanelMaker();
        
        //set layout do painel principal
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        //importa comic sans (pq sim)
        Font comicSansFont = new Font("Comic Sans MS", Font.PLAIN, 16);
        //adiciona paineis no painel principal
        frame.add(mainPanel);
        mainPanel.add(personalPanel);
        mainPanel.add(cvPanel);
        mainPanel.add(areaPanel);
        mainPanel.add(buttonPanel);

        /* bloco de codigo destinado a colorir os subpaineis para facilitar suas respectivas identificações
        personalPanel.setBackground(Color.RED);
        cvPanel.setBackground(Color.BLUE);
        areaPanel.setBackground(Color.GREEN);
        buttonPanel.setBackground(Color.PINK);
        */  

        //Painel de info pessoais
        JLabel titulo = new JLabel("Informação Pessoal");
        titulo.setFont(comicSansFont);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setAlignmentY(TOP_ALIGNMENT);
        personalPanel.add(titulo);
        personalPanel.add(Box.createVerticalStrut(10));
        personalPanel.add(txtFieldTop("Nome:", new JTextField()));
        personalPanel.add(txtFieldTop("idade:", new JTextField()));
        //radial checkbox
        JPanel genderPanel = new JPanel(new BorderLayout(5, 5));
        genderPanel.add(new JLabel("Sexo:"), BorderLayout.WEST);
        JRadioButton female = new JRadioButton("Feminino");
        JRadioButton male = new JRadioButton("Masculino");
        //agrupamento
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(female);
        genderGroup.add(male);
        JPanel checkBox = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        checkBox.add(female); 
        checkBox.add(male);
        genderPanel.add(checkBox, BorderLayout.CENTER);
        //contenção de responsividade do painel
        genderPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, genderPanel.getPreferredSize().height));
        personalPanel.add(genderPanel);

        //Painel de Curriculum Vitae
        JLabel curriculum = new JLabel("Curriculum Vitae");
        curriculum.setAlignmentX(Component.CENTER_ALIGNMENT);
        curriculum.setAlignmentY(TOP_ALIGNMENT);
        JTextArea txt = new JTextArea();
        JScrollPane rollTxt = new JScrollPane(txt);
        cvPanel.add(curriculum);
        cvPanel.add(Box.createVerticalStrut(10));
        cvPanel.add(rollTxt);
        
        //Painel de áreas
        JLabel area = new JLabel("Áreas");
        area.setAlignmentX(Component.CENTER_ALIGNMENT);
        area.setAlignmentY(TOP_ALIGNMENT);
        areaPanel.add(area);
        JPanel interesse = new JPanel();
        JPanel atuação = new JPanel();
        interesse.add(new JLabel("Interesse:"));
        interesse.add(new JComboBox<>(new String[]{"Desenvolvedor"}));
        atuação.add(new JLabel("Atuação:"));
        atuação.add(new JComboBox<>(new String[]{"Programação"}));
        areaPanel.add(interesse);
        areaPanel.add(atuação);
        //contem a responsividade
        areaPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, areaPanel.getPreferredSize().height));
    
        //Painel de Botões
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(new JButton("Salvar"));
        buttonPanel.add(new JButton("Anterior"));
        buttonPanel.add(new JButton("Proximo"));
        buttonPanel.add(new JButton("Novo"));
        buttonPanel.add(new JButton("Cancelar"));
        
        this.add(mainPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }
    public static void main(String[] args) {
        Formulario formulario = new Formulario();
        formulario.setVisible(true);
    }
}
