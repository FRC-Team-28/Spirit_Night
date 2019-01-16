package frc.robot;

import edu.wpi.first.wpilibj.*;

public class Zucc {
	
	private Controller controller;
	private DigitalInput vacSwitch = new DigitalInput(PinConstants.VAC_SWITCH);
	private Spark motor = new Spark(PinConstants.VAC_MOTOR);
	
	public Zucc(Controller newController)
	{
		controller = newController;
	}
	

	public void switchStuff(){
		if (vacSwitch.get() == true)
			{
			}
	{
		
}}}
