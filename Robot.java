//Property of Chad Rakoczy, lead programmer on the Goon Squad
//Property of Chad Rakoczy, lead programmer on the Goon Squad
//Property of Chad Rakoczy, lead programmer on the Goon Squad
//Property of Chad Rakoczy, lead programmer on the Goon Squad

package org.usfirst.frc.team6618.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

@SuppressWarnings("unused")
public class Robot extends IterativeRobot {

	// Initiate Motors
	Jaguar frontLeft = new Jaguar(0);
	Jaguar frontRight = new Jaguar(1);
	Jaguar sucker = new Jaguar(2);

	// Initiate Drive Train
	DifferentialDrive driveTrain = new DifferentialDrive(frontLeft, frontRight);

	// Open XBox Controllers
	XboxController driveController = new XboxController(0);
	XboxController operatorController = new XboxController(1);

	Timer timer;

	// Runs once when robot is turned on
	@Override
	public void robotInit() {
	}

	// Runs once when auton is enabled
	@Override
	public void autonomousInit() {
		timer.reset();
		timer.start();
	}

	// Loops during auton
	@Override
	public void autonomousPeriodic() {
		if (timer.get() < 1) {
			driveTrain.arcadeDrive(1, 0);
		} else if (timer.get() < 2) {
		}

	}

	// Loops during teleop
	@Override
	public void teleopPeriodic() {

		while (isOperatorControl() && isEnabled()) {
			// Run Drive Train
			driveTrain.arcadeDrive(driveController.getRawAxis(1), driveController.getRawAxis(4));

		}

		// Run Sucker
		if (operatorController.getAButton()) {

			sucker.set(1);

		} else if (operatorController.getBButton()) {
			sucker.set(-1);
		} else {
			sucker.set(0);
		}

	}

	@Override
	public void testPeriodic() {
	}
}
