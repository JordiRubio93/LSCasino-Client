package controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Constants;
import model.struct.bet.HorsesBet;
import view.Dialeg;
import view.cavalls.ChooseHorse;

public class HorseButtonController implements ActionListener{
	private ChooseHorse window;
	private String name;
	private HorsesBet bet;

	public HorseButtonController(ChooseHorse window){
		this.window = window;
		this.bet = new HorsesBet(Float.MIN_VALUE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(window.getAmount().isEmpty() || Float.parseFloat(window.getAmount()) <= 0){
			Dialeg dialeg = new Dialeg();
			dialeg.setWarningText("Has d'introduir alguna quantitat positiva!");
		}else{
			window.obreDialeg();
			
			if(window.getDialeg().getResult() == JOptionPane.OK_OPTION){
				name = window.getHorseName();
				
				bet = new HorsesBet(Float.parseFloat(window.getAmount()), name);
				
				window.setVisible(false);
				
				Constants.apostaFeta = true;
			}
		}
	}
}