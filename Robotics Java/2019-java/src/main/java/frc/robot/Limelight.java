package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;


public class Limelight {

	
	Movement move;
	PID rotationPID;
	PID leftRightPID;
	PID distancePID;
	NetworkTable table;
	NetworkTableEntry tv;
	NetworkTableEntry ts;
	NetworkTableEntry tx;
	NetworkTableEntry ta;
	
	
	public Limelight(Movement newMovement)
	{
		move = newMovement;
		rotationPID = new PID(0,0,0,0);
		leftRightPID = new PID(0,0,0,0);
		distancePID = new PID(0,0,0,10);
		
		table = NetworkTableInstance.getDefault().getTable("limelight");
		tx = table.getEntry("tx");
		tv = table.getEntry("tv");
		ta = table.getEntry("ta");
	}

	//This is the method used to chase a target.
	public void chase()
	{
		if (tv.getDouble(0) == 1){
			//added this method to movement so that we can use it autonomously more easily
			move.autonomousUpdate(
					distancePID.update(ta.getDouble(distancePID.getSetpoint())),
					leftRightPID.update(tx.getDouble(leftRightPID.getSetpoint())),
					rotationPID.update(ts.getDouble(rotationPID.getSetpoint()))
			);
		} else {
			move.autonomousUpdate(0, 0, 0.1); //Just spin slowly until we find a target
		}

	}
}
