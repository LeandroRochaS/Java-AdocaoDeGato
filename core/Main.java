package core;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import core.methods.AdopterMethods;
import core.methods.CatMethods;
import entites.Adopter;
import entites.Cat;

public class Main {

	private static List<Cat> cats = new ArrayList<>();
	private static List<Adopter> adopters = new ArrayList<>();
	private static List<Cat> relatorio = new ArrayList<>();
	static JFrame frame;

	private static String dates[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
			"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
	private static String months[] = { "Jan", "feb", "Mar", "Apr", "May", "Jun", "July", "Aug", "Sup", "Oct", "Nov",
			"Dec" };
	private static String years[] = { "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989",
			"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002",
			"2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015",
			"2016", "2017", "2018", "2019" };

	private static String foods[] = {"Royal Canin Exigent", "Royal Canin Cat Premium Filhotes", "Farmina N&D", "Premier Pet Golden Gatos Castrados", 
			"Purina ProPlan Trato Urinário", "GranPlus Adultos", "Ração Biofresh Gatos", "Nutrilus Pro gatos", "Guabi Natural gato adulto castrado"};
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {
			// Instanciar as duas janelas
			AdopterWindow AdopterWindow = new AdopterWindow();
			CadastrarGatoWindow CadastrarGatoWindow = new CadastrarGatoWindow();
			AdotarGatoWindow AdotarGatoWindow = new AdotarGatoWindow();		
			
			// Configurar a barra de navegação (nav bar)
			JMenuBar menuBar = new JMenuBar();
			menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));

			// Menu Cadastros
			JMenu cadastrosMenu = new JMenu("Cadastros");
			
			JMenuItem AdopterMenuItem = new JMenuItem("Cadastro de Adotador");
			JMenuItem CadastroGatoMenuItem = new JMenuItem("Cadastro para Adotar Gato");
			
			
			
			AdopterMenuItem.addActionListener(e -> {
				AdopterWindow.setVisible(true);
				CadastrarGatoWindow.setVisible(false);
			});

			CadastroGatoMenuItem.addActionListener(e -> {
				AdopterWindow.setVisible(false);
				CadastrarGatoWindow.setVisible(true);
			});
			
		

			cadastrosMenu.add(AdopterMenuItem);
			cadastrosMenu.add(CadastroGatoMenuItem);
			

			menuBar.add(cadastrosMenu);

			// Menu Consultas
			JMenu consultasMenu = new JMenu("Consultas");

			JMenuItem consulta1MenuItem = new JMenuItem("Consultar Adotantes");
			JMenuItem consulta2MenuItem = new JMenuItem("Consultar Gatos");
			

			consulta1MenuItem.addActionListener(e -> {
				consultarAdopters();
			});

			consulta2MenuItem.addActionListener(e -> {
				consultarcats();
			});

			consultasMenu.add(consulta1MenuItem);
			consultasMenu.add(consulta2MenuItem);

			menuBar.add(consultasMenu);
			
			// Menu adoção
			JMenu AdotarMenu = new JMenu("Adotar Gato");

			JMenuItem adotarGatoMenuItem = new JMenuItem("Cadastro para Adotar Gato");


			adotarGatoMenuItem.addActionListener(e -> {
				AdopterWindow.setVisible(false);
				AdotarGatoWindow.setVisible(true);
			});


			AdotarMenu.add(adotarGatoMenuItem);
			

			menuBar.add(AdotarMenu);
			
			frame = new JFrame("Sistema de Adoção");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(800, 700);
			frame.setJMenuBar(menuBar);
			frame.setVisible(true);
			
			// Menu relatório
			JMenu relatorioMenu = new JMenu("Relatórios");
			
			JMenuItem relatorioPMenuItem = new JMenuItem("Relatório Provisões");
			JMenuItem relatorioCMenuItem = new JMenuItem("Relatório de gatos");

			relatorioPMenuItem.addActionListener(e -> {
				relatorioProvisoes();
			});
			
			relatorioCMenuItem.addActionListener(e -> {
				relatorioCat();
			});
			
