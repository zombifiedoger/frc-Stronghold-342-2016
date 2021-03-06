
package org.usfirst.frc.team342.robot;

import org.usfirst.frc.team342.robot.commands.drive.DriveWithJoystick;
import org.usfirst.frc.team342.robot.subsystems.BoulderController;
import org.usfirst.frc.team342.robot.subsystems.CameraVisionRedux;
import org.usfirst.frc.team342.robot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.communication.FRCNetworkCommunicationsLibrary;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	private static final String WIN_MESSAGE = "Teleop Initialized, Win... Or Else! (JK)";
	private DriveWithJoystick joydrive;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		// Initialize subsystems.
		DriveSystem.getInstance();
		CameraVisionRedux.getInstance();
		BoulderController.getInstance();

		OI.initInstance();
		FRCNetworkCommunicationsLibrary.HALSetErrorData("Robot Initialized. Ready for Action!");
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	public void disabledInit() {
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		FRCNetworkCommunicationsLibrary.HALSetErrorData("Autonomous Initialized, STAND CLEAR");
	}

	/** This function is called periodically during autonomous */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.

		// if (autonomousCommand != null) {
		// autonomousCommand.cancel();
		// }
		FRCNetworkCommunicationsLibrary.HALSetErrorData(WIN_MESSAGE);
		joydrive = new DriveWithJoystick();
		
		
	}

	/** This function is called periodically during operator control */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		joydrive.start();
		
	}

	/** This function is called periodically during test mode */
	public void testPeriodic() {
	}
}
