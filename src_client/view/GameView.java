package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.Constants;
import model.Bet;
import model.struct.user.PublicUser;

/**
 * 
 * <p>
 * <b> Classe: Gameview </b> <br/>
 * </p>
 * 
 * Finestra b�sica per a les vistes dels jocs
 * 
 * @version 1.0 19/05/2016
 * @author  Pol Valés - ls30599@salleurl.edu <br/>
 * 			Diego Bellino - ls30741@salleurl.edu <br/>
 * 			Enric Marin - ls31308@salleurl.edu <br/>
 * 			Jordi Rubió - ls31289@salleurl.edu <br/>
 * 			David Estepa - ls30622@salleurl.edu <br/>
 * 			Disseny i programació orientats a objectes. <br/>
 * 			La Salle - Universitat Ramon Llull. <br/>
 * 
 */
public abstract class GameView extends BaseJPanel {
	private static final long serialVersionUID = 1L;

	protected BaseJPanel gamePanel;
	protected JPanel jpFinestra;
	protected JPanel jpTemps;
	protected JLabel jlTemps;
	protected GridLayout columnLayout;
	protected JScrollPane jspList;
	protected JPanel jpDades;
	protected JPanel jpList;
	protected JPanel jpAux;
	protected TimerThread timer;
	protected boolean isRuleta;
	protected JButton jbBet;
	protected JButton jbExit;
	protected JPanel jpOptions;
	protected JLabel jlCount;
	
	public GameView(){
		initElements();
	}
	
	protected void initElements(){
		setLayout(new BorderLayout());
		
		//Label temps
		jlTemps = new JLabel();
		jlTemps.setForeground(new Color(1.0f, 1.0f, 1.0f, 1.0f));
		jlTemps.setFont(new Font("Sans Serif", Font.PLAIN, 14));
		//panell temps		
		jpTemps = new JPanel();
		jpTemps.setBackground(new Color(0.0f, 0.0f, 0.0f, 1.0f));
		jpTemps.add(jlTemps);
		add(jpTemps, BorderLayout.NORTH);
		
		//boton salir
		jbExit = new JButton("Exit");
		jbExit.setBackground(Color.WHITE);
		jbExit.setForeground(Constants.coolBlue);
		
		//boton Apostar
		jbBet = new JButton("Bet!");
		jbBet.setBackground(Color.WHITE);
		jbBet.setForeground(Constants.coolOrange);
		
		//barra Inferior (botones)
		jpOptions = new JPanel(new GridLayout(1,2));
		jpOptions.add(jbExit);
		jpOptions.add(jbBet);
		
		//label aposta
		
		
		//panell de apostes
		jpDades = new JPanel(new BorderLayout());
		columnLayout = new GridLayout();
		columnLayout.setColumns(1);
		columnLayout.setVgap(10);
		
		//tirar apostas cap adalt	
		jpList = new JPanel(columnLayout);
		jpAux = new JPanel(new BorderLayout());
		jpAux.add(jpList, BorderLayout.NORTH);		
		jspList = new JScrollPane(jpAux);
		jpDades.add(jspList, BorderLayout.CENTER);
		jpDades.add(jpOptions, BorderLayout.SOUTH);
		jpDades.setBorder(BorderFactory.createTitledBorder(Constants.BET_LABEL));
		add(jpDades, BorderLayout.EAST);
	}
	
	public void setGamePanel(BaseJPanel panel){
		//add(gamePanel, )
	}
	
	public void registerController(){	
		jbBet.addActionListener(getManager().getController());
		jbExit.addActionListener(getManager().getController());
	}
	
	/**
	 * Funcio que s'encarrega de actualitzar el rellotje superior
	 */
	private void actualitzaTemps(String time){
		jlTemps.setText(time);
	
	}
	protected void createDaemonTime(){
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			@Override
			public void run() {
				try{
					actualitzaTemps(dateFormat.format(Calendar.getInstance().getTime()));
				}catch (Exception e){
					e.printStackTrace();
				}
			
			}
		}, Constants.SPLASH_TIME, TimeUnit.SECONDS.toMillis(1));
	}
	
	public void addAtList(PublicUser user, Bet bet){
		columnLayout.setRows(columnLayout.getRows() + 1);
		
		JPanel jpCell = new JPanel(new BorderLayout());
		JPanel jpInfo = new JPanel(new GridLayout(2,1));
		JLabel jlAvatar = new JLabel(new ImageIcon(Constants.AVATAR));
		JLabel jlUser = new JLabel("   " + user.getSurname() + " - " + bet.getAmount() + " �   ");
		JLabel jlAposta = new JLabel("   " + bet.getSlot() + "   ");
		
		jpInfo.add(jlUser);
		jpInfo.add(jlAposta);
		
		jlUser.setFont(new Font("Serif", Font.BOLD, 20));
		jlAposta.setFont(new Font("Serif", Font.PLAIN, 18));
		
		jpCell.add(jlAvatar, BorderLayout.WEST);
		jpCell.add(jpInfo, BorderLayout.CENTER);
		
		jpList.add(jpCell, BorderLayout.CENTER);
	}
}