			relatorioMenu.add(relatorioPMenuItem);
			relatorioMenu.add(relatorioCMenuItem);


			menuBar.add(relatorioMenu);
			
			frame = new JFrame("Sistema de Adoção");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(800, 700);
			frame.setJMenuBar(menuBar);
			frame.setVisible(true);
			
		});
	}

	public static class AdopterWindow extends JFrame implements ActionListener {
		
		private static final long serialVersionUID = 1L;
		private JLabel nameLabel;
		private JTextField nameTextField;
		private JLabel cpfLabel;
		private JTextField cpfTextField;
		private JLabel enderecoLabel;
		private JTextField enderecoTextField;
		private JLabel dobLabel;
		private JComboBox<String> dayComboBox;
		private JComboBox<String> monthComboBox;
		private JComboBox<String> yearComboBox;
		private JLabel telefoneLabel;
		private JTextField telefoneTextField;

		public AdopterWindow() {
			
			setTitle("Adopter Registration");
			setSize(800, 700);
			setLayout(new BorderLayout());

			JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

			JPanel formPanel = new JPanel();
			formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
			EmptyBorder margin = new EmptyBorder(10, 10, 10, 10);
			formPanel.setBorder(margin);
			nameLabel = new JLabel("Nome");
			nameTextField = new JTextField(10);
			nameTextField.setMaximumSize(new Dimension(200, 25));
			formPanel.add(nameLabel);
			formPanel.add(nameTextField);

			cpfLabel = new JLabel("CPF");
			cpfTextField = new JTextField(10);
			cpfTextField.setMaximumSize(new Dimension(200, 25));
			formPanel.add(cpfLabel);
			formPanel.add(cpfTextField);

			enderecoLabel = new JLabel("Endereço");
			enderecoTextField = new JTextField(20);
			enderecoTextField.setMaximumSize(new Dimension(200, 25));
			formPanel.add(enderecoLabel);
			formPanel.add(enderecoTextField);

			dobLabel = new JLabel("Data de Aniversario");
			formPanel.add(dobLabel);

			JPanel dobPanel = new JPanel();
			dobPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			dobPanel.setMaximumSize(new Dimension(200, 25));
			dayComboBox = new JComboBox<>(dates);
			monthComboBox = new JComboBox<>(months);
			yearComboBox = new JComboBox<>(years);
			dobPanel.add(dayComboBox);
			dobPanel.add(monthComboBox);
			dobPanel.add(yearComboBox);
			formPanel.add(dobPanel);

			telefoneLabel = new JLabel("Phone");
			telefoneTextField = new JTextField(20);
			telefoneTextField.setMaximumSize(new Dimension(200, 25));
			formPanel.add(telefoneLabel);
			formPanel.add(telefoneTextField);
			
			
			JButton cadastrarButton = new JButton("Register");
			cadastrarButton.addActionListener(this);			
			formPanel.add(cadastrarButton);
			formPanel.add(cadastrarButton);
	
			mainPanel.add(formPanel);
			add(mainPanel);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// Lógica para salvar o adotador na lista
			String name = nameTextField.getText();
			String cpf = cpfTextField.getText();
			String endereco = enderecoTextField.getText();
			String dob = dayComboBox.getSelectedItem().toString() + " " + monthComboBox.getSelectedItem().toString()
					+ " " + yearComboBox.getSelectedItem().toString();
			String telefone = telefoneTextField.getText();

			Adopter Adopter = new Adopter(cpf, name, endereco, telefone, dob);
			System.out.println("1 - "+ Adopter);
			adopters.add(Adopter);

			JOptionPane.showMessageDialog(this, "Adotador cadastrado com sucesso!" + Adopter.toString());

			nameTextField.setText("");
			cpfTextField.setText("");
			enderecoTextField.setText("");
			telefoneTextField.setText("");
		}
	}

	static class CadastrarGatoWindow extends JFrame implements ActionListener {
		private JTextField singleCodeTextField;
		private JTextField nameTextField;
		private JTextField raceTextField;
		private JTextField surnameTextField;
		private JTextField genderTextField;
		private JTextField ageTextField;
		private JComboBox<String> foodTextField;
		private JTextField quantityFoodTextField;
		private JTextField weightTextField;
		private JComboBox<String> dayInComboBox;
		private JComboBox<String> monthInComboBox;
		private JComboBox<String> yearInComboBox;
	

		public CadastrarGatoWindow() {
			setTitle("Cat Registration");
			setSize(800, 700);
			setLayout(new FlowLayout());

			JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

			JPanel formPanel = new JPanel();
			formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

			JLabel singleCodeLabel = new JLabel("Código único");
			singleCodeTextField = new JTextField(20);
			formPanel.add(singleCodeLabel);
			formPanel.add(singleCodeTextField);

			JLabel nameLabel = new JLabel("Nome");
			nameTextField = new JTextField(20);
			formPanel.add(nameLabel);
			formPanel.add(nameTextField);

			JLabel raceLabel = new JLabel("Raça");
			raceTextField = new JTextField(20);
			formPanel.add(raceLabel);
			formPanel.add(raceTextField);

			JLabel surnameLabel = new JLabel("Apelido");
			surnameTextField = new JTextField(20);
			formPanel.add(surnameLabel);
			formPanel.add(surnameTextField);

			JLabel dobInLabel = new JLabel("Data de Entrada");
			JPanel dobInPanel = new JPanel(new BorderLayout());
			dayInComboBox = new JComboBox<>(dates);
			monthInComboBox = new JComboBox<>(months);
			yearInComboBox = new JComboBox<>(years);
			dobInPanel.add(dayInComboBox, BorderLayout.WEST);
			dobInPanel.add(monthInComboBox, BorderLayout.CENTER);
			dobInPanel.add(yearInComboBox, BorderLayout.EAST);
			formPanel.add(dobInLabel);
			formPanel.add(dobInPanel);

			JLabel genderLabel = new JLabel("Sexo [Macho/Fêmea]");
			genderTextField = new JTextField(20);
			formPanel.add(genderLabel);
			formPanel.add(genderTextField);

			JLabel ageLabel = new JLabel("Idade Aproximada");
			ageTextField = new JTextField(20);
			formPanel.add(ageLabel);
			formPanel.add(ageTextField);

			JLabel foodLabel = new JLabel("Nome da ração");
			foodTextField = new JComboBox<>(foods);
			foodLabel.add(foodTextField);
			formPanel.add(foodLabel);
			formPanel.add(foodTextField);

			JLabel quantityFoodLabel = new JLabel("Quantidade de ração (em gramas)");
			quantityFoodTextField = new JTextField(20);
			formPanel.add(quantityFoodLabel);
			formPanel.add(quantityFoodTextField);

			JLabel weightLabel = new JLabel("Peso");
			weightTextField = new JTextField(20);
			formPanel.add(weightLabel);
			formPanel.add(weightTextField);

			mainPanel.add(formPanel);
			
			
			JButton cadastrarButton = new JButton("Register");
			cadastrarButton.addActionListener(this);

			mainPanel.add(cadastrarButton);

		

			add(mainPanel);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// Lógica para tratar o evento do botão de cadastrar
			Cat cat = criarCat();
			System.out.println("1 - "+ cat);

			cats.add(cat);

			// ... lógica para cadastrar a adoção do gato pelo Adopter

			// Exibir uma mensagem de sucesso
			JOptionPane.showMessageDialog(this, "Gato registrado com sucesso!");

			// Limpar os campos de texto
			singleCodeTextField.setText("");
			nameTextField.setText("");
			raceTextField.setText("");
			surnameTextField.setText("");
			genderTextField.setText("");
			ageTextField.setText("");
			
			quantityFoodTextField.setText("");
			weightTextField.setText("");
			
		}
		

		private Cat criarCat() {
			String singleCode = singleCodeTextField.getText();
			String name = nameTextField.getText();
			String race = raceTextField.getText();
			String surname = surnameTextField.getText();
			String gender = genderTextField.getText();
			String dayIn = (String) dayInComboBox.getSelectedItem();
			String monthIn = (String) monthInComboBox.getSelectedItem();
			String yearIn = (String) yearInComboBox.getSelectedItem();
			double age = Double.parseDouble(ageTextField.getText());
			String food = (String) foodTextField.getSelectedItem();
			String quantityFood = quantityFoodTextField.getText();
			String weight = weightTextField.getText();
			String cpfAdopte = "";
			String entryDate = dayIn + "/" + monthIn + "/" + yearIn;
			String exitDate = "";

			Cat cat = new Cat(singleCode, name, race, surname, gender, entryDate, age, food, quantityFood, weight,
					exitDate, cpfAdopte);

			return cat;
		}

	}
	static class AdotarGatoWindow extends JFrame implements ActionListener {
		private JTextField singleCodeTextField;
		private JTextField cpfAdopteTextField;
		private JComboBox<String> dayOutComboBox;
		private JComboBox<String> monthOutComboBox;
		private JComboBox<String> yearOutComboBox;
		
		public AdotarGatoWindow() {
			setTitle("Adopt Cat Registration");
			setSize(800, 700);
			setLayout(new FlowLayout());

			JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

			JPanel formPanel = new JPanel();
			formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

			JLabel singleCodeLabel = new JLabel("Código único");
			singleCodeTextField = new JTextField(20);
			formPanel.add(singleCodeLabel);
			formPanel.add(singleCodeTextField);
			
			
			JLabel cpfAdopteLabel = new JLabel("CPF do Adotante");
            cpfAdopteTextField = new JTextField(20);
            formPanel.add(cpfAdopteLabel);
            formPanel.add(cpfAdopteTextField);
			

			JLabel dobOutLabel = new JLabel("Date Out");
            JPanel dobOutPanel = new JPanel(new BorderLayout());
            dayOutComboBox = new JComboBox<>(dates);
            monthOutComboBox = new JComboBox<>(months);
            yearOutComboBox = new JComboBox<>(years);
            dobOutPanel.add(dayOutComboBox, BorderLayout.WEST);
            dobOutPanel.add(monthOutComboBox, BorderLayout.CENTER);
            dobOutPanel.add(yearOutComboBox, BorderLayout.EAST);
            
            formPanel.add(dobOutLabel);
            formPanel.add(dobOutPanel);

			mainPanel.add(formPanel);
			
			
			JButton cadastrarButton = new JButton("Register");
			cadastrarButton.addActionListener(this);

			mainPanel.add(cadastrarButton);

		

			add(mainPanel);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String singleCode = singleCodeTextField.getText();
			String cpfAdopte = cpfAdopteTextField.getText();
			String dayOut = (String) dayOutComboBox.getSelectedItem();
			String monthOut = (String) monthOutComboBox.getSelectedItem();
			String yearOut = (String) yearOutComboBox.getSelectedItem();			
			String exitDate = dayOut + "/" + monthOut + "/" + yearOut;
			
			
			Cat cat = CatMethods.searchCat(singleCode,  cats);
			if (cat != null) {		
				Adopter buscaAdopter = AdopterMethods.searchAdopter(cpfAdopte, adopters);
				if (buscaAdopter != null) {					
					cat.setCpfAdopter(cpfAdopte);
					cat.setExitDate(exitDate);
					JOptionPane.showMessageDialog(frame, cat.toString());
					System.out.println(cat);
				} else {
					JOptionPane.showMessageDialog(frame, "Adopter não encontrado");
					System.out.println("Adotador não encontrado");
				}	
			} else {
				JOptionPane.showMessageDialog(frame, "Gato não encontrado");
				System.out.println("Gato não encontrado");
			}			
		}				
	}
	
	private static void consultarAdopters() {
		String cpfAdopter = JOptionPane.showInputDialog(frame, "CPF do Adopter:");
		AdopterMethods AdopterMethods = new AdopterMethods();

		Adopter buscaAdopter = AdopterMethods.searchAdopter(cpfAdopter, adopters);
		if (buscaAdopter != null) {
			JOptionPane.showMessageDialog(frame, buscaAdopter.toString());
		} else {
			JOptionPane.showMessageDialog(frame, "Adotador não encontrado");
			System.out.println("O usuário tentou consultar um adotador que não está registrado no sistema!");
		}
	}

	private static void consultarcats() {
		String idGato = JOptionPane.showInputDialog(frame, "ID do Gato:");
		CatMethods catsMetodos = new CatMethods();
		Cat buscaGato = catsMetodos.searchCat(idGato, cats);
		if (buscaGato != null) {
			JOptionPane.showMessageDialog(frame, buscaGato.toString());
		} else {
			JOptionPane.showMessageDialog(frame, "Gato não encontrado");
			System.out.println("O usuário tentou consultar um gato que não está registrado no sistema!");
		}
	}
	
	private static void relatorioCat() {
		relatorio = CatMethods.relatorioCat(cats, relatorio);
		
		StringBuilder sb = new StringBuilder();
	    for (Cat cat : relatorio) {
	        sb.append(cat.toString()).append("\n"); // Aqui, você pode ajustar o formato de exibição de acordo com os atributos do objeto Cat
	    }	    
		JOptionPane.showMessageDialog(frame, sb.toString());
		System.out.println(relatorio);
		
	}
	
	private static void relatorioProvisoes() {
		relatorio = CatMethods.relatorioCat(cats, relatorio);
		Double RoyalCaninExigent = 0.0;
		Double RoyalCaninCatPremiumFilhotes = 0.0;
		Double FarminaND = 0.0;
		Double PremierPetGoldenGatosCastrados = 0.0;
		Double PurinaProPlanTratoUrinário = 0.0;
		Double GranPlusAdultos = 0.0;
		Double RaçãoBiofreshGatos = 0.0;
		Double NutrilusProgatos = 0.0;
		Double GuabiNaturalgatoadultocastrado = 0.0;
		
		
		for (Cat cat : relatorio) {
			if (cat.getFood().equals("Royal Canin Exigent")){
				RoyalCaninExigent += Double.parseDouble(cat.getQuantityFood());
			}
			if (cat.getFood().equals("Royal Canin Cat Premium Filhotes")){
				RoyalCaninCatPremiumFilhotes += Double.parseDouble(cat.getQuantityFood());
			}
			if (cat.getFood().equals("Farmina N&D")){
				FarminaND += Double.parseDouble(cat.getQuantityFood());
			}
			if (cat.getFood().equals("Premier Pet Golden Gatos Castrados")){
				PremierPetGoldenGatosCastrados += Double.parseDouble(cat.getQuantityFood());
			}
			if (cat.getFood().equals("Purina ProPlan Trato Urinário")){
				PurinaProPlanTratoUrinário += Double.parseDouble(cat.getQuantityFood());
			}
			if (cat.getFood().equals("GranPlus Adultos")){
				GranPlusAdultos += Double.parseDouble(cat.getQuantityFood());
			}
			if (cat.getFood().equals("Ração Biofresh Gatos")){
				RaçãoBiofreshGatos += Double.parseDouble(cat.getQuantityFood());
			}
			if (cat.getFood().equals("Nutrilus Pro gatos")){
				NutrilusProgatos += Double.parseDouble(cat.getQuantityFood());
			}
			if (cat.getFood().equals("Guabi Natural gato adulto castrado")){
				GuabiNaturalgatoadultocastrado += Double.parseDouble(cat.getQuantityFood());
			}						
		}
		String formated = "Royal Canin Exigent: " + RoyalCaninExigent + "\nRoyal Canin Cat Premium Filhotes: " + RoyalCaninCatPremiumFilhotes + 
				"\nFarmina N&D: " + FarminaND + "\nPremier Pet Golden Gatos Castrados: " + PremierPetGoldenGatosCastrados + 
				"\nPurina ProPlan Trato Urinário: "+ PurinaProPlanTratoUrinário + "\nGranPlus Adultos: " + GranPlusAdultos + "\nRação Biofresh Gatos: " + RaçãoBiofreshGatos +
				"\nNutrilus Pro gatos: "+ NutrilusProgatos +"\nGuabi Natural gato adulto castrado: " + NutrilusProgatos; 
		
		JOptionPane.showMessageDialog(frame, formated);
		
	}
}
